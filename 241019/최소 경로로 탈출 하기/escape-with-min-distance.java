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
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Pair[] dir = {
            new Pair(0,1),
            new Pair(0,-1),
            new Pair(1,0),
            new Pair(-1,0),
        };

        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,0));

        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        while (!q.isEmpty()){
            Pair now = q.poll();
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;

                if (nextX>=0 && nextX<n && nextY>=0 && nextY<m && visited[nextX][nextY] == 0 && arr[nextX][nextY] == 1){
                    visited[nextX][nextY] = visited[now.x][now.y]+1;
                    q.add(new Pair(nextX,nextY));
                }
            }

        }

        System.out.println(visited[n-1][m-1]==0? -1 : visited[n-1][m-1]-1);

    }
}