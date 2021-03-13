class Solution {
    
    static final Map<Character, String> phoneMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno",
            '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
            StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length();++i){
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}