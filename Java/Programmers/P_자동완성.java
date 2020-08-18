class Word{
    int cnt;
    Word[] words;
    public Word(){
        this.cnt = 0;
        words = new Word[26];
    }

}
public class P_자동완성 {

    public static void main(String[] args) {
	// write your code here
//        String[] words = {"go","gone","guild"};
//        String[] words = {"abc","def","ghi","jklm"};
        String[] words = {"word","war","warrior","world"};
        int result = solution(words);
        System.out.println(result);
    }

    public static int solution(String[] words) {
        int answer = 0;
        Word root = new Word();
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            makeTree(root, tmp);
        }
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            answer += findTree(root, tmp);
        }
        return answer;
    }

    public static void makeTree(Word root, String word){
        Word pointer = root;
        for (int i = 0; i < word.length(); i++) {
            if(pointer.words[word.charAt(i) - 'a'] != null){
                pointer = pointer.words[word.charAt(i) - 'a'];
                pointer.cnt += 1;
            }
            else{
                pointer.words[word.charAt(i) - 'a'] = new Word();
                pointer = pointer.words[word.charAt(i) - 'a'];
                pointer.cnt += 1;
            }

        }
    }
    public static int findTree(Word root, String word){
        Word pointer = root;
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            if(pointer.cnt == 1){
                return i;
            }
            pointer = pointer.words[word.charAt(i) - 'a'];
        }
        return i;
    }
}
