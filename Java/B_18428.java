import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_18428 {
    static int N;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    static boolean result = false;
    static ArrayList<int[]> teacherList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String get = st.nextToken();
                map[i][j] = get.equals("X") ? 0 : get.equals("S") ? 1 : 2;
                if(map[i][j] == 2)
                    teacherList.add(new int[]{i, j});
            }
        }
        boolean[][] visit = new boolean[N][N];
        dfs(0, 0, 0, visit, map);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static void dfs(int depth, int currentI, int currentJ, boolean[][] visit, int[][] map){
        if(depth >= 3){
            for (int i = 0; i < teacherList.size(); i++) {
                int[] teacher = teacherList.get(i);
                for (int j = 0; j < 4; j++) {
                    int tmpI = teacher[0] + dI[j];
                    int tmpJ = teacher[1] + dJ[j];
                    int cnt = 1;
                    while (tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N){
                        if(map[tmpI][tmpJ] == 1)//학생을 만나면?
                            return;
                        else if(map[tmpI][tmpJ] == 3)//벽을 만나면?
                            break;
                        cnt += 1;
                        tmpI = teacher[0] + dI[j] * cnt;
                        tmpJ = teacher[1] + dJ[j] * cnt;
                    }
                }
            }
            result = true;
            return;
        }
        for (int i = currentI; i < N; i++) {
            for (int j = currentJ; j < N; j++) {
                if(!visit[i][j] && map[i][j] == 0){
                    visit[i][j] = true;
                    map[i][j] = 3;
                    dfs(depth + 1, i, j, visit, map);
                    if(result)
                        return;
                    map[i][j] = 0;
                    visit[i][j] = false;
                }
            }
            currentJ = 0;
        }
    }
}
