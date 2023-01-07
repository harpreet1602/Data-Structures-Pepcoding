package Love Babbar DSA 450.Heap;

public class minStraights {
    // 846. Hand of Straights
// tc O(nlogn + n*GroupSize*log n) => I think sc O(n)
//     846. Hand of Straights
//     TreeMap is used for the feature of getting the smallest value 
//     then checking that are we getting the group size cards starting from the lowest value in each go
//     and if not then return false.
public boolean isNStraightHand1(int[] hand, int groupSize) {
    TreeMap<Integer,Integer> cardCounts = new TreeMap<>();
    int n = hand.length;
    for(int i=0;i<n;i++){
        cardCounts.put(hand[i],cardCounts.getOrDefault(hand[i],0)+1);
    }
    
    while(cardCounts.size()!=0){
        Integer firstK = cardCounts.firstKey();
        
        for(int card = firstK;card<firstK+groupSize;card++){
            if(!cardCounts.containsKey(card)) return false;
            int freq = cardCounts.get(card);
            if(freq == 1) cardCounts.remove(card);
            else{
                cardCounts.put(card,freq-1);
            }
        }             
    }
    
    return true;
}

//     tc O(nlogn +n*Groupsize*logn) => O(nlogn)
//     sc O(n)
//     Simple priorityqueue is used 
//     Add all the elements and then check for lowest ele and go on till groupsize after it
//     if any ele is not present return false,
public boolean isNStraightHand(int[] hand, int groupSize) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
//         min heap
    
    for(int ele:hand){
        pq.add(ele);
    }
    
    while(pq.size()!=0){
        int peek = pq.peek();
        
        for(int card=peek;card<peek+groupSize;card++){
            if(!pq.remove(card)){
                return false;
            }
        }
    }
    return true;
}
}
