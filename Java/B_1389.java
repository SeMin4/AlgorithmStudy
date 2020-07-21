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
public class B_1389 {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int minPerson;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] kevin = new int[N + 1][N + 1];
        int[][] relation = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                kevin[i][j] = 0;
                if(i == j){
                    kevin[i][j] = 1;
                }
                relation[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            Queue<Point> queue = new LinkedList<>();
            for (int j = 1; j < N + 1; j++) {
                if(relation[i][j] == 1){
                    queue.add(new Point(i, j, 1));
                    kevin[i][j] = 1;
                }
            }
            while (!queue.isEmpty()){
                Point point = queue.poll();
                for (int j = 1; j < N + 1; j++) {
                    if(kevin[i][j] == 0 && relation[point.j][j] == 1){
                        kevin[i][j] = point.cnt + 1;
                        queue.add(new Point(point.j, j, point.cnt + 1));
                    }
                }
            }
        }
        int[] sum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            sum[i] = -1;
            for (int j = 1; j < N + 1; j++) {
                sum[i] += kevin[i][j];
            }
            if(sum[i] < min){
                min = sum[i];
                minPerson = i;
            }
        }
        System.out.println(minPerson);

    }
}
