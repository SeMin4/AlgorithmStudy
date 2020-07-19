import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1260 {
    static int N, M, V;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int[][] dfsArr = new int[N + 1][N + 1];
        int[][] bfsArr = new int[N + 1][N + 1];
        boolean[] visitDfs = new boolean[N + 1];
        boolean[] visitBfs = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dfsArr[i][j] = 0;
                bfsArr[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!visitDfs[a]){
                visitBfs[a] = true;
                visitDfs[a]  = true;
            }
            if(!visitDfs[b]){
                visitDfs[b] = true;
                visitBfs[b] = true;
            }
            dfsArr[a][b] += 1;
            dfsArr[b][a] += 1;
            bfsArr[a][b] += 1;
            bfsArr[b][a] += 1;

        }
        visitDfs[V] = false;
        dfs(dfsArr, V, visitDfs);
        System.out.println();
        visitBfs[V] = false;
        bfs(bfsArr, V, visitBfs);
    }
    public static void dfs(int[][] dfsArr, int vertex, boolean[] visit){
        System.out.print(vertex + " ");
            for (int j = 1; j < N + 1; j++) {
                if(dfsArr[vertex][j] != 0 && visit[j]){
                    visit[j] = false;
                    dfs(dfsArr, j, visit);
            }
        }
    }
    public static void bfs(int[][] bfsArr, int vertex, boolean[] visit){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for (int i = 1; i < N + 1; i++) {
                if(bfsArr[tmp][i] != 0 && visit[i]){
                    queue.add(i);
                    visit[i] = false;
                }
            }

        }
    }
}
