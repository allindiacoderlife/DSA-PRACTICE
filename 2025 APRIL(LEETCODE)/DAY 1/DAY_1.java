
class DAY_1 {
    public static void main(String[] args) {
        // Example usage
        int[][] questions = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solve(questions)); // Output: 4
    }

    public static long solve(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + questions[i - 1][0]);
            if (i > questions[i - 1][1]) {
                dp[i] = Math.max(dp[i], dp[i - questions[i - 1][1] - 1] + questions[i - 1][0]);
            }
        }

        return dp[n];
    }
}