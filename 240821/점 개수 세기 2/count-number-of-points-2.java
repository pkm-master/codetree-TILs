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
        if (p.x != this.x) return this.x - p.x;
        else return this.y - p.y;
    }
}

public class Main {
    public static int n,q;
    public static TreeSet<Point> points;
    public static ArrayList<Point> pointsArr;
    
    public static int count(int x1, int y1, int x2, int y2){
        // x1,y1보다는 큰데 x2,y2보다는 작은 범위에 있는 애들 긁어다
        // y가 y1보다 크고 y2보다 작은애들 세서 반환
        Point stStandard = new Point(x1,y1);
        Point endStandard = new Point(x2,y2);
        Point st,end;


        if (points.ceiling(stStandard) != null ) st = points.ceiling(new Point(x1,y1));
        else return 0;

        if (points.floor(endStandard) != null ) end = points.floor(endStandard);
        else return 0;
        
        int stIndex = pointsArr.indexOf(st);
        int endIndex = pointsArr.indexOf(end);

        int cnt = 0;
        for (int i=stIndex; i<=endIndex; i++){
            Point curr = pointsArr.get(i);
            if (curr.y >= y1 && curr.y <= y2) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        points = new TreeSet<>();
        

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));

        }

        pointsArr = new ArrayList<>(points);
    
        for (int i=0; i<q; i++){
            stk = new StringTokenizer(br.readLine());
            System.out.println(count(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())));
        }

    }
}