package inheritance2;

//SLList with additional operation printLostItems() which prints all items.
//that have ever been deleted.
public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList(Item X) {
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item X = super.removeLast();
        deletedItems.addLast(X);
        return X;
    }

    //Prints deleted items.
    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>(0);
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        //vs1 is now: [1, 5, 10, 13]
        vs1.removeLast();
        vs1.removeLast();
        //After deleted vs1 is: [1, 5]

        //should print out the numbers of the fallen, namely 10 and 13.\
        System.out.println("The fallen are: ");
        vs1.printLostItems();
    }
}

