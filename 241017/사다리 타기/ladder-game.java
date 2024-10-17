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
    public static int[][] ladders;
    public static int[] initResult;
    public static int[] select;

    public static int[] runLadder(){
        int[] after = new int[n];
        for (int i=0; i<n; i++) after[i] = i+1;
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i=0; i<m; i++){
            if(select[i] >= 0) q.add(new Pair(ladders[select[i]][0],ladders[select[i]][1]));
        }

        while (!q.isEmpty()){
            int change = q.poll().x;
            int tmp = after[change];
            after[change] = after[change-1];
            after[change-1] = tmp;
        }
        return after;
    }

    public static boolean isSame(int[] A, int[]B){
        for (int i=0; i<n; i++){
            if (A[i]!=B[i]) return false;
        }
        return true;
    }

    public static void dfs(int idx){
        if (idx==l){
            int[] result = runLadder();
            if (isSame(result,initResult)){
                minAns = Math.min(minAns,l);

            }
        }else{
            for (int i=idx; i<m; i++){
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

        ladders = new int[m][2];
        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            ladders[i][0] = Integer.parseInt(stk.nextToken());
            ladders[i][1] = Integer.parseInt(stk.nextToken());
        }

        minAns = (int)1e9;
        select = new int[m];

        for (int i=0; i<m; i++){
            select[i] = i;
        }

        initResult = runLadder();

        for (int i=0; i<m; i++){
            select[i] = -1;
        }

        for (int i=0; i<=m; i++){
            l = i;
            dfs(0);
            if (minAns!=(int)1e9) break;
        }

        System.out.println(minAns);       

    }
}