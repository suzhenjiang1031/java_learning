package test;

//输入被除数和除数，不使用% / *，得到商和余数

import java.util.Scanner;

public class test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个被除数:");
        int beichushu = sc.nextInt();
        System.out.println("请输入除数:");
        int chushu = sc.nextInt();
        int count = 0;
        int yushu = 0;
        while (yushu > chushu){
            yushu = beichushu - chushu;
            count ++;
        }
        System.out.println("余数：" + yushu);
        System.out.println("商" + count);


    }
}
