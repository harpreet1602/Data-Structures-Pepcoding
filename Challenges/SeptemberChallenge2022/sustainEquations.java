public class sustainEquations {
    
    // 990. Satisfiability of Equality Equations
//     tc O(n) sc O(1)
//     Union find method will be used here.
//     Idea is to connect all the characters to a parent which are there in equal equations
//     Check if the parent of the two characters are same in unequal equations then return false
//     otherwise after the end of the iteration, return true.
public boolean equationsPossible(String[] equations) {
    int[] parent = new int[26];
    for(int i=0;i<26;i++){
        parent[i] = i;
    }
    
    for(String eq:equations){
        if(eq.charAt(1)=='='){
            int var1 = getParent(eq.charAt(0)-'a',parent);
            int var2 = getParent(eq.charAt(3)-'a',parent);
            if(var1!=var2){
                parent[var2] = var1;
            }
        }
    }
    
    for(String eq:equations){
        if(eq.charAt(1)=='!'){
            int var1 = getParent(eq.charAt(0)-'a',parent);
            int var2 = getParent(eq.charAt(3)-'a',parent);
            if(var1==var2){
                return false;
            }
        }
    }
    return true;
}
private int getParent(int index,int[] parent){
    if(parent[index] == index){
        return index;
    }
    return getParent(parent[index],parent);
}
}
