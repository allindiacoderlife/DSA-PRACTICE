#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    // Function to find the lower bound index
    long long lower_bound(vector<int>& nums, int low, int high, int element) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Function to count the number of fair pairs
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        sort(nums.begin(), nums.end());
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            long long low = lower_bound(nums, i + 1, nums.size() - 1, lower - nums[i]);
            long long high = lower_bound(nums, i + 1, nums.size() - 1, upper - nums[i] + 1);
            ans += 1 * (high - low);
        }
        return ans;
    }
};

int main() {
    Solution obj;
    vector<int> nums = {1, 2, 3, 4, 5};
    int lower = 3;
    int upper = 6;
    long long result = obj.countFairPairs(nums, lower, upper);
    cout << "Count of fair pairs: " << result << endl; // Output: Count of fair pairs: 6
    return 0;
}
