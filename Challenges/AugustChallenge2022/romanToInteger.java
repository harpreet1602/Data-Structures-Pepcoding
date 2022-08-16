import java.util.HashMap;

public class romanToInteger {
    
    // 13. Roman to Integer
//     tc O(n) sc O(1)
//     add all the numbers but if it is one of the 6 instances case then subtract the currno from the total no accordingly 
public int romanToInt(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    int no = 0;        
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);
    
    for(int i=s.length()-1;i>=0;i--){
        char ch = s.charAt(i);
        int currno = map.get(ch);
        
        if(i!=s.length()-1){
            char nextch = s.charAt(i+1);
            if((ch == 'I') && ((nextch == 'V')|| (nextch == 'X'))){
                no = no - currno;   
            }
            else if((ch == 'X') && ((nextch == 'L')|| (nextch == 'C'))){
                no = no - currno;   
            }
            else if((ch == 'C') && ((nextch == 'D')|| (nextch == 'M'))){
                no = no - currno;   
            }
            else{
                no = no + currno;
            }
        }else{
            no = no + currno;
        }
    }
    return no;
}
}
