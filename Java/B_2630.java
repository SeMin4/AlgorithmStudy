import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int startI, startJ, endI, endJ;
    public Point(int startI, int startJ, int endI, int endJ){
        this.startI = startI;
        this.startJ = startJ;
        this.endI = endI;
        this.endJ = endJ;
    }

}
public class B_2630 {
    static int size;
    static int whitePage = 0;
    static int bluePage = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int[][] paper = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(0, 0, size - 1, size - 1));
        while (!points.isEmpty()){
            Point point = points.poll();
            int startI = point.startI;
            int startJ = point.startJ;
            int endI = point.endI;
            int endJ = point.endJ;
            int value = paper[startI][startJ];
            boolean flag = false;
            for (int i = startI; i <= endI; i++) {
                for (int j = startJ; j <= endJ ; j++) {
                    if(value != paper[i][j]){
                        dividePaper(startI, startJ, endI, endJ, points);
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(!flag){
                if(value == 0){
                    whitePage += 1;
                }else{
                    bluePage += 1;
                }
            }
        }
        System.out.println(whitePage);
        System.out.println(bluePage);


    }

    public static void dividePaper(int startI, int startJ, int endI, int endJ, Queue<Point> points){
        points.add(new Point(startI, startJ, (startI + endI) / 2, (startJ + endJ) / 2));
        points.add(new Point(startI, (startJ + endJ) / 2 + 1, (startI + endI) / 2, endJ));
        points.add(new Point((startI + endI) / 2 + 1, startJ, endI, (startJ + endJ) / 2));
        points.add(new Point((startI + endI) / 2 + 1, (startJ + endJ) / 2 + 1, endI, endJ));
    }
}
