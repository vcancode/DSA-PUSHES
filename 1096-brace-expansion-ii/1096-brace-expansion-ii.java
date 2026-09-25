class Solution {
    String s;
    int n;
    int idx = 0;

    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        Set<String> st= performUnion();   
        return new ArrayList<>(st);
    }

    private Set<String> getUnit() {
        Set<String> result;

        if(s.charAt(idx)=='{'){
            idx++;
            result=performUnion();
        }

        else{
            result = new TreeSet<>();
            result.add(String.valueOf(s.charAt(idx)));
        }

        idx++;
        return result;
    }

    private Set<String> performConcat() {
        Set<String> result = new TreeSet<>();
        result.add("");

        while(idx<n && (s.charAt(idx)=='{' || Character.isLetter(s.charAt(idx)))){

            Set<String> temp = getUnit();

            Set<String> concatresult=new TreeSet<>();
            for(String left: result){
                for(String right: temp){
                    concatresult.add(left+right);
                }
            }

            result=concatresult;
        }

        return result;
    }

    private Set<String> performUnion() {
        Set<String> result = new TreeSet<>();

        while(true){
            Set<String> concatresult = performConcat();
            result.addAll(concatresult);

            if(idx<n && s.charAt(idx)==',') idx++;

            else break;

            
        }

        return result;
    }
}