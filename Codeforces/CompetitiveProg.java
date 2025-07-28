import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CompetitiveProg {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String num = br.readLine();
            // Number shall end with 0
            // Sum of digits shall be divisble by 3
            // Last two digits shall be - even0 even and a 0 hence divible by 4
            int[]digits = new int[10];
            int sum = 0;
            boolean hasZero = false;
            boolean hasSecondZeroorEven = false;
            for(char ch : num.toCharArray()){
                digits[ch-'0']++;
                sum += ch-'0';

                if(ch-'0' == 0){
                    if(hasZero){
                        hasSecondZeroorEven = true;
                    }
                    hasZero = true;
                }
                else if((ch-'0') % 2 == 0){
                    hasSecondZeroorEven = true;
                }
            }
            if(!hasZero || sum%3!=0){
                System.out.println("cyan");
                continue;
            }
            if(digits[0]>=2){
                System.out.println("red");
                continue;
            }
            if(hasSecondZeroorEven){
                System.out.println("red");
                continue;
            }
            System.out.println("cyan");
        }
    }
}
