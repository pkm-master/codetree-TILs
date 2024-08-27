import java.io.*;
import java.util.*;

class StringNumber implements Comparable<StringNumber>{
    String x;

    public StringNumber(String x){
        this.x = x;
    }

    @Override
    public int compareTo(StringNumber s){
        if (Long.parseLong(s.x+this.x) < Long.parseLong(this.x+s.x)) return 1;
        else return -1;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<StringNumber> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<n; i++){
            q.add(new StringNumber(br.readLine()));
        }

        while (!q.isEmpty()){
            System.out.print(q.poll().x);
        }

    }
}