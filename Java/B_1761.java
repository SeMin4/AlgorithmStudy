import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
    int vertex;
    int cost;
    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
}
public class B_1761 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[V1].add(new Edge(V2, cost));
            graph[V2].add(new Edge(V1, cost));
        }
        int[] depth = new int[N + 1];
        int[][] parent = new int[N + 1][2];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(depth, -1);
        visit[1] = true;
        dfs(visit, 0, depth, parent, 1, graph);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int cost = 0;
            while (V1 != V2){
                if(depth[V1] > depth[V2]){
                    cost += parent[V1][1];
                    V1 = parent[V1][0];
                }
                else if(depth[V1] < depth[V2]){
                    cost += parent[V2][1];
                    V2 = parent[V2][0];
                }
                else{
                    cost += parent[V1][1];
                    V1 = parent[V1][0];
                    cost += parent[V2][1];
                    V2 = parent[V2][0];
                }
            }
            bw.write(cost + "\n");
        }
        bw.close();
    }
    public static void dfs(boolean[] visit, int depth, int[] depthArr, int[][] parent, int vertex, ArrayList<Edge>[] graph){
        depthArr[vertex] = depth;
        for (int i = 0; i < graph[vertex].size(); i++) {
            Edge edge = graph[vertex].get(i);
            if(!visit[edge.vertex]){
                visit[edge.vertex] = true;
                parent[edge.vertex][0] = vertex;
                parent[edge.vertex][1] = edge.cost;
                dfs(visit, depth + 1, depthArr, parent, edge.vertex, graph);
            }
        }
    }

}
