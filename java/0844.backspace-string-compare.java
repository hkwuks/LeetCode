class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack = new LinkedList<Character>();
        Deque<Character> tStack = new LinkedList<Character>();

        for (int i = 0; i < s.length();++i){
            Character tmp = s.charAt(i);
            if (tmp == '#'){
                sStack.poll();
            }else {
                sStack.push(tmp);
            }
        }

        for (int i = 0; i < t.length();++i){
            Character tmp = t.charAt(i);
            if (tmp == '#'){
                tStack.poll();
            }else {
                tStack.push(tmp);
            }
        }

        return sStack.equals(tStack);
    }
}


class Solution{
    public boolean backspaceCompare(String s, String t){
        return build(s).equals(build(t));
    }
    public String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();++i){
            Character tmp = s.charAt(i);
            if (tmp == '#'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() -1);
                }
            }else {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}