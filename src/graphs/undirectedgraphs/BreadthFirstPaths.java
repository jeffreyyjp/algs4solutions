package graphs.undirectedgraphs;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex.
    private int[] distTo; // number of edges shortest s-v path

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        marked[s] = true; // Mark the source.
        queue.enqueue(s); // and put it on the queue.
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Remove next vertex from the queue.
            for (int w : G.adj(v)) {
                if (!marked[w]) { // For every unmarked adjacent vertex.
                    edgeTo[w] = v; // save last edge on a shortest path.
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true; // mark it because path is known.
                    queue.enqueue(w); // and add it to the queue.
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);
        return path;
    }
}
