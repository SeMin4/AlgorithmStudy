public class P_소수만들기 {
    static int cnt = 0;
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,7,6,4};
        int result = solution(nums);
        System.out.println(result);
    }
    public static int solution(int[] nums) {
        int answer = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[] prime = new boolean[sum + 1];
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if(!prime[i]){
                for (int j = i + i; j <= sum; j += i) {
                    prime[j] = true;
                }
            }
        }
        boolean[] visit = new boolean[nums.length];
        dfs(0, prime, visit, nums, 0);
        return answer = cnt;
    }
    public static void dfs(int depth, boolean[] prime, boolean[] visit, int[] num, int startIdx){
        if(depth == 3){
            int sum = 0;
            for (int i = 0; i < visit.length; i++) {
                if(visit[i]){
                    sum += num[i];
                }
            }
            if(!prime[sum]){
                cnt += 1;
            }
            return;
        }
        for (int i = startIdx; i < num.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                dfs(depth + 1, prime, visit, num, i + 1);
                visit[i] = false;
            }
        }
    }
}
