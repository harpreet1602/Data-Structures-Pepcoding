
public class peopleAware {
    
//     2327. Number of People Aware of a Secret
//     tc O(n) sc O(n)
//     DP cell meaning => How many new people got to know the secret till the ith day.
//     1D DP will be applied here where formula  will be used according to the noOfPeopleReadyForSharing + the people after the delay who are ready to share - noOfPeople who have forgotton will give us the current noOfPeple who can share the secret.
//     Array of size n+1 is made where 1 is for first person that knows the secret and then n is for nth day that how many new people got to know about the secret on nth day.
//     Then sum will be taken from 1+delay day to the nth day because 1 is just for the initial condition that will not get counted in the people who got to know about the secret from someone else.
public int peopleAwareOfSecret(int n, int delay, int forget) {
    long[] dp = new long[n+1];
    dp[1] = 1;
    long noPeopleShare=0,d,f,mod=(long)1e9+7;
    long sum = 0;
    for(int i=2;i<=n;i++){
        d = (i-delay>=0)?dp[i-delay]:0;
        f = (i-forget>=0)?dp[i-forget]:0;
        dp[i] = (noPeopleShare + d -f + mod)%mod;
        noPeopleShare = dp[i];
    }
    
    for(int i=n-forget+1;i<=n;i++){
        sum = (sum + dp[i])%mod;
    }
    return (int)sum;
}
}
