import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Document{
    int priority;
    int idx;
    public Document(int priority, int idx){
        this.priority = priority;
        this.idx = idx;
    }


}
public class P_프린터 {

    public static void main(String[] args) {
	// write your code here
        int[] priorities = {2, 1, 3, 2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> queue = new LinkedList<>();
        int[] priority_arr = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            priority_arr[priorities[i]] += 1;
            queue.offer(new Document(priorities[i], i));
        }
        int max = 9;
        for (int i = 9; i >= 1; i--) {
            if(priority_arr[i] != 0){
                max = i;
                break;
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()){
            Document tmp = queue.poll();
            if(tmp.priority != max){
                queue.add(tmp);
            }
            else{
                cnt += 1;
                if(tmp.idx == location)
                    return cnt;
                priority_arr[max] -= 1;
                if(priority_arr[max] == 0){
                    for (int i = max; i >= 1 ; i--) {
                        if(priority_arr[i] != 0){
                            max = i;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
