import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1107 {
    static int N;
    static String Nstr;
    static int cnt;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nstr =  br.readLine();
        N = Integer.parseInt(Nstr);
        cnt = Integer.parseInt(br.readLine());
        minValue = Math.abs(100 - N);
        boolean[] btn = new boolean[10];
        for (int i = 0; i < 10; i++) {
            btn[i] = true;
        }
        StringTokenizer st;
        if(cnt != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                btn[tmp] = false;
            }
        }
        overWrapCombination(0, btn, 0, Nstr.length());
        System.out.println(minValue);
    }
    public static void overWrapCombination(int num, boolean[] btn, int depth, int length){
        if(depth == 6){
            int tmp = Math.abs(N - num) + depth;
            if(minValue > tmp){
                minValue = tmp;
            }
            return;
        }
        if(depth >= 1){
            int tmp = Math.abs(N - num) + depth;
            if(minValue > tmp){
                minValue = tmp;
            }
        }
        for (int i = 0; i < 10; i++) {
            if(btn[i]){
                num *= 10;
                num += i;
                overWrapCombination(num, btn, depth + 1, length);
                num /= 10;
            }
        }
    }
}
