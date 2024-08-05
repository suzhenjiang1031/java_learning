public class exercise5 {
    public static void stutter(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++){
            result.append(input.charAt(i)).append(input.charAt(i));
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        stutter("hello!");
    }
}
