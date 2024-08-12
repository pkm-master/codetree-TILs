import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            int value = Integer.parseInt(stk.nextToken());

            if (value >=0) plus.add(value);
            else minus.add(value);
        }

        int ans=2000000000;
        Collections.sort(minus, Collections.reverseOrder());
        Collections.sort(plus);

        if (plus.size()>=2) ans = plus.get(0) + plus.get(1);
        if (minus.size()>=2) ans = Math.min(ans, -minus.get(0)-minus.get(1));

        int i=0;
        int j=0;

        if (plus.size()>=1 && minus.size()>=1){
            while (i<plus.size() && j<minus.size()){
                int tmp_ans = plus.get(i) + minus.get(j);
                ans = Math.min(ans, Math.abs(tmp_ans));
                if (tmp_ans>0 && j<minus.size()){
                    j++;
                } else if(tmp_ans <0 && i<plus.size())  {
                    i++;
                } else if(tmp_ans == 0){
                    break;

                }

            }
        }

        System.out.println(ans);

    }
}