//哈希表
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

//快慢指针法
class Solution {
public:
    bool isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
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

//数学规律
class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> a = { 4, 16, 37, 58, 89, 145, 42, 20 };
        while (n != 1 && a.count(n) == 0) {
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