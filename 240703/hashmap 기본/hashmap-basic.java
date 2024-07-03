import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap hash = new HashMap();
        
        for (int i = 0 ; i < N ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();
            if (method.equals("add")){
                int key = Integer.parseInt(stk.nextToken());
                int value = Integer.parseInt(stk.nextToken());
                hash.put(key,value);


            } else if (method.equals("find")) {
                int target = Integer.parseInt(stk.nextToken());
                System.out.println(hash.getOrDefault(target,"None"));

            } else if (method.equals("remove")){
                int target = Integer.parseInt(stk.nextToken());
                hash.remove(target);

            }
            
        }
    }   
}