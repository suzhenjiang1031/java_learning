package code;

import java.util.Scanner;
import java.lang.Math;

abstract class Shape {
    public abstract double getArea();
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

abstract class Account {
    private String idCard;
    private double balance;

    public Account() {
    }

    public Account(String idCard, double balance) {
        this.idCard = idCard;
        this.balance = balance;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public double getBalance() {
        return this.balance;
    }

    public abstract double getInterest();
}

class FixedDepositAccount extends Account {
    private int months;
    private double rate;

    public FixedDepositAccount() {
    }

    public FixedDepositAccount(String idCard, double balance) {
        super(idCard, balance);
    }

    public FixedDepositAccount(String idCard, double balance, int months, double rate) {
        super(idCard, balance);
        this.months = months;
        this.rate = rate;
    }

    public double getInterest() {
        return super.getBalance() * rate * months / 12;
    }

    @Override
    public String toString() {
        return String.format("%s账户%.2f元存款的%d月的存款利息: %.2f(年利率为%.2f%%)",
                super.getIdCard(), super.getBalance(), months, this.getInterest(), rate * 100);
    }
}

class BankingAccount extends Account {
    private int days;
    private double rate;

    public BankingAccount() {
    }

    public BankingAccount(String idCard, double balance) {
        super(idCard, balance);
    }

    public BankingAccount(String idCard, double balance, int days, double rate) {
        super(idCard, balance);
        this.days = days;
        this.rate = rate;
    }

    public double getInterest() {
        return super.getBalance() * rate * days / 365;
    }

    @Override
    public String toString() {
        return String.format("%s账户%.2f元存款的%d天的存款利息: %.2f(年利率为%.2f%%)",
                super.getIdCard(), super.getBalance(), days, this.getInterest(), rate * 100);
    }
}

abstract class Question {
    private String text;
    private String[] options;

    public Question() {
    }

    public Question(String text, String[] options) {
        this.text = text;
        this.options = options;
    }

    public abstract boolean check(char[] answers);

    public void print() {
        System.out.println(text);
        for (String option : options) {
            System.out.print(option + "\t ");
        }
        System.out.println();
    }
}

class SingleQuestion extends Question {
    private char answer;

    public SingleQuestion() {
    }

    public SingleQuestion(String text, String[] options, char answer) {
        super(text, options);
        this.answer = answer;
    }

    public boolean check(char[] answers) {
        if (answers.length != 1)
            return false;
        return Character.toLowerCase(answers[0]) == Character.toLowerCase(answer);
    }
}

class MultiQuestion extends Question {
    private char[] answer;

    public MultiQuestion() {
    }

    public MultiQuestion(String text, String[] options, char[] answer) {
        super(text, options);
        this.answer = answer;
    }

    public boolean check(char[] answers) {
        if (answer.length != answers.length)
            return false;
        boolean[] flag = new boolean[answer.length];
        for (char answer1 : answers) {
            for (int j = 0; j < answer.length; j++) {
                if (Character.toLowerCase(answer1) == Character.toLowerCase(answer[j])) {
                    if (flag[j])
                        return false;
                    flag[j] = true;
                    break;
                }
            }
        }
        for (boolean b : flag) {
            if (!b)
                return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Triangle Area: " + triangle.getArea());

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("Rectangle Area: " + rectangle.getArea());

        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("001", 100000.00, 36, 0.035);
        System.out.println(fixedDepositAccount);

        BankingAccount bankingAccount = new BankingAccount("002", 100000.00, 182, 0.052);
        System.out.println(bankingAccount);

        MultiQuestion multiQuestion = new MultiQuestion("三国演义中的三绝是谁？",
                new String[]{"A.曹操", "B.刘备", "C.关羽", "D.诸葛亮"}, new char[]{'A', 'C', 'D'});
        multiQuestion.print();
        System.out.print("请输入: ");
        String input1 = scanner.next();
        char[] answers1 = input1.toCharArray();
        if (multiQuestion.check(answers1))
            System.out.println("恭喜，答对了!");
        else
            System.out.println("还得努力呀!");

        SingleQuestion singleQuestion = new SingleQuestion("最早向刘备推荐诸葛亮的是谁?",
                new String[]{"A.徐庶", "B.司马徽", "C.鲁肃", "D.关羽"}, 'B');
        singleQuestion.print();
        System.out.print("请输入: ");
        String input2 = scanner.next();
        char[] answers2 = input2.toCharArray();
        if (singleQuestion.check(answers2))
            System.out.println("恭喜，答对了!");
        else
            System.out.println("还得努力呀!");
    }
}
