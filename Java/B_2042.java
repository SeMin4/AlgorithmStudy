import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2042 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        long[] segmentTree = new long[4*N + 1];
        makeTree(0, N - 1, arr, segmentTree, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                modifyTree(0, N - 1, segmentTree, 1, b - 1, c);
            }
            if(a == 2){
                Long result = findTree(0, N - 1, b - 1, (int)(c - 1), 1, segmentTree);
                System.out.println(result);
            }
        }

    }
    public static long makeTree(int start, int end, long[] arr, long[] segmentTree ,int nodeNum){
        if(start == end){
            return segmentTree[nodeNum] = arr[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[nodeNum] = makeTree(start, mid, arr, segmentTree, nodeNum * 2) + makeTree(mid + 1, end, arr, segmentTree, nodeNum * 2 + 1);
    }
    public static long findTree(int start, int end, int left, int right, int nodeNum, long[] segmentTree){
        if(left > end || right < start)
            return 0;
        if(left <= start &&  end <= right)
            return segmentTree[nodeNum];
        int mid = (start + end) / 2;
        long lResult = findTree(start, mid, left, right, nodeNum * 2, segmentTree);
        long rResult = findTree(mid + 1, end, left, right, nodeNum * 2 + 1, segmentTree);
        return lResult + rResult;
    }
    public static long modifyTree(int start, int end, long[] segmentTree, int nodeNum, int idx, long modifyNum){
        if(start == idx && end == idx){
            return segmentTree[nodeNum] = modifyNum;
        }
        int mid = (start + end) / 2;
        if(start <= idx && idx <= mid){
            return segmentTree[nodeNum] = modifyTree(start, mid, segmentTree, nodeNum * 2, idx, modifyNum) + segmentTree[nodeNum * 2 + 1];
        }
        else{
            return segmentTree[nodeNum] = segmentTree[nodeNum * 2] + modifyTree(mid + 1, end, segmentTree, nodeNum * 2 + 1, idx, modifyNum);
        }
    }
}
