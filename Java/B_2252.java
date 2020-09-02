import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] ind = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            ind[b] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(ind[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            bw.write(vertex + " ");
            for (Integer ver : list[vertex]) {
                ind[ver] -= 1;
                if(ind[ver] == 0){
                    queue.offer(ver);
                }
            }
        }
        bw.write('\n');
        bw.close();
    }
}
