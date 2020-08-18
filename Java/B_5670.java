import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Word{
    int cnt = 0;
    boolean finish = false;
    HashMap<Character, Word> words = new HashMap<>();


}
public class B_5670 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null){
            N = Integer.parseInt(input);
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            Word root = new Word();
            for (int i = 0; i < N; i++) {
                String tmp = words[i];
                makeTree(root, tmp);
            }
            double result = 0;
            for (int i = 0; i < N; i++) {
                String tmp = words[i];
                result += findTree(root, tmp);
            }
            System.out.printf("%.2f\n", result / (double) N);
        }

    }
    public static void makeTree(Word root, String word){
        Word pointer = root;
        for (int i = 0; i < word.length(); i++) {
            if(pointer.words.get(word.charAt(i)) != null){
                pointer = pointer.words.get(word.charAt(i));
                if(i == word.length() - 1){
                    pointer.finish = true;
                }
                pointer.cnt += 1;
            }
            else{
                pointer.words.put(word.charAt(i), new Word());
                pointer = pointer.words.get(word.charAt(i));
                if(i == word.length() - 1){
                    pointer.finish = true;
                }
                pointer.cnt += 1;
            }
        }
    }
    public static double findTree(Word root, String word){
        Word pointer = root;
        pointer = pointer.words.get(word.charAt(0));
        int cnt = 1;
        int i = 0;
        for (i = 1; i < word.length(); i++) {
            if(pointer.cnt == 1)
                return (double) cnt;
            if(pointer.finish){
                pointer = pointer.words.get(word.charAt(i));
                cnt += 1;
            }
            else if(pointer.words.size() == 1){
                while(pointer.words.size() == 1){
                    Set<Character> next = pointer.words.keySet();
                    for(Character character : next){
                        pointer = pointer.words.get(character);
                    }
                    i++;
                    if(pointer.finish){
                        break;
                    }
                }
                i -= 1;
            }
            else{
                pointer = pointer.words.get(word.charAt(i));
                cnt += 1;
            }
        }
        return (double) cnt;
    }
}
