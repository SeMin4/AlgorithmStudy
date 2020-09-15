import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2473 {
    static int N;
    static long result = Long.MAX_VALUE;
    static long[] res_arr = new long[3];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            int j = i + 1;
            int k = N - 1;
            while (j < k){
                long res = arr[i] + arr[j] + arr[k];
                if(res == 0){
                    res_arr[0] = arr[i];
                    res_arr[1] = arr[j];
                    res_arr[2] = arr[k];
                    break;
                }
                else if(result > Math.abs(res)){
                    result = Math.abs(res);
                    res_arr[0] = arr[i];
                    res_arr[1] = arr[j];
                    res_arr[2] = arr[k];
                }
                if(res > 0){
                    k -= 1;
                }
                else{
                    j += 1;
                }
            }

        }
        Arrays.sort(res_arr);
        for (int i = 0; i < 3; i++) {
            System.out.print(res_arr[i] + " ");
        }
    }
}
