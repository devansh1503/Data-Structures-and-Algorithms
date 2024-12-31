import java.util.*;
import java.io.*;

public class ClassyIntegers{ 
    static int k = 3;
    static int max_dig = 20;
    static int[][][]dp = new int[max_dig][max_dig][2];
    static ArrayList<Integer>digits;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            long[]lr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long l = lr[0];
            long r = lr[1];

            int res = solution(r) - solution(l-1);
            result.append(res).append("\n");
        }
        System.out.println(result);
    }

    public static int solution(long range){
        digits = new ArrayList<>();
        while(range!=0){
            digits.add((int)(range%10));
            range /= 10;
        }
        Collections.reverse(digits);
        for(int i=0; i<max_dig; i++){
            for(int j=0; j<max_dig; j++){
                for(int k=0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return digitDP(0,0,0);
    }

    public static int digitDP(int idx, int cnt, int tight){
        if(idx >= digits.size()){
            if(cnt <= k) return 1;
            return 0;
        }
        if(dp[idx][cnt][tight]!=-1) return dp[idx][cnt][tight];
        int n = (tight == 0) ? digits.get(idx) : 9;
        int res = 0;
        for(int i=0; i<=n; i++){
            int newcnt = cnt;
            int newtight = tight;
            // If the new digit is non zero we are counting it
            if(i!=0) newcnt++;
            // if the new digit is less than the original one in that place, we can put any digit 0-9 in the next positions because
            // anyhow in this condition our number will be seen as smaller
            if(i<digits.get(idx)) newtight=1;
            res += digitDP(idx+1, newcnt, newtight);
        }
        return dp[idx][cnt][tight] = res;
    }
}