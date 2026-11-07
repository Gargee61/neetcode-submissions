class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> results = new ArrayList<>();
        // 1. Sort the array to group duplicates together
        Arrays.sort(candidates);
        // 2. Start the backtracking process
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> results) {
        // Base case: success
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate elements at the same recursion depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Early pruning: since the array is sorted, remaining elements will be larger
            if (candidates[i] > target) {
                break;
            }

            // Include the candidate and move to the next index (i + 1)
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, results);
            
            // Backtrack: remove the last element before the next iteration
            path.remove(path.size() - 1);
        }  
    }
}
