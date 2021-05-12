import java.util.*;
public class l003RAL {
    public static Scanner scn=new Scanner(System.in);
    public static ArrayList<String> subsequence(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        ArrayList<String> recAns=subsequence(str.substring(1));
        // ArrayList<String> myAns=new ArrayList<>();
        // for(String s:recAns)
        // {
        //     myAns.add(s);
        //     myAns.add(ch+s);
        // }
        //2nd method
        ArrayList<String> myAns=new ArrayList<>(recAns);  //constructor in java
        //that adds the full recAns values into myAns arraylist
        for(String s:recAns)
        {
            myAns.add(ch+s);
        }    
        return myAns;
    }

    public static String[] keywords={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
     if(str.length()==0)
     {
         ArrayList<String> base=new ArrayList<>();
         base.add("");
         return base;
     }
     char ch=str.charAt(0);
     String code=keywords[ch-'0'];
     ArrayList<String> recAns=getKPC(str.substring(1));
     ArrayList<String> myAns=new ArrayList<>();
     for(int i=0;i<code.length();i++)
     {
         for(String s:recAns)
         {
             myAns.add(code.charAt(i)+s);
         }
     }
     return myAns;
    }
    public static ArrayList<String> decodeWays(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char first=str.charAt(0);
        if(first=='0')
        {
            return new ArrayList<>();
        }
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=decodeWays(str.substring(1));
        for(String s:recAns)
        {
            myAns.add((char)('a'+first-'1')+s);
        }
        if(str.length()>=2)
        {
         char second=str.charAt(1);
         int twodigit=(((first-'0')*10)+(second-'0'));
         if(twodigit<=26)
         {
            ArrayList<String> recAns2=decodeWays(str.substring(2));   
            for(String s:recAns2)
            {
                myAns.add((char)('a'+twodigit-1)+s);
            } 
         }
        }
        return myAns;
    }
    public static String[] keywords1={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz","+-*","<>/%"};
    public static ArrayList<String> decodeways2(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch1=str.charAt(0);
        String code=keywords1[ch1-'0'];
        ArrayList<String> recAns=decodeways2(str.substring(1));
        ArrayList<String> myAns=new ArrayList<>();
        for(int i=0;i<code.length();i++)
        {
            for(String s:recAns)
            {
                myAns.add(code.charAt(i)+s);
            }
        }
        if(str.length()>1)
        {
            char ch2=str.charAt(1);
            int num=(ch1-'0')*10+(ch2-'0');
            if(num==10||num==11)
            {
            ArrayList<String> recAns2=decodeways2(str.substring(2));
            code=keywords1[num];
            for(int i=0;i<code.length();i++)
            {
            for(String s:recAns2)
            {
                myAns.add(code.charAt(i)+s);
            }
            }
        }
        }
        return myAns;        
    }
    public static ArrayList<String> getStairPaths(int n) {
        if(n==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        for(int i=1;i<=3 && n-i>=0;i++)
        {
            ArrayList<String> recAns=getStairPaths(n-i);
            for(String s:recAns)
            {
                myAns.add(i+s);
            }
        }
        return myAns;
    }
    public static ArrayList<String> boardPathOnArray(int n,int[]move) {
        if(n==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        for(int dice=1;dice<=move.length && n-move[dice]>=0;dice++)
        {
            ArrayList<String> recAns=getStairPaths(n-move[dice]);
            for(String s:recAns)
            {
                myAns.add(move[dice]+s);
            }
        }
        return myAns;
    }
        // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr&&sc==dc)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        if(sc+1<=dc)
        {
            ArrayList<String> horizontal=getMazePaths(sr,sc+1,dr,dc);
            for(String s:horizontal)
            {
            myAns.add("h"+s);
            }
        }
        if(sr+1<=dr)
        {
            ArrayList<String> vertical=getMazePaths(sr+1,sc,dr,dc);
            for(String s:vertical)
            {
                myAns.add("v"+s);   
            }
        }
        return myAns;
        }
        //Variation in question can also travel diagonally one step
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePathsDiagonal(int sr, int sc, int dr, int dc) {
        if(sr==dr&&sc==dc)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        if(sc+1<=dc)
        {
            ArrayList<String> horizontal=getMazePathsDiagonal(sr,sc+1,dr,dc);
            for(String s:horizontal)
            {
            myAns.add("h"+s);
            }
        }
        if(sr+1<=dr && sc+1<=dc)
        {
            ArrayList<String> diagonal=getMazePathsDiagonal(sr+1,sc+1,dr,dc);
            for(String s:diagonal)
            {
            myAns.add("d"+s);
            }
        }
        if(sr+1<=dr)
        {
            ArrayList<String> vertical=getMazePathsDiagonal(sr+1,sc,dr,dc);
            for(String s:vertical)
            {
                myAns.add("v"+s);   
            }
        }
        return myAns;
        }
        public static ArrayList<String> getMazePathsJumps(int sr, int sc, int dr, int dc) {
            if(sr==dr && sc==dc)
            {
                ArrayList<String> base=new ArrayList<>();
                base.add("");
                return base;
            }
            ArrayList<String> myAns=new ArrayList<>();
            for(int jump=1;sc+jump<=dc;jump++)
            {
                ArrayList<String> horizontal=getMazePathsJumps(sr,sc+jump,dr,dc);
                for(String s:horizontal)
                {
                    myAns.add("h"+jump+s);
                }
            }
            for(int jump=1;sr+jump<=dr;jump++)
            {
                ArrayList<String> vertical=getMazePathsJumps(sr+jump,sc,dr,dc);
                for(String s:vertical)
                {
                    myAns.add("v"+jump+s);
                }
            }
            for(int jump=1;sr+jump<=dr && sc+jump<=dc;jump++)
            {
                ArrayList<String> diagonal=getMazePathsJumps(sr+jump,sc+jump,dr,dc);
                for(String s:diagonal)
                {
                    myAns.add("d"+jump+s);
                }
            }
            return myAns;
            }
        
    public static void main(String[] args)
    {
        // System.out.println(decodeways2("110"));
        System.out.println(getMazePathsJumps(0, 0, scn.nextInt()-1, scn.nextInt()-1));
    }
}
