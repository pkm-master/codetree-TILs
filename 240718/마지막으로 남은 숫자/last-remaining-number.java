import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0 ; i<n ; i++){
            q.add(-Integer.parseInt(stk.nextToken()));
        }

        while (!q.isEmpty()){
            if (q.size() == 1){
                System.out.println(-q.poll());
            }else{
                int a = q.poll();
                int b = q.poll();
                if (Math.abs(a-b) != 0) q.add(-Math.abs(a-b));
                if (q.size() == 0) System.out.println(-1);
            }
        }   
        

    }
}