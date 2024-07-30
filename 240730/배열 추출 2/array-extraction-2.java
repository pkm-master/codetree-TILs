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
        if(this.x > p.x){
            return 1;
        } else if (this.x == p.x && this.y > p.y){
            return 1;
        } else {
            return -1;
        }
    }
    
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i=0 ; i<n ; i++){
            int k = Integer.parseInt(br.readLine());
            if (k == 0){
                if (!q.isEmpty()) System.out.println(q.poll().y);
                else System.out.println(0);
            } else {
                q.add(new Pair(Math.abs(k),k));

            }
        }
    }
}