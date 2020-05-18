
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15684 {
    static int N, M, H;// 세로줄의 개수, 이미 그어져 있는 가로선의 개수, 가로줄의 개수
    static int result = 4;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][] ladder = new int[H][N];//마지막 세로선에는 가로선을 그을 수 없다.
        for(int i = 0; i < H; ++i){
            for(int j = 0; j < N; ++j){
                ladder[i][j] = 0;
            }
        }//0 점선 이라서 사다리를 놓을 수 있다라는 뜻
        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            ladder[x][y] = 1;
            ladder[x][y + 1] = 2;
        }
        if(M == 0){
            System.out.println(0);
        }
        else{
            selectLine(ladder, 0, 0, 0);
            if(result == 4){
                System.out.println(-1);
            }
            else
                System.out.println(result);
        }

    }
    public static boolean playingLadder(int[][] ladder, int cnt){
        if(cnt % 2 == 1)//들어온 선의 가로 선의 개수가 이미 홀수면 무조건 안댐...
            return false;
        for(int every_player =  0; every_player < N - 1; ++every_player) {// 10명중 9명이 같으면 무조건 남은 한명도 같다 따라서 1명을 뺌.... 어떻게든 시간을 줄여보자...
            int player = every_player;
            for (int i = 0; i < H; ++i) {
                if (ladder[i][player] == 1) {
                    player += 1;
                }else if(ladder[i][player] == 2){
                    player -= 1;
                }
            }
            if(every_player != player){//한명이라도 다르면 무조건 false를 뱉자...
                return false;
            }
        }
        return true;//다같은 경우
    }
    public static void selectLine(int[][] ladder, int row, int col, int depth){
        if(depth >= result){//3개 이상 뽑거나 이미 최소수 이상으로 뽑으려고 하면
            return;
        }
        if(playingLadder(ladder, M+depth)){//게임 돌리기....
            result = depth;
            return;
        }

        for(int i = row; i < H; ++i){
            for(int j = col; j < N - 1; ++j){//제일 마지막 세로선에는 가로선을 긋지 못하게 하기
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0){
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = 2;
                    selectLine(ladder, i, j + 2, depth + 1);
                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }else if(ladder[i][j] == 1){//1이면 그뒤에에는 무조건 선을 그을 수 없으므로 2칸씩 검사해보자... 시간을 줄여보자....
                    ++j;
                }
            }
            col = 0;
        }
    }
}
