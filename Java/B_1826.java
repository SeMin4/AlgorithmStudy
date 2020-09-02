import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class GasStation implements Comparable<GasStation>{
    int pos;
    int fuel;
    public GasStation(int pos, int fuel){
        this.pos  = pos;
        this.fuel = fuel;
    }

    @Override
    public int compareTo(GasStation o) {
        if(this.pos < o.pos){
            return -1;
        }
        else if(this.pos == o.pos)
            return 0;
        else
            return 1;
    }
}
class Position implements Comparable<Position>{
    int idx;
    int fuel;
    int pos;
    public Position(int idx ,int fuel, int pos){
        this.idx =idx;
        this.fuel = fuel;
        this.pos =pos;
    }
    @Override
    public int compareTo(Position o) {
        if(this.fuel > o.fuel){
            return -1;
        }
        else if(this.fuel == o.fuel)
            return 0;
        else
            return 1;
    }
}
public class B_1826 {
    static int N;
    static int destination, initialFuel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        GasStation[] gasInfo = new GasStation[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gasInfo[i] = new GasStation(a, b);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        destination = Integer.parseInt(st.nextToken());
        initialFuel = Integer.parseInt(st.nextToken());
        gasInfo[0] = new GasStation(0, initialFuel);
        gasInfo[N + 1] = new GasStation(destination, 0);
        Arrays.sort(gasInfo);
        int result = dijkstra(gasInfo);
        System.out.println(result);
    }
    public static int dijkstra(GasStation[] gasStation){
        int cnt = -1;
        int fuel = 0;
        int idx = 0;
        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.offer(new Position(0, initialFuel, 0));
        boolean[] visit = new boolean[N + 2];
        while (!queue.isEmpty()){
            Position position = queue.poll();
            fuel += position.fuel;
            cnt += 1;
            for (int i = idx + 1; i <= N + 1; i++) {
                if(!visit[i]){//한번도 방문한적이 없다..
                    if(gasStation[i].pos <= fuel){//가지고 있는 연료보다 거리가 작으면
                        if(i == N + 1)
                            return cnt;
                        queue.offer(new Position(i, gasStation[i].fuel, gasStation[i].pos));
                        idx = i;
                        visit[i] = true;
                    }
                }
            }

        }
        return -1;
    }
}
