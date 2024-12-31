import java.util.*;
import java.io.*;

public class CircumferenceTree{
    public static HashMap<Integer, ArrayList<Integer>>hm;
    public static int[]dist;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1 || n==0){
            System.out.println(0);
            return;
        }
        int nodes = n;
        dist = new int[n+1];
        hm = new HashMap<>();
        while(n-- > 1){
            int[]ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = ab[0];
            int b = ab[1];
            hm.putIfAbsent(a, new ArrayList<>());
            hm.putIfAbsent(b, new ArrayList<>());
            hm.get(a).add(b);
            hm.get(b).add(a);
        }
        bfs(1);
        int farthestNode = maxDist()[1];
        bfs(farthestNode);
        System.out.println(3*maxDist()[0]);
    }

    public static int[] maxDist(){
        int max = dist[0];
        int max_idx = 0;
        for(int i=1; i<dist.length; i++){
            if(dist[i] > max){
                max = dist[i];
                max_idx = i;
            }
        }
        return new int[]{max, max_idx};
    }
    
    public static void bfs(int node){
        // Re-initialize distance each time
        Arrays.fill(dist, -1);
        Queue<Integer>qu = new LinkedList<>();
        qu.add(node);
        dist[node] = 0;
        while(!qu.isEmpty()){
            int nd = qu.poll();
            for(int child : hm.get(nd)){
                if(dist[child]==-1){
                    dist[child] = dist[nd] + 1;
                    qu.add(child);
                }
            }
        }
    }
}