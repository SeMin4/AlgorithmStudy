import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1780 {
    static int N;
    static int[] cnt = {0, 0, 0};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideConquer(arr, 0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }
    public static void divideConquer(int[][] arr, int startI, int startJ, int size){
        int check = arr[startI][startJ];
        for (int i = startI; i < startI + size; i++) {
            for (int j = startJ; j < startJ + size; j++) {
                if(check != arr[i][j]){
                    divideConquer(arr, startI, startJ, size / 3);
                    divideConquer(arr, startI + (size / 3), startJ, size / 3);
                    divideConquer(arr, startI + (size * 2 / 3), startJ, size / 3);
                    divideConquer(arr, startI, startJ + (size / 3), size / 3);
                    divideConquer(arr, startI + (size / 3), startJ + (size / 3), size / 3);
                    divideConquer(arr, startI + (size * 2 / 3), startJ + (size / 3), size / 3);
                    divideConquer(arr, startI, startJ + (size * 2 / 3), size / 3);
                    divideConquer(arr, startI + (size / 3), startJ + (size * 2 / 3), size / 3);
                    divideConquer(arr, startI + (size * 2 / 3), startJ +(size * 2 / 3) , size / 3);
                    return;
                }
            }
        }
        cnt[check + 1] += 1;
    }
}
