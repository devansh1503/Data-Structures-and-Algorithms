package Codeforces.Bit;

import java.util.Scanner;

public class BerlandCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nURDL
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int U = sc.nextInt();
            int R = sc.nextInt();
            int D = sc.nextInt();
            int L = sc.nextInt();
            boolean flag = false;

            for(int i=0; i<16; i++){
                int rU = U, rR = R, rD = D, rL = L;
                if((i&1) != 0){
                    rU--;
                    rL--;
                }
                if((i&2) != 0){
                    rL--;
                    rD--;
                }
                if((i&4) != 0){
                    rR--;
                    rD--;
                }
                if((i&8) != 0){
                    rR--;
                    rU--;
                }
                if(Math.min(rU, Math.min(rD, Math.min(rL, rR)))>=0 && Math.max(rU, Math.max(rD, Math.max(rL, rR)))<=n-2){
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            System.out.println("NO");
        }
    }
    public static int countSetBits(int n){
        int c = 0;
        while(n>0){
            c += n&1;
            n >>= 1;
        }
        return c;
    }
}
