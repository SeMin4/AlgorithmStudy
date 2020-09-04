import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Crystal{
    int i;
    int j;
    int cnt;
    public Crystal(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}
public class B_13460 {
    static int N, M;
    static int destinationI, destinationJ, redI, redJ, blueI, blueJ;
    static int[] dI = {1, 0, -1, 0};
    static int[] dJ = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'O'){
                    destinationI = i;
                    destinationJ = j;
                }
                else if(map[i][j] == 'R'){
                    redI = i;
                    redJ = j;
                }
                else if(map[i][j] == 'B'){
                    blueI = i;
                    blueJ = j;
                }
            }
        }
        int result = bfs(map);
        System.out.println(result);
    }
    public static int bfs(char[][] map){
        Queue<Crystal> redQueue = new LinkedList<>();
        Queue<Crystal> blueQueue = new LinkedList<>();
        redQueue.offer(new Crystal(redI, redJ, 0));
        blueQueue.offer(new Crystal(blueI, blueJ, 0));
        while (true){
            Crystal redCrystal = redQueue.poll();
            Crystal blueCrystal = blueQueue.poll();
            if(redCrystal.cnt <= 9){
                for (int i = 0; i < 4; i++) {
                    int[] redIJ = getIJ(map, redCrystal.i, redCrystal.j, i);
                    int redI = redIJ[0];
                    int redJ = redIJ[1];
                    int[] blueIJ = getIJ(map, blueCrystal.i, blueCrystal.j, i);
                    int blueI = blueIJ[0];
                    int blueJ = blueIJ[1];
                    if(redIJ[0] == -1){//빨간구슬이 빠지고.
                        if(blueIJ[0] != -1)//빨간 구슬만 빼낸경우.
                            return redCrystal.cnt + 1;
                        //같이 빠진 경우... 그냥 버림.
                    }
                    if(blueIJ[0] == -1)//파란구슬만 빼낸 경우..
                        continue;
                    else if(redI == blueI && redJ == blueJ){
                        int redLength = Math.abs(redCrystal.i - redI) + Math.abs(redCrystal.j - redJ);
                        int blueLength = Math.abs(blueCrystal.i - blueI) + Math.abs(blueCrystal.j - blueJ);
                        if(redLength < blueLength){//움직인 거리가 짧다.. red가...
                            blueI = blueI + dI[i];
                            blueJ = blueJ + dJ[i];
                            redQueue.offer(new Crystal(redI, redJ, redCrystal.cnt + 1));
                            blueQueue.offer(new Crystal(blueI, blueJ, blueCrystal.cnt + 1));
                        }
                        else{
                            redI = redI + dI[i];
                            redJ = redJ + dJ[i];
                            redQueue.offer(new Crystal(redI, redJ, redCrystal.cnt + 1));
                            blueQueue.offer(new Crystal(blueI, blueJ, blueCrystal.cnt + 1));
                        }
                    }
                    else{
                        redQueue.offer(new Crystal(redI, redJ, redCrystal.cnt + 1));
                        blueQueue.offer(new Crystal(blueI, blueJ, blueCrystal.cnt + 1));
                    }
                }
            }
            else
                return -1;
        }
    }
    public static int[] getIJ(char[][] map, int i, int j, int type){
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int k;
        switch (type){
            case 0:
                for (k = i - 1; k >= 0; k--) {
                    if(map[k][j] == '#'){
                        break;
                    }
                    else if(map[k][j] =='O'){
                        return ret;
                    }
                }
                ret[0] = k + 1;
                ret[1] = j;
                return ret;
            case 1:
                for (k = j + 1; k < M; k++) {
                    if(map[i][k] == '#')
                        break;
                    else if(map[i][k] == 'O')
                        return ret;
                }
                ret[0] = i;
                ret[1] = k - 1;
                return  ret;
            case 2:
                for(k = i + 1; k < N; ++k){
                    if(map[k][j] == '#')
                        break;
                    else if(map[k][j] == 'O')
                        return ret;
                }
                ret[0] = k - 1;
                ret[1] = j;
                return ret;
            case 3:
                for (k = j - 1; k >= 0; --k){
                    if(map[i][k] == '#')
                        break;
                    else if(map[i][k] == 'O')
                        return ret;
                }
                ret[0] = i;
                ret[1] = k + 1;
                return ret;
            default:
                return ret;
        }
    }
}