#include<iostream>
#include<vector>

using namespace std;

class Solution {
    public:
        int countPairs(vector<int>& nums, int k) {
            int n = nums.size(), count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(i * j % k == 0 && nums[i] == nums[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
};

int main() {
    Solution sol;
    vector<int> nums = {3, 1, 2, 2, 2, 1, 3};
    int k = 2;
    cout << "Count of pairs: " << sol.countPairs(nums, k) << endl;
    return 0;
}