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
    public static int[][] map;
    public static int[][] dirMap;
    public static Pair[] dir = {
        new Pair(-1,0),
        new Pair(-1,1),
        new Pair(0,1),
        new Pair(1,1),
        new Pair(1,0),
        new Pair(1,-1),
        new Pair(0,-1),
        new Pair(-1,-1),
    };
    public static int n, ans;
    public static Pair st;
    // 써져있는 방향에 있는 숫자중 현재 숫자보다 큰 숫자로 이동 가능

    public static void dfs(Pair st, int step){
        Pair next = new Pair(st.x+dir[dirMap[st.x][st.y]].x, st.y+dir[dirMap[st.x][st.y]].y);
        while (next.x >=0 && next.y>=0 && next.x<n && next.y<n){
            if( map[next.x][next.y] > map[st.x][st.y]){
                // 이동
                dfs(next, step+1);
            }
            next = new Pair(next.x+dir[dirMap[st.x][st.y]].x, next.y+dir[dirMap[st.x][st.y]].y);

        }
        ans = Math.max(ans,step);
        // 다음으로 진행할 st 찾기

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dirMap = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                dirMap[i][j] = Integer.parseInt(stk.nextToken())-1;
            }
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        st = new Pair(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1);

        dfs(st, 0);

        System.out.println(ans);
    }
}