import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2573 {
    static int N, M;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt= 0;
        while (true){
            int island = bfs(map);
            if(island == 0 || island >= 2){
                if(island == 0)
                    cnt = 0;
                break;
            }
            map = meltIce(map);
            cnt += 1;

        }
        System.out.println(cnt);

    }
    public static int[][] meltIce(int[][] map){
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int tmpI = i + dI[k];
                        int tmpJ = j + dJ[k];
                        if(map[tmpI][tmpJ] == 0){
                            cnt += 1;
                        }
                    }
                    if(map[i][j] - cnt < 0){
                        newMap[i][j] = 0;
                    }
                    else{
                        newMap[i][j] = map[i][j] - cnt;
                    }
                }
            }
        }
        return newMap;
    }
    public static int bfs(int[][] map){
        int cnt = 0;
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visit[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    visit[i][j] = true;
                    cnt += 1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] tmp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int tmpI = tmp[0] + dI[k];
                            int tmpJ = tmp[1] + dJ[k];
                            if(map[tmpI][tmpJ] != 0 && !visit[tmpI][tmpJ]){
                                visit[tmpI][tmpJ] = true;
                                queue.offer(new int[]{tmpI, tmpJ});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
