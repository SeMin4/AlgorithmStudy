import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class B_5419 {
    static int T, N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ArrayList<Point> pointList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pointList.add(new Point(x, y));
            }
            Collections.sort(pointList, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.y < o2.y){
                        return -1;
                    }else if(o1.y == o2.y){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
            });
            int[] newY = new int[75000];
            int newyValue = 0;
            newY[0] = 0;
            for (int j = 1; j < pointList.size(); j++) {
                if(pointList.get(j - 1).y != pointList.get(j).y){
                    newyValue += 1;
                }
                newY[j] = newyValue;
            }
            long[] segTree = new long[(newyValue + 1) * 4];//개수들을 저장하기 위해 만든... 세그먼트 트리.
            for (int j = 0; j < pointList.size(); j++) {
                pointList.get(j).y = newY[j];
            }
            Collections.sort(pointList, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x < o2.x){
                        return -1;
                    }
                    else if(o1.x == o2.x){
                        if(o1.y < o2.y){
                            return 1;
                        }
                        else if (o1.y == o2.y){
                            return 0;
                        }
                        else{
                            return -1;
                        }
                    }
                    else{
                        return 1;
                    }
                }
            });
            long result = 0;
            for (int j = 0; j < pointList.size(); j++) {
               result += findTree(0, newyValue, pointList.get(j).y, newyValue, 1, segTree);
               updateTree(0, newyValue, 1, pointList.get(j).y, segTree);
            }
            System.out.println(result);
        }
    }
    public static long updateTree(int start, int end, int nodeNum, int idx, long[] tree){
        if(start == idx && end == idx){
            return tree[nodeNum] += 1;
        }
        int mid = (start + end) / 2;
        if(start <= idx && idx <= mid){
            return tree[nodeNum] = updateTree(start, mid, nodeNum * 2, idx, tree) + tree[nodeNum * 2 + 1];
        }
        else{
            return tree[nodeNum] = tree[nodeNum * 2] + updateTree(mid + 1, end, nodeNum * 2 + 1, idx, tree);
        }
    }
    public static long findTree(int start, int end, int left, int right, int nodeNum, long[] tree){
        if(left > end || right < start)
            return 0;
        if(left <= start && right >= end)
            return tree[nodeNum];
        int mid = (start + end) / 2;
        long lResut = findTree(start, mid, left, right, nodeNum * 2, tree);
        long rResult = findTree(mid + 1, end, left, right, nodeNum * 2 + 1, tree);
        return lResut + rResult;
    }
}
