// Leetcode Problem: 2563. Count the Number of Fair Pairs
import java.util.Arrays;
public class DAY_18 {
        public long lower_bound(int[] nums, int low, int high, int element) {
            while(low <= high) {
                int mid = low + ((high - low) / 2);
                if(nums[mid] >= element) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            for(int i = 0; i < nums.length; i++) {
                long low = lower_bound (
                    nums,
                    i + 1,
                    nums.length - 1,
                    lower - nums[i]
                );
                long high = lower_bound (
                    nums,
                    i + 1,
                    nums.length - 1,
                    upper - nums[i] + 1
                );
                ans += 1 * (high - low);
            }
            return ans;
        }
    public static void main(String[] args) {
        DAY_18 obj = new DAY_18();
        int[] nums = {1, 2, 3, 4, 5};
        int lower = 3;
        int upper = 6;
        long result = obj.countFairPairs(nums, lower, upper);
        System.out.println("Count of fair pairs: " + result); // Output: Count of fair pairs: 6
    }
}
