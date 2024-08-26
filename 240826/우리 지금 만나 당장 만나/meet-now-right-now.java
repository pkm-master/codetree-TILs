import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    long x;
    int st, idx;
    public Point(long x, int st, int idx){
        this.x = x;
        this.st = st;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p){
        if (this.x > p.x) return 1;
        else if (this.x < p.x) return -1;
        else return p.st-this.st;
    }
}

public class Main {
    public static int n;
    public static long possibleSt, possibleEnd;
    public static int[] xs,vs;

    public static boolean isPossible(int value){
        HashSet<Integer> lines = new HashSet<>();
        PriorityQueue<Point> points = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            points.add(new Point(xs[i]-vs[i]*value, 1, i));
            points.add(new Point(xs[i]+vs[i]*value, -1, i));
        }

        boolean possible = false;

        while (!points.isEmpty()){
            Point curr = points.poll();
            if(curr.st == -1){
                if (possible) possibleEnd = curr.x;
                break;
            }

            lines.add(curr.idx);
            if (lines.size() == n){ 
                possible = true;
                possibleSt = curr.x;
            }
        }
        if (possible) return true;
        return false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        xs = new int[n];
        vs = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) xs[i] = Integer.parseInt(stk.nextToken());
        
        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) vs[i] = Integer.parseInt(stk.nextToken());

        int st = 0;
        int end = (int)Math.pow(10,9);

        while (st<=end){
            int mid = (st+end)/2;
            if (isPossible(mid)){
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        
        double ans = Math.pow(10,9);
        for (long i=possibleSt; i<=possibleEnd; i++){
            double time = 0;
            for (int j=0; j<n; j++){
                time = Math.max(time, (double)Math.abs(i-xs[j])/vs[j] );
            }
            ans = Math.min(ans, time);
        }

        System.out.println(String.format("%.4f",ans));

    }
}