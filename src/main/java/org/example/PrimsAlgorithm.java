package org.example;

import java.util.*;

// Prim's algorithm for finding MST
public class PrimsAlgorithm {
    
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
    
    // Main Prim's algorithm method
    public static MSTData findMST(Graph graph) {
        List<Edge> mstEdges = new ArrayList<>();
        int operationsCount = 0;
        
        // Make adjacency list
        Map<String, List<Edge>> adjList = new HashMap<>();
        for (String node : graph.getNodes()) {
            adjList.put(node, new ArrayList<>());
            operationsCount++;
        }
        
        // Add edges to adjacency list
        for (Edge edge : graph.getEdges()) {
            adjList.get(edge.getFrom()).add(edge);
            adjList.get(edge.getTo()).add(edge);
            operationsCount += 2;
        }
        
        // Visited nodes and priority queue
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                return Integer.compare(a.getWeight(), b.getWeight());
            }
        });
        operationsCount += 2;
        
        // Start with first node
        String start = graph.getNodes().get(0);
        visited.add(start);
        operationsCount++;
        
        // Add edges from start node
        for (Edge edge : adjList.get(start)) {
            pq.add(edge);
            operationsCount++;
        }
        
        // Main algorithm loop
        while (!pq.isEmpty() && visited.size() < graph.getNodes().size()) {
            operationsCount++;
            
            Edge current = pq.poll();
            operationsCount++;
            
            String next = null;
            // Check if we can add this edge
            if (visited.contains(current.getFrom()) && !visited.contains(current.getTo())) {
                next = current.getTo();
                operationsCount += 2;
            } else if (visited.contains(current.getTo()) && !visited.contains(current.getFrom())) {
                next = current.getFrom();
                operationsCount += 2;
            }
            
            if (next != null) {
                visited.add(next);
                mstEdges.add(current);
                operationsCount += 2;
                
                // Add new edges to queue
                for (Edge edge : adjList.get(next)) {
                    if (!visited.contains(edge.getFrom()) || !visited.contains(edge.getTo())) {
                        pq.add(edge);
                        operationsCount += 2;
                    }
                }
            }
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
