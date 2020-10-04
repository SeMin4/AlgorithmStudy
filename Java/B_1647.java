import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int V1;
    int V2;
    int cost;
    public Edge(int V1, int V2, int cost){
        this.V1 = V1;
        this.V2 = V2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost) return -1;
        else if(this.cost == o.cost) return 0;
        else return 1;
    }
}
public class B_1647 {
    static int N, M;
    static int max_edge = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.offer(new Edge(V1, V2, cost));
        }
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int sum = 0;
        int edge_cnt = 0;
        while (!edges.isEmpty()){
            Edge edge = edges.poll();
            if(union(edge.V1, edge.V2, parent)){
               sum += edge.cost;
                edge_cnt += 1;
                if(edge_cnt == N - 1){
                    sum -= edge.cost;
                    break;
                }
            }
        }
        System.out.println(sum);

    }
    public static boolean union(int V1, int V2, int[] parent){
        V1 = find(V1, parent);
        V2 = find(V2, parent);
        if(V1 == V2){
            return false;
        }
        parent[V1] = V2;
        return true;
    }
    public static int find(int V, int[] parent){
        if(parent[V] == V) return V;
        return parent[V] = find(parent[V], parent);
    }
}
