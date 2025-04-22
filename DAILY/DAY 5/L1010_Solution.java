// LeetCode Problem 1010: Pairs of Songs With Total Durations Divisible by 60
public class L1010_Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int result = 0;
        for (int t : time) {
            int mod = t % 60;
            result += count[(60 - mod) % 60];
            count[mod]++;
        }
        return result;
    }
    public static void main(String[] args) {
        L1010_Solution solution = new L1010_Solution();
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(solution.numPairsDivisibleBy60(time)); // Output: 3
    }
}
