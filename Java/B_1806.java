import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1806 {
    static int N, S;
    static int result = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        sum = arr[0];
        while (left < N){
            if(sum < S){
                right += 1;
                if(right >= N)
                    break;
                sum += arr[right];
            }
            else{
                result = Math.min(result, right - left + 1);
                sum -= arr[left];
                left += 1;
            }
        }
        if (result == Integer.MAX_VALUE)
            System.out.println(0);
        else{
            System.out.println(result);
        }
    }
}
