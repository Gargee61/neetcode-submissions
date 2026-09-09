class Solution {
    public String minWindow(String s, String t) {
       int len1 = s.length();
        int len2 = t.length();

        if (len1 < len2)
            return "";

        int[] countT = new int[256];
        int[] countS = new int[256];

        // Store occurrence of characters of P
        for (int i = 0; i < len2; i++)
            countT[t.charAt(i)]++;

        int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < len1; j++) {
            char currChar = s.charAt(j);
            
            // Count occurrence of characters of string S
            countS[currChar]++;

            // If S's char matches with P's char, increment count
            if (countT[currChar] > 0 && countS[currChar] <= countT[currChar]) {
                count++;
            }

            // If all characters are matched
            if (count == len2) {
                
                // Try to minimize the window
                char startChar;
                while (countS[startChar = s.charAt(start)] > countT[startChar] || countT[startChar] == 0) {
                    if (countS[startChar] > countT[startChar]) {
                        countS[startChar]--;
                    }
                    start++;
                }

                // Update window size
                int len = j - start + 1;
                if (min_len > len) {
                    min_len = len;
                    start_idx = start;
                }
            }
        }

        if (start_idx == -1)
            return "";

        return s.substring(start_idx, start_idx + min_len); 
    }
}
