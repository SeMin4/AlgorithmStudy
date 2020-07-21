import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1992 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        divideConquer(arr, 0, 0, N);
    }
    public static void divideConquer(int[][] arr, int startI, int startJ, int size){
        int check = arr[startI][startJ];
        for (int i = startI; i < startI + size; i++) {
            for (int j = startJ; j < startJ + size; j++) {
                if(check != arr[i][j]){
                    System.out.print("(");
                    divideConquer(arr, startI, startJ, size / 2);
                    divideConquer(arr, startI, startJ + (size / 2), size / 2);
                    divideConquer(arr, startI + (size / 2), startJ, size / 2);
                    divideConquer(arr, startI + (size / 2), startJ + + (size / 2), size / 2);
                    System.out.print(")");
                    return;
                }
            }
        }
        System.out.print(check);
    }

}
