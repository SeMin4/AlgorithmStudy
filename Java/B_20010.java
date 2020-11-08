import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
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
public class B_20010 {
    static int N, K;
    static int MAX_DISTANCE = 0;
    static int MAX_VERTEX = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //트리의 지름, 크루스칼
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[V1][V2] = cost;
            graph[V2][V1] = cost;
            pq.offer(new Edge(V1, V2, cost));
        }
        int sum = 0;
        int cnt = 0;
        ArrayList<Integer>[] shortestList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            shortestList[i] = new ArrayList<>();
        }
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(union(edge.V1, edge.V2, parent, shortestList)){
                sum += edge.cost;
                cnt += 1;
            }
            if(cnt == N - 1){
                break;
            }
        }
        System.out.println(sum);
        boolean[] visit = new boolean[N];
        visit[0] = true;
        dfs(graph, shortestList, 0, 0, visit);
        visit = new boolean[N];
//        System.out.println(MAX_VERTEX);
//        System.out.println(MAX_DISTANCE);
        visit[MAX_VERTEX] = true;
        dfs(graph, shortestList, MAX_VERTEX, 0, visit);
        System.out.println(MAX_DISTANCE);
    }
    public static boolean union(int V1, int V2, int[] parent, ArrayList<Integer>[] graph){
        int parent_V1 = find(V1, parent);
        int parent_V2 = find(V2, parent);
        if(parent_V1 == parent_V2){
            return false;
        }
        parent[parent_V2] = parent_V1;
        graph[V1].add(V2);
        graph[V2].add(V1);
        return true;
    }
    public static int find(int V, int[] parent){
        if(parent[V] == V){
            return V;
        }
        return parent[V] = find(parent[V], parent);
    }
    public static void dfs(int[][] graph, ArrayList<Integer>[] shortestList, int V, int cost, boolean[] visit){
        if(MAX_DISTANCE < cost){
            MAX_DISTANCE = cost;
            MAX_VERTEX = V;
        }
        for (int i = 0; i < shortestList[V].size(); i++) {
            int v = shortestList[V].get(i);
            if(!visit[v]){
                visit[v] = true;
                dfs(graph, shortestList, shortestList[V].get(i), cost + graph[V][v], visit);
            }
        }
    }
}
