package Codeforces.Bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayElimination {
    public static int[]setBit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            setBit = new int[31];
            int n = Integer.parseInt(br.readLine());
            int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int num : arr){
                for(int i=0; i<30; i++){
                    if((num&(1<<i)) != 0){
                        setBit[i]++;
                    }
                }
            }
            for(int i=1; i<=n; i++){
                boolean flag = true;
                for(int j=0; j<30; j++){
                    if(setBit[j]%i != 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
