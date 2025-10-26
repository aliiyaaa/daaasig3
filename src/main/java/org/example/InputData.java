package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class InputData {
    @JsonProperty("graphs")
    private List<Graph> graphs;
    
    public InputData() {}
    
    public InputData(List<Graph> graphs) {
        this.graphs = graphs;
    }
    
    public List<Graph> getGraphs() {
        return graphs;
    }
    
    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }
}
