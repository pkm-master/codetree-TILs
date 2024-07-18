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
        return Math.abs(this.x) + Math.abs(this.y) - Math.abs(p.x) - Math.abs(p.y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> q = new PriorityQueue<>();

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for (int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            q.add(new Pair(x,y));
            
        }

        for (int i=0 ; i<m ; i++){
            Pair p = q.poll();
            p.x += 2;
            p.y += 2;
            q.add(p);
        }

        System.out.println((q.peek().y)+" "+(q.peek().x));
        
    }
}