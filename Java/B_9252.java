import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Parent{
    int i;
    int j;
    public Parent(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class B_9252 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int[][] parent = new int[N + 1][M + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    parent[i][j] = 1;
                }
                else{
                    if(dp[i - 1][j] > dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j];
                        parent[i][j] = -1;
                    }
                    else{
                        dp[i][j] = dp[i][j - 1];
                        parent[i][j] = -2;
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
        System.out.println(LCS(parent,N,M, sb, str1).reverse().toString());
    }
    public static StringBuilder LCS(int[][] parent, int N, int M, StringBuilder sb, String str){
        if(parent[N][M] == 0)
            return sb;
        if(parent[N][M] == 1){
            sb.append(str.charAt(N - 1));
            return LCS(parent, N -1 ,M - 1, sb, str);
        }
        else{
            if(parent[N][M] == -1){
                return LCS(parent, N - 1, M , sb, str);
            }
            else{
                return LCS(parent, N, M - 1, sb, str);
            }
        }


    }
}
