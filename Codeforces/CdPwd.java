import java.util.*;
import java.io.*;

public class CdPwd {
    static Stack<String>st;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        st = new Stack<>();
        while(n-->0){
            String command = br.readLine();
            if(command.equals("pwd")){
                runPwd();
            }
            else{
                String path = command.split(" ")[1];
                populateStack(path);
            }
        }
    }
    public static void runPwd(){
        String str = "";
        Stack<String>dummy = new Stack<>();
        while(!st.isEmpty()){
            String file = st.pop();
            str = "/"+file + str;
            dummy.push(file);
        }
        while(!dummy.isEmpty()){
            st.push(dummy.pop());
        }
        str += '/';
        System.out.println(str);
    }
    public static void populateStack(String path){
        if(path.charAt(0) == '/') st.clear();
        String[]files = path.split("/");
        for(String file : files){
            if(file.equals("")) continue;
            if(file.equals("..")){
                st.pop();
                continue;
            }
            st.push(file);
        }
    }
}
