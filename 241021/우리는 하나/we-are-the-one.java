import java.io.*;
import java.util.*;

class Pair{
    int x, y, z;
    public Pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    public static int[][] cities;
    public static int n,k,u,d,ans;
    public static boolean[][] cityVisited;
    public static Pair[] selected;
    public static Pair[] dir = {
        new Pair(0,1,0),
        new Pair(0,-1,0),
        new Pair(1,0,0),
        new Pair(-1,0,0),
    };
    
    public static void cityBfs(){
        // selected를 기준으로 BFS
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<k; i++){
            q.add(selected[i]);
            visited[selected[i].x][selected[i].y] = true;
        }

        int result = 0;
        while (!q.isEmpty()){
            Pair now = q.poll();
            result++;
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;

                if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && !visited[nextX][nextY]){
                    int nextVal = cities[nextX][nextY];
                    if (Math.abs(nextVal-now.z)<=d && Math.abs(nextVal-now.z)>=u){
                        visited[nextX][nextY] = true;
                        q.add(new Pair(nextX,nextY,nextVal));
                    }
                }

            }
        }

        ans = Math.max(ans,result);
        
    }
    public static void cityDfs(int idx){
        if(idx == k){
            // System.out.println(Arrays.toString(selected));
            cityBfs();
            return;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!cityVisited[i][j]){
                    cityVisited[i][j] = true;
                    selected[idx] = new Pair(i,j,cities[i][j]);
                    cityDfs(idx+1);
                    cityVisited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        u = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());

        cities = new int[n][n];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                cities[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        cityVisited = new boolean[n][n];
        selected = new Pair[k];
        ans = 0;

        cityDfs(0);       

        System.out.println(ans);

    }
}