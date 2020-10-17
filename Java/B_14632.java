import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14632 {
    static int N, M, Q;
    static int K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        String[][] dojang = new String[K][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            dojang[i] = new String[H];
            for (int j = 0; j < H; j++) {
                dojang[i][j] = br.readLine();
            }
        }
        Q = Integer.parseInt(br.readLine());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }
        int[][] qArr  = new int[Q][3];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            qArr[i][0] = Integer.parseInt(st.nextToken());
        qArr[i][1] = Integer.parseInt(st.nextToken());
        qArr[i][2] = Integer.parseInt(st.nextToken());
        for (int j = 0; j < dojang[qArr[i][0] - 1].length; j++, qArr[i][1]++) {
            for (int k = 0, tmpJ = qArr[i][2]; k < dojang[qArr[i][0] - 1][j].length(); k++, tmpJ++) {
                board[qArr[i][1]][tmpJ] = dojang[qArr[i][0] - 1][j].charAt(k);
            }
        }
    }

//        for (int i = qArr.length - 1; i >= 0; i--) {
//            int startI = qArr[i][1];
//            int startJ = qArr[i][2];
//            for (int j = 0; j < dojang[qArr[i][0] - 1].length; j++, startI++) {
//                for (int k = 0, tmpJ = startJ; k < dojang[qArr[i][0] - 1][j].length(); k++, tmpJ++) {
//                    if(board[startI][tmpJ] == '.')
//                        board[startI][tmpJ] = dojang[qArr[i][0] - 1][j].charAt(k);
//                }
//            }
//        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }
}
