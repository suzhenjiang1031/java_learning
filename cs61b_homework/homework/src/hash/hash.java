package hash;

public class hash {
    public int hashCode(String s) {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1) {
            intRep = intRep * 31;
            intRep = intRep + s.charAt(i);
        }
        return intRep;
    }

    public static void main(String[] args) {
        System.out.println("bee".hashCode());
        System.out.println("a".hashCode());
    }
}
