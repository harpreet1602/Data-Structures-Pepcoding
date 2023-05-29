public class designParking {
    class ParkingSystem {
        // 1603. Design Parking System
        // tc O(n) sc O(1)
        //     private variables can be taken
        //     we can store them when the constructor is called
        //     and then in the add function we will check for which car type the function is called.
        //     then if the corresponding variable is more than 0 then return true and otherwise false and  decrement that value.
            private int big,medium,small;
            public ParkingSystem(int big, int medium, int small) {
                this.big = big;
                this.medium = medium;
                this.small = small;
            }
            
            public boolean addCar(int carType) {
                if(carType == 1){
                    return big-->0?true:false;
                }
                if(carType == 2){
                    return medium-->0?true:false;
                    
                }
                if(carType == 3){
                    return small-->0?true:false;   
                }
                return false;
            }
        }
        
        /**
         * Your ParkingSystem object will be instantiated and called as such:
         * ParkingSystem obj = new ParkingSystem(big, medium, small);
         * boolean param_1 = obj.addCar(carType);
         */
}
