
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
    int i;
    int j;
    int age;
    int now;
    int time;
    public Shark(int i, int j){
        this.i = i;
        this.j = j;
        this.age = 2;
        this.now = 0;
        this.time = 0;
    }
    public void nextAge(){
        if(this.now == this.age){
            age += 1;
            this.now = 0;
        }
    }
}
class Locate implements Comparable<Locate>{
    int i;
    int j;
    int distance;
    public Locate(int i, int j, int distance){
        this.i = i;
        this.j = j;
        this.distance = distance;
    }

    @Override
    public int compareTo(Locate o) {
        if(this.distance < o.distance){
            return -1;
        }else if (this.distance == o.distance){
            if(this.i < o.i){
                return -1;
            }else if(this.i == o.i){
                if (this.j < o.j) {
                    return -1;
                }else if(this.j == o.j){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}
public class B_16236 {
    static int N;
    static Shark shark;
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 9){
                    shark = new Shark(i, j);
                }
            }
        }
//        int[][] sequence = new int[N][N];
//        int cnt = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            boolean[][] visited = new boolean[N][N];
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    visited[i][j] = false;
                }
            }
            PriorityQueue<Locate> queue = new PriorityQueue<>();
            queue.add(new Locate(shark.i, shark.j , 0));
            map[shark.i][shark.j] = 0;
            visited[shark.i][shark.j] = true;
            while(!queue.isEmpty()){
                Locate locate = queue.poll();
                int distance = locate.distance;
                if(map[locate.i][locate.j] != 0 && map[locate.i][locate.j] < shark.age){//자기자신이 먹을 수 있는 곳이다!!!
//                    map[locate.i][locate.j] = 0;
                    shark.i = locate.i;
                    shark.j = locate.j;
                    shark.now += 1;
                    shark.time += distance;
                    shark.nextAge();
                    flag = true;
//                    sequence[shark.i][shark.j] = cnt + 1;
//                    cnt += 1;
                    break;
                }
//                visited[locate.i][locate.j] = true;
                for(int i = 0; i < 4; ++i){
                    int tmpi = locate.i + di[i];
                    int tmpj = locate.j + dj[i];
                    if(tmpi >= 0 && tmpj >= 0 && tmpi < N && tmpj < N){
                        if(map[tmpi][tmpj] >= 0 && map[tmpi][tmpj] <= 6 && map[tmpi][tmpj] <= shark.age && !visited[tmpi][tmpj]){//자신이 갈수 있는 곳이면 가자!
                            queue.add(new Locate(tmpi, tmpj, distance + 1));
                            visited[tmpi][tmpj] = true;
                        }
                    }

                }
            }
        }
        System.out.println(shark.time);
//        for(int i = 0; i < N; ++i){
//            for (int j = 0; j < N; ++j){
//                System.out.print(sequence[i][j] + " ");
//            }
//            System.out.println();
//        }


    }


}
