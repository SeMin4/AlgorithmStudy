import java.util.*;

public class P_숫자게임 {

    public static void main(String[] args) {
	// write your code here
//        int[] A = {5,1, 3, 7};
//        int[] B = {2, 2, 6, 8};
        int[] A = {2,2,2,2};
        int[] B = {1,1,1,1};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < A.length && j < B.length; i++) {
            int a = A[i];
            Integer tmpB = pq.peek();
            if(tmpB != null && a <= tmpB){
                answer += 1;
                pq.poll();
                continue;
            }
            int b = B[j];
            while (a > b){
                pq.offer(b);
                j += 1;
                if(j >= B.length){
                    return answer;
                }
                b = B[j];
            }
            answer += 1;
            j += 1;
        }
        return answer;
    }
}
