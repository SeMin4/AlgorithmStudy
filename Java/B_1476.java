import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1476 {

    public static void main(String[] args)  throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E, S, M;
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 1 <= E <= 15
        // 1 <= S <= 28
        // 1 <= M <= 19
        int year = 1;
        while (true){
            if((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0){
                break;
            }
            year += 1;
        }
        System.out.println(year);
    }
}
