class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int ans=0;
        for(char c:s.toCharArray()){
            if(st.isEmpty()) {
                st.push(c);
                continue;
            }
            else{
                if(c=='a' && st.peek()=='b'){
                        st.pop();
                        ans++;
                    }

                else st.push(c);
                }
                
            }

            return ans;
        }

        
    
    }
