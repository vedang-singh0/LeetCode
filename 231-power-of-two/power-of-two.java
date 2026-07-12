class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n<1)//if n is less than 1, any number less than 1 ans will always be false
        return false;
        if(n==1)
        return true;
        if(n%2!=0)
        return false;
        
        while(n%2==0)
        {
            
            return isPowerOfTwo(n/2);
            
        }
        return true;
    }
}