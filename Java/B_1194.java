

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Position{
    int i;
    int j;
    int cnt;
    int key;
    public Position(int i, int j, int cnt, int key){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
        this.key = key;
    }
}
public class B_1194 {
    static int N, M;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int initI = 0, initJ = 0;
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == '0'){
                    initI = i;
                    initJ = j;
                    map[i][j] = '.';
                }
            }
        }
        boolean[][][] visit = new boolean[1<<6][N][M];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(initI, initJ, 0, 0));
        visit[0][initI][initJ] = true;
        int ret = -1;
        queueLoop: while (!queue.isEmpty()){
            Position pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tmpI = pos.i + dI[i];
                int tmpJ = pos.j + dJ[i];
                if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M){
                    if(!visit[pos.key][tmpI][tmpJ] && map[tmpI][tmpJ] != '#'){
                        visit[pos.key][tmpI][tmpJ] = true;
                        if(map[tmpI][tmpJ] == '.'){
                            queue.offer(new Position(tmpI, tmpJ, pos.cnt + 1, pos.key));
                        }
                        else if(map[tmpI][tmpJ] >= 'a' && map[tmpI][tmpJ] <= 'f'){
                            int key = 1 << (map[tmpI][tmpJ] - 'a');
                            key |= pos.key;
                            queue.offer(new Position(tmpI, tmpJ, pos.cnt + 1, key));
                        }
                        else if(map[tmpI][tmpJ] == '1'){
                            ret = pos.cnt + 1;
                            break queueLoop;
                        }
                        else if(map[tmpI][tmpJ] >='A' && map[tmpI][tmpJ] <= 'F'){
                            int key = 1 << (map[tmpI][tmpJ] - 'A');
                            key &= pos.key;
                            if(key > 0){
                                queue.offer(new Position(tmpI, tmpJ, pos.cnt + 1, pos.key));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ret);
    }
}
