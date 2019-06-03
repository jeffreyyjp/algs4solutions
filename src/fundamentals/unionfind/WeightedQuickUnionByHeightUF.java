package fundamentals.unionfind;

public class WeightedQuickUnionByHeightUF {

    private int[] parent;    // parent[i] = parent of i
    private int[] height;    // height[i] = height of subtree rooted at i
    private int count;       // number of components

    public WeightedQuickUnionByHeightUF(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        // make shorter root point to taller one
        if (height[pRoot] < height[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (height[pRoot] > height[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            height[pRoot]++;
        }
        count--;
    }
}
