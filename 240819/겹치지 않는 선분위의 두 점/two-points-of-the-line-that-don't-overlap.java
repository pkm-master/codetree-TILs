import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    long x;
    boolean isSt;
    public Point(long x, boolean isSt){
        this.x = x;
        this.isSt = isSt;
    }

    @Override
    public int compareTo(Point p){
        if (this.x > p.x) return 1;
        else if (this.x == p.x && this.isSt) return 1;
        else return -1;
    }
}
public class Main {
    public static int n,m;
    public static TreeSet<Point> set;
    public static long max_end;

    public static boolean is_possible(long value){
        // 거리가 value이상이면 점을 두고, 그렇게 해서 둔 점의 개수가 n개 이상이면 true
        Point start = set.first();
        long destination = 0;
        long curr = start.x;
        int stuff = 0;

        while (destination<=max_end){
            destination = curr + value;
            Point dest = set.floor(new Point(destination,true));

            if (dest.isSt){
                curr = destination;
                stuff ++;

            }else {
                dest = set.ceiling(new Point(destination,false));
                if (dest != null){
                    curr = dest.x;
                    stuff ++;
                } else{
                    break;
                }
            }
        }

        if (stuff >= n ) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        set = new TreeSet<Point>();

        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            long st = Long.parseLong(stk.nextToken());
            long end = Long.parseLong(stk.nextToken());
            max_end = Math.max(max_end,end);
            set.add(new Point(st,true));
            set.add(new Point(end,false));

        }

        long st = 1;
        long end = (long)Math.pow(10,18);
        long ans = 0;

        while (st<=end){
            long mid = (st+end)/2;
            if (is_possible(mid)){
                st = mid+1;
                ans = Math.max(ans,mid);
            } else{
                end = mid-1;
            }
        }

        System.out.println(ans);    
    }
}