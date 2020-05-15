import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_14889 {
    static int minValue = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str;
        int[][] score = new int[N][N];
        for(int i = 0; i < N; ++i){
            str = br.readLine().split(" ");
            for(int j = 0; j < N; ++j){
                score[i][j] = Integer.parseInt(str[j]);
            }
        }
        boolean[] visited = new boolean[N];
        for(int i = 0; i < visited.length; ++i){
            visited[i] = true;
        }
        solution(visited, score, 0, 0);
        System.out.println(minValue);
    }
    public static void solution(boolean[] visited, int[][] score, int depth, int start_idx){
        if(depth == (N / 2)){
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for(int i = 0; i < visited.length; ++i){
                if(visited[i]){
                    team1.add(i);
                }
                else{
                    team2.add(i);
                }
            }
            int team1_value = teamValue(team1, score);
            int team2_value = teamValue(team2, score);
            int result = Math.abs(team1_value - team2_value);
            if(result < minValue){
                minValue = result;
            }
            return;
        }
        for(int i = start_idx; i < visited.length; ++i){
            if(visited[i]){
                visited[i] = false;
                solution(visited, score, depth + 1, i + 1);
                visited[i] = true;
            }

        }
    }
    public static int teamValue(ArrayList<Integer> team, int[][] score){
        int sum = 0;
        for(int i = 0; i < team.size(); ++i){
            for(int j = 0; j < team.size(); ++j){
                sum += score[team.get(i)][team.get(j)];
            }
        }
        return  sum;
    }
}

