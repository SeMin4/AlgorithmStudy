import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2623 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int[] ind = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            for (int j = 0; j < T - 1; j++) {
                int child = Integer.parseInt(st.nextToken());
                list[parent].add(child);
                ind[child] += 1;
                parent = child;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if(ind[i] == 0 && !visit[i]){
                queue.offer(i);
                visit[i] = true;
                while (!queue.isEmpty()){
                    int v = queue.poll();
                    seq.add(v);
                    for (int j = 0; j < list[v].size(); j++) {
                        int v2 = list[v].get(j);
                        ind[v2] -= 1;
                        if(ind[v2] == 0 && !visit[v2]){
                            queue.offer(v2);
                            visit[v2] = true;
                        }
                    }
                }
            }

        }
        if(seq.size() == N){
            for (int i = 0; i < seq.size(); i++) {
                System.out.println(seq.get(i));
            }
        }else{
            System.out.println(0);
        }
    }
}
