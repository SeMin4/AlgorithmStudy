import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int i;
    int j;
    char value;
    public Point(int i, int j, char value){
        this.i = i;
        this.j = j;
        this.value = value;
    }
}
public class B_10026 {
    static int N;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        boolean[][] visit = new boolean[N][N];
        int normal_result = normalbfs(map, visit);
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'G')

                    map[i][j] = 'R';
            }
        }
        int color_result = colorbfs(map, visit);
        System.out.println(normal_result + " " + color_result);
    }
    public static int normalbfs(char[][] map, boolean[][] visit){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]){
                    cnt += 1;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j, map[i][j]));
                    visit[i][j]  = true;
                    while (!queue.isEmpty()){
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int tmpI = point.i + dI[k];
                            int tmpJ = point.j + dJ[k];
                            if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N){
                                if(!visit[tmpI][tmpJ] && point.value == map[tmpI][tmpJ]){
                                    visit[tmpI][tmpJ] = true;
                                    queue.add(new Point(tmpI, tmpJ, map[tmpI][tmpJ]));
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public static int colorbfs(char[][] map, boolean[][] visit){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]){
                    cnt += 1;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j, map[i][j]));
                    visit[i][j]  = true;
                    while (!queue.isEmpty()){
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int tmpI = point.i + dI[k];
                            int tmpJ = point.j + dJ[k];
                            if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N){
                                if(!visit[tmpI][tmpJ] && point.value == map[tmpI][tmpJ]){
                                    visit[tmpI][tmpJ] = true;
                                    queue.add(new Point(tmpI, tmpJ, map[tmpI][tmpJ]));
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
