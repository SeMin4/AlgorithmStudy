import java.io.*;
import java.util.PriorityQueue;

class Number implements Comparable<Number>{
    int num;
    public Number(int num){
        this.num = num;
    }

    @Override
    public int compareTo(Number o) {
        if(Math.abs(this.num) < Math.abs(o.num)){
            return -1;
        }
        else if (Math.abs(this.num) == Math.abs(o.num)){
            if(this.num < o.num){
                return -1;
            }else if(this.num == o.num){
                return 0;
            }else{
                return 1;
            }
        }
        else
            return 1;
    }
}
public class B_11286 {
    public static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n != 0)
                priorityQueue.add(new Number(n));
            else{
                if(priorityQueue.size() == 0)
                    bw.write(0 + "\n");
                else{
                    Number tmp = priorityQueue.poll();
                    bw.write(tmp.num + "\n");
                }
            }
        }
        bw.close();
    }
}
