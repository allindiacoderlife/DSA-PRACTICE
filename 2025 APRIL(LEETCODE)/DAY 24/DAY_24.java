
// LeetCode Problem 2799: Count Complete Subarrays in an Array
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class DAY_24 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        System.out.println(countCompleteSubarrays(nums)); // Output: 3
    }

    public static int countCompleteSubarrays(int[] nums) {
        int k = (int) Arrays.stream(nums).distinct().count(), res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                st.add(nums[j]);
                if (st.size() == k)
                    res++;
            }
        }
        return res;
    }
}