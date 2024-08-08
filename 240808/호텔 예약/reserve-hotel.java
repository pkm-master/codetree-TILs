import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, index, isStart;
    public Point(int x, int index, int isStart){
        this.x=x;
        this.index=index;
        this.isStart=isStart;
    }

    @Override
    public int compareTo(Point p){
        if (this.x > p.x){
            return 1;
        }else if(this.x == p.x && this.isStart < p.isStart ){
            return 1;
        } else{
            return -1;
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 최대로 겹치는 어찌구의 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            points.add(new Point(s,i,1));
            points.add(new Point(e,i,-1));

        }

        Collections.sort(points);

        int sums = 0;
        int max_value = 0;

        for (int i=0; i<points.size(); i++){
            int point = points.get(i).x;
            sums += points.get(i).isStart;
            if (max_value<sums){
                max_value=sums;
            }
        }

        System.out.println(max_value);
        
    }
}