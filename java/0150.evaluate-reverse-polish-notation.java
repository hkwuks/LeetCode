class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<String>();
        String a,b = null;
        Integer an,bn,cn = null;
        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                a = stack.pollFirst();
                b = stack.pollFirst();
                
                an = Integer.parseInt(a);
                bn = Integer.parseInt(b);
                
                if(tokens[i].equals("+")){
                    cn = an + bn;
                }else if(tokens[i].equals("-")) {
                    cn = bn - an;
                }else if(tokens[i].equals("*")) {
                    cn = an * bn;
                }else if(tokens[i].equals("/")) {
                    cn = bn / an;
                }
                stack.addFirst(cn.toString());
            }else{
                stack.addFirst(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peekFirst());
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}