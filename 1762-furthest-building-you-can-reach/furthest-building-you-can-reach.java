class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //the main problem here is when to use brick or ladder, so that we can move furtherst.
        //here we take out the differences, put them in a min heap, and when size of min heap is greater than that pf ladder
        //we just remove required bricks if those bricks are less that given bricks, and when bricks are finished, we use left ladders, to climb those buildings.
        PriorityQueue<Integer> minHeap=
        new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<heights.length-1;i++)
        {
            int diff=heights[i+1]-heights[i];
            if(diff>0)//no use of negative distances as we go down the buildings
            {
                 minHeap.add(diff);
                if(minHeap.size()>ladders)
                {
                   
                    int required_bircks=minHeap.poll();
                    if(required_bircks>bricks)
                    {
                    return i;
                    }
                    else
                    {
                        bricks=bricks-required_bircks;
                    }


                }
            }
        }
        return heights.length-1;
        
    }
}