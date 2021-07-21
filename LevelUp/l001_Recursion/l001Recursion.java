import java.util.ArrayList;
public class l001Recursion {
    public static void pppppp(int a) {
        System.out.println("I am Base case: " + a);
        return;
    }

    public static void ppppp(int a) {
        System.out.println("hi: " + a);
        pppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pppp(int a) {
        System.out.println("hi: " + a);
        ppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void ppp(int a) {
        System.out.println("hi: " + a);
        pppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pp(int a) {
        System.out.println("hi: " + a);
        ppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void p(int a) {
        System.out.println("hi: " + a);
        pp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    public static void printIncreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        System.out.println(a);
        printIncreasing(a + 1, b);

    }

    public static void printDecreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void oddEven(int a, int b) {
        if(a>b)
        {
            return;
        }

        if(a%2!=0)
        System.out.println(a);
        oddEven(a + 1, b);
        
        if(a%2==0)
        System.out.println(a);
    }

    public static int factorial(int n) {
        if(n==0)
        {
        return 1;
        }
        int recAns = factorial(n-1); 
        return n*recAns;
    }

    public static int power(int a, int b) {
        if(b==0)
        {
            return 1;
        }

        int recAns = power(a,b-1);
        return recAns*a;
    }

    // O(logn)
    public static int powerBtr(int a, int b) {
        if(b==0)
        return 1;

        int recAns = powerBtr(a,b/2);
        recAns*=recAns;

        return b%2==0?recAns:recAns*a;
    }

    public static void printArray(int[] arr,int index) {
        if(index == arr.length)
        return;

        System.out.println(arr[index]);
        printArray(arr, index+1);
    }

    public static void printArrayReverse(int[] arr,int index) {
        if(index==arr.length)
        return;

        printArrayReverse(arr, index+1);
        System.out.println(arr[index]);
    }

    public static int maximum(int[] arr,int index) {
        if(index==arr.length)
        return -(int)1e9;

        int recAns = maximum(arr,index+1);
        return Math.max(recAns,arr[index]);
    }

    public static int minimum(int[] arr,int index) {
        if(index==arr.length)
        return (int)1e9;

        int recAns = maximum(arr,index+1);
        return Math.min(recAns,arr[index]);
    }

    public static boolean find(int[] arr, int data,int index) {
        if(index==arr.length)
        return false;

        if(arr[index] == data)
        return true;

        return find(arr, data, index+1);

    }

    public static int firstIndex(int[] arr, int data,int index) {
        if(index == arr.length)
        return -1;

        if(arr[index] == data)
        {
            return index;
        }
        return firstIndex(arr, data, index+1);
    }

    public static int lastIndex(int[] arr, int data,int index) {
        if(index == arr.length)
        return -1;

        int recAns = lastIndex(arr, data, index+1);
        if(recAns != -1)
        return recAns;

        if(arr[index] == data)
        {
            return index;
        }else{
            return -1;
        }
    }
    public static boolean firstAndLastIndex(int[] arr,int data,int index,int[] ans,boolean res1)
    {
        if(index == arr.length)
        {
            return false;
        }

        if(res1!=true && arr[index] == data)
        {
            ans[0] = index;
            res1=true;
        }


        boolean res = firstAndLastIndex(arr, data, index+1, ans,res1);

        if(res)
        {
            return true;
        }

        if(arr[index] == data)
        {
            ans[1] = index;
            return true;
        }

        return false;
    }
    public static int[] allIndex(int[] arr, int data, int idx, int count)
    {
        if(idx==arr.length)
        {
            return new int[count];
        }

        if(arr[idx]==data)
        {
           count++;
        }

        int[] ans=allIndex(arr, data, idx+1, count);

        if(arr[idx]==data)
        {
            ans[count-1]=idx;
        }
        return ans;

    }

    public static ArrayList<String> subsequence(String str, int idx)
    {
        if(idx==str.length())
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(idx);
       ArrayList<String> recAns =  subsequence(str, idx+1);
        ArrayList<String> myAns = new ArrayList<>();
        for(String s : recAns)
        {
            myAns.add(s);
            myAns.add(ch+s);
        }
        return myAns;
    }
    public static int subsequence(String str, int idx, String asf,ArrayList<String> ans)
    {
        if(idx==str.length())
        {
            ans.add(asf);
            return 1;
        }

        char ch = str.charAt(idx);
        int count = 0;
        count += subsequence(str, idx+1, asf, ans);
        count += subsequence(str, idx+1, asf + ch, ans);
        return count;
    }



    public static void main(String[] args) {
        // recursionPattern(1, 6);
        int[] arr = {1,2,3,4,5,1};
        int a=2,b=3,data=1,index=0,n=5,count=0;
    //     printIncreasing(a, b);
    //     System.out.println();
    //     printDecreasing(a, b);
    //     System.out.println();
    //     printIncreasingDecreasing(a, b);
    //     System.out.println();
    //     oddEven(a, b);
    //     System.out.println();
    //    System.out.println(power(a, b));
    //    System.out.println();
    //   System.out.println(factorial(n));
    //   System.out.println();
    //     printArray(arr, index);
    //     System.out.println();
    //     printArrayReverse(arr, index);
    //     System.out.println();
    //   System.out.println(find(arr, data, index));
    //   System.out.println();
    //   System.out.println(firstIndex(arr, data, index));
    //   System.out.println(); 
    //   System.out.println(lastIndex(arr, data, index));
    //   System.out.println(); 
    //   System.out.println(powerBtr(a, b));
    //   System.out.println();
    //   System.out.println(maximum(arr, index));
    //   System.out.println(); 
    //   System.out.println(minimum(arr, index));
    int[] ans = new int[2];
        System.out.println(firstAndLastIndex(arr,data,0,ans,false));
        for(int  i = 0;i<ans.length;i++)
        System.out.println(ans[i]);
    // int[] ans = allIndex(arr, data, index, count);
    // for(int i =0 ;i <ans.length ; i++)
    // System.out.println(ans[i]);
    
    
//  System.out.println(subsequence("abc", 0));
    // ArrayList<String> ans = new ArrayList<>();
    // subsequence("abc", 0, "", ans);
    // System.out.println(ans);
}
}