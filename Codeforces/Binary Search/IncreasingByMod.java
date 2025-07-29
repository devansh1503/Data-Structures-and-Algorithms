import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IncreasingByMod {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]nm = br.readLine().split(" ");
        long n = Long.parseLong(nm[0]);
        long m = Long.parseLong(nm[1]);
        long[]arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long left = 0, right = m;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(check(arr, mid, m)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
    private static boolean check(long[] arr, long mid, long m) {
        long op = 0;
        long prev = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] >= prev){
                op = (int) (m - (arr[i] - prev));
                if(op > mid) prev = arr[i];
            }else{
                op = prev - arr[i];
                if(op > mid) return false;
            }
        }
        return true;
    }
}
