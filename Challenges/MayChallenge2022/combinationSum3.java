class Solution {
    //     216. Combination Sum III
    //     TC o() SC o()
    //     Backtracking => Because we need to find all possible combinations of k digits
    //     whose sum is n, digit should not be repeated, no permutations are allowed
        /**
     * Backtracking
     *
     * Time complexity = InternalNodes in the RecursionTree   +   K * LeafNodes in RecursionTree
     *                 = (C(9,0) + C(9,1) + ... + C(9,K-1))   +   K * C(9,K)
     * In our solution, the worst case will happen when k = 8. Then Total Time Complexity = O(574) which is O(1)
     *
     * Space Complexity = O(k) -> Depth of Recursion tree + Size of TempList
     *
     * K = Input size of each combination.
     */
        
        private int combinationSum3(List<List<Integer>> ans, List<Integer> smallAns,int noOfEle,int totalSum,int ele){
    //         BASE CASE
    //         If the number of elements are used then check is the sum is also equal
    //         to required sum then add the smallAns into ans, otherwise not
            if(noOfEle == 0){
                if(totalSum == 0){
                    List<Integer> base = new ArrayList<>(smallAns);
                    ans.add(base);
                    return 1;
                }
                return 0;
            }
    //         If the noOfEle are left but the sum has gone less than the required sum // then there is no chance of having the answer so return from there
     
            if(totalSum<0){
                return 0;
            }
    //         Loop over the possibilities startin from curr ele to 9 to add into the smallAns
    //         So first add into smallAns, then invoke for the next element.
    //         then delete the last element for backtracking and finding other smallAns.
            int count = 0;
            for(int i=ele;i<=9;i++){
                smallAns.add(i);
                count+=combinationSum3(ans,smallAns,noOfEle-1,totalSum-i,i+1);
                smallAns.remove(smallAns.size()-1);
            }
    //         Count of such combinations can also be maintained.
            return count;
        }
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> smallAns = new ArrayList<>();
            combinationSum3(ans,smallAns,k,n,1);
            return ans;
        }
    }