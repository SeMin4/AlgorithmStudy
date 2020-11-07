import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int v;
    int cost;
    public Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost) return -1;
        else if(this.cost == o.cost) return 0;
        else return 1;
    }
}
public class B_1238 {
    static int N, M, X;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] in_graph = new ArrayList[N + 1];
        ArrayList<Edge>[] out_graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            in_graph[i] = new ArrayList<>();
            out_graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            in_graph[v1].add(new Edge(v2, cost));
            out_graph[v2].add(new Edge(v1, cost));
        }
        int[] in_distance = new int[N + 1];
        int[] out_distance = new int[N + 1];
        Arrays.fill(in_distance, 1000000000);
        Arrays.fill(out_distance, 1000000000);
        in_distance[X] = 0;
        dijkstra(in_distance, in_graph);
        out_distance[X] = 0;
        dijkstra(out_distance, out_graph);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, in_distance[i] + out_distance[i]);
        }
        System.out.println(res);
    }
    public static void dijkstra(int[] distance, ArrayList<Edge>[] graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            for (int i = 0; i < graph[edge.v].size(); i++) {
                Edge tmpEdge = graph[edge.v].get(i);
                if(distance[tmpEdge.v] > edge.cost + tmpEdge.cost){
                    distance[tmpEdge.v] = edge.cost + tmpEdge.cost;
                    pq.offer(new Edge(tmpEdge.v, edge.cost + tmpEdge.cost));
                }
            }
        }
    }
}
