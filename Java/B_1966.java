import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Doc{
    boolean valid;
    int priority;
    public Doc(int priority, boolean valid){
        this.priority = priority;
        this.valid = valid;
    }

}
public class B_1966 {
    static int testCase;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());

        int N, M;

        ArrayList<Doc> priorityArr;
        while(testCase > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            priorityArr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                if(i == M){
                    priorityArr.add(new Doc(Integer.parseInt(st.nextToken()), true));
                }
                else
                    priorityArr.add(new Doc(Integer.parseInt(st.nextToken()), false));
            }
            boolean get = false;
            int sequence = 0;
            while(!get){
                Doc doc = priorityArr.get(0);
                boolean printDoc = true;
                for (int i = 1; i < priorityArr.size(); i++) {
                    Doc compareDoc = priorityArr.get(i);
                    if (doc.priority < compareDoc.priority){
                        priorityArr.remove(0);
                        priorityArr.add(doc);
                        printDoc = false;
                        break;
                    }
                    printDoc = true;
                }
                if(printDoc){
                    priorityArr.remove(0);
                    sequence += 1;
                    if(doc.valid){
                        get = true;
                        System.out.println(sequence);
                    }
                }
            }
            testCase -= 1;
        }


    }
}
