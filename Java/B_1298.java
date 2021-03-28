import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1298{

    static int MAX_RESUT = 0;
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[N + 1];
        int[] match = new int[N + 1];
        Arrays.fill(match, -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list[n].add(m);
        }
        for (int i = 1; i < list.length; i++) {
            Arrays.fill(visit,false);
            if(dfs(list, visit, i, match)){
                MAX_RESUT += 1;
            }
        }
        System.out.println(MAX_RESUT);
    }

    public static boolean dfs(ArrayList<Integer>[] list, boolean[] visit, int node, int[] match){
        for (int i = 0; i < list[node].size(); i++) {
            int m = list[node].get(i);

            if(visit[m]){
               continue;
            }

            visit[m] = true;

            if(match[m] == -1 || dfs(list, visit, match[m], match)){
                match[m] = node;
                return true;
            }
        }
        return false;
    }


}
