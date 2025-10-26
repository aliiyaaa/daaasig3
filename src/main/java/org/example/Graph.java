package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Graph class to represent the transportation network
public class Graph {
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("nodes")
    private List<String> nodes;
    
    @JsonProperty("edges")
    private List<Edge> edges;
    
    public Graph() {}
    
    public Graph(int id, List<String> nodes, List<Edge> edges) {
        this.id = id;
        this.nodes = nodes;
        this.edges = edges;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<String> getNodes() {
        return nodes;
    }
    
    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
    
    public List<Edge> getEdges() {
        return edges;
    }
    
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
    
    public int getVertexCount() {
        return nodes.size();
    }
    
    public int getEdgeCount() {
        return edges.size();
    }
}
