import java.io.*;
import java.util.*;

public class Main {

    public static int where(int value){
        return value - (value/3) - (value/5) + (value/15);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int st = 1;
        int end = 1000000000;

        while (st<=end){
            int mid = (st+end)/2;

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