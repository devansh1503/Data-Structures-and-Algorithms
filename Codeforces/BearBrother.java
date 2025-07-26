import java.io.IOException;
import java.util.Scanner;

public class BearBrother {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = 0;
        while(x<=y){
            x *= 3;
            y *= 2;
            n++;
        }
        System.out.println(n);
        sc.close();
    }
}
