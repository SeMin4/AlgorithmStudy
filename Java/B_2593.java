import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Info{
    int elevator;
    int cnt;
    public Info(int elevator, int cnt){
        this.elevator = elevator;
        this.cnt = cnt;
    }
}
public class B_2593{
    static int N, M, S, E;
    static int last = -1;
    static int depth = -1;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        int[][] elevators = new int[M][N + 1];
        boolean[] visit = new boolean[M];//그 엘리베이터는 타봤다..
        int[] parent =  new int[M];
        int[][] elvInfo = new int[M][2];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int inc = Integer.parseInt(st.nextToken());
            elvInfo[i][0] = start;
            elvInfo[i][1] = inc;
//            for (int j = start; j <= N; j+=inc) {
//                elevators[i][j] = 1;
//            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Queue<Info> infoQueue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if((S >= elvInfo[i][0]) && (S - elvInfo[i][0]) % elvInfo[i][1] == 0){
                visit[i] = true;
                infoQueue.offer(new Info(i, 1));
            }
        }
        if(infoQueue.size() == 0){
            System.out.println(-1);
            return;
        }
        while (!infoQueue.isEmpty()){
            Info info = infoQueue.poll();
//            if(E < elvInfo[info.elevator][0]) continue;
            if((E >= elvInfo[info.elevator][0]) && (E - elvInfo[info.elevator][0]) % elvInfo[info.elevator][1]  == 0){
                last = info.elevator;
                depth = info.cnt;
                break;
            }
            int startFloor = elvInfo[info.elevator][0];
            int inc = elvInfo[info.elevator][1];
            for(int j = 0; j < M; ++j){
                if(!visit[j]){
                    for(int i = startFloor; i <= N; i+= inc){
                        if(i >= elvInfo[j][0] && (((i - elvInfo[j][0]) % elvInfo[j][1]) == 0)){
                            visit[j] = true;
                            parent[j] = info.elevator;
                            infoQueue.offer(new Info(j, info.cnt + 1));
                            break;
                        }
                    }
                }
            }
//            for (int i = startFloor; i <= N; i+=inc) {//층수..
//                for (int j = 0; j < M; j++) {
//                    if((i >= elvInfo[j][0]) && (((i - elvInfo[j][0]) % elvInfo[j][1]) == 0)  && !visit[j]){//아직 한번도 타보지 못한 엘리베이터라면?
//                        visit[j] = true;
//                        parent[j] = info.elevator;
//                        infoQueue.offer(new Info(j, info.cnt + 1));
//                    }
//                }
//            }
        }
        if(last == -1)
            System.out.println(-1);
        else{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(depth + "\n");
            dfs(bw,parent, last);
            bw.close();
        }

    }
    public static void dfs(BufferedWriter bw, int[] parent, int elv) throws IOException{
        if(parent[elv] == -1){
            bw.write(elv + 1 + "\n");
            return;
        }
        dfs(bw, parent, parent[elv]);
        bw.write(elv + 1 + "\n");

    }


}
