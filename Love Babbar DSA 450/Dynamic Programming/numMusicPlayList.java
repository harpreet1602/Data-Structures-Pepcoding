public class numMusicPlayList {
    class Solution {
        //     920. Number of Music Playlists
        //     tc O(n*goal) sc O(n*goal)
        //     Recursion + Mathematics
        //     We have to think in terms of location that what are the possible options available at the current location
        //     We have two options either we can use the new song or used song at the current location
        //     That too with the condition that old song can be used again if k songs have been used.
        //     So two choices:-
        //     1. for new song 
        //          it is n - usedSongs i.e. total songs - used songs till now
        //     2. for old song 
        //          it is maximum of 0 or usedSongs -k i.e. used songs till now -k because we need atleast the gap of k for each song to be repeated again.
        //     location placement thing is done we will call for the answers through recursion, so all the will be multiplied
        //     But the two choices answer will be added that either we have used the new song + or we have used the old song already played.
        //     Memoise the recursion, it becomes DP because of repeated subproblems.
            private int mod = (int)1e9+7;
            public int numMusicPlaylists(int n, int goal, int k) {
                long[][] dp = new long[101][101];
                for(long[] arr:dp){
                    Arrays.fill(arr,-1);
                }
                return (int)permutePlaylist(0,0,dp,n,goal,k);
            }
            private long permutePlaylist(int usedSongs,int currLoc,long[][] dp,int n, int goal, int k){
                if(currLoc == goal){
                    return usedSongs == n?1:0;
                }
                if(dp[usedSongs][currLoc]!=-1){
                    return dp[usedSongs][currLoc];
                }
                
                long oldSong = (Math.max(0,usedSongs-k) * permutePlaylist(usedSongs,currLoc+1,dp,n,goal,k))%mod;
                
                long newSong = ((n-usedSongs) * permutePlaylist(usedSongs+1,currLoc+1,dp,n,goal,k))%mod;
                
                long total = (oldSong+newSong)%mod;
                
                return dp[usedSongs][currLoc] = total;
            }
        }
}
