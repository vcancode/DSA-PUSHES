class Solution {
    public int maxArea(int[] height){
        int lmax=0;int rmax=0;
        int area=0;
        int l=0,r=height.length-1;
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                int arr=lmax*(r-l);
                area=Math.max(area,arr);
                l++;
            }
            else{
                int arr=rmax*(r-l);
                area=Math.max(area,arr);
                r--;
            }
        }

        return area;
    }

}