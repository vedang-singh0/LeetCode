class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int[] nums,
                          int target,
                          int index,
                          List<Integer> curr,
                          List<List<Integer>> ans)
    {

        if(target==0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<nums.length;i++)
        {

            // Skip duplicate numbers at the same level
            if(i>index && nums[i]==nums[i-1])
                continue;

            // Since array is sorted, no need to continue further
            if(nums[i]>target)
                break;

            curr.add(nums[i]);

            // Move to next index (can't reuse the same element)
            backtrack(nums,target-nums[i],i+1,curr,ans);

            curr.remove(curr.size()-1);
        }

    }
}