import java.util.ArrayList;

public class cycle {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    boolean isCycle;

    public int solve ( int A, int[][] B){
        isCycle = false;
        graph = buildAdjacencyList(A, B);
        visited = new boolean[A + 1];
        return isCycleInUndirectedGraph(A) ? 1 : 0;

    }

    public boolean isCycleInUndirectedGraph ( int A){
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
            if (isCycle) {
                break;
            }
        }
        return isCycle;
    }

    public void dfs (int v, int previous){
        visited[v] = true;
        for (int u : graph[v]) {
            if (u != previous) {
                if (!visited[u]) {
                    dfs(u, v);
                } else {
                    isCycle = true;
                    return;
                }
            }
        }
    }


    public ArrayList<Integer>[] buildAdjacencyList ( int A, int[][] B){
        ArrayList<Integer>[] g = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] num : B) {
            int u = num[0];
            int v = num[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }
}
