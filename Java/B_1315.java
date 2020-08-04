import java.io.*;
import java.util.*;


public class B_1315 {
    static int N;
    static int[] str;
    static int[] intellij;
    static int[] point;
    static int[][] dp;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new int[N];
        intellij = new int[N];
        point = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = Integer.parseInt(st.nextToken());
            intellij[i] = Integer.parseInt(st.nextToken());
            point[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N];
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], - 1);
        }
        int result= calculate(1, 1);
        System.out.println(result);

    }
    public static int calculate(int currentStr, int currentInt){
        if(dp[currentStr][currentInt] != -1)
            return dp[currentStr][currentInt];
        int getPoint = 0;
        int cnt = 0;
        Vector<Integer> visitArray = new Vector<>();
        for (int i = 0; i < N; i++) {
            if(str[i] <= currentStr || intellij[i] <= currentInt){
                if(!visit[i]){
                    visit[i] = true;
                    getPoint += point[i];
                    visitArray.addElement(i);
                }
                cnt += 1;
            }
        }
        dp[currentStr][currentInt] = cnt;
        if(getPoint > 0){
            for (int i = 0; i <= getPoint ; i++) {
                cnt = Math.max(cnt, calculate(Math.min(currentStr + i, 1000), Math.min(currentInt + getPoint - i, 1000)));
            }
        }
        for (int i = 0; i < visitArray.size(); i++) {
            visit[visitArray.get(i)] = false;
        }
        return dp[currentStr][currentInt] = cnt;
    }
}
