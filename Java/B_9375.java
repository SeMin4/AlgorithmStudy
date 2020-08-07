import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_9375 {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            LinkedHashMap<String, ArrayList<String>> hashMap = new LinkedHashMap<>();
            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String elem = st.nextToken();
                String key = st.nextToken();
                if(hashMap.get(key) != null){
                    hashMap.get(key).add(elem);
                }else{
                    hashMap.put(key, new ArrayList<String>());
                    hashMap.get(key).add(elem);
                }
            }
            int result = 1;
            for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : hashMap.entrySet()) {
                result *= (stringArrayListEntry.getValue().size() + 1);
            }
            System.out.println(result - 1);
            
        }
    }
}
