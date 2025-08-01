package Codeforces.Bit;

import java.util.Scanner;

public class NewYearEve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long k = sc.nextLong();
        if(k == 1){
            System.out.println(num);
            return;
        }
        //make all the bits set.
        //eg. 10 = "1010"
        // we need to make it 1111 which will be the max XOR
        // 10000 - 1 which is 1<<4 - 1
        long b = Long.toBinaryString(num).length();
        long res = (long)(1L<<b) - 1; 
        System.out.println(res);
    }
}
