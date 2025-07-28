import java.util.Scanner;

public class KdivisibleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            long k = sc.nextLong();

            
            long multiple = (long)Math.ceil((double)n/(double)k)*k;
            long distribute = (long)Math.ceil((double)multiple/(double)n);
            System.out.println(distribute);
        }
        sc.close();
    }
}
