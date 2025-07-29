import java.util.Scanner;

public class MikeChocolateThieves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long left = 8, right = (long)1e16;
        long res = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long s = 0;
            // i here is the k, so k can go upto k*k*k less than actual n
            for(long i=2; (i*i*i)<=mid; i++){
                // number of ways we can achieve upto n size with current i
                s += mid/(i*i*i);
            }
            if(s == m){
                res = mid;
                right = mid - 1;
            }
            else if(s > m){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(res);
    }
}
