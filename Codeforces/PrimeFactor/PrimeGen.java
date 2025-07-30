package Codeforces.PrimeFactor;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeGen {
    public static boolean[]prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            seive(end);
            for(int i=start; i<=end; i++){
                if(prime[i]){
                    System.out.println(i);
                }
            }
            System.out.println(" ");
        }
        sc.close();
    }
    public static void seive(int n){
        prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for(int p=2; p*p<=n; p++){
            if(prime[p]){
                for(int i=p*p; i<=n; i=i+p){
                    prime[i] = false;
                }
            }
        }
    }
}
