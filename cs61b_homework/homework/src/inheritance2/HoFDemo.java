package inheritance2;

//Demonstrates higher order function in java.
public class HoFDemo {
    public static int do_twtice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFunction tenX = new TenX();
        System.out.println(do_twtice(tenX, 2));
    }
}