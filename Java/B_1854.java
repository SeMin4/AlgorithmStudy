import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int vertex;
    int weight;
    public Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight < o.weight)
            return -1;
        else if(this.weight == o.weight)
            return 0;
        else
            return 1;
    }
}
public class B_1854 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        ArrayList<Edge>[] distance = new ArrayList[N + 1];
        Edge[] dist = new Edge[N + 1];
        for (int i = 1; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(Collections.reverseOrder());
            distance[i] = new ArrayList<>();
            dist[i] = new Edge(i, Integer.MAX_VALUE);
        }
        dist[1].weight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distance[V1].add(new Edge(V2, weight));
        }
        dijkstra(distQueue, distance, dist);
        for (int i = 1; i <= N; i++) {
            if(distQueue[i].size() < K){
                System.out.println(-1);
            }
            else{
                System.out.println(distQueue[i].poll());
            }
        }

    }
    public static void dijkstra(PriorityQueue<Integer>[] distQueue, ArrayList<Edge>[] distance, Edge[] dist){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(1, 0));
        distQueue[1].offer(0);
        while (!priorityQueue.isEmpty()){
            Edge vertex = priorityQueue.poll();
            ArrayList<Edge> distanceList = distance[vertex.vertex];
            for (Edge ed : distanceList) {
                int weight = vertex.weight + ed.weight;
                if(distQueue[ed.vertex].size() < K){
                    distQueue[ed.vertex].add(weight);
                    priorityQueue.add(new Edge(ed.vertex, weight));
                }
                else if(distQueue[ed.vertex].peek() > weight) {
                    distQueue[ed.vertex].poll();
                    distQueue[ed.vertex].offer(weight);
                    priorityQueue.add(new Edge(ed.vertex, weight));
                }
            }
        }
    }
}
