import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_7453 {
    static int N;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }
        long[] AB = new long[N * N];
        long[] CD = new long[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = A[i] + B[j];
                CD[i * N + j] = C[i] + D[j];
            }
        }
        Arrays.sort(CD);
        int size = N * N - 1;
        for (long i : AB) {
            int under_bound, upper_bound;
            under_bound = getUnderBound(CD, 0, size, -i);
            if(under_bound != -1){
                upper_bound = getUpperBound(CD, under_bound, size, -i);
                result += (upper_bound - under_bound);
            }
        }
        System.out.println(result);

    }

    public static int getUnderBound(long[] arr, int start, int end, long num){
        int mid;
        while (start < end){
            mid = (start + end) / 2;
            if(arr[mid] >= num){//찾고자 하느 값이 미드 보다 작다..
                end = mid;
            }
            else{//찾고자 하는 값이 크다면?
                start  = mid + 1;
            }
        }
        if(arr[start] == num)
            return start;
        else{
            return -1;
        }
    }
    public static int getUpperBound(long[] arr, int start, int end, long num){
        int mid;
        while (start < end){
            mid = (start + end) / 2;
            if(arr[mid] <= num){//찾고자 하는 값이 크다면?
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        return start == N * N - 1 ? start + 1 : start;
    }
}
