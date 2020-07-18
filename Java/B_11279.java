import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B_11279 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(maxQueue.isEmpty())
                    System.out.println(0);
                else{
                    int tmp = maxQueue.poll();
                    System.out.println(tmp);
                }
            }else{
                maxQueue.add(num);
            }
        }
    }
}
