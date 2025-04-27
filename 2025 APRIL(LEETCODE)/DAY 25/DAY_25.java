// LeetCode Problem: 2845. Count of Interesting Subarrays
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DAY_25 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        long res = 0;
        int prefix = 0;
        for (int num : nums) {
            if (num % modulo == k) prefix++;
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        DAY_25 obj = new DAY_25();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int modulo = 3;
        int k = 1;
        long result = obj.countInterestingSubarrays(nums, modulo, k);
        System.out.println("Count of interesting subarrays: " + result); // Output: Count of interesting subarrays: 4
    } 
}
