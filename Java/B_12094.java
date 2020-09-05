import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12094 {
    static int N;
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, map[i][j]);
            }
        }
        dfs(map, 0);
        System.out.println(result);
    }
    public static void dfs(int[][] map, int depth){
        if(depth == 10){
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    result = Math.max(result, map[i][j]);
//                }
//            }
            return;
        }
        int[][] newMap;
        for (int i = 0; i < 4; i++) {
            //상우하좌
            newMap = new int[N][N];
            fillMap(newMap, map, i);
            if(!checkEqualMap(map, newMap)){
                dfs(newMap, depth + 1);
            }
        }

    }
    public static void fillMap(int[][] newMap, int[][] map, int direct){
        int k = 0;
        boolean merge = false;
        switch (direct){
            case 0://위로 땡기기..
                for (int j = 0; j < N; j++) {
                    k = 0;
                    merge = false;
                    for (int i = 0; i < N; i++) {
                        if(map[i][j] != 0){
                            if(k > 0 && !merge && newMap[k - 1][j] == map[i][j]){//합칠수 있다면 합쳐라.
                                newMap[k - 1][j] *= 2;
                                result = Math.max(result, newMap[k - 1][j]);
                                merge = true;
                            }
                            else{
                                newMap[k][j] = map[i][j];
                                merge = false;
                                k += 1;
                            }

                        }
                    }
                }
                return;
            case 1://오른쪽으로 땡기기..
                for (int i = 0; i < N; i++) {
                    k = N - 1;
                    merge = false;
                    for (int j= N - 1; j >= 0; j--) {
                        if(map[i][j] != 0){
                            if(k < N - 1 && !merge && newMap[i][k + 1] == map[i][j]){//합칠수 있다면 합쳐라.
                                newMap[i][k + 1] *= 2;
                                result = Math.max(result, newMap[i][k + 1]);
                                merge = true;
                            }
                            else{
                                newMap[i][k] = map[i][j];
                                merge = false;
                                k -= 1;
                            }

                        }
                    }
                }
                return;
            case 2://아래로 땡기기..
                for (int j = 0; j < N; j++) {
                    k = N - 1;
                    merge = false;
                    for (int i = N - 1; i >= 0; i--) {
                        if(map[i][j] != 0){
                            if(k < N - 1 && !merge && newMap[k + 1][j] == map[i][j]){//합칠수 있다면 합쳐라.
                                newMap[k + 1][j] *= 2;
                                result = Math.max(result, newMap[k + 1][j]);
                                merge = true;
                            }
                            else{
                                newMap[k][j] = map[i][j];
                                merge = false;
                                k -= 1;
                            }

                        }
                    }
                }
                return;
            case 3://왼쪽으로 땡기기
                for (int i = 0; i < N; i++) {
                    k = 0;
                    merge = false;
                    for (int j = 0; j < N; j++) {
                        if(map[i][j] != 0){
                            if(k > 0 && !merge && newMap[i][k - 1] == map[i][j]){//합칠수 있다면 합쳐라.
                                newMap[i][k - 1] *= 2;
                                result = Math.max(result, newMap[i][k - 1]);
                                merge = true;
                            }
                            else{
                                newMap[i][k] = map[i][j];
                                merge = false;
                                k += 1;
                            }

                        }
                    }
                }
        }
    }
    public static boolean checkEqualMap(int[][] map, int[][] newMap){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != newMap[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
