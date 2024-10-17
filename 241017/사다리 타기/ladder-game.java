import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair p){
        if (this.y != p.y) return this.y - p.y;
        else return this.x-p.x;
    }

}

public class Main {
    public static int n,m,l,minAns;
    public static Pair[] ladders;
    public static int[] initResult;
    public static int[] select;
    public static int[] after;

    public static void runLadder(){
        for (int i=0; i<n; i++) after[i] = i+1;

        for (int i=0; i<m; i++){
            if (select[i] == 1){
                int change = ladders[i].x;
                int tmp = after[change];
                after[change] = after[change-1];
                after[change-1] = tmp;
            }
        }
    }

    public static boolean isSame(int[] A, int[]B){
        for (int i=0; i<n; i++){
            if (A[i]!=B[i]) return false;
        }
        return true;
    }

    public static void dfs(int idx){
        if (idx==m){            
            runLadder();

            if (isSame(after,initResult)){
                int sum = 0;
                for (int i=0; i<m; i++) sum+= select[i];
                minAns = Math.min(minAns,sum);
            }

        }else{
            for (int i=0; i<2; i++){
                select[idx] = i;
                dfs(idx+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        ladders = new Pair[m];
        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            ladders[i] = new Pair(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
        }

        Arrays.sort(ladders);

        minAns = (int)1e9;
        select = new int[m];
        after = new int[n];
        initResult = new int[n];

        for (int i=0; i<m; i++){
            select[i] = 1;
        }

        runLadder();
        for (int i=0; i<n; i++) initResult[i] = after[i];

        for (int i=0; i<m; i++){
            select[i] = 0;
        }

        dfs(0);
        System.out.println(minAns);       

    }
}