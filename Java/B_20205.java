import java.io.*;
import java.util.StringTokenizer;

public class B_20205 {
    static int N, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] newmap = new int[N * K][N * K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    for (int l = 0; l < K; l++) {
                        newmap[i * K + k][j * K + l] = map[i][j];
                    }
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < newmap.length; i++) {
            for (int j = 0; j < newmap[i].length; j++) {
                bw.write(newmap[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
