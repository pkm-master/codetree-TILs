import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Integer,Integer> line = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            line.put(s,1);
            line.put(e,-1);
            q.add(s);
            q.add(e);

        }


        int sums = 0;
        int max_value = 0;
        
        while (!q.isEmpty()){
            int point = q.poll();
            sums += line.get(point);
            if (max_value<sums){
                max_value = sums;

            }

        }
        System.out.println(max_value);
    }
}