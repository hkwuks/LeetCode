class Solution {
public:
    bool isHappy(int n) {
        if (n == 1) return true;
        unordered_map<int, int> a;
        while (n != 1 && a[n] == 0) {
            a[n] = 1;
            n = getNext(n);
        }
        return n == 1;
    }
    int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
};

class Solution {
public:
    bool isHappy(int n) {
        if (n == 1) return true;
        unordered_set<int> a;
        while (n != 1 && !a.count(n) == 0) {
            a.emplace(n);
            n = getNext(n);
        }
        return n == 1;
    }
    int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
};