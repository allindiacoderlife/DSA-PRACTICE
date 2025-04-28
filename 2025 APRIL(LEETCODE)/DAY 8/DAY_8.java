class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        
        if (hasDistinctElements(nums)) {
            return 0;
        }
        
        while (true) {
            operations++;
            int remainingLength = n - 3 * operations;
            if (remainingLength <= 0) {
                return operations;
            }
            
            int[] remainingArray = new int[remainingLength];
            System.arraycopy(nums, 3 * operations, remainingArray, 0, remainingLength);
            
            if (hasDistinctElements(remainingArray)) {
                return operations;
            }
        }
    }
    
    private boolean hasDistinctElements(int[] arr) {
        boolean[] seen = new boolean[101];
        for (int num : arr) {
            if (seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }
}    
