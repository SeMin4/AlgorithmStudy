import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1014 {
    static int C, N, M;
    static int[] dI = {-1, -1, 0, 0};
    static int[] dJ = {-1, 1, -1, 1};
//    static int[] dI = {1, 1, 0, 0};
//    static int[] dJ = {-1, 1, -1, 1};
    static int max_student = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][] classRoom = new int[N][M];
            for (int j = 0; j < N; j++) {
                String tmp = br.readLine();
                for (int k = 0; k < M; k++) {
                    classRoom[j][k] = tmp.charAt(k) == '.' ? 0 : 1;
                }
            }
            sitSeat(classRoom);
            bw.write(max_student + "\n");
            bw.flush();
            max_student = 0;
        }
        bw.close();

    }
    public static void sitSeat(int[][] classRoom){
        int row = (int) Math.pow(2, M);//앉을수 있는 모든 경우의 수
        int[][] dp = new int[N][row];
        for (int i = 0; i < N; i++) {
            //자기 바로 밑에서 앉을수 있었던 경우의 수들 중에 최대값을 구하자!..
            for (int j = 0; j < row; j++) {//앉을수 있는 모든 경우의 수..
                int preBitMask = 0;
                int bitCnt = 0;
                for (int k = 0; k < M; k++) {
                    int bitMask = j & (1 << k);
                    if(preBitMask > 0 && bitMask > 0){//연속된 1의 값
                        bitCnt = 0;
                        break;
                    }
                    else{
                        if(bitMask > 0){//현재 그값이 1로 세팅..
                            if(classRoom[i][k] == 1){//부서져서 못앉는데 그 비트가 1인 경우..
                                bitCnt = 0;
                                break;
                            }
                            bitCnt += 1;
                        }
                    }
                    preBitMask = bitMask;
                }
                dp[i][j] = bitCnt;
                if(i == 0){
                    max_student = Math.max(max_student, dp[i][j]);
                    continue;
                }
                //자기 바로 윗줄중에서 앉을 수 있는 조합중 최대 조합 구하기.. 그리고 그값과 이값을 더해서 다시 저장
                int maxSitCnt = 0;
                int tmpJ = 0;
                tmpJ |= (j << 1);
                tmpJ |= (j >> 1);
                for (int k = 0; k < row; k++) {
                    //현재 1로 세팅 되어있는 오른쪽 왼쪽을 1로..
                    if((tmpJ & k) == 0){//조건을 만족..현재 1로 세팅 되어 있는 왼쪽 아래 오른쪽 아래가 1이면 안됨..
                        maxSitCnt = Math.max(maxSitCnt, dp[i - 1][k]);
                    }
                }
                dp[i][j] = Math.max(dp[i][j] + maxSitCnt, dp[i][j]);
                max_student = Math.max(dp[i][j], max_student);
            }
        }

    }
}
