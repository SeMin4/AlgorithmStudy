import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2467 {
    static int N;
    static int result = Integer.MAX_VALUE;
    static int left_idx, right_idx;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int leftPointer = 0;
        int rightPointer = N - 1;
        int sum = 0;
        while (leftPointer < N && rightPointer >= 0){
            if(leftPointer == rightPointer){//같은경우..
                break;
            }
            sum = arr[leftPointer] + arr[rightPointer];
            if(sum == 0){
                left_idx = leftPointer;
                right_idx = rightPointer;
                break;
            }
            int res = Math.abs(sum);
            if(res < result){
                result = res;
                left_idx = leftPointer;
                right_idx = rightPointer;
            }
            if(sum < 0){
                leftPointer += 1;
            }
            else{
                rightPointer -= 1;
            }
        }
        System.out.printf("%d %d\n", Math.min(arr[left_idx], arr[right_idx]), Math.max(arr[left_idx], arr[right_idx]));

    }
}
