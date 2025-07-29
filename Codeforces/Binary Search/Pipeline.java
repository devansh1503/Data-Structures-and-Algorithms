import java.util.Scanner;

public class Pipeline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        if(n<=1){
            System.out.println(0);
            return;
        }

        long required = n - 1; // We start with 1 pipe.
        long left = 1, right = k - 1; // Splitters range from 2 to k.
        long answer = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sumLargest = mid * (2 * k - mid - 1) / 2; // Sum of largest mid splitters.
            long sumSmallest = mid * (mid + 1) / 2; // Sum of smallest mid splitters.

            if (sumLargest >= required && sumSmallest <= required) {
                answer = mid;
                right = mid - 1; // Try to find a smaller m.
            } else if (sumLargest < required) {
                left = mid + 1; // Need more splitters.
            } else {
                right = mid - 1; // Sum too large; reduce splitters.
            }
        }

        System.out.println(answer);
    }
}