import java.io.*;
import java.util.*;


class Point implements Comparable<Point>{
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}

class PointY implements Comparable<PointY>{
    int x,y;

    public PointY(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(PointY p){
        return this.y - p.y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());

        Point[] points = new Point[n];
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        Arrays.sort(points);

        int i=0;
        int j=1;

        TreeSet<PointY> current = new TreeSet<>();

        PointY pointI = new PointY(points[0].x, points[0].y);
        PointY pointJ = new PointY(points[1].x, points[1].y);
        current.add(pointI);
        current.add(pointJ);
        PointY[] pointsY = new PointY[n];
        pointsY[0] = pointI;
        pointsY[1] = pointJ;


        int ans = (int)Math.pow(10,6);

        while (j<n){
            int l = Math.abs( current.last().y - current.first().y);
            
            if (l<d){
                j++;
                if (j==n) break;
                pointsY[j] = new PointY(points[j].x,points[j].y);
                current.add(pointsY[j]);

            } else{
                int part = l;

                while (i<j && part >= d){
                    ans = Math.min(ans, Math.abs(current.last().x-current.first().x));
                    current.remove(pointsY[i]);
                    i++;
                    part = Math.abs(current.last().y - current.first().y);
                }
            }

        }

        System.out.println(ans==(int)Math.pow(10,6)?-1:ans);

    }
}