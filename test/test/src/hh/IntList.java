public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

/*Return the size of the list using... recursion!*/
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

/*Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

/*Return the ith item of this IntList using recursion! */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

/*Return the ith item of this IntList no using recursion! */

    public int Get(int i){
        int cnt = 0;
        IntList l = this;
        for (cnt = 0; cnt < i; cnt++){
            l = l.rest;
        }
        return l.first;
    }

    public static void main(String[] args) {
//        IntList L = new IntList(5, null);
//        L.rest = new IntList(10, null);
//        L.rest.rest = new IntList(5, null);

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
//        System.out.println(L.get(2));
        System.out.println(L.size());
    }
}