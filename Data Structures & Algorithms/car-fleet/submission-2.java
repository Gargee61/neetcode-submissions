class Car{
    int position;
    double timeToTarget;

    Car(int position,double timeToTarget){
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
} 
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
       int n = speed.length;
       if(n == 0 ) return 0;
       Car cars[] = new Car[n];

       for(int i=0;i<n;i++){
        cars[i] = new Car(position[i],(double)(target-position[i])/speed[i]);
       }
       Arrays.sort(cars, new Comparator<Car>(){
        public int compare(Car a, Car b){
            return a.position - b.position;
        }
       });
       int ans = 0;
       for(int i=n-1;i>=1;i--){
        if(cars[i].timeToTarget >= cars[i-1].timeToTarget){
            cars[i-1] = cars[i];
        }else{
            ans++;
        }
       }
       return ans+1;
    }
}
