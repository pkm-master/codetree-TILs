import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[] arr;
    public static int howMuch(long value){
        // value안에 최대 몇개의 물건을 통과 시킬 수 있는지
        int stuff = 0;

        for (int i=0; i<m; i++) stuff += value/arr[i];
        // System.out.print("stuff : ");
        // System.out.println(stuff);
        return stuff;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n개의 물건을 m개의 통로를 통해 통과 -> n개의 물건을 모두 통과시키는데 걸리는 최소시간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[m];
        int max_time = 0;

        for (int i=0; i<m; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i]>max_time) max_time = arr[i];
        }

        long st = 0;
        // long end = Long.MAX_VALUE-1;
        long end = n*max_time;
        // long end = 25;
        long ans = Long.MAX_VALUE; 
        // long ans = 25;

        while(st<=end){
            long mid = (st+end)/2;
            // System.out.println(mid);
            if (howMuch(mid)>=n){
                end = mid-1;
                ans = Math.min(ans,mid);

            }else{
                st = mid+1;
            }

        }

        System.out.println(ans);

    }
}