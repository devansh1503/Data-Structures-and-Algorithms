import java.util.*;
import java.io.*;

public class MilitaryProblem {
    static HashMap<Integer, List<Integer>>tree;
    static HashMap<Integer, List<Integer>>traversal;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int[]nq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int n = nq[0];
        int q = nq[1];
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tree = new HashMap<>();
        traversal = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            tree.putIfAbsent(arr[i], new ArrayList<>());
            tree.putIfAbsent(i+2, new ArrayList<>());
            tree.get(arr[i]).add(i+2);
        }
        while(q-->0){
            String[]uk = br.readLine().split(" ");
            int node = Integer.parseInt(uk[0]);
            int k = Integer.parseInt(uk[1]);
            if(!traversal.containsKey(node)){
                traversal.putIfAbsent(node, new ArrayList<>());
                dfs(node, node);
            }
            int res = traversal.get(node).size()>=k ? traversal.get(node).get(k-1) : -1;
            result.append(res).append("\n");
            
        }
        System.out.println(result);

    }
    public static void dfs(int node, int parent){
        traversal.get(parent).add(node);
        for(int child : tree.get(node)){
            dfs(child, parent);
        }
    }
}
