import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
class Edge{
    int vertex;
    int cost;
    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
}
public class B_3176 {
    static int N, K;
    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fr = new FileReader("C:\\Users\\SeMin\\Downloads\\test_data\\lubenica.in.1");
//        BufferedReader br = new BufferedReader(fr);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] depth = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[V1].add(new Edge(V2, cost));
            graph[V2].add(new Edge(V1, cost));
        }
        visit[1] = true;
        depth[1] = 0;
        int[][] parent = new int[N + 1][18];//2^j승의 부모를 저장, 2^j승 까지 부모를 올렸을때 최대 최소 값을 저장
        int[][] max_dp = new int[N + 1][18];//vertex, 최대깊이... 최대 최소.
        int[][] min_dp = new int[N + 1][18];
//        parent[0][0] = -1;
        for (int i = 0; i <= N; i++) {
//            Arrays.fill(parent[i], -1);
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
        }

        dfs(depth, visit, graph, parent, max_dp, min_dp);

        for (int i = 1; i < 18; i++) {//깊이..
            for (int j = 1; j <= N; j++) {//노드
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                min_dp[j][i] = Math.min(min_dp[j][i - 1], min_dp[parent[j][i - 1]][i - 1]);
                max_dp[j][i] = Math.max(max_dp[j][i - 1], max_dp[parent[j][i - 1]][i - 1]);
            }
        }


        K = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] ret = getPath(depth, parent, D, E, max_dp, min_dp);
            bw.write(ret[0] + " " + ret[1] + "\n");
        }
        bw.close();
    }
    public static void dfs(int[] depth, boolean[] visit, ArrayList<Edge>[] graph, int[][] parent, int[][] max_dp, int[][] min_dp){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0});
        int V, dep;
        while (!stack.isEmpty()){
            int[] pop = stack.pop();
            V = pop[0];
            dep = pop[1];
            for (int i = 0; i < graph[V].size(); i++) {
                int v = graph[V].get(i).vertex;
                if(!visit[v]){
                    visit[v] = true;
                    depth[v] = dep + 1;
                    parent[v][0] = V;
                    max_dp[v][0] = graph[V].get(i).cost;//조상으로 올라가기 위한 값을 저장
                    min_dp[v][0] = graph[V].get(i).cost;//조상으로 올라가기 위한 값을 저장
                    stack.push(new int[]{v, dep + 1});
                }
            }
        }
    }
    public static int[] getPath(int[] depth, int[][] parent, int D, int E, int[][] max_dp, int[][] min_dp){
        int[] ret = new int[2];
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        if(depth[D] < depth[E]){
            for (int i = 17; i >= 0; i--) {
                if(depth[D] == depth[E])
                    break;
                if(depth[D] <= depth[parent[E][i]]){
                    minLength = Math.min(minLength, min_dp[E][i]);
                    maxLength = Math.max(maxLength, max_dp[E][i]);
                    E = parent[E][i];
                    i = 17;
                }
            }
        }
        else if(depth[E] < depth[D]){
            for (int i = 17; i >= 0; i--) {
                if(depth[D] == depth[E])
                    break;
                if(depth[E] <= depth[parent[D][i]]){
                    minLength = Math.min(minLength, min_dp[D][i]);
                    maxLength = Math.max(maxLength, max_dp[D][i]);
                    D = parent[D][i];
                    i = 17;
                }
            }
        }
        if(D == E){
            ret[0] = minLength;
            ret[1] = maxLength;
            return ret;
        }
        for (int i = 17; i >= 0; i--) {
            if(parent[D][i] != parent[E][i]){
                minLength = Math.min(minLength, Math.min(min_dp[E][i], min_dp[D][i]));
                maxLength = Math.max(maxLength, Math.max(max_dp[E][i], max_dp[D][i]));
                E = parent[E][i];
                D = parent[D][i];
                i = 17;
            }
        }
        minLength = Math.min(minLength, Math.min(min_dp[E][0], min_dp[D][0]));
        maxLength = Math.max(maxLength, Math.max(max_dp[E][0], max_dp[D][0]));
        ret[0] = minLength;
        ret[1] = maxLength;
        return  ret;
    }
}
