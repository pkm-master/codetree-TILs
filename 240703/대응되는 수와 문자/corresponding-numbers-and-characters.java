import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());


        HashMap num_hash = new HashMap();
        HashMap string_hash = new HashMap();

        for (int i = 1 ; i <= n ; i++){
            String string = br.readLine();
            string_hash.put(string, i);
            num_hash.put(i,string);
        }

        for (int i = 0 ; i < m ; i++){
            String target = br.readLine();
            if ((int)target.charAt(0)>=97 && (int)target.charAt(0)<=122 ){
                System.out.println(string_hash.get(target));
            } else{
                System.out.println(num_hash.get(Integer.parseInt(target)));

            }
        }
    }
}