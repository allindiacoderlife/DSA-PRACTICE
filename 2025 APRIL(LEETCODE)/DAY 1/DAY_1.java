
class DAY_1 {

    public static void main(String[] args) {
        // Example usage
        int[][] questions = {
            {3, 2},
            {4, 3},
            {4, 4},
            {2, 5}
        };
        System.out.println(solve(questions)); // Output: 5
    }

    public static long solve(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;

            long skip = dp[i + 1];
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);

            dp[i] = Math.max(skip, solve);
        }

        return dp[0];
    }
}
