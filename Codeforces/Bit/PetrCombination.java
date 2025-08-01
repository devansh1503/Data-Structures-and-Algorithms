package Codeforces.Bit;

import java.util.Scanner;

public class PetrCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<(int)Math.pow(2, n)-1; i++){
            int sum = 0;
            String binary = Integer.toBinaryString(i);
            int bin = binary.length();
            for(int k=0; k<n-bin; k++){
                binary = "0"+binary;
            }
            for(int j=0; j<n; j++){
                char ch = binary.charAt(j);
                if(ch == '0'){
                    sum -= arr[j];
                }
                else{
                    sum += arr[j];
                }
            }
            if(sum == 0 || Math.abs(sum) == 360 || Math.abs(sum)%360==0){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
