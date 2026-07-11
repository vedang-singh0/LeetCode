class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        divide(nums,0,n-1);
        //here cuz we have to find largest thats why n-kth index, if we sort in descending order, then we can do k+1 index
        int result=nums[n-k];
        return result;
    }
    public static void divide(int arr[],int start,int end)
    {//this belowstep is important otherwise it will iterate for infinte time, and = is also important
        if(start>=end)
        {
            return;
        }
        else
        {
            int mid=start+(end-start)/2;
            divide(arr,start,mid);
            divide(arr,mid+1,end);
            conquer(arr,start,mid,end);
        }
    }
    public static void conquer(int arr[],int start,int mid,int end)
    {
        int merge[]=new int[end-start+1];//or not this start+end-1 cuz only good when start =0 only use this end-start+1
        int indx1=start;
        int indx2=mid+1;
        int x=0;
        while(indx1<=mid && indx2<=end)
        {
            if(arr[indx1]<arr[indx2])
            {
                merge[x]=arr[indx1];
                indx1++;
                x++;
            }
            else
            {
                merge[x]=arr[indx2];
                indx2++;
                x++;
            }
        }
        while(indx1<=mid)
        {
            merge[x]=arr[indx1];
            indx1++;
            x++;
        }
        while(indx2<=end)
        {
            merge[x]=arr[indx2];
            indx2++;
            x++;
        }
        int i,j;
        for(i=0, j=start;i<merge.length;i++,j++)
        {
            arr[j]=merge[i];
        }
        
    }
}