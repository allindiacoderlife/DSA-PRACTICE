// Leetcode Problem: 2537. Count the Number of Good Subarrays
import java.util.*;
class DAY_16 {
    public long countGood(int[] nums, int k) {
        long count = 0;
        int left = 0;
        int pairs = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            pairs += freqMap.get(nums[right]) - 1;

            while (pairs >= k) {
            count += nums.length - right;
            freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
            pairs -= freqMap.get(nums[left]);
            left++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        DAY_16 day_16 = new DAY_16();
        int[] nums = {1, 1, 1, 1, 1};
        int k = 10;
        System.out.println(day_16.countGood(nums, k)); // Output: 1
    }
}