import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicPowder {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[]nk = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = nk[0], k=nk[1];
        long[]req = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[]available = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long left = 0, right = 10000000000001L;
        while(left<=right){
            long mid = left + (right - left) / 2;
            long reqGm = 0;
            for(int i=0; i<req.length; i++){
                long newReq = mid*req[i] - available[i];
                if(newReq>0){
                    reqGm += newReq;
                }
            }
            if(reqGm <= k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }
}
