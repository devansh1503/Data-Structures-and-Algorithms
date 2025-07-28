import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NearlyLucky {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int n = 0;
        for(char ch : num.toCharArray()){
            if(ch == '4' || ch == '7'){
                n++;
            }
        }
        if(n==4 || n==7){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
