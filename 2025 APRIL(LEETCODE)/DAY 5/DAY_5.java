// 1863. Sum of All Subset XOR Totals
public class DAY_5 {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result |= num;
        }
        return result << (nums.length - 1);
    }
}
