import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            q.add(Integer.parseInt(stk.nextToken()));
        }


        int ans = 0;
        while(q.size()>=2){
            int num1 = q.poll();
            int num2 = q.poll();
            int newNum = num1+num2;
            ans += newNum;
            q.add(newNum);

        }

        System.out.println(ans);
    }
}