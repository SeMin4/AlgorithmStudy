import java.io.*;
import java.util.StringTokenizer;

public class B_10942 {
    static int N, M;
    public static void main(String[] args) throws IOException {

	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = -1;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = 1;
                dp[i + 1][i] = 1;
            }
            else{
                dp[i][i + 1] = 0;
                dp[i + 1][i] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            bw.write(dynamicDfs(dp, S, E, arr) + "\n");
        }
        bw.close();
    }

    public static int dynamicDfs(int[][] dp, int s, int e, int[] arr){
        if(dp[s][e] == 1){//팰린드롬이다.
            return 1;
        }
        if(dp[s][e] == 0){//팰린 드롬이 아니다.
            return 0;
        }
        else{
            if(dynamicDfs(dp, s + 1, e - 1, arr) == 1){//한칸 줄인게 팰린드롬이다.
                if(arr[s] == arr[e]){
                    dp[s][e] = 1;
                    return 1;
                }
                else{
                    dp[s][e] = 0;
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
    }
}

