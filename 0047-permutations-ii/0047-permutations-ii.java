// my bruteforce approach

// class Solution {
//     private void helper(int[] nums, List<List<Integer>> ans,List<Integer> comb,Set<Integer> st ){
//         if(comb.size()==nums.length){
//             if(!ans.contains(comb)){
//             ans.add(new ArrayList<>(comb));
//             return;
//             }
//         }

//         for(int i=0;i<nums.length;i++){
//             if(!st.contains(i)){
//                 st.add(i);
//                 comb.add(nums[i]);
//                 helper(nums,ans,comb,st);
//                 st.remove(i);
//                 comb.remove(comb.size()-1);
//             }
//         }





//     }
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> comb = new ArrayList<>();
//         Set<Integer> st = new HashSet<>();
//         helper(nums,ans,comb,st);
//         return ans;
//     }
// }


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, res);
        return res;
    }
    void solve(int s, int[] nums, List<List<Integer>> res){
        if(s == nums.length - 1){
            ArrayList<Integer> newAr = new ArrayList<>();
            for(int val: nums){
                newAr.add(val);
            }
            res.add(newAr);
            return;
        }
        for (int i = s; i < nums.length; i++) {
            boolean duplicate = false;

            for (int j = s; j < i; j++) {
                if (nums[j] == nums[i]) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                continue;
            }

            int temp = nums[s];
            nums[s] = nums[i];
            nums[i] = temp;

            solve(s + 1, nums, res);

            temp = nums[s];
            nums[s] = nums[i];
            nums[i] = temp;
        }
    }
}