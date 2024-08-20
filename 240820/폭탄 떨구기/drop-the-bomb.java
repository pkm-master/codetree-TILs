import java.io.*;
import java.util.*;

public class Main {
    public static TreeSet<Integer> points;
    public static int n,k;

    public static boolean is_possible(int value){
        int curr = points.first();
        int b_num = 0;

        while (true){
            int st_drop = curr+value;
            b_num ++;
            if (b_num > k) return false;
            if (points.higher(st_drop+value) == null) return true;
            curr = points.higher(st_drop+value);
        }

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        points = new TreeSet<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        for (int i=0; i<n; i++){
            points.add(Integer.parseInt(br.readLine()));
        }

        int st = 0;
        int end = (int)Math.pow(10,9);
        int ans = end;


        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                end = mid-1;
                ans = Math.min(ans,mid);

            } else{
                st = mid+1;
            }
        }

        System.out.println(ans);

    
    }
}