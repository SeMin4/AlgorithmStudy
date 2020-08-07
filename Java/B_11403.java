import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11403 {
    static int N;
    static int[][] result;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[N][N];

        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                Arrays.fill(visit[j], false);
            }
            bfs(i, graph, visit);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void bfs(int startIdx, int[][] graph, boolean[][] visit){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if(graph[startIdx][i] == 1){
                visit[startIdx][i] = true;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer point = queue.poll();
            result[startIdx][point] = 1;
            for (int i = 0; i < N; i++) {
                if(graph[point][i] == 1 && !visit[point][i] && result[startIdx][i] != 1){
                    visit[point][i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

