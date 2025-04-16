// Leetcode Problem: 2537. Count the Number of Good Subarrays
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    long long countGood(vector<int> &nums, int k)
    {
        long long result = 0;
        int n = nums.size();
        unordered_map<int, int> freq;
        int left = 0;
        long long pairs = 0;

        for (int right = 0; right < n; ++right)
        {
            freq[nums[right]]++;
            pairs += freq[nums[right]] - 1;

            while (pairs >= k)
            {
            result += n - right;
            pairs -= freq[nums[left]] - 1;
            freq[nums[left]]--;
            left++;
            }
        }

        return result;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 1, 1, 1, 1};
    int k = 10;
    cout << s.countGood(nums, k) << endl; 
    return 0;
}