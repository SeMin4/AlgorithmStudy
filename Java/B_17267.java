import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class People{
    int i;
    int j;
    int leftLimit;
    int rightLimit;
    public People(int i, int j, int leftLimit, int rightLimit){
        this.i = i;
        this.j = j;
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }
}
public class B_17267 {
    static int N, M;
    static int leftLimit, rightLimit;
    static int[] dI = {-1, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        leftLimit = Integer.parseInt(st.nextToken());
        rightLimit = Integer.parseInt(st.nextToken());
        People init = null;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
                if (map[i][j] == 2) {
                    init = new People(i, j, leftLimit, rightLimit);
                    map[i][j] = 0;
                }
            }
        }
        bfs(init, map);
        System.out.println(cnt);
    }

    public static void bfs(People people, int[][] map) {
        Queue<People> queue = new LinkedList<>();
        queue.offer(people);
        boolean[][] visit = new boolean[N][M];
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(visit[i], Integer.MIN_VALUE);
//        }
        visit[people.i][people.j] = true;
        cnt += 1;
        while (!queue.isEmpty()) {
            People current = queue.poll();
            int tmpI;
            tmpI = current.i - 1;
            while (tmpI >= 0 && map[tmpI][current.j] == 0) {//상하는 빠르게..
                if (!visit[tmpI][current.j]){
                    visit[tmpI][current.j] = true;
                    queue.offer(new People(tmpI, current.j, current.leftLimit, current.rightLimit));
                    cnt += 1;
                }
                else break;
                tmpI -= 1;
            }
            tmpI = current.i + 1;
            while (tmpI < N && map[tmpI][current.j] == 0) {
                if (!visit[tmpI][current.j]){
                    visit[tmpI][current.j] = true;
                    queue.offer(new People(tmpI, current.j, current.leftLimit, current.rightLimit));
                    cnt += 1;
                }
                else break;
                tmpI += 1;
            }
            if(current.leftLimit > 0){//좌우는 한칸씩
                int tmpJ = current.j - 1;
                if(tmpJ >= 0){
                    if(map[current.i][tmpJ] == 0 && !visit[current.i][tmpJ]){
                        visit[current.i][tmpJ] = true;
                        queue.offer(new People(current.i, tmpJ, current.leftLimit - 1, current.rightLimit));
                        cnt += 1;
                    }
                }
            }
            if(current.rightLimit > 0){//좌우는 한칸씩
                int tmpJ = current.j + 1;
                if(tmpJ < M){
                    if(map[current.i][tmpJ] == 0 && !visit[current.i][tmpJ]){
                        visit[current.i][tmpJ] = true;
                        queue.offer(new People(current.i, tmpJ, current.leftLimit, current.rightLimit - 1));
                        cnt += 1;
                    }
                }
            }
        }
    }
}