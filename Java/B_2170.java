import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Line implements Comparable<Line>{
    int left;
    int right;
    public Line(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Line o) {
        return this.left < o.left ? -1 : 1;
    }
}
public class B_2170 {
    static int N;
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            lines.add(new Line(left, right));
        }
        Collections.sort(lines);
        int left = lines.get(0).left;
        int right = lines.get(0).right;
        for (int i = 1; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (line.left > right){
                result += (right - left);
                left = line.left;
                right = line.right;
            }
            else{
                right = Math.max(right, line.right);
            }
        }
        result += (right-left);
        System.out.println(result);
    }
}
