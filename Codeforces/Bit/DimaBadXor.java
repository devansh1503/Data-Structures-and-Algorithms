package Codeforces.Bit;

import java.util.HashSet;
import java.util.Scanner;

public class DimaBadXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]arr = new int[n][m];
        int xor = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
            xor ^= arr[i][0];
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((xor^arr[i][0]^arr[i][j]) > 0){
                    System.out.println("TAK");
                    for(int k=0; k<n; k++){
                        if(k == i){
                            System.out.print(j+1+" ");
                        }
                        else System.out.print(1+" ");
                    }
                    return;
                }
            }
        }
        System.out.println("NIE");
        
    }
}
