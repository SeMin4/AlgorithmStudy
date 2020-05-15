import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14890 {
    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        int[][] map = new int[N][N];
        boolean[][] check = new boolean[N][N];//경사로를 세웠는지 아닌지 체크
        boolean[][] check2 = new boolean[N][N]; // 경사로 체크를 위해서 2개 만들기
        for(int i = 0; i < N; ++i){
            str = br.readLine().split(" ");
            for (int j = 0; j < N; ++j){
                map[i][j] = Integer.parseInt(str[j]);
                check[i][j] = true;
                check2[i][j] = true;
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; ++i){
            if(checkRowRoad(map, i, check)){
                cnt += 1;
            }
            if(checkColRoad(map, i, check2)){
                cnt += 1;
            }
        }
        System.out.println(cnt);

    }
    public static boolean checkRowRoad(int[][] map, int pos, boolean[][] check){
        int current_height = map[pos][0];
        for(int i = 1; i < N; ++i){
            if(Math.abs(current_height - map[pos][i]) >= 2){
                return false;
            }
            if(current_height > map[pos][i]){//낮은 층이 들어옴
                int check_height = map[pos][i];
                int current_col = i;
//                i += 1;
                if(current_col + L > N)
                    return false;
                for(; i < current_col + L; ++i){
                    if(check_height != map[pos][i]){
                        return false;
                    }
                    if(!check[pos][i]){
                        return false;
                    }
                    check[pos][i] = false;
                }
                i -= 1;//다시 되돌려 주기
            }else if(current_height < map[pos][i]){//높은 층이 들어옴
                if(i - L < 0)
                    return false;
                for(int j = i - 1; j >= i - L ; --j){
                    if(!check[pos][j])
                        return false;
                    check[pos][j] = false;
                }
            }
            current_height = map[pos][i];
        }
        return true;
    }

    public static boolean checkColRoad(int[][] map, int pos, boolean[][] check){
        int current_height = map[0][pos];
        for(int i = 1; i < N; ++i){
            if(Math.abs(current_height - map[i][pos]) >= 2){
                return false;
            }
            if(current_height > map[i][pos]){//낮은 층이 들어옴
                int check_height = map[i][pos];
                int current_col = i;
//                i += 1;
                if(current_col + L > N)
                    return false;
                for(; i < current_col + L; ++i){
                    if(check_height != map[i][pos]){
                        return false;
                    }
                    if(!check[i][pos]){
                        return false;
                    }
                    check[i][pos] = false;
                }
                i -= 1;//다시 되돌려 주기
            }else if(current_height < map[i][pos]){//높은 층이 들어옴
                if(i - L < 0)
                    return false;
                for(int j = i - 1; j >= i - L ; --j){
                    if(!check[j][pos])
                        return false;
                    check[j][pos] = false;
                }
            }
            current_height = map[i][pos];
        }
        return true;
    }
}
