import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

import java.util.ArrayList;
public class l002_HMBsics {
    public static void HashMapBasic() {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",98);
        map.put("USA",99);
        map.put("UK",98);
        map.put("UK",95);

        // map.remove("UK");

        if(map.containsKey("Uk"))
        {
            System.out.println(map.get("Uk"));
        }

        System.out.println(map);
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        System.out.println(keys);

        for(String key : map.keySet())
        {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public static void countFrequency(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int count=0;
            if(map.containsKey(ch))
            {
                count = map.get(ch);
            }
            map.put(ch,count+1);
        }
        System.out.println(map);
    }

    public static void Frequency(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char key:map.keySet())
        {
            System.out.println(key + " -> " + map.get(key));
        }
    }



   


    public static void indexOfChar(String str)
    {
        HashMap<Character,ArrayList<Integer>> map =new HashMap<>();
        for(int i = 0 ; i < str.length(); i++)
        {   
            char ch = str.charAt(i);
            if(map.containsKey(ch))
            {
                map.get(ch).add(i);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();        
                arr.add(i);
                map.put(ch,arr);
            }
        }
        System.out.println(map);


    }

    public static void indexOfChar2Method(String str)
    {
        HashMap<Character,ArrayList<Integer>> map =new HashMap<>();
        // for(int i = 0 ; i < str.length(); i++)
        // {   
        //     char ch = str.charAt(i);
        //     if(!map.containsKey(ch))
        //     map.put(ch,new ArrayList<>());
        //     map.get(ch).add(i);
        // }

        for(int i = 0 ; i < str.length(); i++)
        {   
            char ch = str.charAt(i);
            //daldo new arraylist agar ye character ki key nhi ho to
            map.putIfAbsent(ch,new ArrayList<>());
            map.get(ch).add(i);
        }

        for(char ch:map.keySet())
        {
            System.out.println(ch + " -> "+map.get(ch));
        }


    }

//portal questions 


    public static char countFrequencyMax(String str)
    {
        int max=-(int)1e9;
        char maxkey='a';
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0 ;i<str.length(); i++)
        {
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);  //ek tareeka hai jise vo if else ki jagah isse kaam hojaega
            //isme default hai to 0 + 1 ohterwise jo get karke mila vo + 1 put kardo ch ki key pai
        }
        for(char key:map.keySet())
        {
            if(map.get(key)>max)
            {
                max=map.get(key);
                maxkey=key;
            }
        }
        return maxkey;
    }

    public static Scanner scn = new Scanner(System.in); 

public static void printCommonNoDuplicate(int[] a1,int[] a2)
{
    HashMap<Integer,Integer> map = new HashMap<>();
    
    for(int i = 0 ; i<a1.length; i++)
    {
        map.put(a1[i],map.getOrDefault(a1[i],0)+1);
    }
    for(int i=0;i<a2.length;i++)
    {
        if(map.containsKey(a2[i]))
        {
                System.out.println(a2[i]);
            map.remove(a2[i]);
        }
    }
}


public static void printCommonDuplicate(int[] a1,int[] a2)
{
    HashMap<Integer,Integer> map = new HashMap<>();
    
    for(int ele:a1)
    {
        map.put(ele,map.getOrDefault(ele,0)+1);
    }
    for(int ele:a2)
    {
        if(map.containsKey(ele))
        {
            System.out.println(ele);
            map.put(ele,map.get(ele)-1);
            if(map.get(ele)==0)    
            map.remove(ele);
        }
    }
}
public static int[] input()
{
    int n =scn.nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++)
    {
        a[i] = scn.nextInt();
    }
    return a;
}



public static void longestConsSequence(int[] a){
    HashSet<Integer> set = new HashSet<>();   //only keys are stored in hashset
    
    for(int ele:a)
    set.add(ele);
    int len = 0,head=0;
    for(int ele:a)
    {
        if(!set.contains(ele))
        continue;
        int left=ele-1,right=ele+1;
        
        set.remove(ele);
        
        while(set.contains(left))
        set.remove(left--);
        
        while(set.contains(right))
        set.remove(right++);
        
        
        if((right - left - 1)>=len)
        {
         if((right - left - 1)==len)
        {   
            if((left+1)<head)
            {
            len = right-left-1;
            head=left+1;                            
            }
        }
        else
        {
            len = right-left-1;
            head=left+1;                            
            
        }

            
            // System.out.println(len);
        }
        
    }
    // System.out.println("...........");
    for(int i=0;i<len;i++)
    {
        System.out.println(head+i);
    }
}

    public static void main(String[] args)
    {
        // HashMapBasic();
        // countFrequency("abcdeeeddfsf");
        // indexOfChar("aaabbcc");


         
    // int[] a1=input();
    // int[] a2=input();
        // printCommonNoDuplicate(a1,a2);



    }
}
