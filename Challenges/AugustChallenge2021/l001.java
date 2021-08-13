import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class l001{
    // 1. Two Sum
//     So in this brute force will be fixing one and checking with other TC O(n^2) SC O(1)
// Optimised solution will be to use a hashmap where we will be storing the addresses of the numbers
//     and then if target - current number already exists in the hashmap that means we got the pair 
public int[] twoSum(int[] nums, int target) {
    int[] ans= new int[2];
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i<nums.length;i++)
    {
        if(map.containsKey(target-nums[i]))
        {
            ans[1] = i;
            ans[0] = map.get(target-nums[i]);
            return ans;
        }
        map.put(nums[i],i);
    }
    return ans;
}



// Sort the given array then use the concept of previous if the current ele = prev then 
// call will not be made for the duplicate element
// Rest of the question is then finding the subsets using this combination method
public int subsetsDup(int[] nums,int idx,List<Integer> smallAns, List<List<Integer>> ans)
    {
        List<Integer> base = new ArrayList<>(smallAns);
        ans.add(base);
        int count=0,prev=-11;
        for(int i =idx;i<nums.length;i++)
        {
            if(prev!=nums[i])
            {
            smallAns.add(nums[i]);    
            count+=subsetsDup(nums,i+1,smallAns,ans);
            smallAns.remove(smallAns.size()-1);
            }
            prev=nums[i];
        }
        
        
        return count;
        
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsDup(nums,0,smallAns,ans);
        return ans;
    }

    // Path Sum II
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
        //    Path Sum II 
        // TC O(nlogn) SC O(logn) recursive space
        // Just apply the same technique of recursion to reach the target
        // traverse the tree and add the current val till leaf then check if
        //  it matches the target then add otherwise 
        // don't add.
        // then the recursive calls for both side
        // remove the current val at the end 
    public void path(TreeNode root,int targetSum,List<Integer> smallAns,List<List<Integer>> ans)
    {
        if(root==null)
            return;
        
        smallAns.add(root.val);
        if(root.left==null & root.right==null)
        {
            if(targetSum == root.val)
            {
            List<Integer> base = new ArrayList<>(smallAns);
                ans.add(base);
            }
        }
          path(root.left,targetSum-root.val,smallAns,ans);
        path(root.right,targetSum-root.val,smallAns,ans);
       
       
        smallAns.remove(smallAns.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        path(root,targetSum,smallAns,ans);
        return ans;
    }

    // 1331. Rank Transform of an Array
// Copy arr into sortedArray and sort it.
// Iterate sortedArray and record the rank for each element in hashmap map.
// Iterate arr again, and assign map[arr[i]] to arr[i].
// return the final result arr.
// Easy Java explanation Code | HashMap time: O(nlogn), space: O(n)
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = new int[arr.length];
        for(int i=0;i<arr.length;i++)
            sortedArray[i] = arr[i];
        
        Arrays.sort(sortedArray);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ele:sortedArray)
        {
            map.putIfAbsent(ele,map.size()+1);
        }
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = map.get(arr[i]);
        }
        return arr;
        
    }

    
// leetcode 926. Flip String to Monotone Increasing
// TC:O(n) SC:O(1)
// Maintain a zero to one count when 0 is seen and one count when 1 is seen 
// but at each stage we will check if there is minmum no of flips for one ton convert to zero
// at that stage zero to one count will be updated as one count and after the loop
// the answer will be contained in the zero to one count irrespective of whether zero is converted to one
// or one is converted to zero or at some cases both things have happened this function will handle 
// all such cases because of the answer so far has been tracked in zero to one count
    
public int minFlipsMonoIncr(String s) {
    int oneCount=0,zeroToOne=0;
    for(int i=0;i<s.length();i++)
    {
        char ch = s.charAt(i);
        if(ch == '0'){
            zeroToOne++;        
        }
        else{
            oneCount++;
        }
        if(zeroToOne>oneCount){
            zeroToOne = oneCount;
        }
    }
    return zeroToOne;
}

// 58. Length of Last Word
// Tc: O(n) SC : O(1)
// Start traversing from the end and skip of atlast encountered with empty spaces
// Then when you got the first character from the end that is not the space then start counting till you find
// the empty space again or the word length has finished and return the count.
public int lengthOfLastWord(String s) {
    int n = s.length();
    int idx=n-1;
    while(idx>=0 && s.charAt(idx)==' ')
    {
        idx--;
    }
    int count=0;
    while(idx>=0 && s.charAt(idx)!=' ')
    {
        count++;
        idx--;
    }
    return count;
}

// 1281. Subtract the Product and Sum of Digits of an Integer
// Extract every digit from the number and make the sum and product at the same time and decrease the number
// every time to get the last digit everytime to overall get all the digits of which sum and product 
// has been calculated and then return product - sum
public int subtractProductAndSum(int n) {
    int temp=n,product=1,sum=0;
    while(temp!=0){
        int digit = temp % 10;
        temp = temp/10;
        product = product * digit;
        sum = sum + digit;
    }
    return product - sum;
}


// 665. Non-decreasing Array
// we will be ensuring that on the place I am standing all the digits previous me should be smaller or 
// equal to me, also the check if nums[i-2] < = nums[i] then assign the nums[i-1] = nums[i] because that will
// be safe option and then if nums[i-2] > nums[i] then nums[i] = nums[i-1] that will be the safe option
// Everytime manipulation is done then count is increased , if count<=1  then return true otherwise false
public boolean checkPossibility(int[] nums) {
    int count = 0;
    for(int i = 1 ; i< nums.length; i++){
        if(nums[i-1]>nums[i]){
            count++;
            if(i-2<0 || nums[i-2]<=nums[i]) nums[i-1] = nums[i];
            else{
                nums[i] = nums[i-1];
            }
        }
    }
    return count<=1;
}



// 954. Array of Doubled Pairs
// Two points to catch here is first of all sort the array by the absolute value because we will only be able
// to find the target of 2 * current element as element/2 gives problem (15/2 = 7 but 7*2 != 15) 
// to store the elements and do its pairing we need to start stroing the element's frequency in HashMap.
// Then put all the frequency of the elements in the HashMap.
// After that for doing the sorting by absolute value we need to make an array og big Integer.
// In sorting whosever is small between two elements will be placed first.
// Start traversing the sorted array and if the frequency of current element is 0 then continue the iteration
// Decrease the freq of the current ele by 1 and then find the target ele that is 2*ele if it's not present or  // frequncy is zero return false if not decrease the target element's freq by 1 and if the whole array is
// traversed successfully the return true at the end. 
public boolean canReorderDoubled(int[] arr) {
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    for(int ele:arr) {
         freqMap.put(ele, freqMap.getOrDefault(ele,0) + 1);
    }
    Integer[] ar = new Integer[arr.length];
    
    for(int i=0;i<arr.length;i++){
        ar[i] = arr[i];
    }
    Arrays.sort(ar, (a,b)->{
        return Math.abs(a) - Math.abs(b);
    });
    
    for(Integer ele:ar){
        if(freqMap.get(ele) == 0){
            continue;
        }
        freqMap.put(ele,freqMap.get(ele) - 1);
        if(freqMap.getOrDefault(2*ele,0) == 0){
            return false;
        }
        
        freqMap.put(2*ele,freqMap.get(2*ele) - 1);
        
        
        
    }
    return true;
    
}

    // 49. Group Anagrams
    // time: O(str.length*strs.length) space : O(str.length*strs.length) 
    // Here we need to know this thing that the HashMap value can be anything but HashMap key can aonly be that
    // which have equals and HashCode function. So we have created a HashMap of HashMap of character,Integer and 
    // the value will be List<String> why to store the frequency map of characters of every string
    // Now after that we will create a frequency map everytime while traversing each string of the strings array
    // in it we will be checking if in the big hashmap small hashmap frequncy map is not present we need to make 
    // new list add the string and put the small hashmap into big hashmap or if it is already present then 
    // just get that list and add the string. 
    // After that traverse on the values of the big hashmap where you will get list<string> and add it into 
    // list<list<string>> and return the answer after adding all the strings. 
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>, List<String>> bmap = new HashMap<>();
        for(String str:strs){
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int  i =0 ;i <str.length(); i++){
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0) + 1);
            }    
            if(bmap.containsKey(fmap) == false){
                List<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(fmap,list);
            }
            else{
                List<String> list = bmap.get(fmap);
                list.add(str);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for(List<String> list:bmap.values()){
            res.add(list);
        }
        return res;
    }


}