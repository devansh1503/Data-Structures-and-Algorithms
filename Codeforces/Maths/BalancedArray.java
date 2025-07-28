import java.util.Scanner;

public class BalancedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int half = n/2;
            if(half%2==1){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            long[] arr = new long[n];
            long sumEven = 0;
            for (int i = 0; i < half; i++) {
                arr[i] = 2 * (i + 1);
                sumEven += arr[i];
            }
            long sumOdd = 0;
            for (int i = 0; i < half - 1; i++) {
                arr[half + i] = 2 * i + 1;
                sumOdd += arr[half + i];
            }
            arr[n - 1] = sumEven - sumOdd;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
