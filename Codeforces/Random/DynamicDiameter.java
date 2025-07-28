import java.util.*;
import java.io.*;

public class DynamicDiameter {
    static HashMap<Integer, List<Integer>>tree;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 1){
            System.out.println(1);
            return;
        }
        tree = new HashMap<>();
        while(n-->1){
            String[]uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            tree.putIfAbsent(u, new ArrayList<>());
            tree.putIfAbsent(v, new ArrayList<>());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int farthestNodeFrom1 = bfs(1, new int[tree.size()+1])[1];
        int[]dist = new int[tree.size()+1];
        int[]res2 = bfs(farthestNodeFrom1, dist);
        int Diameter = res2[0];
        int farthest2 = res2[1];

        boolean[]isEndPoint = new boolean[tree.size()+1];
        for(int i=1; i<dist.length; i++){
            isEndPoint[i] |= dist[i] == Diameter;
        }
        bfs(farthest2, dist);
        
        for(int i=1; i<dist.length; i++){
            isEndPoint[i] |= dist[i] == Diameter;
        }

        for(int i=1; i<tree.size()+1; i++){
            if(isEndPoint[i]) System.out.println(Diameter+1);
            else System.out.println(Diameter);
        }

    }
    public static int[] bfs(int start, int[]dist){
        Arrays.fill(dist, -1);
        Queue<Integer>qu = new LinkedList<>();
        qu.add(start);
        dist[start] = 0;
        int max = 0;
        int idx = start;
        while(!qu.isEmpty()){
            int node = qu.poll();
            for(int child : tree.get(node)){
                if(dist[child] == -1){
                    dist[child] = dist[node]+1;
                    qu.add(child);
                    if(max < dist[child]){
                        max = dist[child];
                        idx = child;
                    }
                }
            }
        }
        return new int[]{max, idx};
    }
}
