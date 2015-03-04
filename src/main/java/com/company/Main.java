package com.company;

import ru.test.graph.DeepFirstSearch;
import ru.test.graph.UndirectedEdge;
import ru.test.graph.Graph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph = Graph.<String>getDirectedGraphBuilder().build();

        String vA = "A";
        String vB = "B";
        String vC = "C";
        String vD = "D";
        UndirectedEdge<String> edgeAB = new UndirectedEdge<String>(vA, vB);
        UndirectedEdge<String> edgeBC = new UndirectedEdge<String>(vB, vC);
        UndirectedEdge<String> edgeBD = new UndirectedEdge<String>(vB, vD);

        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);
        graph.addVertex(vD);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeBC);
        graph.addEdge(edgeBD);

        DeepFirstSearch<String> search = new DeepFirstSearch<String>();
        List<String> res = search.find(vA, vD, graph);

        System.out.println(res);
    }
}
