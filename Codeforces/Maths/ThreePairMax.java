import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreePairMax {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        while(t-->0){
            long[]arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long x = arr[0];
            long y = arr[1];
            long z = arr[2];
            long max = Math.max(x, Math.max(y, z));
            long cnt = 0;
            if(x == max) cnt++;
            if(y == max) cnt++;
            if(z == max) cnt++;
            if(cnt<2){
                System.out.println("NO");
                continue;
            }
            long a = Math.min(x, y);
            long b = Math.min(x, z);
            long c = Math.min(y, z);

            if(Math.max(a,b) == x && Math.max(a, c) == y && Math.max(b, c) == z){
                System.out.println("YES");
                System.out.println(a+" "+b+" "+c);
            }
            else System.out.println("NO");
        }
    }
}
