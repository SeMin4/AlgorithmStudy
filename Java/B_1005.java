import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Vertex{
    ArrayList<Integer> vertexList = new ArrayList<>();
}
public class B_1005 {
    static int T, N, K, W;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] time = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                time[j] = Integer.parseInt(st.nextToken());//건물 건설 시간
            }
            Vertex[] graph = new Vertex[N];
            for (int j = 0; j < N; j++) {
                graph[j] = new Vertex();
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int tmpI = Integer.parseInt(st.nextToken());
                int tmpJ = Integer.parseInt(st.nextToken());
                graph[tmpJ - 1].vertexList.add(tmpI - 1);
            }
            W = Integer.parseInt(br.readLine()) - 1;
            result = Integer.MIN_VALUE;
            int[] dp = new int[N];
            for (int j = 0; j < N; j++) {
                dp[j] = -1;
            }
            result = dfs(graph, time, W, dp);
            bw.write(result + "\n");
        }
        bw.close();
    }

    public static int dfs(Vertex[] graph, int[] time, int start, int[] dp){
        if(dp[start] != -1)
            return dp[start];
        int cost = 0;
        for (int i = 0; i < graph[start].vertexList.size(); i++) {
            Integer v = graph[start].vertexList.get(i);
            cost = Math.max(cost, dfs(graph, time, v, dp));
        }
        return dp[start]  = cost + time[start];
    }
}
