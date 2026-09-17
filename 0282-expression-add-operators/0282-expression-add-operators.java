class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        
        helper(num, 0, new StringBuilder(), 0, 0, target);

        return ans;
    }

     private void helper(
        String num,
        int idx,
        StringBuilder current,
        long value,
        long prev,
        int target
    ) {

        if(idx==num.length()){
            if(value==target) ans.add(current.toString());
            return;
        }

        int startlen = current.length();

        long number=0;

        for(int i=idx;i<num.length();i++){
            if(i>idx && num.charAt(idx)=='0') break;
            number=number*10 + (num.charAt(i)-'0');
            String part = num.substring(idx,i+1);
            if(idx==0){
                current.append(part);
                helper(
                    num,
                    i+1,
                    current,
                    number,
                    number,
                    target
                );

                current.setLength(startlen);
            }
            else{
                //+
                current.append('+').append(part);
                helper(
                    num,
                    i+1,
                    current,
                    value+number,
                    number,
                    target
                );
                current.setLength(startlen);

                //-
                current.append('-').append(part);
                helper(
                    num,
                    i+1,
                    current,
                    value-number,
                    -number,
                    target
                );
                current.setLength(startlen);

                //*
                current.append('*').append(part);
                helper(
                    num,
                    i+1,
                    current,
                    value-prev + (prev*number),
                    prev*number,
                    target
                );
                current.setLength(startlen);
            }
        }
    }
}