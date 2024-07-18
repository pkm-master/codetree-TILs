import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++){
            q.add(-Integer.parseInt(stk.nextToken()));
        }

        for (int i=0 ; i<m ;i++){
            int local_max = q.poll();
            q.add(local_max+1);
        }

        System.out.println(-q.peek());
    }
}