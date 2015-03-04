package ru.test.graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeepFirstSearchDirectedGraphTest {

    @Test
    public void simpleTwoNodesTest() {

        String vA = "A";
        String vB = "B";
        UndirectedEdge<String> edgeAB = new UndirectedEdge<String>(vA, vB);

        Graph<String> graph = Graph.<String>getDirectedGraphBuilder().build();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addEdge(edgeAB);

        DeepFirstSearch<String> search = new DeepFirstSearch<String>();
        List<String> result = search.find(vA, vB, graph);

        assertTrue(vA.equals(result.get(0)));
        assertTrue(vB.equals(result.get(1)));

    }

    @Test
    public void simpleFreeNodesChainTest() {
        String vA = "A";
        String vB = "B";
        String vC = "C";

        UndirectedEdge<String> edgeAB = new UndirectedEdge<String>(vA, vB);
        UndirectedEdge<String> edgeBC = new UndirectedEdge<String>(vB, vC);

        Graph<String> graph = Graph.<String>getDirectedGraphBuilder().build();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeBC);

        DeepFirstSearch<String> search = new DeepFirstSearch<String>();
        List<String> result = search.find(vA, vC, graph);

        assertTrue(vA.equals(result.get(0)));
        assertTrue(vB.equals(result.get(1)));
        assertTrue(vC.equals(result.get(2)));
    }

    @Test
    public void simpleFourNodesTest() {
        String vA = "A";
        String vB = "B";
        String vC = "C";
        String vD = "D";

        UndirectedEdge<String> edgeAB = new UndirectedEdge<String>(vA, vB);
        UndirectedEdge<String> edgeBC = new UndirectedEdge<String>(vB, vC);
        UndirectedEdge<String> edgeBD = new UndirectedEdge<String>(vB, vD);

        Graph<String> graph = Graph.<String>getDirectedGraphBuilder().build();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);
        graph.addVertex(vD);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeBC);
        graph.addEdge(edgeBD);

        DeepFirstSearch<String> search = new DeepFirstSearch<String>();
        List<String> result = search.find(vA, vD, graph);

        assertTrue(vA.equals(result.get(0)));
        assertTrue(vB.equals(result.get(1)));
        assertTrue(vD.equals(result.get(2)));
    }

    @Test
    public void shouldFindPathInGraphWithCycleTargetNodeNotInCycle() {
        String vA = "A";
        String vB = "B";
        String vC = "C";
        String vD = "D";
        String vE = "E";

        UndirectedEdge<String> edgeAB = new UndirectedEdge<String>(vA, vB);
        UndirectedEdge<String> edgeBC = new UndirectedEdge<String>(vB, vC);
        UndirectedEdge<String> edgeCD = new UndirectedEdge<String>(vC, vD);
        UndirectedEdge<String> edgeDB = new UndirectedEdge<String>(vD, vB);
        UndirectedEdge<String> edgeBE = new UndirectedEdge<String>(vB, vE);

        Graph<String> graph = Graph.<String>getDirectedGraphBuilder().build();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);
        graph.addVertex(vD);
        graph.addVertex(vE);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeBC);
        graph.addEdge(edgeCD);
        graph.addEdge(edgeDB);
        graph.addEdge(edgeBE);

        DeepFirstSearch<String> search = new DeepFirstSearch<String>();
        List<String> result = search.find(vA, vE, graph);
        assertEquals(vA, result.get(0));
        assertEquals(vB, result.get(1));
        assertEquals(vE, result.get(2));
    }

}
