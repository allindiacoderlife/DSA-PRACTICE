// Leetcode Problem: 2999. Count the Number of Powerful Integers

import java.util.Arrays;

class DAY_10 {
    private long[][][] dp;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long countFinish = countPowerful(finish, limit, s);

        long countStart = countPowerful(start - 1, limit, s);

        return countFinish - countStart;
    }

    private long countPowerful(long x, int limit, String s) {
        String numStr = Long.toString(x);
        int n = numStr.length();
        dp = new long[n][2][2]; 
        for (long[][] row : dp) {
            for (long[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return digitDP(0, 1, 0, numStr, limit, s);
    }

    private long digitDP(int pos, int isSmaller, int hasSuffix, String numStr, int limit, String s) {
        if (pos == numStr.length()) {
            return hasSuffix == 1 ? 1 : 0;
        }

        if (dp[pos][isSmaller][hasSuffix] != -1) {
            return dp[pos][isSmaller][hasSuffix];
        }

        long count = 0;
        int maxDigit = isSmaller == 1 ? 9 : (numStr.charAt(pos) - '0');

        for (int digit = 0; digit <= maxDigit; digit++) {
            if (digit > limit) {
                continue;
            }

            int newIsSmaller = isSmaller == 1 || digit < maxDigit ? 1 : 0;

            int newHasSuffix = hasSuffix;
            if (s.length() <= pos + 1) {
                String suffixCandidate = numStr.substring(0, pos) + digit;
                if (suffixCandidate.endsWith(s)) {
                    newHasSuffix = 1;
                }
            }

            count += digitDP(pos + 1, newIsSmaller, newHasSuffix, numStr, limit, s);
        }

        dp[pos][isSmaller][hasSuffix] = count;
        return count;
    }

    public static void main(String[] args) {
        DAY_10 obj = new DAY_10();
        System.out.println(obj.numberOfPowerfulInt(1, 6000, 4, "124")); // Output: 5
        System.out.println(obj.numberOfPowerfulInt(15, 215, 6, "10"));  // Output: 2
        System.out.println(obj.numberOfPowerfulInt(1000, 2000, 4, "3000")); // Output: 0
        System.out.println(obj.numberOfPowerfulInt(1829505, 1255574165, 7, "11223")); // Efficient for large ranges
    }
}