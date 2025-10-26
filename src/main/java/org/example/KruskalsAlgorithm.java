package org.example;

import java.util.*;

// Kruskal's algorithm for finding MST
public class KruskalsAlgorithm {
    
    // Class to store MST results
    public static class MSTData {
        public List<Edge> mstEdges;
        public int totalCost;
        public int operationsCount;
        
        public MSTData(List<Edge> mstEdges, int totalCost, int operationsCount) {
            this.mstEdges = mstEdges;
            this.totalCost = totalCost;
            this.operationsCount = operationsCount;
        }
    }
    
    // Main Kruskal's algorithm method
    public static MSTData findMST(Graph graph) {
        List<Edge> mstEdges = new ArrayList<>();
        int operationsCount = 0;
        
        // Sort edges by weight
        List<Edge> sortedEdges = new ArrayList<>(graph.getEdges());
        Collections.sort(sortedEdges, new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                return Integer.compare(a.getWeight(), b.getWeight());
            }
        });
        operationsCount += graph.getEdges().size() * (int)(Math.log(graph.getEdges().size()) / Math.log(2));
        
        // Make Union-Find
        UnionFind uf = new UnionFind();
        for (String node : graph.getNodes()) {
            uf.makeSet(node);
            operationsCount++;
        }
        operationsCount += uf.getOperationsCount();
        
        // Main algorithm loop
        for (Edge edge : sortedEdges) {
            operationsCount++;
            
            if (uf.union(edge.getFrom(), edge.getTo())) {
                mstEdges.add(edge);
                operationsCount++;
                
                // Check if we have enough edges
                if (mstEdges.size() == graph.getNodes().size() - 1) {
                    operationsCount++;
                    break;
                }
            }
            operationsCount += uf.getOperationsCount();
        }
        
        // Calculate total cost
        int totalCost = 0;
        for (Edge edge : mstEdges) {
            totalCost += edge.getWeight();
            operationsCount++;
        }
        
        return new MSTData(mstEdges, totalCost, operationsCount);
    }
}
