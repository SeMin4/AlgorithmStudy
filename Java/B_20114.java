import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20114 {
    static int N, H, W;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        String[] map = new String[H];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("?");
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N * W; j+= W) {
                String substr = map[i].substring(j, j + W);
                for (int k = 0; k < substr.length(); k++) {
                    if(sb.charAt(j / W) == '?'){
                        if(substr.charAt(k) != '?'){
                            sb.setCharAt(j / W, substr.charAt(k));
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

}
