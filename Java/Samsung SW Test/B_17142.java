
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Virus{
    int i;
    int j;
    int count;
    public Virus(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.count = cnt;
    }
}
public class B_17142{
    static int N, M;
    static int[] di = {0, -1 ,0, 1};
    static int[] dj = {-1, 0, 1, 0};
    static int min_cnt = Integer.MAX_VALUE;
    static ArrayList<Virus> virusArrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virusArrayList.add(new Virus(i, j, 0));
                }
            }
        }
        boolean[] virusBoolean = new boolean[virusArrayList.size()];
        selectVirus(virusBoolean, map, 0, 0);
        if(min_cnt == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min_cnt);
    }
    public static void selectVirus(boolean[] virusBoolean, int[][] map, int depth, int current_idx){
        if(depth == M){
            int tmp =calculateTime(virusBoolean, map);
            if(tmp < min_cnt){
                min_cnt = tmp;
            }
            return;
        }
        //depth 뽑은 갯수
        //virusBoolean.length - i 남은 개수
        //M 뽑아야 하는 개수
        for (int i = current_idx; i < virusBoolean.length ; i++) {
            if(virusBoolean.length - i + depth >= M){
                virusBoolean[i] = true;
                selectVirus(virusBoolean, map,depth + 1, i + 1);
                virusBoolean[i] = false;
            }
            else{
                return;
            }

        }
    }
    public static int calculateTime(boolean[] virusBoolean, int[][] map){

        int[][] checkMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                checkMap[i][j] = map[i][j];
            }
        }
        Queue<Virus> virusQueue = new LinkedList<>();
        for(int i = 0; i < virusBoolean.length; ++i){
            if(virusBoolean[i]){
                virusQueue.add(virusArrayList.get(i));
                checkMap[virusArrayList.get(i).i][virusArrayList.get(i).j] = 3;
            }
        }
        int cnt = 0;
        int prev_cnt = 0;
        while (!virusQueue.isEmpty()){
            Virus virus = virusQueue.poll();
            cnt = virus.count;
            if(map[virus.i][virus.j] == 2)
                cnt = prev_cnt;
            prev_cnt = cnt;

            if(cnt > min_cnt){
                return Integer.MAX_VALUE;
            }
            int tmpI = virus.i;
            int tmpJ = virus.j;
            for(int i = 0; i < 4; ++i){
                tmpI =  virus.i + di[i];
                tmpJ = virus.j + dj[i];
                if(tmpI >=0 && tmpI < N && tmpJ >= 0 && tmpJ < N){
                    if(checkMap[tmpI][tmpJ] == 0){
                        virusQueue.add(new Virus(tmpI, tmpJ,  virus.count + 1));
                        checkMap[tmpI][tmpJ] = 3;
                    }else if(checkMap[tmpI][tmpJ] == 2){
                        virusQueue.add(new Virus(tmpI, tmpJ,  virus.count + 1));
                        checkMap[tmpI][tmpJ] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(checkMap[i][j] == 0)
                    return Integer.MAX_VALUE;
            }
        }
        return cnt;
    }
}
