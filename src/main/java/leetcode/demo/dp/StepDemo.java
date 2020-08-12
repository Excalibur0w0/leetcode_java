package leetcode.demo.dp;

public class StepDemo {
    public int getStep(int s) {
        int[] dp = new int[s + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= s; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[s];
    }

    public static void main(String[] args) {
        System.out.println(new StepDemo().getStep(10));
    }
}
