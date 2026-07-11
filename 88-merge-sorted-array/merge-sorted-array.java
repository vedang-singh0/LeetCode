class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indx1=0;
        int indx2=0;
        int x=0;
        //we will not form anyother array to copy our answers cus, we have num1 of size m+n where we will copy our answers anfter merging, so no use of this, its given in question
        //int[] sorted=new int[m+n];
        int merge[]=new int[m+n];
        //when you will write condition for the rest left elements dont include them in this while loop, do them aftter this while. as done below
        while(indx1<m && indx2<n)
        {
            if(nums1[indx1]<nums2[indx2])
            {
                merge[x]=nums1[indx1];
                x++;
                indx1++;
            }
            else
            {
                merge[x]=nums2[indx2];
                x++;
                indx2++;
            }
        } 
            //if used if have to enter loop for once, and while used to enter again n again, thats why use while
            while(indx1<m)
            {
                merge[x]=nums1[indx1];
                x++;
                indx1++;
            }
            while(indx2<n)
            {
                merge[x]=nums2[indx2];
                x++;
                indx2++;
            }
            for(int i=0;i<merge.length;i++)
            {
                nums1[i]=merge[i];
            }  
            for(int i=0;i<merge.length;i++)
            {
                System.out.print(nums1[i]+" ");
            } 
            System.out.println();
        }
    }
