import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    String name;
    int score;
    public Person(String name, int score){
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Person o) {
        if(this.score > o.score) return -1;
        else if(this.score == o.score){
            return name.compareTo(o.name);
        }
        else return 1;
    }
}
public class B_20124 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            person[i] = new Person(name, score);
        }
        Arrays.sort(person);
        System.out.println(person[0].name);
    }
}
