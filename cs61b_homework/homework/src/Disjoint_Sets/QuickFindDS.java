package Disjoint_Sets;

public class QuickFindDS implements DisjoinSets{
    private int[] id;

    //very fast: Two array accesses: theta(1)
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    //Relatively slow: N+2 to 2N+2 array accesses: theta(N)
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

}
