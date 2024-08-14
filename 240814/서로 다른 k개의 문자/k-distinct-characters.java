import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String str = stk.nextToken();
        int k = Integer.parseInt(stk.nextToken());

        int[] chars = new int[26];
        HashSet<Character> hash = new HashSet<>();
        int i=0;
        int j=1;
        int ans=1;
        int tmp=1;

        chars[str.charAt(i)-'a'] += 1;
        hash.add(str.charAt(i));
        
        while (i<str.length() && j<str.length()){
            if (hash.size()>k){
                chars[str.charAt(i)-'a'] -= 1;
                if (chars[str.charAt(i)-'a']==0){
                    hash.remove(str.charAt(i));
                }
                i++;
                tmp--;
            } else {
                hash.add(str.charAt(j));
                chars[str.charAt(j)-'a'] += 1;
                tmp++;
                if (hash.size()<=k) ans = Math.max(ans,tmp);
                j++;

            }
        }

        System.out.println(ans);
    }

}