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
    public static ArrayList<Pair>[] graph;
    public static int n,m;

    public static void fillDist(int node, int[] dist){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(node,0));

        while (!q.isEmpty()){
            Pair now = q.poll();
            visited[now.x] = true;
            dist[now.x] = Math.min(now.l, dist[now.x]);

            for (Pair next:graph[now.x]){
                if (!visited[next.x]){
                    q.add(new Pair(next.x, next.l + dist[now.x]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n개의 정점/ m개의 간선
        // abc가 주어졌을때 특정 정점을 잠아 abc중 가장 가까운 정점까지의 거리가 최대가 되도록
        // 3개의 정점에 대해 3개의 dist를 구할 수 있음
        // 그다음 1번정점부터 돌리면서 세개의 dist중 최솟값을 찾음
        // ans보다 그 값이 크면 ans갱신
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int[] distA = new int[n+1];
        int[] distB = new int[n+1];
        int[] distC = new int[n+1];

        graph = new ArrayList[n+1];
        int inf = (int)1e9;

        for (int i=1; i<=n ;i++){
            distA[i] = inf;
            distB[i] = inf;
            distC[i] = inf;
            graph[i] = new ArrayList<Pair>();

        }

        stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        for (int i=0; i<m ;i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());

            graph[st].add(new Pair(end,l));
            graph[end].add(new Pair(st,l));
        }

        fillDist(a,distA);
        fillDist(b,distB);
        fillDist(c,distC);

        int ans = 0;
        for (int i=1; i<=n; i++){
            int min = Math.min(distA[i],Math.min(distB[i],distC[i]));
            ans = Math.max(min,ans);
        }

        System.out.println(ans);


    }
}