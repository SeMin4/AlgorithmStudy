import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11437 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] depth = new int[N + 1];
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            list[V1].add(V2);
            list[V2].add(V1);
        }
        dfs(1, depth, 1, list, parent);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int depV1 = depth[V1];
            int depV2 = depth[V2];
            if(depV1 > depV2){//v1이 무조건 작게... 깊이가
                int tmp;
                tmp = depV1;
                depV1 = depV2;
                depV2 = tmp;
                tmp = V1;
                V1 = V2;
                V2 = tmp;
            }
            while (depV1 != depV2){
                V2 = parent[V2];
                depV2 = depth[V2];
            }
            while (V1 != V2){
                V1 = parent[V1];
                V2 = parent[V2];
            }
            System.out.println(V1);

        }


    }
    public static void dfs(int V, int[] depth, int dep, ArrayList<Integer>[] tree, int[] parent){
        depth[V] = dep;
        for (int i = 0; i < tree[V].size(); i++) {
            int v = tree[V].get(i);
            if(depth[v] == 0){
                parent[v] = V;
                dfs(v, depth, dep + 1, tree, parent);
            }

        }
    }
}
