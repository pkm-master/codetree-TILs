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
    public static int[][] arr;
    public static Pair[] dir = {
        new Pair(0,1),
        new Pair(0,-1),
        new Pair(1,0),
        new Pair(-1,0),
    };
    public static Pair[] st;

    public static int n,k,m, ans;

    public static void dfs(int idx){
        if (idx == m){
            Queue<Pair> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];

            for (int i=0; i<k; i++){
                q.add(st[i]);
                visited[st[i].x-1][st[i].y-1] = true;
            }

            int cnt = 0;

            while (!q.isEmpty()){
                Pair now = q.poll();
                cnt++;
                for (Pair di:dir){
                    int nextX = now.x+di.x;
                    int nextY = now.y+di.y;
                    if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && !visited[nextX][nextY] && arr[nextX][nextY]==0){
                        q.add(new Pair(nextX,nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }

            ans = Math.max(cnt,ans);
            
        }else{
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (arr[i][j]==1){
                        arr[i][j] = 0;
                        dfs(idx+1);
                        arr[i][j] = 1;
                    }
                }
            }
        }
        // m개 선택 후, 선택 완료하면 BFS로 탐색
    }
    public static void main(String[] args) throws IOException {
        // 주어진 돌 중 m개의 돌만 적절하게 치워 도달 가능한 수를 최대로 하는 프로그램
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken()); // 격자 크기
        k = Integer.parseInt(stk.nextToken()); // 시작점 수
        m = Integer.parseInt(stk.nextToken());

        arr = new int[n][n];
        st = new Pair[k];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n ;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for (int i=0; i<k; i++){
            stk = new StringTokenizer(br.readLine());
            st[i] = new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
        
        ans = 0;

        dfs(0);

        System.out.println(ans);


        // 여기에 코드를 작성해주세요.
    }
}