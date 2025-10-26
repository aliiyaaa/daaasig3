package org.example;

import java.util.HashMap;
import java.util.Map;

// Simple Union-Find for Kruskal's algorithm
public class UnionFind {
    private Map<String, String> parent;
    private Map<String, Integer> rank;
    private int operationsCount;
    
    public UnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
        operationsCount = 0;
    }
    
    // Make a new set
    public void makeSet(String x) {
        parent.put(x, x);
        rank.put(x, 0);
        operationsCount += 2;
    }
    
    // Find root of x
    public String find(String x) {
        operationsCount++;
        if (!parent.get(x).equals(x)) {
            operationsCount++;
            parent.put(x, find(parent.get(x))); // Path compression
            operationsCount += 2;
        }
        operationsCount++;
        return parent.get(x);
    }
    
    // Union two sets
    public boolean union(String x, String y) {
        String rootX = find(x);
        String rootY = find(y);
        operationsCount += 2;
        
        if (rootX.equals(rootY)) {
            operationsCount++;
            return false; // Same set already
        }
        
        // Union by rank
        if (rank.get(rootX) < rank.get(rootY)) {
            parent.put(rootX, rootY);
            operationsCount += 2;
        } else if (rank.get(rootX) > rank.get(rootY)) {
            parent.put(rootY, rootX);
            operationsCount += 2;
        } else {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootX) + 1);
            operationsCount += 3;
        }
        
        return true;
    }
    
    public int getOperationsCount() {
        return operationsCount;
    }
}
