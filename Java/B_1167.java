import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge{
    int vertex;
    int cost;
    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
}
public class B_1167 {
    static int V;
    static int maxLength = Integer.MIN_VALUE;
    static int maxIdx = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int v;
            while ((v = Integer.parseInt(st.nextToken())) != -1){
                int cost = Integer.parseInt(st.nextToken());
                graph[V].add(new Edge(v, cost));
            }
        }
        boolean[] visit = new boolean[V + 1];
        visit[1] = true;
        dfs(visit, 1, graph, 0);
        visit = new boolean[V + 1];
        visit[maxIdx] = true;
        dfs(visit, maxIdx, graph, 0);
        System.out.println(maxLength);
    }
    public static void dfs(boolean[] visit, int V, ArrayList<Edge>[] graph, int cost){
        if(cost > maxLength){
            maxLength = cost;
            maxIdx = V;
        }
        for (int i = 0; i < graph[V].size(); i++) {
            int v = graph[V].get(i).vertex;
            if(!visit[v]){
                visit[v] = true;
                dfs(visit, v, graph, cost + graph[V].get(i).cost);
            }
        }
    }
}
