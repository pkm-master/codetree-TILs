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
    
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n][n];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken())-1;
            int y = Integer.parseInt(stk.nextToken())-1;
            q.add(new Pair(x,y));
            visited[x][y] = true;
        }

        Pair[] dir = {
            new Pair(0,1),
            new Pair(0,-1),
            new Pair(1,0),
            new Pair(-1,0),
        };
        int cnt = 0;
        while (!q.isEmpty()){
            Pair now = q.poll();
            cnt++;
            for (Pair di:dir){
                int nextX = now.x + di.x;
                int nextY = now.y + di.y;
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && arr[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    q.add(new Pair(nextX,nextY));
                }
            }
        }

        System.out.println(cnt);





    }
}