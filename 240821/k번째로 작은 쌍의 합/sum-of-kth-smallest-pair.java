import java.io.*;
import java.util.*;

class Tuple implements Comparable<Tuple>{
    int sum, a_idx, b_idx;

    public Tuple(int sum, int a_idx, int b_idx){
        this.sum = sum;
        this.a_idx = a_idx;
        this.b_idx = b_idx;
    }

    @Override
    public int compareTo(Tuple t){
        if (this.sum != t.sum){
            return this.sum - t.sum;
        } else if (this. a_idx != t.a_idx){
            return this.a_idx - t.a_idx;
        } else{
            return this.b_idx - t.b_idx;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) A[i] = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<m ; i++) B[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Tuple> sumq = new PriorityQueue<>();
        
        for (int i=0 ; i<n ; i++) sumq.add(new Tuple(A[i]+B[0], i, 0));

        Tuple curr = new Tuple(0,0,0);
        for (int i=0; i<k; i++){
            curr = sumq.poll();
            if (curr.b_idx + 1 < m) sumq.add(new Tuple(A[curr.a_idx]+B[curr.b_idx+1],curr.a_idx,curr.b_idx+1));
        }

        System.out.println(curr.sum);


    }
}