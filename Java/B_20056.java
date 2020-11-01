import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Ball{
    int m;
    int s;
    int d;
    public Ball(){
        this.m = 0;
        this.s = 0;
        this.d = 0;
    }
    public Ball(int m, int s, int d){
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
class Map{
    ArrayList<Ball> list = new ArrayList<>();
}
public class B_20056 {
    static int N, M, K;
    static int[] dI = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dJ = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map[][] map = new Map[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Map();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpI = Integer.parseInt(st.nextToken()) - 1;
            int tmpJ = Integer.parseInt(st.nextToken()) - 1;
            int tmpM = Integer.parseInt(st.nextToken());
            int tmpS = Integer.parseInt(st.nextToken());
            int tmpD = Integer.parseInt(st.nextToken());
            map[tmpI][tmpJ].list.add(new Ball(tmpM,tmpS, tmpD));
        }
        while (K > 0){
            map = moveBall(map);
            K--;
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < map[i][j].list.size(); k++) {
                    sum += map[i][j].list.get(k).m;
                }
            }
        }
        System.out.println(sum);

    }
    public static Map[][] moveBall(Map[][] map){
        Map[][] retMap = new Map[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                retMap[i][j] = new Map();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ArrayList<Ball> ballList = map[i][j].list;
                for (int k = 0; k < ballList.size(); k++) {
                    Ball ball = ballList.get(k);
                    int tmpI = i + (dI[ball.d] * ball.s);
                    if(tmpI > 0){
                        tmpI %= N;
                    }
                    else{
                        tmpI = (tmpI % N + N) % N;
                    }
                    int tmpJ = j + (dJ[ball.d] * ball.s);
                    if(tmpJ > 0){
                        tmpJ %= N;
                    }
                    else{
                        tmpJ = (tmpJ % N + N) % N;
                    }
                    retMap[tmpI][tmpJ].list.add(ball);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ArrayList<Ball> ballList = retMap[i][j].list;
                if(ballList.size() >= 2){
                    int tmpM = 0;
                    int tmpS = 0;
                    int dir = ballList.get(0).d % 2;
                    boolean flag = false;
                    for (int k = 0; k < ballList.size(); k++) {
                        tmpM += ballList.get(k).m;
                        tmpS += ballList.get(k).s;
                        if(!flag && dir != (ballList.get(k).d % 2)){
                            flag = true;
                        }
                    }
                    tmpM /= 5;
                    tmpS /= ballList.size();
                    //flag false면 다같이 방향이 같다는 말
                    //flag true면 방향이 다른애가 1명이라도 있다는 말..
                    ballList.clear();
                    if(tmpM == 0)
                        continue;
                    if(flag){
                        for (int k = 1; k <= 7; k+= 2) {
                            ballList.add(new Ball(tmpM, tmpS, k));
                        }
                    }
                    else{
                        for (int k = 0; k <= 6; k+= 2) {
                            ballList.add(new Ball(tmpM, tmpS, k));
                        }
                    }
                }
            }
        }

        return retMap;
    }
}
