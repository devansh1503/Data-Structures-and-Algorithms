import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapsLock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        boolean allUpperExceptFirst = true;
        boolean allUpper = true;
        
        // Check conditions
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (Character.isUpperCase(c)) {
                    allUpperExceptFirst = false;
                }
            } else {
                if (!Character.isUpperCase(c)) {
                    allUpper = false;
                    allUpperExceptFirst = false;
                }
            }
        }
        
        // Transform if needed
        if (allUpper || allUpperExceptFirst) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(Character.toUpperCase(c));
                }
            }
            System.out.println(result.toString());
        } else {
            System.out.println(s);
        }
    }
}