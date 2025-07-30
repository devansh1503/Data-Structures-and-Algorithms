package Codeforces.PrimeFactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class GoodSeq {
    public static HashSet<Integer>[]primeFactors;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 1;
        int[]dp = new int[arr[n-1]+1];
        seive(arr[n-1]);
        for(int i=0; i<n; i++){
            int num = arr[i];
            int currMax = 0;
            for(int p : primeFactors[num]){
                currMax = Math.max(currMax, dp[p]);
            }
            currMax++;
            max = Math.max(max, currMax);
            for(int p : primeFactors[num]){
                dp[p] = Math.max(dp[p], currMax);
            }
        }
        System.out.println(max);
    }

    public static void seive(int n){
        primeFactors = new HashSet[n+1];
        for(int i=0; i<=n; i++){
            primeFactors[i] = new HashSet<>();
        }
        boolean[]prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for(int i=2; i<=n; i++){
            if(prime[i]){
                primeFactors[i].add(i);
                for(int j=2*i; j<=n; j=i+j){
                    prime[j] = false;
                    primeFactors[j].add(i);
                }
            }
        }
    }
}
