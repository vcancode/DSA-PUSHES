class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int x:nums){
            int num=x;
            List<Integer> li = new ArrayList<>();
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                   li.add(i);
                   while(num%i==0){
                    num/=i;
                   }
                   
                }
            }

            if(num>1) li.add(num);
            mp.put(x,li);
        }

        int l=0,r=0;
        int ans=0;
        Map<Integer,Integer> mp2 = new HashMap<>();
        while(r<nums.length){
            for(int i=0;i<mp.get(nums[r]).size();i++){
                int num=mp.get(nums[r]).get(i);
                mp2.put(num,mp2.getOrDefault(num,0)+1);
            }

            while(mp2.size()>k){
                for(int i=0;i<mp.get(nums[l]).size();i++){
                    int num=mp.get(nums[l]).get(i);
                    mp2.put(num,mp2.getOrDefault(num,0)-1);
                    if(mp2.get(num)==0) mp2.remove(num);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }

        return ans;
        
    }
}