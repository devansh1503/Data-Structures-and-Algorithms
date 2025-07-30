package Codeforces.PrimeFactor;

import java.util.Scanner;

public class Taxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isPrime(n)){
            System.out.println(1);
        }
        else if(n%2==0 || isPrime(n-2)){
            System.out.println(2);
        }
        else System.out.println(3);
        sc.close();
    }
    public static boolean isPrime(int n){
        for(int p=2; p*p<=n; p++){
            if(n%p==0) return false;
        }
        return true;
    }
}
