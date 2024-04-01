package test;

//逢7过或者7的倍数。打印100以内符合的数据
public class test5{
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            //个位是7 十位是7 7的倍数
            if(i % 10== 7 || i / 10 % 10 == 7 || i % 7 == 0){
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }
    }
}
