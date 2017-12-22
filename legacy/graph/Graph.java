package graph;

import java.util.*;

public class Graph {
    public Set<Node> nodes;
    public int size;
    private Node start;
    
    void init () {
        Node A=new Node("A");
        Node B=new Node("B");
        Node C=new Node("C");
        Node D=new Node("D");
        Node E=new Node("E");
        Node F=new Node("F");
        Node G=new Node("G");
        
        A.addEdge(new Edge(A, B));
        B.addEdge(new Edge(B, D));
        B.addEdge(new Edge(B, C));
        B.addEdge(new Edge(B, E));
        C.addEdge(new Edge(C, E));
        D.addEdge(new Edge(D, G));
        E.addEdge(new Edge(D, E));
        E.addEdge(new Edge(E, F));
        
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
    }
    
    public void breadFirstSearch(Node startNode){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        while(queue.size()!=0) {
            Node node = queue.poll();
            
        }
    }
    
    public static void main(String[] args) {

    }

}
