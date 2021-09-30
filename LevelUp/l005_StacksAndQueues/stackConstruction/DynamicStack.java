// to yhaa pai dynamic stack ke pass stack vali sari cheeze milgyi public and protected
        
public class DynamicStack extends stack{
    DynamicStack(int size){
        super(size);
        // to yeh sidha stack ke parameterized constructor ko call karde 
    }
    DynamicStack(){
        super();
        // to ye stack ke default constructor ko call karde
    }
    // ye override yha pai and super mai function ka signature same hona chaiye
    // tabhi override kar sakte ho
    // baaki kisi function mai koi change nhi tha to bas push ko override kar rhe hai
    // taki size khatam hote hi khud bada le => dynamic stack 
    @Override
    public void push(int data) throws Exception{
        if(super.size() == super.MaxCapacity()){
            int[] temp = new int[super.size()];
            int idx = super.size() - 1;
            while(super.size()!=0){
                temp[idx--] = super.pop();
            }
            initialize(temp.length*2);

            for(int ele:temp){
                super.push(ele);
            }
        }
        super.push(data);
    }
}
