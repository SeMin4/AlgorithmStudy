import java.util.LinkedList;
import java.util.Queue;

public class P_네트워크{

    public static void main(String[] args) {
	// write your code here
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                answer += 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visit[i] = true;
                while (!queue.isEmpty()){
                    int V = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if(computers[V][j] == 1 && !visit[j]){
                            queue.offer(j);
                            visit[j] = true;
                        }

                    }
                }
            }
        }
        return answer;
    }
}
