import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bitpp {
    public static int x = 0;
    public static void main(String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String operation = br.readLine();
            operate(operation);
        }
        System.out.println(x);
    }
    public static void operate(String operation){
        if(operation.charAt(0) == 'X'){
            operation = operation.substring(1);
        }
        else{
            operation = operation.substring(0, operation.length()-1);
        }
        if(operation.equals("++")){
            x++;
        }
        else if(operation.equals("--")){
            x--;
        }
    }
}
