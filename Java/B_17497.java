import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_17497 {
    static long N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        ArrayList<Character> result = new ArrayList<>();
        int cnt = 0;
        while (N > 0 && cnt < 99){
            if((N & 1L) == 1){
                N *= 2;
                result.add('/');
            }
            else if((N & 2L) > 0){
                N -= 2;
                result.add('+');
            }
            else{
                N /= 2;
                result.add('*');
            }
            cnt += 1;
        }
        if(cnt > 99){
            System.out.println(-1);
            return;
        }
        System.out.println(cnt);
        for (int i = result.size() - 1; i >= 0 ; i--) {
            System.out.print("[" + result.get(i) + "] ");
        }


    }
}
