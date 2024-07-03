import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap hash = new HashMap();

        for (int i = 0 ; i < N ; i++){
            String key = br.readLine();
            if (hash.containsKey(key)){
                int new_value = (int)hash.get(key) + 1 ;
                hash.replace(key, new_value);
            } else{
                hash.put(key,1);
            }
        }

        System.out.println(Collections.max(hash.values()));

    }
}