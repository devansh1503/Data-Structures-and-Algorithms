import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dungeon {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long sum = a+b+c;
            long min = Math.min(a, Math.min(b, c));
            if(sum%9 == 0 && min>=sum/9){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
