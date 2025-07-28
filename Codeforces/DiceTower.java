import java.util.Scanner;

public class DiceTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long x = sc.nextLong();
            if(x < 15){
                System.out.println("NO");
                continue;
            }
            // for one dice, sum of all sides = 21, with one side hidden = 15 to 20 
            // for n dices, two sides shall be hidden so max number that will be hidden = 6 + 1 = 7, 21-7 = 14
            // for n+1 dices = 14 + 14 +...n + (15 to 20) = 14n + k 
            // which can be 14(n+1) + (1 to 6) = x
            // so we shall check the remainder and quotient for x/14. remainder shall be 1 to 6 and quo. shall be >= 1
            long rem = x%14;
            if(rem>=1 && rem<=6 && x/14>=1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
