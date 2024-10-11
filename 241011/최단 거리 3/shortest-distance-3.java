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

    public boolean eqauls(Pair p){
        if (this.x == p.x && this.l == p.l) return true;
        else return false;
    }

}


public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] dist = new int[n+1];
        int inf = (int)1e9;
        HashSet<Pair>[] graph = new HashSet[n+1];

        for (int i=1; i<=n; i++){
            dist[i] = inf;
            graph[i] = new HashSet<Pair>();
        }

        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());

            graph[st].add(new Pair(end,l));
            graph[end].add(new Pair(st,l));
        }

        stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(a,0));
        dist[a] = 0;

        while (!q.isEmpty()){
            Pair now = q.poll();
            visited[now.x] = true;
            dist[now.x] = Math.min(dist[now.x], now.l);

            for (Pair next:graph[now.x]){
                if (!visited[next.x]){
                    q.add(new Pair(next.x, next.l + now.l));
                }
            }
        }

        System.out.println(dist[b]);


    }
}