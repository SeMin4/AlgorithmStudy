import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        if(this.cost < o.cost)return -1;
        else if(this.cost == o.cost) return 0;
        else return 1;
    }
}
public class B_16118 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] foxAdjList = new ArrayList[N + 1];
        ArrayList<Edge>[] wolfAdjList = new ArrayList[N * 2 + 1];
        for (int i = 1; i <= N; i++) {
            foxAdjList[i] = new ArrayList<>();
            wolfAdjList[i] = new ArrayList<>();
        }
        for (int i = N + 1; i <= 2 * N; i++) {
            wolfAdjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            foxAdjList[v1].add(new Edge(v2, 2 * cost));
            foxAdjList[v2].add(new Edge(v1, 2 * cost));
            wolfAdjList[v1].add(new Edge(v2 + N, cost));
            wolfAdjList[v1 + N].add(new Edge(v2, 4 * cost));
            wolfAdjList[v2].add(new Edge(v1 + N, cost));
            wolfAdjList[v2 + N].add(new Edge(v1, 4 * cost));
        }
        int[] foxDistance = new int[N + 1];
        int[] wolfDistance = new int[2 * N + 1];
        Arrays.fill(foxDistance, 2000000000);
        Arrays.fill(wolfDistance, 2000000000);
        dijkstra(1, foxDistance, foxAdjList);
        dijkstra(1, wolfDistance, wolfAdjList);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(foxDistance[i] < Math.min(wolfDistance[i], wolfDistance[i + N]))
                cnt += 1;
        }
        System.out.println(cnt);
    }
    public static void dijkstra(int v, int[] distance, ArrayList<Edge>[] adjList){
        distance[v] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(edge.cost > distance[edge.v])
                continue;
            for (int i = 0; i < adjList[edge.v].size(); i++) {
                Edge tmp = adjList[edge.v].get(i);
                if((tmp.cost + edge.cost) < distance[tmp.v]){
                    distance[tmp.v] = (tmp.cost + edge.cost);
                    pq.offer(new Edge(tmp.v, (tmp.cost + edge.cost)));
                }
            }
        }
    }
}
