class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int bd=0;
        int sd=0;
        int profit=0;
        for(int i=1;i<=n-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                sd++;
            }
            
            else
            {
                profit=profit+(prices[sd]-prices[bd]);
                sd=bd=i;
            }
            
        }
        profit=profit+(prices[sd]-prices[bd]);
return profit;
    }
    
}