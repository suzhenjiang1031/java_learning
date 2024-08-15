package inheritance1;

public interface List61B<item> {
    //Inserts X into the back of the list.
    public void addLast(item x);

    //Returns the item from the back of the list.
    public item getLast();

    //Gets the ith item in the list (o is the front).
    public item get(int i);

    //Returns the number of items in the list.
    public int size();

    //Deletes item from back of the list and returns deleted item.
    public item removeLast();

    //Inserts item into given position.
    public void insert(item x, int position);

    //Inserts an item at the front.
    public item getFirst();

    //Prints the list. works for ANY of list.
    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
    }
}
