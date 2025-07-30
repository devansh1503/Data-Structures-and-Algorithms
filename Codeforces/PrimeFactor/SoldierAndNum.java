package Codeforces.PrimeFactor;

import java.util.Scanner;

public class SoldierAndNum {
    public static int[]primeFactors = new int[5000001];
    public static void main(String[] args) {
        for(int i=2; i<=5000000; i++){
            if(primeFactors[i]==0){
                for(int j=1; j<=5000000/i; j++){
                    for(int k=i*j; k%i==0 ;k/=i)
                        primeFactors[i*j]++;
                }
            }
            primeFactors[i] += primeFactors[i-1]; //for factorial, eg. 6 = 6*5*4*3*2*1 hence - 2*3*5*2*2*3*2*1 ignore 1, it becomes 7 rounds
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(primeFactors[a] - primeFactors[b]);
        }
        sc.close();
    }
}
