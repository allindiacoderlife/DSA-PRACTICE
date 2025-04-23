#include<iostream>
#include<vector>

using namespace std;
class Solution {
    public:
        int countLargestGroup(int n) {
            vector<int> count(37, 0); // Maximum digit sum for n <= 1000 is 36 (999)
            for (int i = 1; i <= n; ++i) {
                count[digitSum(i)]++;
            }
            int maxCount = 0;
            for (int i = 0; i < count.size(); ++i) {
                maxCount = max(maxCount, count[i]);
            }
            int result = 0;
            for (int i = 0; i < count.size(); ++i) {
                if (count[i] == maxCount) {
                    result++;
                }
            }
            return result;
        }
        int digitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
};

int main() {
    Solution solution;
    int n = 13; // Example input
    cout << "Number of largest groups: " << solution.countLargestGroup(n) << endl;
    return 0;
}

