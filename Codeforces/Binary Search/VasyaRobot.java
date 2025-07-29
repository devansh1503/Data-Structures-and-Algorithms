import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VasyaRobot {
    public static long[][]cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        String path = br.readLine();
        String[]dest = br.readLine().split(" ");
        long x = Long.parseLong(dest[0]);
        long y = Long.parseLong(dest[1]);

        cnt = new long[(int)n][4];
        String pattern = "UDLR";
        for(int i=0; i<path.length(); i++){
            if(i>0){
                for(int j=0; j<4; j++){
                    cnt[i][j] = cnt[i-1][j];
                }
            }
            cnt[i][pattern.indexOf(path.charAt(i))]++;
        }

        long left = 0, right = n, res = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(check(mid, (int)n, x, y)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    public static boolean check(long segment, int n, long x, long y){
        if(segment == 0){
            long x1 = cnt[n-1][3] - cnt[n-1][2];
            long y1 = cnt[n-1][0] - cnt[n-1][1];
            return (x1==x && y1==y);
        }
        for(int i=0; i+segment<=n; i++){
            long[]total = cnt[n-1];
            long[]left = i>0 ? cnt[i-1] : new long[4];
            long[]right = cnt[i+(int)segment-1];

            long curU = total[0] - (right[0] - left[0]);
            long curD = total[1] - (right[1] - left[1]);
            long curL = total[2] - (right[2] - left[2]);
            long curR = total[3] - (right[3] - left[3]);

            long dx = curR - curL;
            long dy = curU - curD;

            long remX = Math.abs(x - dx);
            long remY = Math.abs(y - dy);

            long need = remX + remY;

            if(need <= segment && need%2 == segment%2){
                return true;
            }
        }
        return false;
    }
}
