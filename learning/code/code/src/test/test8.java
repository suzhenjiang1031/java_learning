package test;

import java.util.Random;
import java.util.Scanner;

//猜数字
public class test8 {
    public static void main(String[] args) {
        //创建对象
        //生成随机数
        //口诀：包头不包尾，包左不包右

        //秘诀
        //用来生成任意数到任意数之间的随机数 7 ~ 15
        //1.让这个范围头尾都减去一个值，让这个范围从0开始 -7 0 ~ 8
        //2.尾巴+1 8 + 1 = 9
        //3.最终的结果：再加上第一步减去的值
//        Random r = new Random();
//        int number = r.nextInt(9) + 7; //7 ~ 15
//        System.out.println(number);

        //分析
        //1.生成一个1~100的随机数字
        int count = 0;
        Random r = new Random();
        int number = r.nextInt(100) + 1;
        //2.猜这个数字是多少
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入你要猜的数字");
            int guessNumber = sc.nextInt();
            //3.判断两个数字给出不同的提示
            //猜的数字大了
            //猜的数字小了
            //猜中了
            count ++;
            if (count == 3){
                System.out.println("猜中了");
                break;
            }
            if (guessNumber > number){
                System.out.println("大了");
            }else if (guessNumber < number){
                System.out.println("小了");
            }else{
                System.out.println("猜中了");
                break;
            }
        }

    }
}
