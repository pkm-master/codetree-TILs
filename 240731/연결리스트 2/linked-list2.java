import java.io.*;
import java.util.*;

class Node{
    int id;
    Node prev,next;

    public Node(int id){
        this.id = id;
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

    public void delete(){
        if (this.prev != null) this.prev.next = this.next;
        if (this.next != null) this.next.prev = this.prev;
        this.prev = null;
        this.next = null;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        HashMap<Integer, Node> hash = new HashMap<>();

        for (int i=1 ; i<=n ; i++){
            hash.put(i,new Node(i));
        }

        for (int i=0 ; i<q ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(stk.nextToken());
            int nodeI = Integer.parseInt(stk.nextToken());

            if (method == 1 ){
                hash.get(nodeI).delete();
            } else if (method == 2){
                int nodeJ = Integer.parseInt(stk.nextToken());
                hash.get(nodeI).insertprev(hash.get(nodeJ));

            } else if (method == 3){
                int nodeJ = Integer.parseInt(stk.nextToken());
                hash.get(nodeI).insertback(hash.get(nodeJ));
                
            }else {
                System.out.print(hash.get(nodeI).prev != null ? hash.get(nodeI).prev.id : 0 );
                System.out.print(" ");
                System.out.println(hash.get(nodeI).next != null ? hash.get(nodeI).next.id : 0 );
            }
        }

        for (int i=1 ; i<=n ; i++){
                System.out.print(hash.get(i).next != null ? hash.get(i).next.id : 0 );
                System.out.print(" ");

        }
    }
}