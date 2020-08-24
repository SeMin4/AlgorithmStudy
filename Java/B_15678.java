import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15678 {
    public static int N, D;
    public static long result = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
//        FileReader fr = new FileReader("C:\\Users\\SeMin\\Desktop\\input.txt");
//        BufferedReader br = new BufferedReader(fr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long[] dp = new long[N];
        dp[0] = arr[0];
        result = dp[0];
        long[] segmentTree = new long[4*D + 1];
        Arrays.fill(segmentTree, Long.MIN_VALUE);
        updateTree(0, D - 1, segmentTree, 1, 0, dp[0]);
        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];
            dp[i] = Math.max(dp[i], dp[i] + segmentTree[1]);
            result = Math.max(dp[i], result);
            updateTree(0, D - 1, segmentTree, 1, i % D, dp[i]);
        }
        System.out.println(result);
    }

    public static long updateTree(int start, int end, long[] segmentTree, int idx, int originIdx, long value){
        if(start == originIdx && end == originIdx){
            return segmentTree[idx] = value;
        }
        int mid = (start + end) / 2;
        if(start <= originIdx && originIdx <= mid){
            return segmentTree[idx] = Math.max(updateTree(start, mid, segmentTree, idx * 2, originIdx, value),segmentTree[idx * 2 + 1]);
        }
        else{
            return segmentTree[idx] = Math.max(segmentTree[idx * 2], updateTree(mid + 1, end, segmentTree, idx * 2 + 1, originIdx, value));
        }
    }

}
