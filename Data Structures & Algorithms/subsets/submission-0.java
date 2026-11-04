class Solution {
    public List<List<Integer>> subsets(int[] A) {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        subsetsHelper(A, 0, new ArrayList<>(), ar);
        return new ArrayList<>(ar);
    }

    void subsetsHelper(int[] A, int currIdx, ArrayList<Integer> curr,
                       ArrayList<ArrayList<Integer>> ar) {

        if (currIdx == A.length) {
            ar.add(new ArrayList<>(curr));
            return;
        }

        // take
        curr.add(A[currIdx]);
        subsetsHelper(A, currIdx + 1, curr, ar);

        // backtrack
        curr.remove(curr.size() - 1);

        // don't take
        subsetsHelper(A, currIdx + 1, curr, ar);
    }
}
