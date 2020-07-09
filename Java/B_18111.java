import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_18111 {
    static int N, M, B;
    static int minTime = Integer.MAX_VALUE;
    static int height;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[] map = new int[N * M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i*M + j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(map);
        int minValue = map[0];
        int maxValue = map[map.length - 1];
        int negative = 0, positive = 0, time = 0;

        while(maxValue >= minValue){
            negative = 0;
            positive = 0;
            time = 0;
            for (int i = 0; i < map.length; i++) {
                int diff = map[i] - maxValue;
                if(diff > 0){//깍아야 한다
                    negative += diff;
                }else if(diff < 0) {//채워야 한다.
                    positive += diff;
                }
            }
            if(negative + B < (positive * -1)){
                maxValue -= 1;
            }
            else{
                time = negative * 2 + (positive * -1);
                if(time < minTime){
                    minTime = time;
                    height = maxValue;
                }
                maxValue -= 1;
            }
        }
        System.out.println(minTime + " " + height);
    }
}
