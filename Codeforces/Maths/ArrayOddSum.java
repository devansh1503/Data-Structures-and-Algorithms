import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayOddSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // even + even = even
            // odd + odd = even
            // even + odd = odd
            // even + odd + odd = even
            // number of odd numbers shall also be an odd number for this to be possible
            int numOdds = 0;
            for(int num : arr){
                if(num%2==1) numOdds++;
            }
            int numEvens = n - numOdds;
            if(numOdds!=0 && (numOdds%2 == 1 || (numOdds%2==0 && numEvens>=1))) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
