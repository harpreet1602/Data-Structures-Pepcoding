public class stapSequence{
    
    // 936. Stamping The Sequence
//     tc O(n^2) sc O(n) I think
//     We will move from "target string" to "asterick string" so this is reverse fashion
//     We will check that where can stamping be done where atleast one nonStar character should be there and rest can be '*' or other characters to do the stamp
//     Once we get the index then put a stamp from there on
//     Keep following the process you will get the answer.
public int[] movesToStamp(String stamp, String target) {
    List<Integer> reverseIndexList = new ArrayList<>();
    int len = target.length();
    char[] charTarget = target.toCharArray();
    char[] targetStr = new char[len];
    Arrays.fill(targetStr,'*');
    
    while(!Arrays.equals(charTarget,targetStr)){
        int index = fetchIndex(charTarget,stamp);
        if(index == -1){
            return new int[0];
        }
        updateIndex(charTarget,index,stamp);
        reverseIndexList.add(index);
    }
    int[] ans = new int[reverseIndexList.size()];
    for(int i=0;i<ans.length;i++){
        ans[i] = reverseIndexList.get(reverseIndexList.size()-1-i);
    }
    return ans;
}

private int fetchIndex(char[] arr,String stamp){
    for(int i=0;i<=arr.length-stamp.length();i++){
        int j = 0;
        int s = i;
        boolean nonStr = false;
        while((j<stamp.length() && s<arr.length)&&(arr[s]=='*'||arr[s] == stamp.charAt(j))){
            if(arr[s]!='*'){
                nonStr = true;
            }         //*************,ab => this should not be stamped because it will give wrong answer as other stamps will get affected.
            j++;
            s++;
        }
        if(j == stamp.length() && nonStr){
            return i;
        }
    }
    return -1;
}

private void updateIndex(char[] arr,int idx,String stamp){
    for(int j=0;j<stamp.length();j++){
        arr[j+idx] = '*';
    }
}
}