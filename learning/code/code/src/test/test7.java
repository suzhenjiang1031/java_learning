package test;

import java.util.Scanner;

//判断一个整数是不是质数
public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int number = sc.nextInt();
        boolean flag = true;

        for (int i = 2; i < number; i++){
            if (number % i == 0){
                flag = false;
                break;
            }
        }
        //只有当这个循环结束了，表示这个范围之内所有的数字都判断完毕了
        //此时才能断定number是一个质数
        if (flag){
            System.out.println(number + "是一个质数");
        }else{
            System.out.println(number + "不是一个质数");
        }
    }
}
