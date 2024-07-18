import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] arr = new int[n];
        int total = 0;

        for (int i=0 ; i<n ; i++){
            int el = Integer.parseInt(stk.nextToken());
            arr[i] = el;
            q.add(el);
            total += el;
        }

        total -= q.peek();
        float max_value = (float)total/n;
        total += q.peek();

        for (int i=0 ; i<n-1 ; i++){
            int del_el = arr[i];
            q.remove(del_el);
            total -= del_el;
            total -= q.peek();
            float local = (float)total/(q.size()-1);
            if (local > max_value) max_value = local;
            total += q.peek();
        }

        System.out.println(String.format("%.2f",max_value));
    }
}