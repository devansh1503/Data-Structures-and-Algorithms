import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DiverseSubstr {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        for(int i=0; i<n-1; i++){
            if(str.charAt(i)!=str.charAt(i+1)){
                System.out.println("YES");
                System.out.println(str.substring(i, i+2));
                return;
            }
        }
        System.out.println("NO");
    }
}
