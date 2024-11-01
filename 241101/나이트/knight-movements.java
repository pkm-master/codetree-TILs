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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Pair st = new Pair(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1);
        Pair end = new Pair(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1);
        
        Pair[] dir = {
            new Pair(2,1),
            new Pair(2,-1),
            new Pair(-2,1),
            new Pair(-2,-1),
            new Pair(1,2),
            new Pair(-1,2),
            new Pair(1,-2),
            new Pair(-1,-2),
        };

        int[][] visited = new int[n][n];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(st);
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = -1;
            }
        }
        visited[st.x][st.y] = 0;

        while (!q.isEmpty()){
            Pair now = q.poll();
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && visited[nextX][nextY]==-1 ){
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                    q.add(new Pair(nextX, nextY));

                }
            }
        }

        System.out.println(visited[end.x][end.y]);
        



    }
}