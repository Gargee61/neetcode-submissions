
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // preprocessing: make sure nums1 is smallest
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int N = nums1.length + nums2.length; // total number of elements in both arrays

        if (N == 1){
            // handle edge case of exactly one element
            if (nums1.length == 1){
                return nums1[0];
            } else {
                return nums2[0];
            }
        }


        // we want to find a partition of nums1 and nums2 such that the left partition has the same number of elements as the right partitition or is off by one,
        // and the largest element of the left partition is <= to the smallest element of the right partition

        // first approach: increment over nums1 from the 0th element and make equal partions, until we find a valid partition, and calculate the median

        int low = 0;
        int high = nums1.length;
        int i = 0;
        while(true) {

            int j = N / 2 - i;
                int largestL;
                if(i == 0){
                    largestL = nums2[j-1]; // left partition of nums1 is empty

                } else if (j == 0){
                    largestL = nums1[i - 1]; // left partition of nums2 is empty
                } else {
                    largestL = Math.max(nums1[i-1], nums2[j-1]);
                }

                int smallestR;
                if (i == nums1.length){
                    // right partition of nums1 is empty
                    smallestR = nums2[j];

                } else if(j == nums2.length){
                    // right partition of nums2 is empty
                    smallestR = nums1[i];
                } else {
                    // choose the smallest
                    smallestR = Math.min(nums1[i], nums2[j]);

                }
            // the ith element is in the right partition (possibly empty)
            if (largestL <= smallestR) {
                if (N % 2 == 0){
                    return (float) (largestL + smallestR) / 2;
                } else {
                    return smallestR;
                }
            } else{
                // cases to handle: 
                // case 1: rightmost element of left partition in nums1 is greater than the leftmost element in the right partion of nums2
                // i marks the highest index in nums1 we should consider

                if (i > 0 && j < nums2.length && nums1[i - 1] > nums2[j]){
                    //System.out.println("A " + i);
                    high = i - 1;
                }
                

                // case 2: leftmost element of right partition in nums1 is less than the rightmost element in left partition of nums2
                // i marks the lowest index in nums1 we should consider
                if (i < nums1.length && j > 0 && nums1[i] < nums2[j - 1]){
                    //System.out.println("B " + i);
                    low = i + 1;

                }

                //i++;
                i = (low + high) / 2;
            }
           

        }
        
    }
}