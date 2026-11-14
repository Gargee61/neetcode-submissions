class Solution {
     List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(""), 0, 0);
        return res;
    }
    private void backtrack(int n, StringBuilder curr, int openCount, int closeCount) {
        if (openCount == n && closeCount == n) {
            res.add(curr.toString());
            return;
        }
        if (openCount < n) {
            curr.append("(");
            backtrack(n, curr, openCount + 1, closeCount);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (closeCount < openCount) {
            curr.append(")");
            backtrack(n, curr, openCount, closeCount + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
        
    }
}
