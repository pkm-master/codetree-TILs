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
    public static int[][] iceBerg;
    public static int n,m;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(0,-1),
        new Pair(1,0),
        new Pair(-1,0),
    };
    
    public static int howManyLeft(){
        int ans  = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                ans += iceBerg[i][j];
            }
        }
        return ans;

    }
    
    public static void melt(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        boolean[][] visited = new boolean[n][m];

        visited[0][0] = true;
        while (!q.isEmpty()){
            Pair now = q.poll();
            for(Pair di:dir){
                int nextX = now.x+di.x;
                int nextY = now.y+di.y;
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<m && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    if(iceBerg[nextX][nextY] == 1){
                        iceBerg[nextX][nextY] = 0;
                    }else{
                        q.add(new Pair(nextX,nextY));
                    }
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

        iceBerg = new int[n][m];


        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                iceBerg[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int curr = howManyLeft();
        int before = curr;
        int time = 0;

        while (curr>0){
            before = curr;
            melt();
            curr = howManyLeft();
            time++;
        }

        System.out.println(time+" "+before);
        

        // NxM 크기. 빙하.
        // 숫자 1은 빙하 
        // 물에닿아있으면 녹음
        // 
    }
}