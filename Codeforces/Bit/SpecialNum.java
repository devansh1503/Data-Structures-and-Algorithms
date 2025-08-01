package Codeforces.Bit;

import java.util.Scanner;

public class SpecialNum {
    public static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long pow = 1;
            long sum = 0;
            char[]binaryArray = Integer.toBinaryString(k).toCharArray();
            for(int i=binaryArray.length-1; i>=0; i--){
                char ch = binaryArray[i];
                sum += (pow * (ch-'0'))%MOD;
                pow = ((long)n*pow)%MOD;
            }
            System.out.println(sum%MOD);
        }
        sc.close();
    }
}
