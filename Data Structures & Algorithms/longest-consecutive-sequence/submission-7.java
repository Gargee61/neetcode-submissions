class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for (int num:nums) {
           store.add (num);
        }

        for (int num:nums){
          if (!store.contains(num-1)) {
        int streak=0;
        int curr=num;
        while (store.contains(curr)){
           streak++;
           curr++;
        }
        
        res = Math.max(res,streak);
          }
        }
        return res;
    }
}
