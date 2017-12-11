package graph;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    public String name;
    public List<Edge> edges;
    public boolean visited;
    
    private Node(){};
    
    public Node(String name){
        this.name=name;
        this.edges=new ArrayList<>();
    }
    
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
    
    public List<Node> getNeibours(){
//        return this.edges.stream().
        return null;
    }
}
