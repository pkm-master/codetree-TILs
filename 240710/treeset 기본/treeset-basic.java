import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0 ; i < n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();
            if (method.equals("add")) set.add(Integer.parseInt(stk.nextToken()));
            else if (method.equals("remove")) set.remove(Integer.parseInt(stk.nextToken()));
            else if (method.equals("find")) System.out.println(set.contains(Integer.parseInt(stk.nextToken()))? true : false);
            else if (set.size() == 0) System.out.println("None");
            else if (method.equals("lower_bound")){
                int token = Integer.parseInt(stk.nextToken());
                System.out.println(set.ceiling(token) == null? "None" : set.ceiling(token));
            } 
            else if (method.equals("upper_bound")){
                int token = Integer.parseInt(stk.nextToken());
                System.out.println(set.higher(token) == null? "None" : set.higher(token));
            } 
            else if (method.equals("largest")) System.out.println(set.last());
            else if (method.equals("smallest")) System.out.println(set.first());

        }
    }
}