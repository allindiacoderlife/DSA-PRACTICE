// 1863. Sum of All Subset XOR Totals
#include<iostream>
#include<vector>

using namespace std;
class Solution
{
public:
    int subsetXORSum(vector<int> &nums)
    {
        int ans = 0;
        for (int num : nums)
        {
            ans |= num;
        }
        return ans << (nums.size() - 1);
    }
};