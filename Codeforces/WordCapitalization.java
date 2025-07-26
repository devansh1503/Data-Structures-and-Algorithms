import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCapitalization {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String first = s.substring(0,1);
        String remaining = s.substring(1, s.length());
        System.out.println(first.toUpperCase()+remaining);
    }
}
