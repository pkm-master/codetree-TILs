import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment>{
    int s,e,color, y;
    public Segment(int s, int e, int color, int y){
        this.s = s;
        this.e = e;
        this.color = color;
        this.y = y;
    }

    @Override
    public int compareTo(Segment s){
        return this.y - s.y;
    }

}

class Point implements Comparable<Point>{
    int x,idx;
    boolean isSt;

    public Point(int x, int idx, boolean isSt){
        this.x = x;
        this.idx = idx;
        this.isSt = isSt;
    }

    @Override
    public int compareTo(Point p){
        return this.x-p.x;
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Segment[] Lines = new Segment[n];
        PriorityQueue<Point> points = new PriorityQueue<Point>();
        
        for(int i=0; i<n; i++ ){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            Lines[i] = new Segment(s,e,i,y);
            points.add(new Point(s,i,true));
            points.add(new Point(e,i,false));
        }

        TreeSet<Segment> currLines = new TreeSet<>();
        HashSet<Integer> colors = new HashSet<>();

        while (!points.isEmpty()){
            Point curr = points.poll();
            if (curr.isSt){
                currLines.add(Lines[curr.idx]);
            } else{
                currLines.remove(Lines[curr.idx]);
            }
            if (!currLines.isEmpty()) colors.add(currLines.first().color);

        }

        System.out.println(colors.size());

    }
}