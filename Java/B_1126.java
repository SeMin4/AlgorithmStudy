import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1126 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] blockList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            blockList[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[50][500001];//i:그블록을 사용 한다 j : 두탑의 높이의 차이
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 500001; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        dp[0][blockList[0]] = blockList[0];//첫번째를 사용하였으면 최대치는 그 높이만큼.
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 500001; j++) {
                if (dp[i - 1][j] == -1) {
                    continue;
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);//안쓰는 경우
                    dp[i][j + blockList[i]] = Math.max(dp[i][j + blockList[i]], dp[i - 1][j] + blockList[i]);//block을 쓰는 경우(원래 높은 곳에다가 또 놓는 경우임)
                    if(blockList[i] > j){//두탑의 차이보다 현재 쌓으려는게 더 크다?
                        dp[i][blockList[i] - j] = Math.max(dp[i][blockList[i] - j], dp[i - 1][j] + blockList[i] - j);
                    }
                    else{//현재 쌓아도 값이 높은애가 계속 높다!
                        dp[i][j - blockList[i]] = Math.max(dp[i][j - blockList[i]], dp[i - 1][j]);
                    }
                }
            }
        }
        if(dp[N - 1][0] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[N - 1][0]);
    }
}
