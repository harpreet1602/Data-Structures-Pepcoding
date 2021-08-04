public class l001{
    // 0->1 , 1-> 1 / false -> true, true -> true
    public static void offToOn(int n, int k)
    {
        int mask = 1<<k;
        System.out.println(mask | n);
        
        System.out.println(n);
    }

    // 1->0 , 0-> 0 / true -> false, false-> false
    public static void onToOff(int n, int k)
    {
        int mask = 1<<k;
        n = ((~mask) & n);
        System.out.println(n);
    }
    // tc O(n)
    // n no of bits
    public static int countSetBits_02(int n)
    {
        int countOf1 = 0;
        for(int i = 0 ;i<32;i++)
        {
           if(((n<<i)&n)!=0)
           {
                countOf1++;
           }                                     // triple right shift mai 0 hi add hongr to galt nhi hoga ,
        }                         // 1 and 31 zeroes vala mai infinite loop lag jaega
        return countOf1;

    }
    // tc O(log n) worst mai O(n)
    public static int countSetBits(int n)
    {
        int countOf1 = 0;
        while(n>0)
        {
            countOf1 += (n&1);
            n = n>>>1;           // triple right shift mai 0 hi add hongr to galt nhi hoga ,
        }                         // 1 and 31 zeroes vala mai infinite loop lag jaega
        return countOf1;

    }
    public static int countSetBits_03(int n)
    {
        int countOf1 = 0;
        while(n>0)
        {
            n = (n&(n-1));                  //here each time last set bit will become unset         
            countOf1++;                     //so it runs no of 1s time.
        }
        return countOf1;
    }

    // 231. Power of Two
    
    // 4 => 100
    // 3 => 011
    // & => 000
    // so 4 is power of 2
    
    public boolean isPowerOfTwo(int n) {
        return (n>0 && (n&(n-1))==0)?true:false;
    }
    // 342. Power of Four

// if it is not a power of 2 return false  and if it is then see after is there even no of zeroes
// after 1 because there will be only one bit 1 in the number and in the end if count is odd
// return false and if count is even then a its LSB 1 will never come 
    public boolean isPowerOfFour(int n) {
        if(n<=0 || (n&(n-1))!=0)
           {
                return false;
           }
           int count=0;
          while(n!=1)
           {
               count++;
               n>>>=1;
           }
           return (count&1)==0;
           
           
           
    }

    // 136. Single Number
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int ele:nums)
        {
            ans^=ele;
        }
        return ans;
    }

    // 338. Counting Bits
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1 ;i <=n;i++)
        {
            ans[i] = ans[i&(i-1)] + 1;
        }
        return ans;
    }



    // 268. Missing Number
    // Here take the xor of all the elements with their indexes in the end length should also
    // be taken into the xor then we will get the missing element
    public int missingNumber(int[] nums) {
        int i=0,ans=0;
        for(int ele:nums)
        {
            ans^=ele^i;
            i++;
        }
        return ans^nums.length;
    }

    // for 3 => (3*(3+1)/2)=6
    // array of size 3 => [0,2,1] => 6-(2+1) = 3 final ans
    public int missingNumber1(int[] nums){
        int ans=0,n=nums.length;
        for(int ele:nums)
        {
            ans+=ele;
        }
        return ((n*(n+1))/2) - ans;
    }



    // 190. Reverse Bits
     // you need treat n as an unsigned value
    //  Here find the last bit by n&1 and then place it at 31-i position till thr time n reaches 0
    // make the ans 
     public int reverseBits(int n) {
        int revAns=0, power=31;
        while(n!=0)
        {
            revAns+=((n&1)<<power);
            n=n>>>1;
            power-=1;
        }
        return revAns;
    }
    // 260. Single Number III
    // xor of all the number will be containing the xor of two numbers whose occurence is 1
    // with that xor we will create a xor mask by setting only the last set bit in the number
    // on the basis of that bit xor with all the elements all the elements will be divided in 
    // in two groups where duplicates come in one group get cancelled we will get two unique answers

    public int[] singleNumber3(int[] nums) {
        int A=0,B=0,xor=0,xor_mask=0;
        for(int ele:nums)
        {
            xor^=ele;
        }
        xor_mask = (xor&(-xor));
        for(int ele:nums)
        {
            if((ele&xor_mask)==0)
                A^=ele;
            else
                B^=ele;
        }
        int[] ans=new int[2];
        ans[0]=A;
        ans[1]=B;
        return ans;
        // return new int[]{A,B};
    }

    // 137. Single Number II
    public int singleNumber2(int[] nums) {
        int k = 3;
        int ans=0;
        for(int i =0 ;i<32;i++)
        {
            int mask = 1<<i;
            int count=0;
            for(int ele:nums)
            {
                if((ele&mask)!=0)
                {
                    count++;
                }
            }
            ans |= (count%k)!=0?mask:0;
            
        }
        return ans;
    }

    // nqueen most optimized with bits
    // ???





    // suduku
    




    public static void main(String[] args)
    {
        int n= 6,k=3;
        offToOn(n, k);
        onToOff( n,  k);
        System.out.println(countSetBits_02(n));
    }
}