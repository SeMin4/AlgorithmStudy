import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int i;
    int j;
    boolean end;
    boolean visit;
    public Position(int i, int j, boolean end, boolean visit){
        this.i = i;
        this.j = j;
        this.end = end;
        this.visit = visit;

    }
}
public class B_9205 {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            ArrayList<Position> positions = new ArrayList<>();
            for (int j = 0; j < N + 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                positions.add(new Position(x, y, false, false));
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions.add(new Position(x, y, true, false));
            String result = bfs(positions);
            bw.write(result + "\n");
        }
        bw.close();


    }
    public static String bfs(ArrayList<Position> positionArrayList){
        Queue<Position> queue = new LinkedList<>();
        Position start = positionArrayList.get(0);
        positionArrayList.get(0).visit = true;
        queue.add(new Position(start.i, start.j, start.end, start.visit));
        while (!queue.isEmpty()){
            Position position = queue.poll();
            if(position.end){
                return "happy";
            }
            for (int i = 1; i < positionArrayList.size(); i++) {
                Position tmpPosition = positionArrayList.get(i);
                if(!tmpPosition.visit){
                    if(Math.abs(tmpPosition.i - position.i) + Math.abs(tmpPosition.j - position.j) <= 1000){
                        tmpPosition.visit = true;
                        queue.add(tmpPosition);
                    }
                }
            }
        }
        return "sad";

    }
}
