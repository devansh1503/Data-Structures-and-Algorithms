import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnstableArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[]inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            if(n == 1){
                System.out.println(0);
                continue;
            }
            if(n == 2){
                System.out.println(m);
                continue;
            }
            if(n>2){
                System.out.println(2*m);
                continue;
            }
        }
    }
}
