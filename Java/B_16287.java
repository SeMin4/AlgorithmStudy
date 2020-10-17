import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16287 {
    static int W, N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visit = new boolean[800000];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] > W) {//애초에 못만듬...
                    continue;
                }
                if (visit[W - arr[i] - arr[j]]) {
                    System.out.println("YES");
                    return;
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[i] + arr[j] < W) {//이러한 값이 있다..
                    visit[arr[i] + arr[j]] = true;
                }
            }
        }
        System.out.println("NO");

//        ArrayList<Sum> arrayList = new ArrayList<>();
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = i + 1; j < N; j++) {
//                arrayList.add(new Sum(arr[i] + arr[j], i, j));
//            }
//        }
//        Collections.sort(arrayList);
//        int left = 0;
//        int right = arrayList.size() - 1;
//        while (left != right){
//            Sum sumLeft = arrayList.get(left);
//            Sum sumRight = arrayList.get(right);
//            if(sumLeft.sum + sumRight.sum == W){
//                if(sumLeft.idx1 != sumRight.idx1 && sumLeft.idx1 != sumRight.idx2 && sumLeft.idx2 != sumRight.idx1 && sumLeft.idx2 != sumRight.idx2){
//                    System.out.println("YES");
//                    return;
//                }
//                else{
//                    left += 1;
//                }
//            }
//            else{
//                if(sumLeft.sum + sumRight.sum < W){
//                    left += 1;
//                }
//                else  right -=1;
//            }
//        }
//        System.out.println("NO");
    }
}
