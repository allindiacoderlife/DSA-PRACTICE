// LeetCode Problem 39: Combination Sum
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class L39_Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int n = candidates.length;
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(candidates);
            func(list, temp, candidates, target, 0, n);
            return list;
        }
        public void func(List<List<Integer>> list, List<Integer> temp, int[] arr, int target, int start, int n) {
            if(target == 0) {
                list.add(new ArrayList<>(temp));
                return;
            }
            for(int i = start; i < n; i++) {
                if(arr[i] > target) break;
                temp.add(arr[i]);
                func(list, temp, arr, target - arr[i], i , n);
                temp.remove(temp.size() - 1);
            }
        }
    public static void main(String[] args) {
        L39_Solution obj = new L39_Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = obj.combinationSum(candidates, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}
