import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();


            if (method.equals("push")){
                int new_int = Integer.parseInt(stk.nextToken());
                q.add(-new_int);
            }else if (method.equals("size")){
                System.out.println(q.size());
            }else if (method.equals("empty")){
                System.out.println(q.isEmpty()? 1 : 0);
            }else if (method.equals("top")){
                System.out.println(-q.peek());
            }else if (method.equals("pop")){    
                System.out.println(-q.poll());
            }
        }
    }
}