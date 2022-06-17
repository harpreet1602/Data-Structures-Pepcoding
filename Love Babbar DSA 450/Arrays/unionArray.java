public class unionArray {
    
    // Union of two arrays 
    // https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
    // tc O(n) sc O(n)
    // Maintain a set and add all the elements of a and then b 
    // return the set.size().
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(a[i]);
        }
        
        for(int i=0;i<m;i++){
            set.add(b[i]);
        }
        
        return set.size();
    }
}
