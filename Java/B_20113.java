import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20113 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int idx = -1;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] in = new int[N + 1];
        for (int i = 0; i < N; i++) {
            in[Integer.parseInt(st.nextToken())] += 1;
        }
        for (int i = 1; i <= N; i++) {
            if(max < in[i]){
                max = in[i];
                idx = i;
            }

        }
        for (int i = 1; i <= N; i++) {
            if(idx != i){
                if(max == in[i]){
                    System.out.println("skipped");
                    return;
                }
            }
        }
        System.out.println(idx);
    }
}
