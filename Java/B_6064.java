import java.io.*;
import java.util.StringTokenizer;

public class B_6064 {
    static int K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int M, N, x, y;
        int startX = 1;
        int startY = 1;
        int gcd;
        int lcm;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            gcd = setGCD(M, N);
            lcm = (M / gcd) * N;
            boolean flag = false;
            for (int j = x; j < lcm; j += M) {
                if((j - y) % N == 0){
                    bw.write(j + "\n");
                    flag = true;
                    break;
                }

            }

            if(!flag){
                int error = -1;
                bw.write(error + "\n");
            }
        }
        bw.close();
    }
    public static int setGCD(int a, int b){
        if(a < b){
            int tmp;
            tmp = b;
            b = a;
            a = tmp;
        }
        while (a % b != 0){
            int mod = a % b;
            a = b;
            b = mod;
        }
        return b;
    }
}
