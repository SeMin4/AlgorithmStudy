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
    }
}
