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
    // 3 : 비를 피할 수 있음
    // 2 : 사람이 존재
    // 1 : 벽이 존재 
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Pair[] dir = {
            new Pair(0,1),
            new Pair(0,-1),
            new Pair(1,0),
            new Pair(-1,0)
        };

        int[][] arr = new int[n][n];
        ArrayList<Pair> humans = new ArrayList<>();
        Queue<Pair> st = new LinkedList<>();
        int[][] visited = new int[n][n];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                if (arr[i][j]==3){
                    st.add(new Pair(i,j));
                    visited[i][j] = 1;
                }else if (arr[i][j]==2){
                    humans.add(new Pair(i,j));
                }
            }
        }

        while (!st.isEmpty()){
            Pair now = st.poll();
            for (Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;
                if (nextX>=0 && nextY>=0 && nextX<n && nextY<n && visited[nextX][nextY]==0 && arr[nextX][nextY] != 1){
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                    st.add(new Pair(nextX,nextY));
                }
            }
        }

        int[][] result = new int[n][n];
        for (int i=0; i<humans.size(); i++){
            Pair currHuman = humans.get(i);
            result[currHuman.x][currHuman.y] = visited[currHuman.x][currHuman.y] == 0? -1 : visited[currHuman.x][currHuman.y]-1;
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}