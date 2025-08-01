package Codeforces.Bit;

import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k>n){
            System.out.println("NO");
            return;
        }
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int[]arr = new int[k];
        int idx = 0;
        int i=0;
        for(i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                if(idx>=k){
                    System.out.println("NO");
                    return;
                }
                arr[idx++] = 1<<i;
            }
        }
        if(idx < k){
            int last = 0;
            for(i=0; i<idx; i++){
                if(arr[i] == 1) continue;
                last = i;
                break;
            }
            while(idx<k && last<k){
                arr[idx] = arr[last]/2;
                arr[last] = arr[idx];
                idx++;
                while(last<k && arr[last] == 1){
                    last++;
                }
            }
        }
        System.out.println("YES");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
