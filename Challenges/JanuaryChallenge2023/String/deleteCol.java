public class deleteCol{
    
    // 944. Delete Columns to Make Sorted
// tc O(n*m) sc O(1)
//    Dry run to understand, this is a complex way no need of this 
public int minDeletionSize1(String[] strs) {
    int n = strs.length,m=strs[0].length();
    int prevMax=0, deleteCount=0;
    for(int i=0;i<m;i++){
        prevMax = -1;
        for(int j=0;j<n;j++){
        String str = strs[j];
            int curr = str.charAt(i)-'a';
            if(prevMax>curr){
                // System.out.println(str);
                deleteCount++;
                break;
            }
            prevMax = Math.max(curr,prevMax);
        }   
    }
    return deleteCount;
}

//     Instead just imagine the strings array length as rows and one string length as column
//     now in the column we need to traverse the rows so j first inside its loop i will come
//     accordingly we can check the condition strs[i-1][j]>strs[i][j] then increment the delete count of column and break from that column and move to next one.
public int minDeletionSize(String[] strs) {
    int n = strs.length,m =strs[0].length(),deleteCount=0;
    
        for(int j=0;j<m;j++)
        {
            for(int i=1;i<n;i++){
                if(strs[i-1].charAt(j)>strs[i].charAt(j)){
                    deleteCount++;
                    break;
                }
            }   
        }
        return deleteCount;    
}
}