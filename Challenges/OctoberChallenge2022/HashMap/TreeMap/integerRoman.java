public class integerRoman{
    
    // 12. Integer to Roman
//     tc O(n) sc O(n)
//     We will take a treemap ands store number to roman number in it
//     Accordingly we will take the greatest number smaller thatn the current number 
//     and add its roman number equivalent in the string
//     subtract the closest number from the current number and keep on going until the number is finished.
public String intToRoman1(int num) {
    TreeMap<Integer, String> map = new TreeMap<>();
    String ans = "";
    
    map.put(1,"I");
    map.put(4,"IV");
    map.put(5,"V");
    map.put(9,"IX");
    map.put(10,"X");
    map.put(40,"XL");
    map.put(50,"L");
    map.put(90,"XC");
    map.put(100,"C");
    map.put(400,"CD");
    map.put(500,"D");
    map.put(900,"CM");
    map.put(1000,"M");
    
    while(num>0){
        Integer closestKey = map.floorKey(num);
        ans += map.get(closestKey);
        num = num - closestKey;
    }
    return ans;
}
public String intToRoman(int num) {
    String[] rarr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] iarr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    int n = iarr.length;
    StringBuilder ans = new StringBuilder();
    
    for(int i=0;i<n;i++){
        while(iarr[i]<=num){
            num = num - iarr[i];
            ans.append(rarr[i]);
        }
    }
    return ans.toString();
}   

}