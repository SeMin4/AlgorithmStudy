import java.util.Arrays;

public class P_풍선터트리기{

    public static void main(String[] args) {
	// write your code here
//        int[] a = {9,-1,-5};
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int answer = 0;
        //작은것은 딱 1번만 가능
        //큰거는 항상 가능..
        //1개만 남을때 까지 터뜨리자..
        //정렬?...
        // -5, -1 ,9
       int[] Tree = new int[a.length * 4];
       int N = a.length;
        makeTree(0, N - 1, 1, Tree, a);
        for (int i = 0; i < N; i++) {
            int lResult = findTree(0, N - 1, 0, i - 1, 1, Tree);
            int rResult = findTree(0, N -1 , i + 1, N - 1, 1, Tree);
            if(a[i] < lResult || a[i] < rResult){//지금 살리려고 하는 숫자가 왼쪽보다
//                System.out.println(a[i]);
                answer += 1;
            }
        }
        return answer;
    }
    public static int makeTree(int start, int end,int nodeNum, int[] Tree, int[] A){
        if(start == end)
            return Tree[nodeNum] = A[start];
        int mid = (start + end) / 2;
        return Tree[nodeNum] = Math.min(makeTree(start, mid, nodeNum * 2, Tree, A), makeTree(mid + 1, end, nodeNum * 2 + 1, Tree, A));
    }
    public static int findTree(int start ,int end ,int left, int right, int nodeNum, int[] Tree){
        if(left > end || right < start){
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return Tree[nodeNum];
        }
        int mid = (start + end) / 2;
        int lResult = findTree(start, mid, left, right,nodeNum * 2,Tree);
        int rResult = findTree(mid + 1, end, left, right, nodeNum * 2 + 1, Tree);
        return Math.min(lResult, rResult);
    }
}
