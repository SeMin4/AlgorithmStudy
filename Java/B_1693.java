import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1693 {
    static int N;
    static int color;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            graph[V1].add(V2);
            graph[V2].add(V1);
        }
//        color = Math.min(5, N + 1);
        color = 20;
        int[][] dp = new int[N + 1][color];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        dfs(dp, 1, graph, visit);
        int res = dp[1][1];
        for (int i = 1; i < color; i++) {
            res = Math.min(res, dp[1][i]);
        }
        System.out.println(res);
    }
    public static int[] dfs(int[][] dp, int vertex, ArrayList<Integer>[] graph, boolean[] visit){
        if(graph[vertex].size() == 0){
            for (int i = 1; i < color; i++) {
                dp[vertex][i] = i;
            }
            return dp[vertex];
        }
        for (int i = 1; i < color; i++) {
            dp[vertex][i] = i;
        }
        for (int i = 0; i < graph[vertex].size(); i++) {
            int v = graph[vertex].get(i);
            if(!visit[v]){
                visit[v] = true;
                int[] ret = dfs(dp, v, graph, visit);
                for (int j = 1; j < color; j++) {
                    int min = 2100000000;
                    for (int k = 1; k < color; k++) {
                        if(j == k) continue;
                        min = Math.min(min, ret[k]);
                    }
                    dp[vertex][j] += min;
                }
            }
        }
        return dp[vertex];
    }
}
