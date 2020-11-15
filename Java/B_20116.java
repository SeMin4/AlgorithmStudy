import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B_20116 {
    static int N, L;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        long[] x = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }
        long[] dp = new long[N];
        dp[N - 1] = x[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + x[i];
        }
        boolean flag = false;
        for (int i = N - 1, cnt = 1; i >= 1; i--, cnt += 1) {
            double xcenter = (double) dp[i] / (double) cnt;
            if(!((x[i - 1] - L) < xcenter && xcenter < (x[i - 1] + L))){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("unstable");
        }
        else{
            System.out.println("stable");
        }
    }
}