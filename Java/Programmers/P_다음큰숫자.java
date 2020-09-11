public class P_다음큰숫자{

    public static void main(String[] args) {
	// write your code here
        int result = solution(15);
        System.out.println(result);
    }
    public static int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int one_cnt = 0, zero_cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1')
                one_cnt+= 1;
            else
                zero_cnt += 1;
        }
        int i = n + 1;
        while (true){
            String tmp = Integer.toBinaryString(i);
            int one = 0;
            for (int j = 0; j < tmp.length(); j++) {
                if(tmp.charAt(j) == '1')
                    one += 1;
            }
            if(one == one_cnt)
                return i;
            i += 1;
        }
    }
}
