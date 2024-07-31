import java.io.*;
import java.util.*;

class Node{
    String data;
    Node prev,next;

    public Node(String data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public void insertprev(Node node){
        if (this.prev != null ) this.prev.next = node;
        node.prev = this.prev;

        this.prev = node;
        node.next = this;

    }

    public void insertback(Node node){
        if (this.next != null) this.next.prev = node;
        node.next = this.next;

        this.next = node;
        node.prev = this;
        
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s_init = br.readLine();
        Node curr = new Node(s_init);

        int n = Integer.parseInt(br.readLine());

        for (int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();
            if (method.equals("1")){
                String value = stk.nextToken();
                curr.insertprev(new Node(value));
                
            }else if (method.equals("2")){
                String value = stk.nextToken();
                curr.insertback(new Node(value));


            }else if (method.equals("3")){
                if (curr.prev != null) curr = curr.prev;
            }else if (method.equals("4")){
                if (curr.next != null) curr = curr.next;
            }

            System.out.print( curr.prev != null ? curr.prev.data + " " : "(Null) ");
            System.out.print( curr.data + " " );
            System.out.println( curr.next != null ? curr.next.data : "(Null)" );

        }


    }
}