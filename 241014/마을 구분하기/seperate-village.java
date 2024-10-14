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
    public static boolean[][] visited;
    public static int[][] arr;
    public static int n;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(0,-1),
        new Pair(1,0),
        new Pair(-1,0),
    };
    public static int cnt;

    public static void dfs(Pair now){
        if (visited[now.x][now.y]){
            return;
        }

        visited[now.x][now.y] = true;
        cnt++;
        for (int i=0; i<4; i++){
            int next_x = now.x+dir[i].x;
            int next_y = now.y+dir[i].y;

            if (0<=next_x && next_x<n && 0<=next_y && next_y<n && !visited[next_x][next_y] && arr[next_x][next_y] == 1){
                dfs(new Pair(next_x,next_y));
            }

        }
    }
    public static void main(String[] args) throws IOException {
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

        PriorityQueue<Integer> q= new PriorityQueue<>();
        cnt = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] == 1 && !visited[i][j]){
                    dfs(new Pair(i,j));
                    q.add(cnt);
                    cnt = 0;

                }
                
            }
        }

        System.out.println(q.size());
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }

    }
}