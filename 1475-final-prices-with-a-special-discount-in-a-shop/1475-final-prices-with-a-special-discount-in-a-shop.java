class Solution {
    static{
        int[] prices = {1};
        for(int i=0;i<200;i++){
            int[] answer = finalPrices(prices);
        }
    }
    public static int[] finalPrices(int[] prices) {
        int[] answer = prices.clone();

        if(prices.length < 0){
            return answer;
        }

        for(int i=0;i<prices.length;i++){
            
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] >= prices[j]){
                    answer[i] -= prices[j];
                    break;
                }
            }
        }

        return answer;
    }
}