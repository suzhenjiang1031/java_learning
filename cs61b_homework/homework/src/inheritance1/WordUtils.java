package inheritance1;

public class WordUtils {
    //Return the length of the longest word.
    public static String longest(SLList<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i++) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        SLList<String> somelist = new SLList<>();
        somelist.addLast("elk");
        somelist.addLast("are");
        somelist.addLast("watching");
        System.out.println(longest(somelist));
        somelist.print();
    }
}
