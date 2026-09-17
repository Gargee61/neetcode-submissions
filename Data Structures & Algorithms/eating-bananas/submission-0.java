class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int max=Integer.MIN_VALUE;
        for(int no:piles){
            if(no>max){
                max=no;
            }
        }
        int i=1; int j=max; int result=Integer.MAX_VALUE;
        while(i<=j){
            int k=i+(j-i)/2; int c=0;
            for(int l=0; l<piles.length; l++){
                  if(piles[l]<=k){
                     c+=1;
                  }else{
                    c+=(int)Math.ceil((double)piles[l]/k);
                  }
            }
            if(c<=h && result>k){
                result=k;
            } if(c>h){
                i=k+1;
            }else{
                j=k-1;
            }
        }
        return result;  
    }
}
