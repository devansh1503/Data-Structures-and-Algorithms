import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class NonCoPrime {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n<=2){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        System.out.println(1+" "+n);
        System.out.print(n-1+" ");
        for(long i=n-1; i>=1; i--){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
