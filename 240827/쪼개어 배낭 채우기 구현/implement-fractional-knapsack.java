import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
    double x;
    int y;
    public Pair(double x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        if (this.x>p.x) return 1;
        else return -1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Pair> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            q.add(new Pair((double)v/w, w));
        }

        double value = 0;
        int curr = 0;
        while (curr<=m && !q.isEmpty()){
            Pair currJ = q.poll();
            int canAdd = Math.min(currJ.y, m-curr);
            value += currJ.x * canAdd;
            curr += canAdd;

        }    

        System.out.println(String.format("%.3f",value));
    }

}