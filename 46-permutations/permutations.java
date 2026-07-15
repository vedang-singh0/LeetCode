class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        getPerm(nums,0,result);
        return result;
        
    }
    public /*List<List<Integer>>*/ void getPerm(int nums[],int index,/*int*/ List<List<Integer>> perm)//perm is a list not integer, so dont use int with list. also make the function void as not returning something
    {
        //the main idea is to swap each index with the each element in array, so we take index var for iterating over index and for element iteration we have variable i, now we will everytime iterate i from index to n, recall the state space tree, how we fill one position and swap other two, and move to next node and so on. and then we do backtrack, so we swap once again. the swap function will carry one array, and  two places with need to be swapped, index and i. so this is the code
        int n=nums.length;
        if(index==n)
        {
            List<Integer> current=new ArrayList<>();
            for(int j=0;j<nums.length;j++)
            {
                current.add(nums[j]);//we are making here a list from array of num, cuz perm is list of list it will only take, list as input, so we firts ahve to convert nums to list.
            }
            perm.add(current);
            return;
        }
        for(int i=index;i<n;i++)
        {
            swapNum(nums,index,i);
            getPerm(nums,index+1,perm);
            //backtrack swap
            swapNum(nums,index,i);
        }
    }
    public static void swapNum(int nums[],int index,int i)//here we are passing two integers, but we should pass one array and its two indices
    {
        
        int temp=nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
    }
}