class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+" ");

        }
        System.out.println();
        
    }
    //here we dont return anything, so instead of int well return void
    public static void quickSort(int arr[],int start,int end)
    {
        //"if" checks the condition only once, so Quick Sort partitions the array once and then lets recursion handle the smaller subarrays."while" checks the condition again after recursion returns, but since start and end never change in that function call, the condition stays true forever, causing the same partitioning to repeat and leading to Time Limit Exceeded.
        if(start<end)
        {
            int pivot=partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }
    public static int partition(int arr[],int start,int end)
    {
        int pivot=arr[end];
        //we have replaced i=-1 with i=start-1 becuz in case starrt will be in 5th index, soi will be according to that, not -1 always
        int i = start-1;
        for(int j=start;j<end;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[end]=temp;
        return i;
    }
}