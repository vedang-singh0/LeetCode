class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        getPerm(nums,0,result);
        return result;   
    }
    public void getPerm(int[] nums,int index,List<List<Integer>> perm)
    {
        int n=nums.length;
        if(index==n)
        {
            List<Integer> current = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                current.add(nums[i]);
            }
            perm.add(current);
            return;
        }
        //set is used to remove duplicates
        Set<Integer> used=new HashSet<>();
        for(int i=index;i<nums.length;i++)//here well iterate from index to n
        {
            if(used.contains(nums[i]))
            {
                continue;//this will not iterate the below code, just change the value of i to its next.
            }
            used.add(nums[i]);//if that elememnt is not in set, then add it to the set.
            swapNum(nums,index,i);
            getPerm(nums,index+1,perm);
            swapNum(nums,index,i);
        }
    }
    public void swapNum(int nums[],int index,int i)
    {
        int temp=nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
    }
}