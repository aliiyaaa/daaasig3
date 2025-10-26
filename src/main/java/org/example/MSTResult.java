package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MSTResult {
    @JsonProperty("mst_edges")
    private List<Edge> mstEdges;
    
    @JsonProperty("total_cost")
    private int totalCost;
    
    @JsonProperty("operations_count")
    private int operationsCount;
    
    @JsonProperty("execution_time_ms")
    private double executionTimeMs;
    
    public MSTResult() {}
    
    public MSTResult(List<Edge> mstEdges, int totalCost, int operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
    }
    
    public List<Edge> getMstEdges() {
        return mstEdges;
    }
    
    public void setMstEdges(List<Edge> mstEdges) {
        this.mstEdges = mstEdges;
    }
    
    public int getTotalCost() {
        return totalCost;
    }
    
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
    
    public int getOperationsCount() {
        return operationsCount;
    }
    
    public void setOperationsCount(int operationsCount) {
        this.operationsCount = operationsCount;
    }
    
    public double getExecutionTimeMs() {
        return executionTimeMs;
    }
    
    public void setExecutionTimeMs(double executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }
}
