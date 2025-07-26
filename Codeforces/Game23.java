import java.io.BufferedReader;
import java.util.Scanner;

public class Game23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(m%n!=0){
            System.out.println(-1);
        }
        else{
            int q = m/n;
            int moves = 0;
            while(q!=1){
                if(q%3 == 0){
                    q /= 3;
                    moves++;
                }
                else if(q%2 == 0){
                    q /= 2;
                    moves++;
                }
                else{
                    moves = -1;
                    break;
                }

            }
            System.out.println(moves);
        }
    }
}
