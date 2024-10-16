import java.io.*;
import java.util.*;

public class Main {
    public static int[] result;
    public static HashSet<Long> numbers = new HashSet<>();
    public static int n;
    public static boolean isBeautiful(int[] result){
        int repeat = 1;
        for (int i=1; i<n; i++){
            if (result[i] == result[i-1]){
                repeat++;
                if (repeat == result[i]){
                    repeat = 0;
                }
            } else{
                if (repeat % result[i-1] != 0) return false;
                repeat = 1;
            }
        }
        if (repeat % result[n-1] != 0 ) return false;
        return true;
    }
    public static void select(int idx){
        if (idx==n){
            long value = 0;
            for (int i=0; i<n; i++){
                value += result[i]*Math.pow(10,n-i-1);
            }
            if (isBeautiful(result)){
                numbers.add(value);
            }
        } else{
            for (int i=1; i<=4; i++){
                result[idx] = i;
                select(idx+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 1이상 4이하의 숫자로만 이루어져있으면서, 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자
        // 1333221
        result = new int[n];
        select(0);
        System.out.println(numbers.size());
        
    }
}