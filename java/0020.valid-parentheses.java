class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i < s.length(); ++i) {
            Character c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.addFirst(c);
            }else if(stack.isEmpty()){
                return false;
            } else if (c == ')' && stack.peekFirst() == '('){
                stack.pollFirst();
            }else if (c == ']' && stack.peekFirst() == '['){
                stack.pollFirst();
            }else if (c == '}' && stack.peekFirst() == '{'){
                stack.pollFirst();
            }else{
                return false;
            }
        }
        if(stack.peekFirst() == null){
            return true;
        }else{
            return false;
        }
    }
}