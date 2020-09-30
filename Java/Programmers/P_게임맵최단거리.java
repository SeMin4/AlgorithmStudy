import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class Point implements Comparable<Point>{
    int i;
    int j;
    int value;
    public Point(int i, int j, int value){
        this.i = i;
        this.j = j;
        this.value = value;
    }
    @Override
    public int compareTo(Point o) {
        if(this.value < o.value) return -1;
        else if(this.value == o.value) return 0;
        else return 1;
    }
}
public class P_게임맵최단거리{
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    public static void main(String[] args) {
	// write your code here
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        int answer = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 1));
        int N = maps.length;
        int M = maps[0].length;
        int[][] value = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(value[i], Integer.MAX_VALUE);
        }
        while (!pq.isEmpty()){
            Point point = pq.poll();
            for (int i = 0; i < 4; i++) {
                int tmpI = point.i + dI[i];
                int tmpJ = point.j + dJ[i];
                if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M){
                    if(maps[tmpI][tmpJ] == 1 && value[tmpI][tmpJ] > point.value + 1){
                        value[tmpI][tmpJ] = point.value + 1;
                        pq.offer(new Point(tmpI, tmpJ, point.value + 1));
                    }
                }
            }
        }

        return answer = value[N - 1][M - 1] == Integer.MAX_VALUE ? -1 : value[N - 1][M - 1];
    }
}
