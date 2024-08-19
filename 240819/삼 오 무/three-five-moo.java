import java.io.*;
import java.util.*;

public class Main {

    public static long where(long value){
        return value - (value/3) - (value/5) + (value/15);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        long st = 1;
        long end = Long.MAX_VALUE;

        while (st<=end){
            long mid = (st+end)/2;

            if (where(mid) == n && mid %3 != 0 && mid % 5 != 0){
                System.out.println(mid);
                break;

            } else if (where(mid) >= n){
                end = mid-1;
            } else{
                st = mid+1;
            }
        }


    }
}