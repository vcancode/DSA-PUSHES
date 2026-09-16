class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return Collections.emptyList();
       
        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        helper("", digits, phone_map, output);
        return output;
    }

    private void helper(String comb, String digits, String[] phone, List<String> ans){
            if(digits.isEmpty()) ans.add(comb);
            else{
                String letters = phone[digits.charAt(0)-'2'];
                for(char c :  letters.toCharArray())
                    helper(comb+c,digits.substring(1),phone,ans);
            }
    }
}