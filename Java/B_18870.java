import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
class Point {
    int num;
    int idx;
    int cnt;
    public Point(int num, int idx ){
        this.num = num;
        this.idx = idx;
        this.cnt = 0;
    }
}
public class B_18870 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            arr.add(new Point(Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.num < o2.num)
                    return -1;
                else if(o1.num == o2.num)
                    return 0;
                else{
                    return 1;
                }
            }
        });
        Point point = arr.get(0);
        point.cnt = 0;
        arr.set(0, point);
        for (int i = 1; i < arr.size(); i++) {
            Point point1 = arr.get(i);
            Point point2 = arr.get(i - 1);
            int cnt;
            if(point1.num == point2.num)
                cnt = point2.cnt;
            else{
                cnt = point2.cnt + 1;
            }
            point1.cnt = cnt;
            arr.set(i, point1);

        }
        Collections.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.idx < o2.idx)
                    return -1;
                else if(o1.idx == o2.idx)
                    return 0;
                else
                    return 1;
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).cnt + " ");
        }
        System.out.println();
    }
}
