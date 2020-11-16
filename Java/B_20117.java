import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_20117 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
        }
        int ret = 0;
        while (deque.size() >= 2){
            deque.pollFirst();
            int max = deque.pollLast();
            ret += (max * 2);
        }
        if(deque.size() != 0){
            ret += deque.pollFirst();
        }
        System.out.println(ret);

    }
}
