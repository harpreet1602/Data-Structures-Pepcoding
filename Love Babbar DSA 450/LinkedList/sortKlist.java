public class sortKlist{
    
    // 23. Merge k Sorted Lists
// tc O(nlogn) sc O(logn) recursive space I think
//     Merging the k sorted list so we can't take pointers on more than 2 lists to sort them 
//     so main merging logic will be there on two lists 
//     THat is why recursively we will try to bring two lists by doing divide and conquer
//     Our lists will get sorted, it is just like merge sort in arrays.
//     Binary search kind of thing can be applied on indexes of the array 
//     and we will keep on asking for the answer till we get si == ei from where we can return a single list and then two single lists can be merged together after that while coming back sorted list will merge with other sorted lists recursively. 
public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    if(n == 0){
        return null;
    }
    return mergeKLists(lists,0,n-1);
}
private ListNode mergeKLists(ListNode[] lists,int si,int ei){
    if(si == ei){
        return lists[si];
    }
    
    int mid = si + ((ei-si)/2);
    ListNode leftList = mergeKLists(lists,si,mid);
    ListNode rightList = mergeKLists(lists,mid+1,ei);
    
    return mergeTwoSortedLists(leftList,rightList);
}
private ListNode mergeTwoSortedLists(ListNode left,ListNode right){
    ListNode c1 = left, c2 = right, c, head;
    head = new ListNode(-1);
    c = head;
    while(c1!=null && c2!=null){
        if(c1.val<=c2.val){
            c.next = c1;
            c1 = c1.next;
        }
        else{
            c.next = c2;
            c2 = c2.next;
        }
        c = c.next;
    }
    if(c1!=null){
        c.next = c1;
    }
    else{
        c.next = c2;
    }
    return head.next;
}
}