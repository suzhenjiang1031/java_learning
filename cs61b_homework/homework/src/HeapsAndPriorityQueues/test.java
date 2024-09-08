//package HeapsAndPriorityQueues;
//
//import java.util.*;
//import java.util.concurrent.TransferQueue;
//
//public class test {
//    public List<String> unharmoniousTexts(Sniffer sniffer, int M) {
//        ArrayList<String> allMessages = new ArrayList<String>();
//
//        for (Timer timer = new Timer(); timer.hours() < 24;) {
//            allMessages.add(sniffer.getNextMessage());
//        }
//
//        Comparator<String> cmptr = new HarmoniousnessComparator();
//        Collections.sort(allMessages, cmptr, Collections.reverseOrder());
//
//        return allMessages.subList(0, M);
//    }
//
//    public List<String> unharmoniousTexts(Sniffer sniffer, int M) {
//        Comparator<String> cmptr = new HarmoniousnessComparator();
//        MinPQ<String> unharmonisousTexts = new HeapMinPQ<Transaction>(cmptr);
//        for (Timer time = new Timer(); timer.hours() < 24; ) {
//            unharmoniousTexts.add(sniffer.getNextMessage());
//            if (unharmonisousTexts.size > M) {
//                unharmonisousTexts.removeSmallest();
//            }
//            ArrayList<String> textlist = new ArrayList<>();
//            while (unharmonisousTexts.size > 0) {
//                textlist.add(unharmonisousTexts.removeSmallest());
//            }
//        }
//        return textlist;
//    }
//}
