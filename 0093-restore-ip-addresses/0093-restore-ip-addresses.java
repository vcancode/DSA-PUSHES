class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s,0,0,new StringBuilder(),ans);
        return ans;
    }

    private void helper(String s, int idx,int parts,StringBuilder current,List<String> ans){
        if(parts==4){
            if(idx==s.length()){
                current.deleteCharAt(current.length()-1);
                ans.add(current.toString());
                //  current.append('.');
            }

            return;
        }

        int remaining = s.length()-idx;
        int partsleft = 4-parts;

        if(remaining<partsleft || remaining>3*partsleft) return;

        int num=0;
        int startlength=current.length();

        for(int i=idx;i<s.length() && i<idx+3;i++){
            if(i>idx && s.charAt(idx)=='0') break;

            num=num*10 + (s.charAt(i)-'0');

            if(num>255) break;

            //choose this number
            current.append(num).append('.');

            //recurse
            helper(s,i+1,parts+1,current,ans);

            //undo
            current.setLength(startlength);
        }

        return;
    }
}