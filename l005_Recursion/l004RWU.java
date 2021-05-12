import java.util.*;
//Recursion Way up
public class l004RWU {
    public static Scanner scn=new Scanner(System.in);
    public static void subsequence(String ques,String ans)
    {
        if(ques.length()==0)
        {
            System.out.println(ans);
            return;
        }
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        subsequence(roq,ans);
        subsequence(roq,ans+ch);
    }
    public static int subsequence(String ques,String ans,ArrayList<String> res)
    {
        if(ques.length()==0)
        {
            res.add(ans);
            return 1;
        }
        int count=0;
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        count+=subsequence(roq,ans,res);
        count+=subsequence(roq,ans+ch,res);
        return count;
    }
    //portal question of subsequences
    public static void printSS(String str, String ans) {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        String roq=str.substring(1);
        printSS(roq,ans+ch);
        printSS(roq,ans);
    }
    //nokia keypad question
    public static String[] codes={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str, String asf) {
        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }
        char ch=str.charAt(0);
        int no=ch-'0';
        String value=codes[no];
        for(int i=0;i<value.length();i++)
        {
            printKPC(str.substring(1),asf+value.charAt(i));
        }
    }
    //stair path
    public static void printStairPaths(int n, String path) {
        if(n==0)
        {
            System.out.println(path);
            return;
        }
        for(int jump=1;jump<=3 && n-jump>=0;jump++)
        printStairPaths(n-jump,path+jump);
    }
    //board path
    public static int printBoardPaths(int n,String ans)
    {
        if(n==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int dice=1;dice<=6 && n-dice>=0;dice++)
        {
            count+=printBoardPaths(n-dice,ans+dice);
        }
        return count;
    }
    public static int printBoardPath1(int a,int n,String ans)
    {
        if(a==n)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int dice=1;dice<=6 && dice+a<=n;dice++)
        {
            count+=printBoardPath1(a+dice, n, ans+dice);
        }
        return count;
    }
    public static int printBoardPathWithArray(int n,int[] arr,String ans)
    {
        if(n==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int jump:arr)
        {
            if(n-jump>=0)
            {
                count+=printBoardPathWithArray(n-jump, arr, ans+jump);
            }
        }
        return count;
    }
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr==dr-1 && sc==dc-1)
        {
            System.out.println(psf);
            return;
        }
        if(sc+1<dc)
        {
            printMazePaths(sr,sc+1,dr,dc,psf+'h');
        }
        if(sr+1<dr)
        {
            printMazePaths(sr+1,sc,dr,dc,psf+'v');
        }
    }
      // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static int printMazePathsMulipleJumps(int sr, int sc, int dr, int dc, String psf) {
        if(sr==dr-1 && sc==dc-1)
        {
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int jump=1;sc+jump<dc;jump++)
        {
            count+=printMazePathsMulipleJumps(sr,sc+jump,dr,dc,psf+'h'+jump);
        }
        for(int jump=1;sr+jump<dr;jump++)
        {
            count+=printMazePathsMulipleJumps(sr+jump,sc,dr,dc,psf+'v'+jump);
        }
        for(int jump=1;sr+jump<dr && sc+jump<dc;jump++)
        {
            count+=printMazePathsMulipleJumps(sr+jump,sc+jump,dr,dc,psf+'d'+jump);
        }
        return count;
    }
    //printPermutations
    //my code
    public static void printPermutations(String str,String ans) {
        if(str.length()==0)
        {
            System.out.println(ans);
        }
        for(int i=0;i<str.length();i++)
        {
            String roq="";
            for(int j=0;j<str.length();j++)
            {
                if(j!=i)
                {
                roq+=str.charAt(j);
                }
            }
            printPermutations(roq,ans+str.charAt(i));
        }
        }
        //Sir code 
    public static void printPermutationsSir(String str,String ans) {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutations(ros,ans+str.charAt(i));
        }
    }
    //printPermutationsWithoutDuplicate
    public static int printPermutationsWithoutDuplicate(String str,String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        char prev='$';
        for(int i=0;i<str.length();i++)
        {
            if(prev!=str.charAt(i))
            {
            String ros=str.substring(0,i)+str.substring(i+1);
            count+=printPermutationsWithoutDuplicate(ros,ans+str.charAt(i));
            }
            prev=str.charAt(i);
        }
        return count;
    }
    public static void printPermutationsWithoutDuplicate(String str)
    {
        StringBuilder sb=new StringBuilder();
        int[] freq=new int[26];
        for(int i=0;i<str.length();i++)
        {
            freq[str.charAt(i)-'a']++;
        }
        for(int i=0;i<freq.length;i++)
        {
            for(int j=0;j<freq[i];j++)
            {
              sb.append((char)(i+'a'));  
            }
        }
        System.out.println(printPermutationsWithoutDuplicate(sb.toString(),""));
    }
    //print encodings
    public static int decodeWays(String str,String ans)
    {
        int n=str.length();
        if(n==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        char ch=str.charAt(0);
       
        if(ch=='0')
        return 0;
        
        count+=decodeWays(str.substring(1),ans+ (char) ('a'+ch-'1') );
       
        if(n>1)
        {
        int second=(ch-'0')*10+(str.charAt(1)-'0');
        if(second<=26)
        {
            count+=decodeWays(str.substring(2),ans+ (char) ('a'+second-1) );
        }
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        ArrayList<String> res=new ArrayList<>();
        // System.out.println(subsequence("abc","",res));
        // System.out.println(res);
        // System.out.println(printBoardPath1(0,2, ""));
        // int[] arr={3,5,6};
        // System.out.println(printBoardPathWithArray(10, arr, ""));
        // System.out.println(printMazePathsMulipleJumps(0, 0, 3, 3, ""));
        System.out.println(decodeWays("143", ""));
    }
}
