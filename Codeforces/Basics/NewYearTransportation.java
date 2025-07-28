import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewYearTransportation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]inp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = inp1[1] - 1;
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idx = 0;
        while(idx<arr.length && idx<t){
            idx = idx + arr[idx];
        }
        if(idx == t){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
