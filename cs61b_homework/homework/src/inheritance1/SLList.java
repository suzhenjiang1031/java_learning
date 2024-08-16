package inheritance1;

public class SLList<Blorp> implements List61B<Blorp> {
    public class Node {
        public Blorp item;  //Equivalent of first
        public Blorp next; //Equivalent of rest

        public Node(Blorp i, Node h) {
            item = i;
            next = h;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() {
        size = 0;
        sentinel = new Node(null, null);
    }

    public SLList(Blorp x) {
        size = 1;
        sentinel = new  Node(x, null);
    }

    //Adds an item of the front.
    public void addFirst(Blorp x) {
        Node oldFrontNode = sentinel.next;
        Node newNode = new Node(x, oldFrontNode);
        sentinel.next = newNode;
        size += 1;
    }

    //Gets the front item of the list.
    public Blorp getFirst() {
        return sentinel.next.item;
    }

    //Puts an item at the back of the list.
    public void addLast(Blorp x) {
        size += 1;

        Node p = sentinel;

        //Move p until it reaches the end.
    }


}
