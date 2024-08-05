public class exercise3 {
    public static void main(String[] args) {
        int total = 25;
        for (int number = 1; number <= (total / 2); number++) {
            total = total - number;
            System.out.println((total + " " + number));
        }
    }
}

//1. total = 25 - 1 = 24 number = 1
//2. total = 24 - 2 = 22 number = 2
//3. total = 22 - 3 = 19 number = 3
//4. total = 19 - 4 = 15 number = 4
//5. total = 15 - 5 = 10 number = 5

