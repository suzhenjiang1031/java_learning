package hh;

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
        last = sentinel;
        size = 0;
    }

    public DLList(int x) {
        sentinel = new IntNode(63, last, null);
        last = new IntNode(x, null, sentinel);
        sentinel.next = last;
        size = 1;
    }

    public void addfirst(int x) {
        size = size + 1;
        IntNode newNode = new IntNode(x, sentinel.next, sentinel);
        if (sentinel.next != null) {
            sentinel.next.prev = newNode;
        }
        sentinel.next = newNode;
        if (size == 0) {
            last = newNode;
        }
    }

    public void addlast(int x) {
        size = size + 1;
        IntNode newNode = new IntNode(x, null, last);
        last.next = newNode;
        last = newNode;
    }

    public int getlast() {
        return last.item;
    }

    public void removelast() {
        size = size - 1;
        last = last.prev;
        last.next = null;
    }

    public int returnsize() {
        return size;
    }

    public static void main(String[] args) {
        DLList d = new DLList(20);
        d.addlast(2);
        d.addlast(3);
        d.addlast(4);
        d.addlast(5);
        d.removelast();
        d.addfirst(1);
        int s = d.getlast();
        System.out.println(s);
    }

}