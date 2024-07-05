import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        HashSet<Long> hash = new HashSet<>();
        
        for ( int i = 0 ; i < n ; i++){
            stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();
            long ele = Long.parseLong(stk.nextToken());
            
            if (method.equals("find")){
                if (hash.contains(ele)){
                    System.out.println("true");
                }else {
                    System.out.println("false");
                }
            } else if (method.equals("add")){
                hash.add(ele);
            }else{
                hash.remove(ele);
            }
        }
    }
}