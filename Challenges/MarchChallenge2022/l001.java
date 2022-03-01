


cdpublic class l001{
    
//     338. Counting Bits
//     tc O(n) sc O(n)
//     So observe the pattern by doing a dry run for 10 numbers that for even index the 
//     answer will be same as ind/2 as it is just the left shift operation of the ind/2
//     ans for odd ind the ans is same as ind-1 as after even ine more one comes in the pattern
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                ans[i] = ans[i/2];
            }
            else{
                ans[i] = ans[i-1] + 1;
            }
        }
        return ans;        
    }

}