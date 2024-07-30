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
        if (this.x > p.x){
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

        PriorityQueue<Pair> not_arrive = new PriorityQueue<>();
        PriorityQueue<Pair> waiting = new PriorityQueue<>();
        int[] Arrive_time = new int[n];
        int[] Enter_time = new int[n];
        int[] spend_time = new int[n];
        int current_time = 0;

        for (int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());
            spend_time[i] = t;

            not_arrive.add(new Pair(a,i));
        }

        Pair Arrived = not_arrive.poll();
        current_time += Arrived.x;
        waiting.add(new Pair(Arrived.y, Arrived.x));
        while (!not_arrive.isEmpty() && not_arrive.peek().x == current_time ){
            Arrived = not_arrive.poll();
            waiting.add(new Pair(Arrived.y, Arrived.x));
        }

        while (!not_arrive.isEmpty() || !waiting.isEmpty()){
            if (!waiting.isEmpty()){
                Pair Enter = waiting.poll();
                Arrive_time[Enter.x] = Enter.y;
                Enter_time[Enter.x] = current_time;
                
                current_time += spend_time[Enter.x];
                while (!not_arrive.isEmpty() && not_arrive.peek().x <= current_time){
                    Arrived = not_arrive.poll();
                    waiting.add(new Pair(Arrived.y, Arrived.x));
                }

            } else{
                Arrived = not_arrive.poll();
                current_time = Arrived.x;
                waiting.add(new Pair(Arrived.y, Arrived.x));
                while (!not_arrive.isEmpty() && not_arrive.peek().x == current_time ){
                    Arrived = not_arrive.poll();
                    waiting.add(new Pair(Arrived.y, Arrived.x));
                }
            }
        }

        int max_wait = 0;
        for (int i=0 ; i<n ; i++){
            int waiting_time = Enter_time[i] - Arrive_time[i];
            if (waiting_time > max_wait) max_wait = waiting_time;
        }

        System.out.println(max_wait);
    }

}