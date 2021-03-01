public class P_신규아이디추천{

    public static void main(String[] args) {
	// write your code here
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^.";
//        String new_id = "123_.def";
//        String new_id = "abcdefghijklmn.p";
        String new_id = "=.=";
        System.out.println(solution(new_id));
    }
    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z'){
                continue;
            }else if(sb.charAt(i) >= '0' && sb.charAt(i) <= '9'){
                continue;
            }else if(sb.charAt(i) =='-' || sb.charAt(i) =='_' || sb.charAt(i) == '.'){
                continue;
            }
            else{
                sb.deleteCharAt(i);
                i--;
            }
        }
        int cnt = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) =='.'){
                cnt +=1 ;
                if(cnt >= 2){
                    sb.deleteCharAt(i);
                    i--;
                    cnt -= 1;
                }
            }else
                cnt = 0;
        }
        if(sb.length() == 0){
            sb = new StringBuilder("a");
        }
        if(sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            sb = new StringBuilder("a");
        }
        if( sb.charAt(sb.length() - 1) == '.'){
            sb.deleteCharAt(sb.length() - 1);
        }
        if(sb.length() == 0){
            sb = new StringBuilder("a");
        }
        if(sb.length() >= 16){
            sb = new StringBuilder(sb.substring(0, 15));
        }
        if(sb.charAt(sb.length() - 1) == '.'){
            sb.deleteCharAt(sb.length() - 1);
        }
        if(sb.length() <= 2){
            do{
                sb.append(sb.charAt(sb.length() - 1));
            }while (sb.length() < 3);
        }

        return sb.toString();
    }
}