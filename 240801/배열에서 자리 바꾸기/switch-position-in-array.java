import java.io.*;
import java.util.*;

class Node{
    int id;
    Node next,prev;

    public Node(int id){
        this.id = id;
        this.next = null;
        this.prev = null;
    }
}


public class Main {
    public static void connect (Node s, Node e){
        if (s!= null) s.next = e;
        if (e!= null) e.prev = s;
    }

    public static void disconnect (Node s, Node e){
        if (s!=null) s.next = null;
        if (e!=null) e.prev = null;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        
        Node[] node_arr = new Node[N+1];
        for (int i=1 ; i<=N ; i++){
            node_arr[i] = new Node(i);
            connect(node_arr[i-1], node_arr[i]);
        }

        for (int i=0 ; i<Q ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            if (node_arr[a].prev == node_arr[d]){
                Node tmp_after_b = node_arr[b].next;

                connect(node_arr[c].prev,node_arr[a]);
                connect(node_arr[b],node_arr[c]);
                connect(node_arr[d],tmp_after_b);

            }else if (node_arr[c].prev == node_arr[b]){
                Node tmp_after_d = node_arr[d].next;

                connect(node_arr[a].prev, node_arr[c]);
                connect(node_arr[d],node_arr[a]);
                connect(node_arr[b],tmp_after_d);

            }else{
                Node tmp_before_c = node_arr[c].prev;
                Node tmp_after_d = node_arr[d].next;

                connect(node_arr[a].prev, node_arr[c]);
                connect(node_arr[d], node_arr[b].next);
                connect(tmp_before_c, node_arr[a]);
                connect(node_arr[b],tmp_after_d);

            }
        }

        Node curr = node_arr[4];
        while (curr.prev != null){
            curr = curr.prev;
        }

        while (curr != null){
            System.out.print(curr.id + " ");
            curr = curr.next;
        }
    }
}