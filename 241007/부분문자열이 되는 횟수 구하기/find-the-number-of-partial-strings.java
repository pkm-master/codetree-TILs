import java.io.*;
import java.util.*;


public class Main {
    
    public static int[] del;
    public static boolean[] skip;

    public static boolean IsBoobun(String A, String B, int mid){
        // A랑 B를 비교해서 B가 A의 부분문자열인지 확인
        
        int bOrder = 0;
        int bLength = B.length();

        for (int i=1; i<=mid; i++){
            skip[del[i]-1] = true;
        }


        for (int i=0; i<A.length(); i++){
            if (skip[i]) continue;

            if (B.charAt(bOrder)==A.charAt(i)){
                bOrder++;
            }
            if (bOrder == bLength){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        del = new int[A.length()+1];
        skip = new boolean[A.length()+1];

        for (int i=1; i<= A.length(); i++){
            del[i] = Integer.parseInt(stk.nextToken());

        }

        int st = 0;
        int end = A.length();
        int ans = 0;

        
        while (st<=end){
            int mid = (st+end)/2;
            if (IsBoobun(A,B, mid)){
                st = mid+1;
                ans = Math.max(ans, mid);
            } else{
                end = mid-1;
            }

            for (int i=1; i<=mid; i++){
                skip[del[i]-1] = false;
            }
        }

        System.out.println(ans+1);

    }
}