package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphResult {
    @JsonProperty("graph_id")
    private int graphId;
    
    @JsonProperty("input_stats")
    private InputStats inputStats;
    
    @JsonProperty("prim")
    private MSTResult prim;
    
    @JsonProperty("kruskal")
    private MSTResult kruskal;
    
    public GraphResult() {}
    
    public GraphResult(int graphId, InputStats inputStats, MSTResult prim, MSTResult kruskal) {
        this.graphId = graphId;
        this.inputStats = inputStats;
        this.prim = prim;
        this.kruskal = kruskal;
    }
    
    public int getGraphId() {
        return graphId;
    }
    
    public void setGraphId(int graphId) {
        this.graphId = graphId;
    }
    
    public InputStats getInputStats() {
        return inputStats;
    }
    
    public void setInputStats(InputStats inputStats) {
        this.inputStats = inputStats;
    }
    
    public MSTResult getPrim() {
        return prim;
    }
    
    public void setPrim(MSTResult prim) {
        this.prim = prim;
    }
    
    public MSTResult getKruskal() {
        return kruskal;
    }
    
    public void setKruskal(MSTResult kruskal) {
        this.kruskal = kruskal;
    }
}
