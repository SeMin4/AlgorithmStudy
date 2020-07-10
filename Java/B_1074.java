import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1074 {
    static int N, r, c;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N * 2);
        int cnt = 0;
        int horizontalMax = (int) Math.pow(2, N) - 1;
        int horizontalMin = 0;
        int verticalMax = (int) Math.pow(2, N) - 1;
        int verticalMin = 0;

        while(true){
            int verticalMid = (verticalMax + verticalMin) / 2;
            int horizontalMid = (horizontalMax + horizontalMin) / 2;
            if(verticalMid >= r){
                verticalMax = verticalMid;
                if(horizontalMid >= c){
                    horizontalMax = horizontalMid;
                    //1사분면
                }else{
                    horizontalMin = horizontalMid + 1;
                    cnt += size / 4;
                    //2사분면
                }
            }else{
                verticalMin = verticalMid + 1;
                if(horizontalMid >= c){
                    horizontalMax = horizontalMid;
                    cnt += 2 * (size / 4);
                    //3사분면
                }else{
                    horizontalMin = horizontalMid + 1;
                    cnt += 3 * (size / 4);
                    // 4사분면
                }
            }
            size /= 4;
            if(verticalMax - verticalMin == 0 && horizontalMax - horizontalMin == 0){
                break;
            }

        }
        System.out.println(cnt);

    }
}
