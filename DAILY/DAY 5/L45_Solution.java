// LeetCode Problem 45: Jump Game II

public class L45_Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n - 1);
            for(int j = i + 1; j <= maxJump; j++) {
                if(dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[0];
    }
    public int jumpGreedy(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        L45_Solution solution = new L45_Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums)); // Output: 2
    }
}
