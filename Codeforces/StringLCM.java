import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLCM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String a  = br.readLine();
            String b = br.readLine();

            long lena = a.length();
            long lenb = b.length();

            boolean flag = false;
            for(int i=0; i<Math.min(lena, lenb); i++){
                if(a.charAt(i) != b.charAt(i)){
                    System.out.println(-1);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            long lcm = LCM(lena, lenb);
            String resa = "";
            for(int i=0; i<lcm/lena; i++){
                resa += a;
            }

            if(isValid(a, b, resa)){
                System.out.println(resa);
                continue;
            }
            String resb = "";
            for(int i=0; i<lcm/lenb; i++){
                resb += b;
            }
            if(isValid(a, b, resb)){
                System.out.println(resb);
                continue;
            }
            System.out.println(-1);
        }
    }

    public static boolean isValid(String a, String b, String res){
        for(int i=0; i<res.length(); i=i+a.length()){
            if(!res.substring(i, i+a.length()).equals(a)) return false;
        }

        for(int i=0; i<res.length(); i=i+b.length()){
            if(!res.substring(i, i+b.length()).equals(b)) return false;
        }
        return true;
    }

    public static long LCM(long a, long b){
        return Math.abs(a*b)/gcd(a, b);
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
