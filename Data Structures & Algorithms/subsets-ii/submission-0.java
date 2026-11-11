class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n : freqMap.keySet()) {
            List<List<Integer>> curr = res;
            for(int i = 0; i < freqMap.get(n); i++) {
                List<List<Integer>> next = new ArrayList<>();
                for(List<Integer> row : curr) {
                    List<Integer> copy = new ArrayList<>(row);
                    copy.add(n);
                    next.add(copy);
                }
                curr = next;
                res.addAll(next);
            }
        } 
        return res; 
    }
}
