import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17499 {
    static int N, Q;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int pointer = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                idx = (pointer + idx) % N;
                int value = Integer.parseInt(st.nextToken());
                arr[idx] += value;
            }
            else if(command == 2) {
                pointer = ((pointer - Integer.parseInt(st.nextToken())) % N + N) % N;
            }
            else {
                pointer = (pointer + Integer.parseInt(st.nextToken())) % N;
            }
        }
        for(int i = pointer; i < N; ++i){
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < pointer; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
