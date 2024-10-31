import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static ArrayList<Pair> walls;
    public static int[][] map;
    public static int[] deleteWallIdx;
    public static int k,wallN,n,ans;
    public static Pair st;
    public static Pair end;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(0,-1),
        new Pair(1,0),
        new Pair(-1,0),
    };
    public static int bfs(){
        int[][] visited = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(st);
        visited[st.x][st.y] = 1;
        while (!q.isEmpty()){
            Pair now = q.poll();
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && visited[nextX][nextY]==0 && map[nextX][nextY] != 1){
                    q.add(new Pair(nextX,nextY));
                    visited[nextX][nextY] = visited[now.x][now.y]+1;
                }
            }
        }

        return visited[end.x][end.y]-1;

    }
    public static void dfs(int idx, int j){
        if (idx == k){
            for (int i=0; i<k; i++){
                map[walls.get(deleteWallIdx[i]).x][walls.get(deleteWallIdx[i]).y] = 0;
            }
            int step = bfs();
            if (step!=-1){
                ans = Math.min(ans, step);
            }

            for (int i=0; i<k; i++){
                map[walls.get(deleteWallIdx[i]).x][walls.get(deleteWallIdx[i]).y] = 1;
            }

            return;
        }
        for (int i=j; i<wallN; i++){
            deleteWallIdx[idx] = i;
            dfs(idx+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        wallN = 0;
        ans = (int)1e9;
        map = new int[n][n];
        walls = new ArrayList<>();


        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j]==1){
                    wallN++;
                    walls.add(new Pair(i,j));
                }
            }
        }
        deleteWallIdx = new int[k];
    
        stk = new StringTokenizer(br.readLine());

        st = new Pair(Integer.parseInt(stk.nextToken())-1,Integer.parseInt(stk.nextToken())-1);
        
        stk = new StringTokenizer(br.readLine());
        
        end = new Pair(Integer.parseInt(stk.nextToken())-1,Integer.parseInt(stk.nextToken())-1);

        dfs(0,0);
        
        System.out.println(ans);
    }
}