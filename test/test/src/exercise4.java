public class exercise4 {
    public static void printIndexed(String input){
        StringBuilder result = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++){
            result.append(input.charAt(i)).append(length - 1 - i);
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        String input = "ZELDA";
        printIndexed(input);

    }
}
