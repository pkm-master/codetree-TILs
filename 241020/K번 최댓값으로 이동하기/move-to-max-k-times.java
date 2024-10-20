import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int val,i,j;
    public Pair (int val, int i, int j){
        this.val = val;
        this.i = i;
        this.j = j;
    }
    @Override
    public int compareTo(Pair p){
        if (this.val != p.val){
            return this.val - p.val;
        } else if (this.i != p.i){
            return p.i - this.i;
        } 
        return p.j-this.j;

    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Pair[] dir = {
            new Pair(0,1,0),
            new Pair(0,-1,0),
            new Pair(0,0,1),
            new Pair(0,0,-1),
        };
        stk = new StringTokenizer(br.readLine());
        
        int initI = Integer.parseInt(stk.nextToken()); 
        int initJ = Integer.parseInt(stk.nextToken());

        Pair st = new Pair(arr[initI][initJ], initI,initJ);


        for (int idx=0; idx<k; idx++){
            PriorityQueue<Pair> saved = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Pair> q = new LinkedList<>();
            q.add(st);
            boolean[][] visited = new boolean[n+1][n+1];

            boolean canMove = false;

            while (!q.isEmpty()){
                Pair now = q.poll();
                saved.add(now);

                for (Pair di:dir){
                    int nextI = now.i + di.i;
                    int nextJ = now.j + di.j;
                    if(nextI>=1 && nextI<=n && nextJ>=1 && nextJ<=n && !visited[nextI][nextJ] && arr[nextI][nextJ]<st.val){
                        q.add(new Pair(arr[nextI][nextJ],nextI,nextJ));
                        canMove = true;
                        visited[nextI][nextJ] = true;

                    }
                }

            }

            if (!canMove){
                break;
            }

            saved.poll();
            st = saved.poll();

        }

        System.out.println(st.i+" "+st.j);

    }
}