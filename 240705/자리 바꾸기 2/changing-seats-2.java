import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] people = new int[n+1];
        int[][] sequence = new int[3*k][2];

        Map<Integer,HashSet> hash = new HashMap<>();
        
        for(int i = 1; i < n+1 ; i++) {
            people[i] = i;
            HashSet<Integer> value = new HashSet<>();
            value.add(i);
            hash.put(i,value);

        }

        for (int i = 0 ; i < k ; i ++){
            stk = new StringTokenizer(br.readLine());
            sequence[i][0] = Integer.parseInt(stk.nextToken());
            sequence[i+k][0] = sequence[i][0];
            sequence[i+2*k][0] = sequence[i][0];
            
            sequence[i][1] = Integer.parseInt(stk.nextToken());
            sequence[i+k][1] = sequence[i][1];
            sequence[i+2*k][1] = sequence[i][1];
        }

        for (int i = 0 ; i < 3*k ; i++){
            int a = sequence[i][0];
            int b = sequence[i][1];

            int p1 = people[a];
            int p2 = people[b];

            people[b] = p1;
            people[a] = p2;

            hash.get(p1).add(b);
            hash.get(p2).add(a);
            
        }

        for (int i = 1 ; i <= n ; i++) System.out.println(hash.get(i).size());
    }
}