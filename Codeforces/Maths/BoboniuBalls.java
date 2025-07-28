import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoboniuBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long[] balls = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long r = balls[0];
            long g = balls[1];
            long b = balls[2];
            long w = balls[3];
            boolean possible = false;

            // Check initial configuration
            if (canPalindrome(new long[]{r, g, b, w})) {
                possible = true;
            } else {
                long min = Math.min(r, Math.min(g, b));
                // Check k = min, min-1, min-2 (ensure k >= 0)
                for (int i = 0; i <= 2; i++) {
                    long k = min - i;
                    if (k < 0) continue;
                    long nr = r - k;
                    long ng = g - k;
                    long nb = b - k;
                    long nw = w + 3 * k;
                    if (canPalindrome(new long[]{nr, ng, nb, nw})) {
                        possible = true;
                        break;
                    }
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
    }

    public static boolean canPalindrome(long[] balls) {
        int cnt = 0;
        for (long num : balls) {
            if (num % 2 == 1) cnt++;
        }
        return cnt <= 1;
    }
}