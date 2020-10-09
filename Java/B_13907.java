import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int vertex;
    long cost;
    int cnt;
    public Edge(int vertex, long cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    public Edge(int vertex, long cost, int cnt){
        this.vertex = vertex;
        this.cnt = cnt;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost) return -1;
        else if(this.cost == o.cost){
            if (this.cnt < o.cnt) return -1;
            else if(this.cnt == o.cnt) return 0;
            else return 1;
        }
        else return 1;
    }
}
public class B_13907 {
    static int N, M, K;
    static int S, D;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph[V1].add(new Edge(V2, cost));
            graph[V2].add(new Edge(V1, cost));
        }
        long[][] distance = dijkstra(graph);
        long res = distance[D][0];
        for (int i = 1; i < distance[D].length; i++) {
            res = Math.min(res, distance[D][i]);
        }
        bw.write(res + "\n");
        for (int i = 0; i < K; i++) {
            int inc = Integer.parseInt(br.readLine());
            res = distance[D][0];
            for (int j = 1; j < distance[D].length; j++) {
                distance[D][j] += (inc * j);
                res = Math.min(res, distance[D][j]);
            }
            bw.write(res + "\n");
        }
        bw.close();

    }
    public static  long[][] dijkstra(ArrayList<Edge>[] graph){
        long[][] distance = new long[N + 1][N + 1];//몇개의 거쳐서 왔는가?
        for (int i = 0; i <= N; i++) {
            Arrays.fill(distance[i], 10000000000L);
        }
        distance[S][0] = 0;
//        Arrays.fill(distance[S], 0);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(S, 0 , 0));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.vertex;
            fr: for (int i = 0; i < graph[v].size(); i++) {
                Edge des = graph[v].get(i);
                long cost = edge.cost + des.cost;
                for(int j = 0; j <= N && j <= edge.cnt; ++j){
                    if(distance[des.vertex][j] < cost){
                        continue fr;
                    }
                }
                if((edge.cnt + 1) < distance[0].length && (distance[des.vertex][edge.cnt + 1] > cost)){
                    distance[des.vertex][edge.cnt + 1] = cost;
                    pq.offer(new Edge(des.vertex, distance[des.vertex][edge.cnt + 1], edge.cnt + 1));
                }
            }
        }
        return distance;
    }
}
