import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1110{
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = N;
        int cnt = 0;
        while (true){
            cnt += 1;
            int tendigit = num / 10;
            int onedigit = num % 10;
            int newnum = tendigit + onedigit;
            num = onedigit * 10 + newnum % 10;
            if(num == N){
              break;
            }
        }
        System.out.println(cnt);
    }
}
