package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Main class for Assignment 3 - MST algorithms
public class Main {
    public static void main(String[] args) {
        try {
            // Read the input file
            InputData inputData = JsonProcessor.readInputData("ass_3_input.json");
            List<GraphResult> results = new ArrayList<>();
            
            System.out.println("Starting MST algorithms...");
            System.out.println("Number of graphs: " + inputData.getGraphs().size());
            System.out.println();
            
            // Process each graph
            for (Graph graph : inputData.getGraphs()) {
                System.out.println("Graph " + graph.getId() + ":");
                System.out.println("Nodes: " + graph.getVertexCount());
                System.out.println("Edges: " + graph.getEdgeCount());
                
                // Run Prim's algorithm
                long start = System.nanoTime();
                PrimsAlgorithm.MSTData primResult = PrimsAlgorithm.findMST(graph);
                long end = System.nanoTime();
                double primTime = (end - start) / 1000000.0; // Convert to ms
                
                // Run Kruskal's algorithm
                start = System.nanoTime();
                KruskalsAlgorithm.MSTData kruskalResult = KruskalsAlgorithm.findMST(graph);
                end = System.nanoTime();
                double kruskalTime = (end - start) / 1000000.0; // Convert to ms
                
                // Make result objects
                MSTResult primMST = new MSTResult(
                    primResult.mstEdges,
                    primResult.totalCost,
                    primResult.operationsCount,
                    primTime
                );
                
                MSTResult kruskalMST = new MSTResult(
                    kruskalResult.mstEdges,
                    kruskalResult.totalCost,
                    kruskalResult.operationsCount,
                    kruskalTime
                );
                
                // Make input stats
                InputStats inputStats = new InputStats(graph.getVertexCount(), graph.getEdgeCount());
                
                // Add to results
                GraphResult graphResult = new GraphResult(graph.getId(), inputStats, primMST, kruskalMST);
                results.add(graphResult);
                
                // Print results
                System.out.println("Prim's Algorithm:");
                System.out.println("  Cost: " + primResult.totalCost);
                System.out.println("  Operations: " + primResult.operationsCount);
                System.out.println("  Time: " + String.format("%.2f", primTime) + " ms");
                System.out.println("  Edges: " + primResult.mstEdges);
                
                System.out.println("Kruskal's Algorithm:");
                System.out.println("  Cost: " + kruskalResult.totalCost);
                System.out.println("  Operations: " + kruskalResult.operationsCount);
                System.out.println("  Time: " + String.format("%.2f", kruskalTime) + " ms");
                System.out.println("  Edges: " + kruskalResult.mstEdges);
                
                // Check if results are the same
                if (primResult.totalCost == kruskalResult.totalCost) {
                    System.out.println("Both algorithms found same cost!");
                } else {
                    System.out.println("ERROR: Different costs found!");
                }
                
                System.out.println();
            }
            
            // Write output file
            OutputData outputData = new OutputData(results);
            JsonProcessor.writeOutputData(outputData, "ass_3_output.json");
            
            System.out.println("Output written to ass_3_output.json");
            
            // Print summary
            System.out.println("\nSummary:");
            for (GraphResult result : results) {
                System.out.println("Graph " + result.getGraphId() + ":");
                System.out.println("  Prim: " + result.getPrim().getOperationsCount() + " ops, " + 
                    String.format("%.2f", result.getPrim().getExecutionTimeMs()) + " ms");
                System.out.println("  Kruskal: " + result.getKruskal().getOperationsCount() + " ops, " + 
                    String.format("%.2f", result.getKruskal().getExecutionTimeMs()) + " ms");
                
                if (result.getPrim().getExecutionTimeMs() < result.getKruskal().getExecutionTimeMs()) {
                    System.out.println("  Prim was faster");
                } else {
                    System.out.println("  Kruskal was faster");
                }
            }
            
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}