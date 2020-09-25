import java.io.*;
import java.util.StringTokenizer;

public class B_14003 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        int[] parent = new int[N + 1];
        parent[0] = -1;
        dp[0] = Integer.MIN_VALUE;
        int lastIdx = 0;
        for (int i = 1; i <= N;  i++) {
            if(dp[lastIdx] < arr[i]){
                dp[++lastIdx] = arr[i];
                parent[i] = lastIdx;
            }
            else{
                int lowerIdx = lowerBound(0, lastIdx, arr[i], dp);
                dp[lowerIdx] = arr[i];
                parent[i] = lowerIdx;
            }
        }

        System.out.println(lastIdx);
        printArray(arr, parent, N, lastIdx, bw);
        bw.close();
    }
    public static int lowerBound(int start, int end, int value, int[] dp){
        while (start < end){
            int mid = (start + end) / 2;
            if(dp[mid] < value){//중간값이 찾으려는 값보다 작을때?
                start  = mid + 1;
            }
            else{
                end = mid;
            }

        }
        return start;
    }
    public static void printArray(int[] arr, int[] parent, int N, int lastIdx, BufferedWriter bw) throws IOException{
        if(lastIdx == 0){
            return;
        }
        if(parent[N] == lastIdx){
            printArray(arr, parent, N - 1, lastIdx- 1, bw);
            bw.write(arr[N] + " ");
        }
        else{
            printArray(arr, parent, N - 1, lastIdx, bw);
        }

    }
}
