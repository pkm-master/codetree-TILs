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

    public static int count(int[][] visited){
        int sum = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                sum += visited[i][j];
            }
        }
        return sum;
    }

    public static int color (int value, Pair st){

        int[][] visited = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        visited[st.x][st.y] = 1;
        q.add(st);

        while (!q.isEmpty()){
            Pair curr = q.poll();
            for (int i=0; i<4; i++){
                Pair next = new Pair(curr.x + dir[i].x, curr.y + dir[i].y);
                if (next.x<n && next.y<n && next.x>=0 && next.y>=0 && visited[next.x][next.y]==0 && Math.abs(arr[next.x][next.y]-arr[curr.x][curr.y]) <= value){
                    q.add(next);
                    visited[next.x][next.y] = 1;
                }
            }

        }

        return count(visited);

    }

    public static boolean is_possible(int value){
        int total = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int part = color(value, new Pair(i,j));
                total = Math.max(part,total);
            }
        }
        if (total>=Math.pow(n,2)/2+Math.pow(n,2)%2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

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