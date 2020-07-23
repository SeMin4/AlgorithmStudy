import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5525 {
    static int N, M;
    static String S;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int result = 0;
        int cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if(S.charAt(i - 1) =='I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I'){
                cnt += 1;
                if(cnt == N){
                    cnt -= 1;
                    result += 1;
                }
                i++;
            }else{
                cnt = 0;
            }

        }
        System.out.println(result);

    }
}
