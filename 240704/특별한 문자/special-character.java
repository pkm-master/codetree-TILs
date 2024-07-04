import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Map<Character,Integer> hash = new HashMap<>();
        
        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);

            if (hash.containsKey(ch)){
                hash.replace(ch,hash.get(ch)+1);

            } else {
                hash.put(ch, 1);
            }
        }

        boolean is_contains = false;

        ArrayList<Character> arr = new ArrayList<>();
        for (char ch : hash.keySet()){
            if (hash.get(ch) == 1){
                is_contains = true;
                arr.add(ch);
            }
        }

        int min_val = (int)Math.pow(10,6);

        for (char ch : arr){
            if (word.indexOf(ch) < min_val){
                min_val = word.indexOf(ch);
            }
        }
        
        if (is_contains){
            System.out.println(word.charAt(min_val));
        }else{
            System.out.println("None");
        }

    }
}