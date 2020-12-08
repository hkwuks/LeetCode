//回溯算法,break就肯定没有结果,continue是增大当前数字,backtrack保证了list中元素的合法性
class Solution {
public:
    vector<int> splitIntoFibonacci(string S) {
        vector<int> list;
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    bool backtrack(vector<int>& list, string S, int length, int index, long long sum, int prev) {
        if (index == length)
            return list.size() >= 3;
        long long curr = 0;
        for (int i = index;i < length;++i) {
            //每个块不要0开头，除非这个块是0本身
            if (i > index && S[index] == '0') {
                break;
            }
            curr = curr * 10 + S[i] - '0';
            if (curr > INT_MAX) {
                break;
            }
            //寻找第三个元素的时候进入
            if (list.size() > 1) {
                if (curr < sum) {
                    continue;
                }
                else if (curr > sum) {
                    break;
                }
            }
            list.emplace_back(curr);
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            }
            list.pop_back();
        }
        return false;
    }
};