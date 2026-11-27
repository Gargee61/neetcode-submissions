class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        backtrack(output, s, 0, new ArrayList<>(), dp);
        return output;
    }

    private void backtrack(List<List<String>> output, String s, int i, List<String> choices, Boolean[][] dp) {
        if (i == s.length()) {
            output.add(new ArrayList<>(choices));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j, dp)) {
                choices.add(s.substring(i, j + 1));
                backtrack(output, s, j + 1, choices, dp);
                choices.remove(choices.size() - 1); // Backtrack step
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
        if (i >= j) return true;
        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        return dp[i][j] = isPalindrome(s, i + 1, j - 1, dp); 
    }
}
