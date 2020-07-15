import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[][] networkGraph = new boolean[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                networkGraph[i][j] = false;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmpA = Integer.parseInt(st.nextToken());
            int tmpB = Integer.parseInt(st.nextToken());
            networkGraph[tmpA][tmpB] = true;
            networkGraph[tmpB][tmpA] = true;
        }
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int cnt = 0;
        while (!queue.isEmpty()){
            Integer a = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if(networkGraph[a][i] && !visited[i]){
                    queue.add(i);
                    cnt += 1;
                    visited[i] = true;
                }
            }
        }
        System.out.println(cnt);


    }
}
