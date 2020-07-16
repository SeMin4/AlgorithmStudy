import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
public class B_7576 {
    static int M, N;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Point> points = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    points.add(new Point(i,j, 0));
                    visited[i][j] = true;
                }
                else if(map[i][j] == -1){
                    visited[i][j] = true;
                }
            }
        }
        while (!points.isEmpty()){
            Point point = points.poll();
            if(point.cnt > result){
                result = point.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int tmpI = point.i + dI[i];
                int tmpJ = point.j + dJ[i];
                if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M){
                    if(visited[tmpI][tmpJ] == false && map[tmpI][tmpJ] == 0){
                        points.add(new Point(tmpI, tmpJ, point.cnt + 1));
                        map[tmpI][tmpJ] = 1;
                    }
                }
            }
        }
        boolean flag  = check(map);
        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }
    public static boolean check(int[][] map){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
