import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    int start;
    int end;
    int length;
    public Person(int start, int end){
        if(start > end){
            this.start = end;
            this.end = start;
        }
        else{
            this.start = start;
            this.end = end;
        }
    }

    @Override
    public int compareTo(Person o) {
        if(this.end < o.end) return -1;
        else if (this.end == o.end){
            if(this.start < o.start) return -1;
            else if(this.start == o.start) return 0;
            else return 1;
        }
        else return 1;
    }
}
public class B_13334{
    static int N, D;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        D = Integer.parseInt(br.readLine());
        Arrays.sort(people);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            pq.offer(people[i].start);
            while (!pq.isEmpty() && pq.peek() < (people[i].end - D)) pq.poll();
            res = Math.max(res, pq.size());
        }
        System.out.println(res);

    }
}
