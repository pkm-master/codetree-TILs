import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        stk = new StringTokenizer(br.readLine());

        for (int i=0 ; i<n ; i++){
            int el = Integer.parseInt(stk.nextToken());
            set.add(el);
        }
        for (int i=0 ; i<k ; i++){
            int el = set.last();
            System.out.print(el + " ");
            set.remove(el);
        }
    }
}