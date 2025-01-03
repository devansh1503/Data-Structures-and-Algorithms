import java.util.*;
import java.io.*;

public class AlternatingCurrent {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[]arr = br.readLine().toCharArray();
        Stack<Character>st = new Stack<>();
        for(char ch : arr){
            if(!st.isEmpty() && st.peek() == ch) st.pop();
            else st.push(ch);
        }
        System.out.println(st.isEmpty()?"Yes": "No");
    }
}
