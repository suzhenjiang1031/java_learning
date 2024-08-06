//addLast getLast RemoveLast
public class DLList {
    private static class IntNode {
        public IntNode prev;

        public int item;
        public  IntNode next;

        public IntNode(int x, IntNode n, IntNode p) {
            prev = p;
            item = x;
            next  = n;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public DLList() {
        sentinel = new IntNode(63, null, null);
        size = 0;
    }

    public DLList(int x) {
        sentinel = new IntNode(63, sentinel.next, null);
        sentinel.next = new IntNode(x, null, sentinel);
        size = 1;
    }

    public void addlast(int x) {
        size = size + 1;
        last.next = new IntNode(x, sentinel, null);
        last = last.next;
    }

    public int getlast() {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    public void removelast() {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = null;
    }

    public int returnsize() {
        return size;
    }

    public static void main(String[] args) {
        DLList d = new DLList();
        d.addlast(2);
        d.addlast(3);
        d.addlast(4);
        d.addlast(5);
        int s = d.getlast();
        System.out.println(s);
    }

}