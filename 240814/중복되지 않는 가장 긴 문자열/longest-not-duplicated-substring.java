import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int i=0;
        int j=1;
        int ans = 1;
        int temps = 1;
        HashSet<Character> hash = new HashSet<>();
        hash.add(str.charAt(i));


        while (i<str.length() && j<str.length()){
            if (hash.contains(str.charAt(j))){
                hash.remove(str.charAt(i));
                i++;
                temps--;
            } else{
                hash.add(str.charAt(j));
                j++;
                temps++;
                ans = Math.max(ans,temps);
                // System.out.println(hash);
            }
        }

        System.out.println(ans);
    }
}