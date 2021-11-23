class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length()==s2.length()&&(s2+s2).contains(s1);
    }
}