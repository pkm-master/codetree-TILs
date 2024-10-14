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
    public static int n,m;

    public static Pair[] dir={
        new Pair(0,1),
        new Pair(1,0),
    };

    public static void dfs(Pair now){
        if (visited[now.x][now.y]){
            return;
        }

        visited[now.x][now.y] = true;

        for (int i=0; i<2; i++){
            int next_x = now.x + dir[i].x;
            int next_y = now.y + dir[i].y;
            if (0<=next_x && next_x<n && 0<=next_y && next_y<m && !visited[next_x][next_y] && arr[next_x][next_y] == 1){
                dfs(new Pair(next_x, next_y));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(new Pair(0,0));

        System.out.println(visited[n-1][m-1]? 1 : 0);
    }
}