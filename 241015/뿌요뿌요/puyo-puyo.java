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
    public static int[][] arr;
    public static boolean[][] visited;
    public static int n,cnt;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(1,0),
        new Pair(0,-1),
        new Pair(-1,0)
    };
    
    public static void dfs(Pair start){
        if (visited[start.x][start.y]){
            return;
        }
        visited[start.x][start.y] = true;
        cnt++;
        for (Pair di:dir){
            int nextX = start.x + di.x;
            int nextY = start.y + di.y;
            if (0<=nextX && nextX<n && nextY>=0 && nextY<n && !visited[nextX][nextY] && arr[nextX][nextY] == arr[start.x][start.y]){
                dfs(new Pair(nextX,nextY));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int popN = 0;
        int ans = 0;
        
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j]){
                    cnt = 0;
                    dfs(new Pair(i,j));
                    ans = Math.max(ans,cnt);
                    if (cnt>=4) popN++;
                }        
            }
        }

        System.out.println(popN+" "+ans);


    }
}