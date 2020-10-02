import java.util.Arrays;

public class P_체육복 {

    public static void main(String[] args) {
	// write your code here
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, 1);
        for (int i = 0; i < lost.length; i++) {
            cnt[lost[i]] -= 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            cnt[reserve[i]] += 1;
        }
        if(cnt[1] == 0 && cnt[2] >= 2){
            cnt[1] = 1;
            cnt[2] = 1;
        }

        for (int i = 2; i < n; i++) {
            if(cnt[i] == 0 && cnt[i - 1] >= 2){
                cnt[i] += 1;
                cnt[i - 1] -= 1;
            }
            else if(cnt[i] == 0 && cnt[i + 1] >= 2){
                cnt[i] += 1;
                cnt[i + 1] -= 1;
            }
        }
        if(cnt[n] == 0 && cnt[n - 1] >= 2){
            cnt[n] = 1;
            cnt[n - 1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            answer = cnt[i] >= 1 ? answer += 1 : answer;
        }
        return answer;
    }
}
