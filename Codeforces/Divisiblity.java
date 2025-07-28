import java.util.Scanner;

public class Divisiblity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a%b == 0){
                System.out.println(0);
                continue;
            }
            int q = a/b;
            System.out.println((b*(q+1))-a);
        }
        sc.close();
    }
}
