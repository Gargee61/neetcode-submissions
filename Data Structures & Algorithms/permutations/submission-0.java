class Solution {
    public List<List<Integer>> permute(int[] nums) {
         Set<Integer> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, visited, result);
        return result;
    }

    private void backtrack(int [] nums, List<Integer> path, Set<Integer> visited, List<List<Integer>> result) {
        if (visited.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num: nums) {
            if (!visited.contains(num)) {
                path.add(num);
                visited.add(num);
                backtrack(nums, path, visited, result);
                path.remove(path.size() - 1);
                visited.remove(num);
            }
        }
    }
}
