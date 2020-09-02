import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2239 {
    static int cnt = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        boolean[][][] chk = new boolean[3][9][10];//각각을 카운팅..
        //chk [0] -> 가로 chk[1] = 세로 chk[2] => 3 * 3 으로 한개씩
        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = tmp.charAt(j) - '0';
                if(map[i][j] == 0)
                    cnt +=  1;
                else{
                    chk[0][i][map[i][j]] = true;
                    chk[1][j][map[i][j]] = true;
                    chk[2][(i / 3 * 3) + (j / 3)][map[i][j]] = true;//(i / 3 * 3 + j / 3)
                }
            }
        }
        dfs(0, map, chk);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    public static void dfs(int depth, int[][] map, boolean[][][] chk){
        if(depth == cnt){
            flag = true;
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j] == 0){
                    boolean getNumber = false;
                    for (int k = 1; k <= 9; k++) {
                        if(!chk[0][i][k] && !chk[1][j][k] && !chk[2][(i /3 * 3) + (j / 3)][k]){
                            getNumber = true;
                            map[i][j] = k;
                            chk[0][i][k] = true;
                            chk[1][j][k] = true;
                            chk[2][(i / 3 * 3) + (j / 3)][k] = true;//(i / 3 * 3 + j / 3)
                            dfs(depth + 1, map, chk);
                            if(flag)
                                return;
                            map[i][j] = 0;
                            chk[0][i][k] = false;
                            chk[1][j][k] = false;
                            chk[2][(i / 3 * 3) + (j / 3)][k] = false;//(i / 3 * 3 + j / 3)
                            getNumber = false;
                        }
                    }
                    if(!getNumber)
                        return;
                }
            }
        }
    }
}
