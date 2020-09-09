import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9466 {
    static int T, N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] ind = new int[N + 1];
            int[] arr = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                ind[arr[j]] += 1;
            }
            int result = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j <= N; j++) {
                if(ind[j] == 0)
                    queue.offer(j);
            }
            while (!queue.isEmpty()){
                int vert = queue.poll();
                result += 1;
                ind[arr[vert]] -= 1;
                if(ind[arr[vert]] == 0){
                    queue.offer(arr[vert]);
                }
            }
            System.out.println(result);
        }
    }
}
