package inheritance1;

//The next item always goes in the size position.
public class AList<item> {
    private item[] items;
    private int size;
    private static int FACTOR = 2;

    //create an empty list.
    public AList() {
        size = 0;
        items = (item[]) new Object[100];
    }

    //Resize our backing array so that it is of the given capacity.
    private void resize(int capacity) {
        item[] a = (item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    //Inserts X into the back of the list.
    public void addLast(item x) {
        if (size == items.length) {
            resize(size * FACTOR);
        }

        items[size] = x;
        size += 1;
    }

    //Return the last in the list(0 is the front).
    public item getLast() {
        return items[size - 1];
    }

    //Gets the ith item in the list(0 is the front).
    public item get(int i) {
        return items[i];
    }

    //Return the number of items in the last.
    public int size() {
        return size;
    }

    //Deletes item from back of the list and returns deleted item;
    public item remove() {
        item itemToReturn = getLast();
        items[size - 1] = null;
        size -= 1;
        return itemToReturn;

    }

    //Inserts item into given position.
    public void insert(item x, int position) {
        item[] newitems = (item[]) new Object[items.length + 1];
        System.arraycopy(items, 0, newitems, 0, position);
        newitems[position] = x;

        System.arraycopy(items, position, newitems, position + 1, items.length - position);
        items = newitems;
        size = size + 1;
    }

    //Inserts an item at the front.
    public void addFirst(item x) {
        insert(x, 0);
    }

    //Gets an item from the front.
    public item getFirst() {
        return get(0);
    }

}
