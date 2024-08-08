import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<Integer> rs = new ArrayList<>();

        for (int i=1; i<str.length(); i++){
            char before = str.charAt(i-1);
            char current = str.charAt(i);
            if (current == '(' && before == '('){
                ls.add(i);
            }else if (current == ')' && before == ')'){
                rs.add(i);
            }
        }

        int[] biggers = new int[ls.size()];

        int j=0;
        long sums = 0;
        for (int i=0;i<ls.size();i++){

            while( j < rs.size() && ls.get(i)>rs.get(j) ){
                j++;
            }
            biggers[i] = rs.size() - j;
            sums += biggers[i];
        }

        System.out.println(sums);
        

    }
}