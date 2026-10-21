class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<nums1.length;i++){
            mp.put(nums1[i],i);
        }

        for(int i=nums2.length-1;i>=0;i--){
            int num = nums2[i];
            if(mp.containsKey(num)){
                if(st.isEmpty()){
                    ans[mp.get(num)]=-1;
                }
                else{
                    while(true){
                        int key=st.peek();
                        if(key>num){
                            ans[mp.get(num)]=key;
                            break;
                        }
                        else{
                            st.pop();
                            if(st.isEmpty()){
                                ans[mp.get(num)]=-1;
                                break;
                            }
                        }
                    }
                }

            }
            st.push(num);
        }

        return ans;
    }
}