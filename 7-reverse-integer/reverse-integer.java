class Solution {
    public int reverse(int x) {
        int rev=0;
        int temp=x;
        while(temp!=0)
        {
        int digit=temp%10;
        
        //integer max value=2147483647, thats why last digit must me less than 7 
        //for number to be acceptable, same goes for negative
        //overflow
        if(rev>Integer.MAX_VALUE/10|| rev== Integer.MAX_VALUE/10 && digit>7)
        return 0;
        //underflow
        if(rev<Integer.MIN_VALUE/10|| rev== Integer.MAX_VALUE/10 && digit<-8)
        return 0;
        //the below given line will always come below, after the over and underflow, have been checked,(imp)
        rev=rev*10+digit;
        temp=temp/10;
        }
        
        return rev;
    }
}