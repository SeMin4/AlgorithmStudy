import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_20112 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            list.add(tmp);
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(map[j][i]);
            }
            if(!list.get(i).equals(sb.toString())){
                flag = true;
            }
        }
        if(flag){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }

    }
}
