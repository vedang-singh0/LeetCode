class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        //becuz in ques it is given -123 will not be considered as palindrome, as it will be123-, so we will only check over positiv numbers
        while(temp>0)
        {
            int digit=temp%10;
            if(rev>Integer.MAX_VALUE || rev==Integer.MAX_VALUE && digit>7)
            return false;
            if(rev<Integer.MIN_VALUE || rev==Integer.MIN_VALUE && digit<-8)
            return false;
            
            rev=rev*10+digit;
            temp=temp/10;
        }
        if(rev==x)
        return true;
        else
        return false;
        
    }
}