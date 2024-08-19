import java.io.*;
import java.util.*;

class Period{
    int min, max, isValid;
    public Period(int min, int max, int isValid){
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}


public class Main {
    public static int n;

    public static Period where(int value){

        int min_value = 1;
        int additional = 0;
        for (int i=1; i<=n; i++){
            int max_j = Math.min(value/i,n);

            min_value += max_j;
            if(max_j * i == value){
                min_value-=1;
                additional+=1;
            }
        }
        if (additional == 0) return new Period(min_value,min_value,-1);

        return new Period(min_value, min_value+additional-1,1);

    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // A[i][j] = i*j
        // k번째로 오는 수 
        // 배열의 인덱스는 1부터 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int st = 1;
        int end = (int)Math.pow(n,2);

        while (st<=end){
            int mid = (st+end)/2;
            // System.out.println(mid);
            Period p = where(mid);
            if (p.isValid != -1 && p.min<=k && p.max>=k){
                System.out.println(mid);
                break;
            } else if (p.max <= k ){
                st = mid + 1;
            } else{
                end = mid - 1;
            }

        }

        
    }
}