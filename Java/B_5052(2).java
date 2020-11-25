import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_5052_2{
    static int T;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            String result = "YES";
            for (int j = 0; j < N; j++) {
                list.add(br.readLine());
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() < o2.length())
                        return -1;
                    else if(o1.length() == o2.length())
                        return 0;
                    else return 1;
                }
            });
            HashMap<Integer, Set<String>> hashMap = new HashMap<>();
            for (int j = 1; j <= 10; j++) {
                hashMap.put(j, new HashSet<>());
            }
            for (int j = 0; j < N; j++) {
                String tmp = list.get(j);
                int k;
                for (k = 1; k < tmp.length(); k++) {
                    String sub = tmp.substring(0, k);
                    if(hashMap.get(k).contains(sub)){
                        result = "NO";
                        break;
                    }
                }
                if(result.equals("NO"))
                    break;
                else
                    hashMap.get(k).add(tmp);
            }
            System.out.println(result);
        }
    }
}
