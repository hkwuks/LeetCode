// 全部通过
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放左边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}

// 一般方法，未通过大字符串用例
class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length(),sLen=s.length();
        if(tLen>sLen){
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>(2*tLen);
        for (int i = 0; i < tLen; ++i) {
            char c = s.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = tLen-1;
        int len = Integer.MAX_VALUE;
        int start=-1;
        while (true) {
            if (check(tMap, t)) {
                if(j-i+1<len){
                    len=j-i+1;
                    start=i;
                }
                if (j - i + 1 > tLen) {
                    tMap.put(s.charAt(i), tMap.get(s.charAt(i)) - 1);
                    ++i;
                    continue;
                }
            }

            if(j<sLen-1){
                ++j;
                tMap.put(s.charAt(j), tMap.getOrDefault(s.charAt(j), 0) + 1);
            } else {
                break;
            }
        }
        if (len > sLen) {
            return "";
        }
        return s.substring(start,start+len);
    }

    private boolean check(Map<Character,Integer> tMap, String t) {
        HashMap<Character, Integer> tmp = new HashMap<>(2*t.length());
        for (int k = 0; k < t.length(); ++k) {
            char c = t.charAt(k);
            if(!tmp.containsKey(c)){
                tmp.put(c,tMap.getOrDefault(c,0));
            }
            if (tmp.get(c)==0) {
                return false;
            }
            tmp.put(c,tmp.get(c)-1);
        }
        return true;
    }
}

// 改进方法，未通过大字符串用例
class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length(),sLen=s.length();
        if(tLen>sLen){
            return "";
        }
        if(tLen==sLen && s.equals(t)){
            return s;
        }
        Map<Character, Integer> tMap = new HashMap<>(2*tLen);
        for (int i = 0; i < tLen; ++i) {
            char c = s.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        HashSet<Character> tCheck = new HashSet<Character>(2*tLen);
        for (int i = 0; i < tLen; i++) {
            char c=t.charAt(i);
            tCheck.add(c);
        }
        int i = 0, j = tLen-1;
        int len = Integer.MAX_VALUE;
        int start=-1;
        if (check(tMap, t)) {
            if (j - i + 1 < len) {
                len = j - i + 1;
                start = i;
            }
        }
        while(j<sLen){
            while(j<sLen-1){
                ++j;
                tMap.put(s.charAt(j), tMap.getOrDefault(s.charAt(j), 0) + 1);
                if(tCheck.contains(s.charAt(j))){
                    if (check(tMap, t)) {
                        if (j - i + 1 < len) {
                            len = j - i + 1;
                            start = i;
                        }
                        break;
                    }
                }
            }
            while (j - i + 1 > tLen) {
                tMap.put(s.charAt(i), tMap.get(s.charAt(i)) - 1);
                ++i;
                if(tCheck.contains(s.charAt(i))){
                    if (check(tMap, t)) {
                        if (j - i + 1 < len) {
                            len = j - i + 1;
                            start = i;
                        }
                    }else if(i<sLen-tLen){
                        --i;
                        tMap.put(s.charAt(i), tMap.getOrDefault(s.charAt(i), 0) + 1);
                        break;
                    }
                }
            }

            if(j==sLen-1){
                if (check(tMap, t)) {
                    if (j - i + 1 < len) {
                        len = j - i + 1;
                        start = i;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        if (len > sLen) {
            return "";
        }
        return s.substring(start,start+len);
    }

    private boolean check(Map<Character,Integer> tMap, String t) {
        HashMap<Character, Integer> tmp = new HashMap<>(2*t.length());
        for (int k = 0; k < t.length(); ++k) {
            char c = t.charAt(k);
            if(!tmp.containsKey(c)){
                tmp.put(c,tMap.getOrDefault(c,0));
            }
            if (tmp.get(c)==0) {
                return false;
            }
            tmp.put(c,tmp.get(c)-1);
        }
        return true;
    }
}