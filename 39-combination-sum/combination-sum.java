class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);

        return result;
    }

    public void backtrack(int[] candidates, int target, int index,
                          List<Integer> current, List<List<Integer>> result) {

        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        // Try every candidate starting from 'index'
        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);

            // i is passed because we can reuse the same element
            backtrack(candidates, target - candidates[i], i, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}