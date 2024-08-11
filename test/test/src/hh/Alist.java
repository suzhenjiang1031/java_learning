package hh;

public class Alist<Item> {
    private Item[] items;
    private int size;

    //Creates an empty list.
    public Alist() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    //Resizes the underlying array to the target capacity.
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    //Inserts X into the back of the list
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = x;
        size = size + 1;
    }

    //Returns the item from the back of the list.
    public Item getLast() {
        return items[size - 1];
    }

    //Get the ith item in the list (0 is the first).
    public Item get(int i) {
        return items[i];
    }

    //Return the number of items in the list.
    public int size() {
        return size;
    }

    //Deletes item from back of the list and returns deleted item.
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size = size -1;
        return x;
    }

}
