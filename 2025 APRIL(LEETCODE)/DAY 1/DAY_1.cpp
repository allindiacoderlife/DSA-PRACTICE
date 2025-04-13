#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long solve(vector<vector<int>>& questions) {
    int n = questions.size();
    vector<long> dp(n + 1, 0);

    for (int i = n - 1; i >= 0; i--) {
        int points = questions[i][0];
        int brainpower = questions[i][1];
        int nextIndex = i + brainpower + 1;

        long skip = dp[i + 1];
        long solve = points + (nextIndex < n ? dp[nextIndex] : 0);

        dp[i] = max(skip, solve);
    }

    return dp[0];
}

int main() {
    // Example usage
    vector<vector<int>> questions = {
        {3, 2},
        {4, 3},
        {4, 4},
        {2, 5}
    };
    cout << solve(questions) << endl; // Output: 5
    return 0;
}