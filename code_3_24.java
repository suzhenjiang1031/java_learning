package  code_3_24;

import java.util.Scanner;

public class code_3_24 {
    public static void main(String[] args) {
        //键盘输入两个整数，如果其中一个为6，最终结果输出true
        //如果它们的和为6的倍数，最终结果也输出true
        //其他情况都是false

        //分析：
        //1.键盘录入两个整数
        //变量a 变量b

        //2. a == 6; b == 6; (a+b) % 6 == 0;
        //如果满足其中一个，那么就可以输出true

/*      Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数:");
        int number1 = sc.nextInt();
        System.out.println("请输入第二个整数:");
        int number2 = sc.nextInt();

        //可以短路逻辑运算符去连接三个判断
        boolean result = number1 == 6 || number2 == 6 || (number1 + number2) % 6 == 0;
        System.out.println(result);*/


        //三元运算符 需求：获取两个数的较大值

        //分析
        //1.定义两个变量记录两个整数
/*        int num1 = 10;
        int num2 = 20;*/

        //2.使用三元运算符获取两个整数的较大值
        //格式： 关系表达式 ? 表达式1 : 表达式2
        //整个三元表达式必须被使用
/*        int max = num1 > num2 ? num1 : num2;
        System.out.println(max);

        System.out.println(num1 > num2 ? num1 : num2);*/

        /*
        需求：动物园里有两只老虎。体重分别为通过键盘录入获得，使用程序实现判断两只老虎的体重是否相等
         */

        //分析：
        //1.键盘录入两只老虎的体重
/*        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一只老虎的体重:");
        int weight1 = sc.nextInt();
        System.out.println("请输入第二只老虎的体重:");
        int weight2 = sc.nextInt();

        //2.比较
        //true false
        //相同  不同
        //System.out.println(weight1 == weight2);

        String result = weight1 == weight2 ? "相同": "不同";
        System.out.println(result);*/

        //已知三个和尚的身高，用程序获取这三个和尚的最高身高

        //1.定义三个变量记录三个和尚的身高
/*        int height1 = 150;
        int height2 = 210;
        int height3 = 165;
        //2.拿着第一个和尚和第二个和尚进行比较
        //再拿着结果和第三个和尚进行比较即可
        int temp = height1 > height2 ? height1 : height2;
        int result = temp > height3 ? temp : height3;
        System.out.println(result);*/
    }
}
