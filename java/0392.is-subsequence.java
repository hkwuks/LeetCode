class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] arr=s.toCharArray();
        int k=-1;
        for(int i=0;i<s.length();i++){
            k=t.indexOf(arr[i],k+1);
            if(k==-1) return false;
            
        }
        return true;
    }
}