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




    public static void main(String[] args)
    {
        int n= 6,k=3;
        offToOn(n, k);
        onToOff( n,  k);
        System.out.println(countSetBits_02(n));
    }
}