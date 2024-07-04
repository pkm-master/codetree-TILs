import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Map,Integer> hash = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            String word = br.readLine();
            Map<Character, Integer> tmp_hash = new HashMap<>();

            for (int j = 0 ; j < word.length() ; j++){
                char key = word.charAt(j);
                if (tmp_hash.containsKey(key)){
                    tmp_hash.replace(key, tmp_hash.get(key)+1);
                }else {
                    tmp_hash.put(key,1);
                }
            }

            if (hash.containsKey(tmp_hash)){
                hash.replace(tmp_hash,hash.get(tmp_hash)+1);
            }else {
                hash.put(tmp_hash,1);
            }

        }

        System.out.println(Collections.max(hash.values()));


    }
}