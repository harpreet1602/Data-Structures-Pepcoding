import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class l001{
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    // 206. Reverse Linked List
public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null)
        return head;
    ListNode prev=null,curr=head,forw=head.next;
    while(forw!=null){
        curr.next=prev;
        prev=curr;
        curr=forw;
        forw=forw.next;
    }
    curr.next=prev;
    return curr;
}

public static Scanner scn = new Scanner(System.in);

// https://www.codechef.com/SEPT21C/problems/PALINT
// First make a frequency map of integers present
// Then start traversing over the map and check if its xor value is present in map 
// if it is present then freq of first integer and frequency of xor value of integer will be added
// and checked with max ans so far 
// it it is not present then we will go for that key's freq if it is higher or not.
public static void solveXorEqual(){
        
    int t = scn.nextInt();
    while(t-->0){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=scn.nextInt();
        int x = scn.nextInt();
        for(int i = 0 ;i<n;i++){
            int val = scn.nextInt();
            map.put(val,map.getOrDefault(val,0)+1);
        }
     
        int max=0,ans=0, changes=0;
        if(x==0){
            for(int key:map.keySet()){
                max=Math.max(max,map.get(key));
            }
            System.out.println(max+" "+changes);
            
        }
        else{
        for(int key:map.keySet()){
            int k = key^x;
            if(map.containsKey(k))
            {
                if(map.get(key) + map.get(k) > ans){
                    ans = map.get(key) + map.get(k);
                    changes = map.get(key);
                }
                else if(map.get(key) + map.get(k) == ans){
                    changes = Math.min(map.get(key),changes);
                }
               
            }
            if(map.get(key) == ans)
                {
                    changes=0;
                }
            if(map.get(key)>ans){
                    ans = map.get(key);
                    changes=0;
                }
        }
        System.out.println(ans+" " + changes);
    }
    }
}


// 848. Shifting Letters
// traverse from backward and you will get the value for that character to be shifted how many
// times at current position
public String shiftingLetters(String s, int[] shifts) {
    char[] str = s.toCharArray();  
    int index = 0;
    for(int i =s.length()-1 ;i>=0;i--){
           index = (index + shifts[i])%26;
           str[i] = (char)(((str[i]-'a' + index)%26)+'a');
       }
    return new String(str);
}

// 350. Intersection of Two Arrays II
    //     brute force tc O(m*n) sc O(1)
        public int[] intersect1(int[] nums1, int[] nums2) {
            int m=nums1.length, n=nums2.length, ind=0;
            ArrayList<Integer> ans = new ArrayList<>();
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(nums1[i] == nums2[j]){
                        ans.add(nums1[i]);
                        nums2[j]=-1;
                        nums1[i]=-2;
                    }
                }
            }
            int[] arr = new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                arr[i] = ans.get(i);
            }
            return arr;
        }
    //     time: O(m+n) sc:O(m)
        public int[] intersect2(int[] nums1, int[] nums2) {
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();
        
            for(int ele:nums1){
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
            for(int ele:nums2){
                if(map.get(ele)!=null && map.get(ele)>0)
                {
                    ans.add(ele);
                    map.put(ele,map.get(ele)-1);
                }
            }
            
            
            
            
            
            int[] arr = new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                arr[i] = ans.get(i);
            }
            return arr;
            
        }
    //     tc O(nlogn)
        public int[] intersect(int[] nums1, int[] nums2) {
            int i=0,j=0,m=nums1.length,n=nums2.length;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            ArrayList<Integer> ans = new ArrayList<>();
        
            while(i<m && j<n){
                int a = nums1[i];
                int b = nums2[j];
                if(a==b){
                    ans.add(a);
                    i++;
                    j++;
                }
                else if(a<b){
                     i++;
                }
                else{
                    j++;
                }
            }     
            int[] arr = new int[ans.size()];
            for(i=0;i<ans.size();i++){
                arr[i] = ans.get(i);
            }
            return arr;
        }




}