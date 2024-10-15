import java.util.*;
import java.io.*;

class Pair{
    int x,y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;

    }
}

public class Main {
    public static int[][] map;
    public static int n,m;
    public static boolean[][] visited;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(0,-1),
        new Pair(1,0),
        new Pair(-1,0)
    };
    public static void dfs(Pair start){
        if (visited[start.x][start.y]){
            return;
        }
        visited[start.x][start.y] = true;

        for (Pair di:dir){
            int nextX = start.x + di.x;
            int nextY = start.y + di.y;
            if (0<=nextX && nextX<n && nextY>=0 && nextY<m){
                if ((!visited[nextX][nextY]) && (map[nextX][nextY]==1)){
                    dfs(new Pair(nextX,nextY));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n][m];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int ans = 0;
        int ansK = 1;
        for (int k=1; k<=100; k++){
            int cnt = 0;
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    map[i][j] = arr[i][j]>k?1:0;
                }
            }

            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if (map[i][j] == 1 && !visited[i][j]){
                        dfs(new Pair(i,j));
                        cnt++;
                    }
                }
            }
            if (ans < cnt){
                ans = cnt;
                ansK = k;
            }

        }

        System.out.println(ansK+" "+ans);

    }
}