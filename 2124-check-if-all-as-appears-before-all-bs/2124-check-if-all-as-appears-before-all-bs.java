class Solution {
    public boolean checkString(String s) {
        int lastpos = s.lastIndexOf('a');
        int first  = s.indexOf('b');
        if(lastpos<0 || first<0) return true;
        return lastpos<first;
    }
}