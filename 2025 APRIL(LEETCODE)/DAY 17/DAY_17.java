// leetcode problem : 2176. Count Equal and Divisible Pairs in an Array

class DAY_17 {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,2,2,1,3};
        int k = 2;
        DAY_17 obj = new DAY_17();
        int result = obj.countPairs(nums, k);
        System.out.println("The number of pairs is: " + result);
    }
}