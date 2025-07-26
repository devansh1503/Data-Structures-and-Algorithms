import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfRound {
    public static String res = "";
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int num = Integer.parseInt(br.readLine());
            processNum(num);
            res.trim();
            System.out.println(res.split(" ").length);
            System.out.println(res);
            res = "";
        }
    }
    public static void processNum(int num){
        int size = 0;
        while(num!=0){
            int dig = num%10;
            int round = dig * (int)Math.pow(10, size);
            if(round!=0){
                res += round+" ";
            }
            num /= 10;
            size++;
        }
    }
}
