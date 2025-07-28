import java.util.*;
import java.io.*;

public class TenderCarpenter{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean flag = false;
            for(int i=1; i<arr.length; i++){
                int min = Math.min(arr[i], arr[i-1]);
                int max = Math.max(arr[i], arr[i-1]);
                if(2*min > max){
                    result.append("Yes").append("\n");
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            result.append("No").append("\n");
        }
        System.out.println(result);
    }
}