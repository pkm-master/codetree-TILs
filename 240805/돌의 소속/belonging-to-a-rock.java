import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        int[] sum1 = new int[n+1];
        int[] sum2 = new int[n+1];
        int[] sum3 = new int[n+1];
        int one,two,three;

        for (int i=1; i<=n; i++){
            int group = Integer.parseInt(br.readLine());
            one = two = three = 0;
            if (group == 1){
                one = 1;
            }else if (group == 2){
                two = 1;
            }else if (group == 3){
                three = 1;
            }
            sum1[i] = sum1[i-1]+one;
            sum2[i] = sum2[i-1]+two;
            sum3[i] = sum3[i-1]+three;
        }

        for (int i=0; i<q; i++ ){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            System.out.println((sum1[e]-sum1[s-1])+" "+(sum2[e]-sum2[s-1])+" "+(sum3[e]-sum3[s-1]));
        }
    }
}