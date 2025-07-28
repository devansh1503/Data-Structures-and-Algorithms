import java.util.Scanner;

public class RoadToZero {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t-->0){
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if(b >= 2*a){
                System.out.println((x+y)*a);
                continue;
            }

            long min = Math.min(x, y);
            long max = Math.max(x, y);
            System.out.println(b*min + a*(max-min));
        }
        sc.close();
    }
}
