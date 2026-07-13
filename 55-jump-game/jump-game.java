import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        //max jumps =index of array, jumps can be less than that value but should not exceed tha value
        int n=nums.length;
        int start=0;
        int end=0;
        int next_jump=0;
        if(n==1)
        return true;
       while(start<=end && end<n-1)
       {
        for(int i=start;i<=end;i++)
        {
            next_jump=Math.max(next_jump,i+nums[i]);
            if(next_jump>=n-1)
        return true;
        }
        start=end+1;//setting start value
        end=next_jump;//setting end value
       }
      
        return false;
    }
}