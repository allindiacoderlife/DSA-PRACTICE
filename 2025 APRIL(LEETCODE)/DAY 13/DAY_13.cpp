#include <iostream>
using namespace std;

// Function to calculate (x^y) % p
long power(long x, long y, long p) {
    long res = 1; // Initialize result
    x = x % p; // Update x if it is more than or equal to p
    if (x == 0) return 0; // In case x is divisible by p
    while (y > 0) {
        // If y is odd, multiply x with result
        if (y & 1) {
            res = (res * x) % p;
        }
        // y must be even now
        y = y >> 1; // y = y / 2
        x = (x * x) % p; // Change x to x^2
    }
    return res;
}

// Function to calculate the count of good numbers
int countGoodNumbers(long n) {
    long mod = 1000000007;
    long even = (n + 1) / 2;
    long odd = n / 2;
    long evenCount = power(5, even, mod);
    long oddCount = power(4, odd, mod);
    return (int)((evenCount * oddCount) % mod);
}

int main() {
    long n = 50;
    cout << countGoodNumbers(n) << endl;
    return 0;
}