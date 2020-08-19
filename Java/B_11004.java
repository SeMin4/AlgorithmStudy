import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_11004 {
    static int N, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        System.out.println(arr.get(K - 1));
    }
}
