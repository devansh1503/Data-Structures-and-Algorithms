import java.util.Scanner;

public class BalancedRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sum = 0;
        
        // First pass: compute initial b[i] and rounding error
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i] / 2;  // Integer division (rounds toward zero)
            sum += b[i];
        }
        
        // Second pass: distribute the rounding error
        for (int i = 0; i < n && sum != 0; i++) {
            if (a[i] % 2 != 0) {
                if (sum > 0 && a[i] < 0) {
                    b[i]--;
                    sum--;
                } else if (sum < 0 && a[i] > 0) {
                    b[i]++;
                    sum++;
                }
            }
        }
        
        // Output the results
        for (int num : b) {
            System.out.println(num);
        }

        sc.close();
    }
}
