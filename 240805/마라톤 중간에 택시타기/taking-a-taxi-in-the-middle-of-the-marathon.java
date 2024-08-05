import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] xL = new int[n];
        int[] xR = new int[n];
        int[] yL = new int[n];
        int[] yR = new int[n];
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            xs[i] = x;
            ys[i] = y;

            if (i>=1) xL[i] = xL[i-1]+Math.abs(xs[i]-xs[i-1]);
            if (i>=1) yL[i] = yL[i-1]+Math.abs(ys[i]-ys[i-1]);
        }

        for (int i=n-2 ; i>=0; i-- ){
            xR[i] = xR[i+1]+Math.abs(xs[i]-xs[i+1]);
            yR[i] = yR[i+1]+Math.abs(ys[i]-ys[i+1]);

        }

        int min_value = 2000*100000;

        for (int i=1 ; i<n-1 ; i++){
            int dist = 0 ;
            dist += xL[i-1];
            dist += xR[i+1];
            dist += Math.abs(xs[i+1]-xs[i-1]);

            dist += yL[i-1];
            dist += yR[i+1];
            dist += Math.abs(ys[i+1]-ys[i-1]);

            if (dist < min_value) min_value=dist;
        }
        System.out.println(min_value);

    }
}