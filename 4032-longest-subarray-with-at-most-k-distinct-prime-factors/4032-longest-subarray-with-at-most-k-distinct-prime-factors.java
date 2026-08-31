class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> arr = new ArrayList<>();
        for(int num : nums)
            {
                List<Integer> list = new ArrayList<>();
                for(int i=2;i*i<=num;i++)
                    {
                        if(num%i==0)
                        {
                            list.add(i);
                            while(num%i==0)
                                {
                                    num /= i;
                                }
                        }
                    }
                if(num > 1)list.add(num);
                arr.add(list);
            }
        int l = 0;
        int r = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        while(r<arr.size())
            {
                for(int i=0;i<arr.get(r).size();i++)
                    {
                        int num = arr.get(r).get(i);
                        map.put(num,map.getOrDefault(num,0)+1);
                    }
                while(map.size()>k)
                {
                    for(int i=0;i<arr.get(l).size();i++)
                    {
                        int num = arr.get(l).get(i);
                        map.put(num,map.getOrDefault(num,0)-1);

                        if(map.get(num)==0)map.remove(num);
                    }
                    l++;
                }
                ans = Math.max(ans,r-l+1);
                r++;
            }
        return ans;
    }
}