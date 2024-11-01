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
        int k = Integer.parseInt(stk.nextToken());

        // 상한귤 전부 큐에넣고 BFS
        int[][] map = new int[n][n];
        Queue<Pair> rotten = new LinkedList<>();
        int[][] visited = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = -1;

            }
        }
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 2){
                    rotten.add(new Pair(i,j));
                    visited[i][j] = 0;
                }
            }
        }

        Pair[] dir = {
            new Pair(0,1),
            new Pair(0,-1),
            new Pair(1,0),
            new Pair(-1,0),
        };

        while (!rotten.isEmpty()){
            Pair now = rotten.poll();
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && visited[nextX][nextY]==-1 && map[nextX][nextY]==1){
                    rotten.add(new Pair(nextX,nextY));
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                }
            }
        }


        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j]==1 && visited[i][j]==-1){
                    System.out.print(-2+" ");
                    
                }else{
                    System.out.print(visited[i][j]+" ");
                }
            }
            System.out.println();
        }






        // 각 귤이 상하는 시간
        // 상한귤 2, 그냥귤 1, 빈귤 0 

    }
}