class Solution {
    private void helper(int[] nums, List<List<Integer>> ans,List<Integer> comb,Set<Integer> st ){
        if(comb.size()==nums.length){
            if(!ans.contains(comb)){
            ans.add(new ArrayList<>(comb));
            return;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(!st.contains(i)){
                st.add(i);
                comb.add(nums[i]);
                helper(nums,ans,comb,st);
                st.remove(i);
                comb.remove(comb.size()-1);
            }
        }





    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        helper(nums,ans,comb,st);
        return ans;
    }
}