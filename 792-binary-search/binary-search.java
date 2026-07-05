class Solution {
    public int search(int[] nums, int target) {
        int size=nums.length;
        
            int mid;
           
            int first=0;
            int last=size-1;
            while(first<=last)
            {

            
            mid=first+(last-first)/2;
            if(nums[mid]>target)
            {
                
                last=mid-1;
            }
            else if(nums[mid]<target)
            {
                first=mid+1;
                last=size-1;
            }
            else if(nums[mid]==target)
            {
                return mid;
            }
            }


        
        return -1;
    }

}