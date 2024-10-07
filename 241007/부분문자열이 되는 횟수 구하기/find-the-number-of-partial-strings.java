import java.io.*;
import java.util.*;


public class Main {
    
    public static String[] As;

    public static boolean IsBoobun(String A, String B){
        // A랑 B를 비교해서 B가 A의 부분문자열인지 확인
        int bOrder = 0;
        int bLength = B.length();
        for (int i=0; i<A.length(); i++){
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

        As = new String[A.length()+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        As[0] = A;

        for (int i=0; i<A.length(); i++){
            int removeIdx = Integer.parseInt(stk.nextToken())-1;
            A = A.substring(0,removeIdx)+"*"+A.substring(removeIdx+1);
            As[i+1] = A;
        }

        int st = 0;
        int end = A.length();
        int ans = 0;

        while (st<=end){
            int mid = (st+end)/2;
            if (IsBoobun(As[mid],B)){
                st = mid+1;
                ans = Math.max(ans, mid);
            } else{
                end = mid-1;
            }
        }

        System.out.println(ans+1);

    }
}