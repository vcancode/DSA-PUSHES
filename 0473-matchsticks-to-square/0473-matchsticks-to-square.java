class Solution {

    private boolean helper(int[] matchsticks,int[] buckets,int target,int idx){
        if(idx<0) return true;
        int num = matchsticks[idx];
        for(int i=0;i<buckets.length;i++){
            if(num+buckets[i]>target) continue;

            buckets[i]+=num;

            if(helper(matchsticks,buckets,target,idx-1)) return true;

            buckets[i]-=num;

        }

        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        int sum = 0;
        for(int num:matchsticks){
            sum+=num;
        }
        if(sum%4!=0) return false;

        int target = sum/4;

        Arrays.sort(matchsticks);

        int[] buckets = new int[4];

        return helper(matchsticks,buckets,target,n-1);
    }
}