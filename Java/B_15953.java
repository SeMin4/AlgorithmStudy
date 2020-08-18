import java.io.*;
import java.util.StringTokenizer;

public class B_15953 {
    static int T;
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] money0 = {500,300,200,50,30, 10, 0};
        int[] money1 = {512,256,128,64,32, 0};
        for (int i = 0; i < T; i++) {
            result = 0;
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a != 0){
                int cnt = 1;
                int diff = 1;
                int idx = 0;
                while (a > cnt && idx < 6){
                    cnt += (diff + 1);
                    diff += 1;
                    idx += 1;
                }
                result += money0[idx];
            }
            if(b != 0){
                int diff = 1;
                int cnt = 1;
                int idx = 0;
                while (b > cnt && idx < 5){
                    cnt = cnt + (diff * 2);
                    diff *= 2;
                    idx += 1;
                }
                result += money1[idx];
            }
            bw.write(result * 10000 + "\n");
        }
        bw.close();
    }

}
