import java.util.Scanner;

public class DigitalRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            // S(n) = n%9
            // So kth number n shall be 9*(k-1) + S(n)
            long k = sc.nextLong();
            int x = sc.nextInt();

            long res = (9*(k-1))+(long)x;
            System.out.println(res);
        }
        sc.close();
    }
}
