import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ChickenHouse{
    int row;
    int col;
    public ChickenHouse(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class House{
    int row;
    int col;
    public House(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class B_15686 {
    static int N, M;//N 지도의 크기 M : 고를수 있는 치킨집의 개수
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        ArrayList<ChickenHouse> chickenHouses = new ArrayList<>();
        ArrayList<House> houses = new ArrayList<>();
        int[][] map = new int[N][N];
        for(int i = 0; i < N; ++i){
            str = br.readLine().split(" ");
            for(int j = 0; j < N; ++j){
                int tmp =  Integer.parseInt(str[j]);
                if(tmp == 2){
                    chickenHouses.add(new ChickenHouse(i ,j));
                    map[i][j] = 0;
                }
                else if (tmp == 1){
                    houses.add(new House(i, j));
                    map[i][j] = tmp;
                }
                else{
                    map[i][j] = 0;
                }
            }
        }
        boolean[] visited = new boolean[chickenHouses.size()];
        for(int i = 0; i < visited.length; ++i){
            visited[i] = true;
        }
        distance(chickenHouses, houses, visited, 0, 0);
        System.out.println(minValue);
    }

    public static void distance(ArrayList<ChickenHouse> chickenHouses, ArrayList<House> houses, boolean[] visited, int depth, int current_idx){
        if(depth >= M){
            int[] resultDistance = new int[houses.size()];
            for(int i = 0; i < resultDistance.length; ++i){
                resultDistance[i] = Integer.MAX_VALUE;
            }
            for(int i = 0; i < visited.length; ++i){
                if(visited[i] == false){
                    for(int j = 0; j < houses.size(); ++j){
                        int rowSum = Math.abs(chickenHouses.get(i).row - houses.get(j).row);
                        int colSum = Math.abs(chickenHouses.get(i).col - houses.get(j).col);
                        if(resultDistance[j] > rowSum + colSum){
                            resultDistance[j] = rowSum + colSum;
                        }
                    }
                }
            }
            int sum = 0;
            for(int i = 0; i < resultDistance.length; ++i){
                sum += resultDistance[i];
            }
            if(minValue > sum){
                minValue = sum;
            }
        }
        else{
            for(int i = current_idx; i < chickenHouses.size(); ++i){
                if(visited[i]){
                    visited[i] = false;
                    distance(chickenHouses, houses, visited, depth + 1, i + 1);
                    visited[i] = true;
                }
            }
        }
    }
}
