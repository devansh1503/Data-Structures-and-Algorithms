import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PoisonedDagger {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[]nh = br.readLine().split(" ");
            long n = Long.parseLong(nh[0]);
            long h = Long.parseLong(nh[1]);

            long[]a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long left = 0, right = h;
            while(left <= right){
                long mid = left + (right - left) / 2;
                if(isValid(mid, a, h)){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
    public static boolean isValid(long k, long[]a, long h){
        long hits = 0L;
        long start = a[0];
        long currEnd = a[0];
        for(long time : a){
            if(time > currEnd){
                hits += currEnd - start;
                start = time;
            }
            currEnd = Math.max(currEnd, time+k);
        }
        hits += currEnd - start;
        return hits>=h;
    }
}
