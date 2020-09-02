import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2056 {
    static int N;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] visit = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            int constraint = Integer.parseInt(st.nextToken());
            for (int j = 0; j < constraint; j++) {
                int constraintVertex = Integer.parseInt(st.nextToken());
                graph[constraintVertex].add(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            if(visit[i] == 0){
                visit[i] = weight[i];
                bfs(i, graph, visit, weight);
            }
        }
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, visit[i]);
        }
        System.out.println(result);
    }
    public static void bfs(int vertex, ArrayList<Integer>[] graph, int[] visit, int[] weight){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        while (!queue.isEmpty()){
            vertex = queue.poll();
            ArrayList<Integer> lists = graph[vertex];
            for(int i = 0; i < lists.size(); ++i){
                int ver = lists.get(i);
                if(visit[ver] < visit[vertex] + weight[ver]){
                    visit[ver] = visit[vertex] + weight[ver];
                    queue.offer(ver);
                }
            }
        }
    }
}
