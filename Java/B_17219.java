import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_17219 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < N;  i++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            String findStr = br.readLine();
            bw.write(hashMap.get(findStr) + "\n");
        }
        bw.close();

    }
}
