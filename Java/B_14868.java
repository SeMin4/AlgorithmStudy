import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Position{
    int i;
    int j;
    int type;
    public Position(int i, int j, int type){
        this.i = i;
        this.j = j;
        this.type = type;
    }
}
public class B_14868 {
    static int N, K;
    static int cnt = 0;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    static int result = 0;
    static int kCNT =  1;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = K;
        int[][] map = new int[N + 2][N + 2];
        int[] parent = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            parent[i] = i;
        }
        Arrays.fill(map[0], -1);
        Arrays.fill(map[N + 1], -1);
        for (int i = 1; i <= N; i++) {
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }
        Queue<Position> queue = new LinkedList<>();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpI = Integer.parseInt(st.nextToken());
            int tmpJ = Integer.parseInt(st.nextToken());
            map[tmpI][tmpJ] = i;
            queue.offer(new Position(tmpI, tmpJ, i));
        }
        Queue<Position> queue2 = new LinkedList<>();
        int cnt = 0;
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                Position position = queue.poll();
                queue2.offer(position);
                for (int i = 0; i < 4; i++) {
                    int tmpI = position.i + dI[i];
                    int tmpJ = position.j + dJ[i];
                    if(map[tmpI][tmpJ] > 0 && map[tmpI][tmpJ] != position.type){
                        if(parent[map[tmpI][tmpJ]] != parent[position.type]){
                            if(union(map[tmpI][tmpJ], position.type, parent)){
                                System.out.println(cnt);
                                return;
                            }
                        }
                    }
                }
            }
            while (!queue2.isEmpty()){
                Position position = queue2.poll();
                for (int i = 0; i < 4; i++) {
                    int tmpI = position.i + dI[i];
                    int tmpJ = position.j + dJ[i];
                    if(map[tmpI][tmpJ] == 0){
                        map[tmpI][tmpJ] = position.type;
                        queue.offer(new Position(tmpI, tmpJ, position.type));
                    }
                }
            }
            cnt += 1;
        }

    }
    public static int find(int x, int[] parent){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
    public static boolean union(int x, int y, int[] parent){
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent == yParent)
            return false;
//        if(y > x){
//            int tmp = y;
//            y = x;
//            x = tmp;
//        }
//        updateParent(y, parent, xParent);
        parent[yParent] = xParent;
        kCNT += 1;
        if(kCNT == K)
            return true;
        return false;
    }
    public static void updateParent(int y, int[] parent ,int update){
        if(parent[y] == y){
            parent[y] = update;
            return;
        }
        updateParent(parent[y], parent, update);
        parent[y] = update;
    }
}
