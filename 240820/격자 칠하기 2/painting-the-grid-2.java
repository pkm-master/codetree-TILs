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
    public static int n;
    public static int[][] arr;
    public static Pair[] dir = {new Pair(0,1),new Pair(0,-1),new Pair(1,0),new Pair(-1,0)};
    public static boolean[][] visited;

    public static int coloring (int value, Pair st){
        if (visited[st.x][st.y]){
            return 0;
        }
        visited[st.x][st.y] = true;
        int cnt = 1;
        for (int i=0; i<4; i++){
            Pair next = new Pair(st.x+dir[i].x, st.y+dir[i].y);
            if (next.x<n && next.y<n && next.x>=0 && next.y>=0 && !visited[next.x][next.y] && Math.abs(arr[next.x][next.y]-arr[st.x][st.y]) <= value){
                cnt += coloring(value,next);
            }
        }
        return cnt;
    }

    public static boolean is_possible(int value){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = false;
            }
        }
        Pair st = new Pair(0,0);
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                st.x = i;
                st.y = j;
                int part = coloring(value, st);
                if (2*part >= n*n){
                    return true;
                }

            }
        }

        return false;
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

        int st = 0;
        int end = (int)Math.pow(10,6);
        int ans = end;

        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                end = mid-1;
                ans = Math.min(ans,mid);
            } else{
                st = mid+1;
            }
        }

        System.out.println(ans);

    }
}