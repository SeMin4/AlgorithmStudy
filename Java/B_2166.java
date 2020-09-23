import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
    long x;
    long y;
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
public class B_2166 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += ccw(points[0], points[i], points[i + 1]);
        }
        System.out.println(String.format("%.1f", (double)Math.abs(sum)/2));

    }
    public static long ccw(Point p1, Point p2, Point p3){
        return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
    }
}
