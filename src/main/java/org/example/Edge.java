package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

// Edge class for graph edges
public class Edge {
    @JsonProperty("from")
    private String from;
    
    @JsonProperty("to")
    private String to;
    
    @JsonProperty("weight")
    private int weight;
    
    public Edge() {}
    
    public Edge(String from, String to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Edge{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", weight=" + weight +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return weight == edge.weight &&
                ((from.equals(edge.from) && to.equals(edge.to)) ||
                 (from.equals(edge.to) && to.equals(edge.from)));
    }
    
    @Override
    public int hashCode() {
        // Make sure edges are considered equal regardless of direction
        String smaller = from.compareTo(to) < 0 ? from : to;
        String larger = from.compareTo(to) < 0 ? to : from;
        return (smaller + larger).hashCode() + weight;
    }
}
