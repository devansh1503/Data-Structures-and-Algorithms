import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCircle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[]arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        if(arr[n-1] < arr[n-2] + arr[n-3]){
            System.out.println("YES");
            System.out.print(arr[n-2]+" ");
            System.out.print(arr[n-1]+" ");
            System.out.print(arr[n-3]+" ");
            for(int i=n-4; i>=0; i--){
                System.out.println(arr[i]+" ");
            }
        }
        else{
            System.out.println("NO");
        }
    }
}
