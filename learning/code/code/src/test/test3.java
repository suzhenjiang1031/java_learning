package test;

import java.util.Scanner;

//判断回文数

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的回文数：");
        int x = sc.nextInt();
        int temp = x;
        int num = 0;
        while(x != 0){
            int ge = x % 10;
            x = x / 10;
            num = num * 10 + ge;
        }
        System.out.println(num);
        System.out.println(temp == num);
    }
}