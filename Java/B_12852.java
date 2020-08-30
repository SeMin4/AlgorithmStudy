import java.util.Scanner;

public class B_12852 {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N + 1];
        int[] parent = new int[N + 1];
        parent[1] = -1;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            parent[i] = i - 1;
            if(i % 2 == 0 && dp[i] > dp[i / 2] + 1){
                dp[i] = dp[i / 2] + 1;
                parent[i] = i / 2;
            }
            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1){
                dp[i] = dp[i / 3] + 1;
                parent[i]  = i / 3;
            }
        }
        System.out.println(dp[N]);
        printParent(parent, N);
        System.out.println();

    }
    public static void printParent(int[] parent, int i){
        System.out.print(i + " ");
        if(parent[i] == -1)
            return;
        printParent(parent, parent[i]);

    }
}
