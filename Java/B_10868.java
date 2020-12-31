import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] segmentTree = new int[4*N + 1];
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        makeTree(0, N - 1, arr, segmentTree, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = findTree(0, N - 1, a - 1, b - 1, 1, segmentTree);
            bw.write(result + "\n");
        }
        bw.close();

    }
    public static int makeTree(int start, int end, int[] arr, int[] segmentTree ,int nodeNum){
        if(start == end){
            return segmentTree[nodeNum] = arr[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[nodeNum] = Math.min(makeTree(start, mid, arr, segmentTree, nodeNum * 2), makeTree(mid + 1, end, arr, segmentTree, nodeNum * 2 + 1));
    }
    public static int findTree(int start, int end, int left, int right, int nodeNum, int[] segmentTree){
        if(left > end || right < start)
            return Integer.MAX_VALUE;
        if(left <= start &&  end <= right)
            return segmentTree[nodeNum];
        int mid = (start + end) / 2;
        int lResult = findTree(start, mid, left, right, nodeNum * 2, segmentTree);
        int rResult = findTree(mid + 1, end, left, right, nodeNum * 2 + 1, segmentTree);
        return Math.min(lResult,rResult);
    }
}
