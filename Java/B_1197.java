import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int V1;
    int V2;
    int weight;
    public Edge(int V1, int V2, int weight){
        this.V1 = V1;
        this.V2 = V2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight < o.weight)
            return -1;
        else if (this.weight == o.weight)
            return 0;
        else
            return 1;
    }
}
public class B_1197 {
    static int V, E;
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        int[] parent = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(V1, V2, weight));
        }
        Collections.sort(edges);
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            union(parent, edge.V1, edge.V2, edge.weight);
        }
        System.out.println(result);
    }
    public static int find(int[] parent, int v){//경로 최적화
        if(parent[v] == v){
            return  v;
        }
        else{
            return find(parent, parent[v]);
        }
    }
    public static void union(int[] parent, int v1, int v2, int weight){
        v1 = find(parent, v1);
        v2 = find(parent, v2);
        if(v1 != v2){
            parent[v1] = v2;
            result += weight;
        }
    }
}
