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
        if(this.y != p.y) return this.y - p.y;
        return this.x - p.x;
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

        int j=0;

        TreeSet<PointY> current = new TreeSet<>();
        PointY[] pointsY = new PointY[n];

        for (int i=0; i<n; i++){
            pointsY[i] = new PointY(points[i].x, points[i].y);

        }

        int ans = (int)Math.pow(10,6);

        current.add(pointsY[0]);

        for (int i=0; i<n; i++){
            while (j+1<n && current.last().y - current.first().y<d){
                current.add(pointsY[j+1]);
                j++;
            }
            
            if (current.last().y - current.first().y<d){
                break;

            } 

            ans = Math.min(ans, pointsY[j].x - pointsY[i].x);
            current.remove(pointsY[i]);
        }


        // for (int st=0;st<n-1;st++){
        //     for (int end=st+1; end<n; end++){
        //         if (points[end].x - points[st].x == 3070 && Math.abs(points[end].y - points[st].y)>=d){ System.out.println(points[end].x+" "+points[end].y + " " + points[st].x + " " + points[st].y);
        //         System.out.println(end+" "+st);}

        //     }
        // }

        System.out.println(ans==(int)Math.pow(10,6)?-1:ans);

    }
}