import java.util.Arrays;
import java.util.Scanner;

public class SeqWithDig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long k = sc.nextLong();
            long min = -1;

            while(min!=0 && k-->1){
                String num = ""+a;
                int[]dig = Arrays.stream(num.split("")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(dig);
                min = (long)dig[0];
                long max = (long)dig[dig.length-1];
                a += min*max;
            }
            System.out.println(a);
        }
    }
}
