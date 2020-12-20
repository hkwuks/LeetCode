//双哈希表
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length)
            return false;
        Map<String, Character> s2char = new HashMap<>();
        Map<Character, String> char2s = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            if (s2char.containsKey(strings[i]) && !s2char.get(strings[i]).equals(pattern.charAt(i)))
                return false;
            if (char2s.containsKey(pattern.charAt(i)) && !char2s.get(pattern.charAt(i)).equals(strings[i]))
                return false;
            s2char.put(strings[i], pattern.charAt(i));
            char2s.put(pattern.charAt(i), strings[i]);
        }
        return true;
    }
}

//单哈希表
class Solution {
    public boolean wordPattern(String pattern,String s) {
        String[] strings = s.split(" ");
        if(pattern.length()!=strings.length)
            return false;
        Map map = new HashMap<>();
        for (Integer i = 0; i < pattern.length(); ++i) {
            if (!Objects.equals(map.put(pattern.charAt(i), i),(map.put(strings[i], i))))
                return false;
        }
        return true;
    }
}