import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Point{
    int i;
    int j;
    int cnt;
    public Point(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}
public class B_2178 {
    static int N, M;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
                if(arr[i][j] == 0)
                    visit[i][j] = true;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visit[0][0] = true;
        while (!queue.isEmpty()){
            Point point = queue.poll();
            if(point.i == N - 1 && point.j == M - 1){
                System.out.println(point.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tmpI = point.i + dI[i];
                int tmpJ = point.j + dJ[i];
                if(tmpI >= 0 && tmpI < N && tmpJ >=  0 && tmpJ < M){
                    if(!visit[tmpI][tmpJ] && arr[tmpI][tmpJ] == 1){
                        queue.add(new Point(tmpI, tmpJ, point.cnt + 1));
                        visit[tmpI][tmpJ] = true;
                    }
                }
            }
        }
    }
}
