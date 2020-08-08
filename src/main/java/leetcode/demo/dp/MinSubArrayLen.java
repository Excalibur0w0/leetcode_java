package leetcode.demo.dp;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
//        int result = minSubArrayLen.minSubArrayLen3(7, new int[]{2, 3, 1, 2, 4, 3});
        int result = minSubArrayLen.minSubArrayLen3(5, new int[]{2, 3});
        System.out.println(result);
    }

    // 双指针方法
    public int minSubArrayLen3(int s, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums[0] >= s) {
            return 1;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(i <= j && j < nums.length) {
            if (sum >= s) {
                int subLen = j - i + 1;
                if (subLen < min) {
                    min = subLen;
                }
                sum -= nums[i++];
            } else {
                sum += nums[j++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums[0] >= s) {
            return 1;
        }
        // 使用行间转换dp[i][j] = dp[i - 1][j] - nums[i - 1]; 进行压缩空间
        // 得到dp[j] = dp[j] - nums[i - 1]
        int[] dp = new int[nums.length];
        int min = Integer.MAX_VALUE;

        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            dp[j] = dp[j - 1] + nums[j];
            if (dp[j] >= s && j + 1 < min) {
                min = j + 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[j] = dp[j] - nums[i - 1];
                if (dp[j] >= s && j - i + 1 < min) {
                    min = j - i + 1;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp为数组的所有连续子序列和，第一维度表示左下标，第二维度表示右边下标
        // if(i != j): dp[i][j] = dp[i][j - 1] + nums[j];
        // if(i == j): dp[i][j] = nums[i];
        int[][] dp = new int[nums.length][nums.length];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                if (dp[i][j] >= s && j - i + 1 < min) {
                    min = j - i + 1;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
