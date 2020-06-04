
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class B_17779{
    static int N;
    static int min_diff = Integer.MAX_VALUE;
//    public static int minx, miny, len1, len2;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int x = 1; x <= N; ++x){
            for(int y = 1; y <= N; ++y){
                for(int d1 = 1; d1 <= N; ++d1){
                    for(int d2 = 1; d2 <= N; ++d2){
                        if((x + d1 + d2 <= N) && (y + d2 <= N) && (y - d1 >= 1)){
                            ArrayList<Point> line1, line2, line3, line4;
                            line1 = new ArrayList<>();
                            for(int i = 0; i <= d1; ++i){
                                line1.add(new Point(x + i, y - i));
                            }
                            line2 = new ArrayList<>();
                            for(int i = 0; i <= d2; ++i){
                                line2.add(new Point(x + i, y + i));
                            }
                            line3 = new ArrayList<>();
                            for(int i = 0; i <= d2; ++i){
                                line3.add(new Point(x + d1 + i, y -d1 + i));
                            }
                            line4 = new ArrayList<>();
                            for(int i = 0; i <= d1; ++i){
                                line4.add(new Point(x + d2 + i, y + d2 - i));
                            }
                            int tmp = drawLine(line1, line2,line3, line4, map, x, y, d1 , d2);
                            if(tmp < min_diff){

                                min_diff = tmp;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min_diff);

    }
    public static int drawLine(ArrayList<Point> line1, ArrayList<Point> line2, ArrayList<Point> line3, ArrayList<Point> line4, int[][] map ,int x, int y, int d1, int d2){
        int diff = 0;
        int[][] checkMap = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                checkMap[i][j] = 6;
            }
        }
        for(int i = 0; i < line1.size(); ++i){
            int tmpX, tmpY;
            Point point = line1.get(i);
            tmpX = point.x;
            tmpY = point.y;
            checkMap[tmpX][tmpY] = 5;
        }
        for(int i = 0; i < line2.size(); ++i){
            int tmpX, tmpY;
            Point point = line2.get(i);
            tmpX = point.x;
            tmpY = point.y;
            checkMap[tmpX][tmpY] = 5;
        }
        for(int i = 0; i < line3.size(); ++i){
            int tmpX, tmpY;
            Point point = line3.get(i);
            tmpX = point.x;
            tmpY = point.y;
            checkMap[tmpX][tmpY] = 5;
        }
        for(int i = 0; i < line4.size(); ++i){
            int tmpX, tmpY;
            Point point = line4.get(i);
            tmpX = point.x;
            tmpY = point.y;
            checkMap[tmpX][tmpY] = 5;
        }
        for(int r = 1 ; r < x + d1; ++r){
            for(int c = 1; c<= y; ++c){
                if(checkMap[r][c] == 5)
                    break;
                else
                    checkMap[r][c] = 1;
            }
        }

        for(int r = 1 ; r <= x + d2; ++r){
            for(int c = N; c > y; --c){
                if(checkMap[r][c] == 5)
                    break;
                else
                    checkMap[r][c] = 2;
            }
        }
        for(int r = x + d1 ; r <= N; ++r){
            for(int c = 1; c < (y - d1 + d2); ++c){
                if(checkMap[r][c] == 5)
                    break;
                else
                    checkMap[r][c] = 3;
            }
        }
        for(int r = x + d2 + 1; r <= N; ++r){
            for(int c = N; c >= (y - d1 + d2);--c){
                if(checkMap[r][c] == 5)
                    break;
                else
                    checkMap[r][c] = 4;
            }
        }
        int[] area = new int[6];
        for(int i = 1; i <= N; ++i){
            for (int j = 1; j <= N ; j++) {
                if(checkMap[i][j] == 1){
                    area[1] += map[i][j];
                }else if(checkMap[i][j] == 2){
                    area[2] += map[i][j];
                }else if(checkMap[i][j] == 3){
                    area[3] += map[i][j];
                }else if(checkMap[i][j] == 4){
                    area[4] += map[i][j];
                }else{
                    area[5] += map[i][j];
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i <= 5; ++i){
            if(maxValue < area[i]){
                maxValue = area[i];
            }
            if(minValue > area[i])
                minValue = area[i];
        }
        diff = maxValue - minValue;
        return diff;
    }

}
