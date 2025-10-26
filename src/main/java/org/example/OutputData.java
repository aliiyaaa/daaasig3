package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class OutputData {
    @JsonProperty("results")
    private List<GraphResult> results;
    
    public OutputData() {}
    
    public OutputData(List<GraphResult> results) {
        this.results = results;
    }
    
    public List<GraphResult> getResults() {
        return results;
    }
    
    public void setResults(List<GraphResult> results) {
        this.results = results;
    }
}
