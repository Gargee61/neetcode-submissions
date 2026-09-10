class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       
       int n = nums.length;

       //Step1:Intialize the deque and result array 
       //Deque stores INDICES, not values
       Deque<Integer> deque = new ArrayDeque<>();
       int[] result = new int[n-k+1];

       //Step2:Setup deque for the first k elements
       for(int i=0;i<k;i++){
        //Remove all smaller elements from the back
        while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
        } 
        deque.offerLast(i);
       }

       //The front of the deque is the max of the first window
       result[0] = nums[deque.peekFirst()];

       //Step 3:Process the remaining elements
       for(int i=k;i<n;i++){
        //remove the element that has slid out of the window
        if(deque.peekFirst() <= i-k){
        deque.pollFirst();
        }
       
       //Remove all elements smaller than the incoming element
        while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
        }

       //add current element's index
       deque.offerLast(i);

         //The front of the deque is always the max of the window
         result[i-k+1] = nums[deque.peekFirst()];
        }
        
        return result;
    }
}
