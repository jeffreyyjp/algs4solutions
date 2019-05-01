package fundamentals.unionfind;

public class WeightedQuickFindUF {
    private int[] id;  // access to component id (site indexed)
    private int[] sz;    // size of component (site indexed)
    private int count; // number of components

    public WeightedQuickFindUF(int n) {
        // Initialize component id array.
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        sz = new int[n];
        for (int i = 0; i < n; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);

        // nothing to do if p and q are already in the same component.
        if (pID == qID) return;

        // Rename p's component to q's name.
        int smaller = pID;
        int larger = qID;
        if (sz[pID] > sz[qID]) {
            smaller = qID;
            larger = pID;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == smaller) {
                id[i] = larger;
            }
        }
        sz[larger] += sz[smaller];
        count--;
    }
}
