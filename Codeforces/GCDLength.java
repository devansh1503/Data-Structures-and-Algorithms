import java.util.Scanner;

public class GCDLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long gcd = (long)Math.pow(10, c-1);
            // x = gcd * k, x = 10^c-1 * k,  10^a-1 = 10^c-1 * k,  k = 10^a-c,  x= gcd * 10^a-c (same for y, just add gcd in last so that x and y have same gcd)
            long x = gcd * (long)Math.pow(10, a-c);
            long y = gcd * (long)Math.pow(10, b-c) + gcd;

            System.out.println(x+" "+y);
        }
    }
}
