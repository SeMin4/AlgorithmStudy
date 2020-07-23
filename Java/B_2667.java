import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
class Point{
    int i;
    int j;
    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class B_2667 {
    static int N;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visit[i][j]){
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    int cnt = 0;
                    while (!queue.isEmpty()){
                        Point point = queue.poll();
                        cnt += 1;
                        for (int k = 0; k < 4; k++) {
                            int tmpI = point.i + dI[k];
                            int tmpJ = point.j + dJ[k];
                            if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N){
                                if(map[tmpI][tmpJ] == 1 && !visit[tmpI][tmpJ]){
                                    queue.add(new Point(tmpI, tmpJ));
                                    visit[tmpI][tmpJ] = true;
                                }
                            }
                        }
                    }
                    result.add(cnt);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
