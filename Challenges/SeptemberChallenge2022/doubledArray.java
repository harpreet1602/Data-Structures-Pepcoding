public class doubledArray {
    
    // 2007. Find Original Array From Doubled Array
//     tc O(n) sc O(n)
//     make the freuency table
//     then decrease the frequency of i th number and 2*i th number 
//     then check if 2* i freq<0 then return empty array
//     otherwise keep on adding the i in the answer
//     in the end look at the frequency map
//     see if any freq is not 0 then return empty array
public int[] findOriginalArray(int[] changed) {
    int[] freq = new int[100001];
    int n =changed.length,idx=0;
    int[] ans = new int[n/2];
    
    if(n%2!=0){
        return new int[]{};
    }
    for(int i=0;i<n;i++){
        freq[changed[i]]++;
    }
    
    for(int i=0;i<=freq.length/2;i++){
        while(freq[i]>0  && freq[2*i]>0){    
            freq[i]--;
            freq[2*i]--;                
        
            
        if(freq[2*i]<0){
            return new int[]{};
        }
        ans[idx++] = i;
        }
    }
    for(int i=0;i<freq.length;i++){
        if(freq[i]!=0){
            return new int[]{};
        }
    }
    return ans;
}
}
