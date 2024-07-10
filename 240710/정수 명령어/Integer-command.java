import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++){
            int K = Integer.parseInt(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for (int k = 0 ; k < K ; k++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                String method = stk.nextToken();
                if (method.equals("I")) set.add(Integer.parseInt(stk.nextToken()));
                else if (set.size()==0) ;
                else if (method.equals("D") && stk.nextToken().equals("1")) set.remove(set.last());
                else set.remove(set.first());
            }
            if (set.size() == 0 ) {System.out.println("EMPTY");}
            else {System.out.println(set.last() + " " + set.first());}
        }

    }
}