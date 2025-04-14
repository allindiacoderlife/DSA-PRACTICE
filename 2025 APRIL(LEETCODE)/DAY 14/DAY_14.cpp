#include<iostream>
#include<vector>

using namespace std;

class DAY_14 {
    public:
    int countGoodTriplets(vector<int>& arr, int a, int b, int c) {
        int n = arr.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (abs(arr[i] - arr[j]) <= a && abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};

int main() {
    DAY_14 obj;
    vector<int> arr = {1, 2, 3, 4, 5};
    int a = 1, b = 1, c = 1;
    cout << "Number of good triplets: " << obj.countGoodTriplets(arr, a, b, c) << endl;
    return 0;
}