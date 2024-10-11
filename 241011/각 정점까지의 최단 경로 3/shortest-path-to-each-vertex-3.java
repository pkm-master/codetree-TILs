import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
    int x,l;
    public Pair(int x, int l){
        this.x = x;
        this.l = l;

    }

    @Override
    public int compareTo(Pair p){
        return this.l - p.l;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int inf = (int)1e9;


        int[] dist = new int[n+1];
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();

        for (int i=1; i<=n; i++){
            map.put(i,new ArrayList<Pair>());   
            if (i != 1){
                dist[i] = inf;
            }
        }

        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int length = Integer.parseInt(stk.nextToken());
            if (map.containsKey(st)){
                map.get(st).add(new Pair(end, length));
            }            
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        q.add(new Pair(1,0));

        while (!q.isEmpty()){
            Pair now = q.poll();
            int currNode = now.x;
            int currDist = now.l;
            visited[currNode] = true;
            dist[currNode] = Math.min(currDist, dist[currNode]);

            for (Pair next:map.get(currNode)){
                int nextNode = next.x;
                int nextDist = next.l + now.l;
                if (!visited[nextNode]){
                    q.add(new Pair(nextNode,nextDist));
                }
            }
        }

        for (int i=2; i<=n; i++){
            System.out.println(dist[i]==inf? -1: dist[i]);
        }
        


    }
}