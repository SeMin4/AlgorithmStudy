import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Trie{
    boolean chk;
    int child;
    Trie[] nodes;
    public Trie(boolean chk, int child){
        this.chk = chk;
        this.child = child;
        this.nodes = new Trie[10];
    }
}
public class B_5052 {
    static int T;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Trie root = new Trie(false, 0);
            int N = Integer.parseInt(br.readLine());
            String result = "YES";
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String tmp = br.readLine();
                list.add(tmp);
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
            for (int j = 0; j < N; j++) {
                Trie pointer = root;
                String tmp = list.get(j);
                int k = 0;
                for (k = 0; k < tmp.length() - 1; k++) {
                    if(pointer.chk){
                        result = "NO";
                        break;
                    }
                    pointer.child += 1;
                    if(pointer.nodes[tmp.charAt(k) - '0'] == null){
                        pointer.nodes[tmp.charAt(k) - '0'] = new Trie(false, 0);
                    }
                    pointer = pointer.nodes[tmp.charAt(k) - '0'];
                }
                if(pointer.chk){
                    result = "NO";
                    break;
                }
                pointer.child += 1;
                if(pointer.nodes[tmp.charAt(k) - '0'] == null){
                    pointer.nodes[tmp.charAt(k) - '0'] = new Trie(true, 0);
                }
            }
            System.out.println(result);
        }

    }
}
