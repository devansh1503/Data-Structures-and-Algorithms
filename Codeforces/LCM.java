import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[]inp = br.readLine().split(" ");
            long l = Long.parseLong(inp[0]);
            long r = Long.parseLong(inp[1]);
            // The second multiple of l shall be in the range if it is valid
            long new_r = l*2;

            if(new_r>r){
                System.out.println(-1+" "+-1);
            }
            else System.out.println(l+" "+new_r);
        }
    }

    // These are not required
    public static long lcm(long a, long b){
        return Math.abs(a*b)/gcd(a, b);
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
