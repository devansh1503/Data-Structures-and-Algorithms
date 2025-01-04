import java.util.*;
import java.io.*;

public class NapoleanCake{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[]res = new int[n];
            int creamReached = 0;
            for(int i=n-1; i>=0; i++){
                creamReached = Math.max(creamReached-1, arr[i]);
                if(creamReached > 0){
                    res[i] = 1;
                }
            }
            for(int i : res){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
