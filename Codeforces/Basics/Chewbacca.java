import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chewbacca {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            int digit = ch - '0';
            int inverted = 9 - digit;

            // First digit cannot be zero
            if (i == 0 && inverted == 0) {
                result.append(digit);
            } else {
                result.append(Math.min(digit, inverted));
            }
        }

        System.out.println(result);
    }
}
