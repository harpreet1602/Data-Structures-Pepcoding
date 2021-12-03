
public class l001{

    // 208. Implement Trie (Prefix Tree)
    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trie/implement-trie-official/ojquestion
    public static class Trie {

        /** Initialize your data structure here. */
        private class TrieNode{
          TrieNode[] children;
          boolean isWord;
    
          public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
          }
        }
        private TrieNode root;
    
        public Trie() {
          root = new TrieNode();
        }
    
        // space O(26*n) => O(n), time O(n)
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
    
            for(int i=0;i<word.length();i++){
              char ch = word.charAt(i);
              if(curr.children[ch-'a'] == null){
                //   At index again 26 size array will be taken
                  curr.children[ch-'a'] = new TrieNode();
              }
              curr=curr.children[ch-'a'];
            }
            curr.isWord = true;
            // word is completed so we need something to tell that
        }
    
        // It has more effective search than in BST
        // because of the elements stored in this fashion, it will be really faster

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
    
            for(int i=0;i<word.length();i++){
              char ch = word.charAt(i);
              if(curr.children[ch-'a'] == null){
                  return false;
              }
              curr=curr.children[ch-'a'];
            }
            return curr.isWord;
            // if the word is over then true otherwise false
        }
    
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
          TrieNode curr = root;
    
            for(int i=0;i<prefix.length();i++){
              char ch = prefix.charAt(i);
              if(curr.children[ch-'a'] == null){
                  return false;
              }
              curr=curr.children[ch-'a'];
            }
            return true;
            // for prefix only so of the loop is over then the answer will be true otherwise
            //  it is false then it will return false in between
        }
      }


    //   211. Design Add and Search Words Data Structure
      class WordDictionary {

        private class TrieNode{
            TrieNode[] children;
            boolean isWord;
            public TrieNode(){
                children = new TrieNode[26];
                isWord = false;
            }
        }
        private TrieNode root;
        public WordDictionary()
        {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isWord = true;
        }
        
        // this one is different as for '.' we need to find all the possibilities that whether it matches or not. 
        // For this purpose we need to use recursion here to get the answer and we will use or there that whenever it 
        //    gives true then there is no need to call ahead return true. 
        private boolean search(String word,int idx, TrieNode curr){
            if(idx == word.length()){
                return curr.isWord;
            }
            
            char ch = word.charAt(idx);
            boolean ans = false;
            if(ch=='.'){
                for(int i=0;i<26;i++){
                    if(curr.children[i]!=null)
                    ans = ans || search(word,idx+1,curr.children[i]);
                }    
            }else{
                    if(curr.children[ch-'a'] == null) return false;
                    ans = ans || search(word,idx+1,curr.children[ch-'a']);
            }
            return ans;        
        }
        public boolean search(String word) {
            TrieNode curr = root;
            return search(word,0,curr);
        }
    }

    // 421. Maximum XOR of Two Numbers in an Array
    
    class MaxXor {
    
        private class TrieNode{
            TrieNode[] children;
            public TrieNode(){
                children = new TrieNode[2];
            }
        }
        
        public int findMaximumXOR(int[] nums) {
            TrieNode root = new TrieNode();
    //         inserting
    // for every bit we will be inserting all the 32 bits in the increasing trie manner 

            for(int ele:nums){
    //             MSB matters to us more than the LSB because max answer comes from MSB side 
    //             so that is why traversing from 31st to 0th bit because in total there will be 32 bits
                TrieNode curr = root;
                for(int i=31;i>=0;i--){
                    int bit = ((ele>>i)&1);
                    if(curr.children[bit]==null){
                        curr.children[bit] = new TrieNode();
                    }
                    curr = curr.children[bit];        
                }        
            }
            
            int ans = 0;
    // After all the bits are inserted then we need to search the opposite bit in each number's bit position
    // If you find the opp. bit then also make your answer by adding 2^bit position because at that place there will
    // be 1 in the answer. Find the maximum answer out of all the numbers' xor result. 
    //         searching
        //         maximum
            for(int ele:nums){
    //             MSB matters to us more than the LSB because max answer comes from MSB side 
    //             so that is why traversing from 31st to 0th bit because in total there will be 32 bits
                TrieNode curr = root;
                int currans = 0;
                for(int i=31;i>=0;i--){
                    int bit = ((ele>>i)&1);
                    int searchBit = bit==1?0:1;
                    if(curr.children[searchBit]!=null){
                        curr = curr.children[searchBit];
                        currans += Math.pow(2,i);
                    }else{
                        curr = curr.children[bit];
                    }
                }
                ans = Math.max(ans,currans);
            }
            return ans;
        }
    }



}