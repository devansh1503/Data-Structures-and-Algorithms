import java.util.*;
import java.io.*;

// This problem requires Multi Source BFS traversal

public class ThreePathsTree {
    static HashMap<Integer, List<Integer>>tree;
    static int[]parent;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        int nodes = n;
        while(nodes-->1){
            String[]ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            tree.putIfAbsent(a, new ArrayList<>());
            tree.putIfAbsent(b, new ArrayList<>());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        ArrayList<Integer>sources = new ArrayList<>();

        int[]dist = new int[n+1];
        sources.add(1);
        int fromOne = farthestNode(sources, dist);

        int[]distA = new int[n+1];
        sources.clear();
        sources.add(fromOne);
        int fromA = farthestNode(sources, distA);

        int[]distB = new int[n+1];
        sources.clear();
        sources.add(fromA);
        int fromB = farthestNode(sources, distB);
        int mx = distB[fromB];

        sources.clear();
        int node = fromB;
        while(parent[node]!=-1){
            sources.add(node);
            node = parent[node];
        }

        int[]distC = new int[n+1];
        farthestNode(sources, distC);

        int maxDist = -1, bestNode=-1;
        for(int i=0; i<distC.length; i++){
            if(distC[i] >= maxDist){
                maxDist = distC[i];
                if(i!=fromA && i!=fromB){
                    bestNode = i;
                }
            }
        }

        System.out.println(maxDist+mx);
        System.out.println((fromA)+" "+(fromB)+" "+(bestNode));
    }

    public static int farthestNode(ArrayList<Integer>sources, int[]dist){
        Arrays.fill(dist, -1);
        Queue<Integer>qu = new LinkedList<>();
        int max = 0;
        for(int src : sources){
            dist[src] = 0;
            qu.add(src);
            parent[src] = -1;
        }
        int idx = sources.get(0); // This step is only required for single source to find the farthest node
        while(!qu.isEmpty()){
            int node = qu.poll();
            int parent_dist = dist[node];
            for(int nd : tree.get(node)){
                if(dist[nd]==-1){
                    dist[nd] = parent_dist+1;
                    parent[nd] = node;
                    qu.add(nd);
                    if(dist[nd] > max){
                        max = dist[nd];
                        idx = nd;
                    }
                }
            }
        }
        return idx;
    }
}
