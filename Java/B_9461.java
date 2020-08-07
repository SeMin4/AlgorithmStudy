import java.io.*;

public class B_9461 {
    static int T;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n];
            for (int j = 0; j < n; j++) {
                if(j == 0 || j == 1 || j == 2){
                    dp[j] = 1;
                    continue;
                }
                dp[j] = dp[j - 3] + dp[j - 2];
            }
            bw.write(Long.toString(dp[n - 1]));
            bw.write("\n");
        }
        bw.close();
    }
}
