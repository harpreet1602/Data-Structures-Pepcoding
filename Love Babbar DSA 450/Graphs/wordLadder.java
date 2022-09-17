import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class wordLadder {
    
//     127. Word Ladder
// tc O(n*10*26)=> O(n) sc O(n) I think
//     So what can be done in this word ladder question
//     Here we have to go from start word to end word 
//     So we will try each and every possibility in each word by placing a to z character in each position of every word
// And we will go level by level to each word so BFS will be used here.
//    To see if it is in the set if it is then remove it from the set as it is visited with the minimum steps and we don't want to visit it in future with more no. of steps
//     Why are we using set here? So that search and removal time gets decreased.
//     Whenever I will see the endword coming i will return the level+1 from there that this is the minimum level through which I can reach endword
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>();
    LinkedList<String> que = new LinkedList<>();
    int level=0;
    for(String str:wordList){
        set.add(str);
    }
    if(!set.contains(endWord)){
        return 0;
    }
    que.addLast(beginWord);
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            String rword = que.removeFirst();
            if(rword.equals(endWord)){
                return level+1;
            }
            char[] rwordArr = rword.toCharArray();
            for(int i=0;i<rwordArr.length;i++){
                char ch = rwordArr[i];
                for(int j=0;j<26;j++){
                    rwordArr[i] = (char)(j+'a');
                    String checkWord = new String(rwordArr);
                  
                    if(set.contains(checkWord)){
                        set.remove(checkWord);
                        que.addLast(checkWord);
                    }
                }
                rwordArr[i] = ch;
            }
        }
        level++;
    }
    return 0;
}
}
