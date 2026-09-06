class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0,maxLen=0;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0) + 1);

            while(map.get(ch) > 1){
               char lChar = s.charAt(l);
               map.put(lChar,map.get(lChar)-1);
               l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
