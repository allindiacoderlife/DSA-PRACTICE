// LeetCode Problme 1399 : Count Largest Group
public class DAY_23 {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; // Maximum digit sum for n <= 1000 is 36 (999 -> 9+9+9)
        int maxCount = 0;
        int largestGroup = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
            if (count[sum] > maxCount) {
                maxCount = count[sum];
                largestGroup = 1;
            } else if (count[sum] == maxCount) {
                largestGroup++;
            }
        }

        return largestGroup;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        DAY_23 obj = new DAY_23();
        System.out.println(obj.countLargestGroup(13)); // Output: 4
    }
}
