

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Rotate{
    int number;
    int direction;
    int cnt;
    public Rotate(int number, int direction, int cnt){
        this.number = number;
        this.direction =direction;
        this.cnt = cnt;
    }
}
class Point{
    int i;
    int j;
    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class B_17822 {
    static int N, M, T;
    static  int sum = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] roundPlane = new int[N + 1][M];
        for (int i = 1; i <=N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                roundPlane[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Rotate> rotateArrayList = new ArrayList<>();
        for(int i = 0; i < T; ++i){
            st = new StringTokenizer(br.readLine());
            rotateArrayList.add(new Rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < rotateArrayList.size(); ++i){
            Rotate rotate = rotateArrayList.get(i);
            rotateRoundPlane(rotate, roundPlane);
            if(checkRemove(roundPlane)){//지운게 없으면
                averagePlane(roundPlane);
            }
        }
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j < M ; j++) {
                sum += roundPlane[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void rotateRoundPlane(Rotate rotate, int[][] roundPlane){
        rotate.cnt %= M;
        if(rotate.direction == 0){
            for(int i = 1; i <= rotate.cnt; ++i){
                for(int j = rotate.number ; j < roundPlane.length; j += rotate.number){
                    int tmp = roundPlane[j][M - 1];
                    for(int k = roundPlane[j].length - 1; k >= 1; --k){
                        roundPlane[j][k] = roundPlane[j][k - 1];
                    }
                    roundPlane[j][0] = tmp;
                }
            }
        }else{
            for(int i = 1; i <= rotate.cnt; ++i){
                for(int j = rotate.number ; j < roundPlane.length; j += rotate.number){
                    int tmp = roundPlane[j][0];
                    for(int k = 0; k < roundPlane[j].length - 1 ; ++k){
                        roundPlane[j][k] = roundPlane[j][k + 1];
                    }
                    roundPlane[j][M - 1] = tmp;
                }
            }
        }

    }
    public static boolean checkRemove(int[][] roundPlane){
        boolean flag;
        Queue<Point> deleteQueue = new LinkedList<>();
        for(int i = 1; i <= N; ++i){
            if(roundPlane[i][0] != 0 && roundPlane[i][0] == roundPlane[i][M - 1]){
                deleteQueue.add(new Point(i, 0));
                deleteQueue.add(new Point(i, M - 1));
            }
            for (int j = 0; j < M - 1; j++) {
                if(roundPlane[i][j] != 0){
                    if(roundPlane[i][j] == roundPlane[i][j + 1]){
                        deleteQueue.add(new Point(i, j));
                        deleteQueue.add(new Point(i, j + 1));
                    }
                }
            }

        }
        for(int j = 0; j < M ; ++j){
            for (int i = 1; i <= N - 1 ; i++) {
                if(roundPlane[i][j] != 0){
                    if(roundPlane[i][j] == roundPlane[i + 1][j]){
                        deleteQueue.add(new Point(i, j));
                        deleteQueue.add(new Point(i + 1, j));
                    }
                }
            }
        }
        if(deleteQueue.isEmpty()){
            return true;
        }
        while(!deleteQueue.isEmpty()){
            Point point = deleteQueue.poll();
            roundPlane[point.i][point.j] = 0;
        }
        return false;
    }

    public static void averagePlane(int[][] roundPlane){
        double sum = 0;
        double average = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(roundPlane[i][j] != 0){
                    sum += roundPlane[i][j];
                    cnt += 1;
                }

            }
        }
        average = sum / cnt;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(roundPlane[i][j] != 0){
                    if(roundPlane[i][j] < average){
                        roundPlane[i][j] += 1;
                    }
                    else if(roundPlane[i][j] > average){
                        roundPlane[i][j] -= 1;
                    }
                }

            }
        }
    }
}
