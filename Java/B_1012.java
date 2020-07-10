import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    int i;
    int j;
    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class B_1012 {
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    static int M, N, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        int testCase;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (testCase > 0){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[][] ground = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int tI, tJ;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                tJ = Integer.parseInt(st.nextToken());
                tI = Integer.parseInt(st.nextToken());
                ground[tI][tJ] = 1;//배추심기
                visited[tI][tJ] = true;//방문해야함
            }
            int cnt = bfsMap(ground, visited);
            System.out.println(cnt);
            testCase -= 1;
        }
    }
    public static int bfsMap(int[][] ground, boolean[][] visited){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(ground[i][j] == 1 && visited[i][j]){
                    cnt += 1;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    visited[i][j] = false;
                    while (!queue.isEmpty()){
                        Point tmpPoint = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int tmpI = tmpPoint.i + dI[k];
                            int tmpJ = tmpPoint.j + dJ[k];
                            if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M){
                                if(ground[tmpI][tmpJ] == 1 && visited[tmpI][tmpJ]){
                                    queue.add(new Point(tmpI, tmpJ));
                                    visited[tmpI][tmpJ] = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
