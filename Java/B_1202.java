import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ValueRange;
import java.util.*;

class Diamond{
    int weight;
    long value;
    public Diamond(int weight, long value){
        this.weight = weight;
        this.value = value;
    }
}
public class B_1202 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Diamond> diamonds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            diamonds.add(new Diamond(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(diamonds, new Comparator<Diamond>() {
            @Override
            public int compare(Diamond o1, Diamond o2) {
                if(o1.weight < o2.weight) return -1;
                else if(o1.weight == o2.weight) return 0;
                else return 1;
            }
        });
        Collections.sort(bags);
        long sum = 0;
        PriorityQueue<Diamond> priorityQueue = new PriorityQueue<>(new Comparator<Diamond>() {
            @Override
            public int compare(Diamond o1, Diamond o2) {
                if(o1.value > o2.value) return -1;
                else if(o1.value == o2.value) return 0;
                else return 1;
            }
        });
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && bags.get(i) >= diamonds.get(j).weight){//담을수있는 보석이 있는가?
                priorityQueue.offer(diamonds.get(j));
                j += 1;
            }
            if(!priorityQueue.isEmpty()){
                sum += priorityQueue.poll().value;
            }
        }
        System.out.println(sum);
    }


}

