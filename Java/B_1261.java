import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Position implements Comparable<Position>{
    int i;
    int j;
    int cnt;
    public Position(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Position o) {
        if(this.cnt < o.cnt)return -1;
        else if(this.cnt == o.cnt) return 0;
        else return 1;
    }
}
public class B_1261 {
    static int N, M;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        int[][] max = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(max[i], 2000000000);
        }
        max[0][0] = 0;
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(0, 0, 0));
        while (!pq.isEmpty()){
            Position position = pq.poll();
            if(position.i == N - 1 && position.j == M - 1){
                System.out.println(position.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tmpI = position.i + dI[i];
                int tmpJ = position.j + dJ[i];
                if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M){
                    if(max[tmpI][tmpJ] > position.cnt + 1 && (map[tmpI][tmpJ] == 1)){

                        max[tmpI][tmpJ] = position.cnt + 1;
                        pq.offer(new Position(tmpI, tmpJ, position.cnt + 1));

                    }
                    else if(max[tmpI][tmpJ] > position.cnt && map[tmpI][tmpJ] == 0){

                        max[tmpI][tmpJ] = position.cnt;
                        pq.offer(new Position(tmpI,tmpJ, position.cnt));
                    }

                }
            }
        }
    }
}
