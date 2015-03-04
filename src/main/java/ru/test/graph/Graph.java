package ru.test.graph;

import ru.test.graph.builders.GraphBuilder;
import ru.test.graph.strategies.AdjacencyDetector;

import java.util.*;

public class Graph<VERTEX> {

    //Set???
    private Set<VERTEX> vertices;

    //Set???
    private Set<Edge<VERTEX>> edges;
    private Map<VERTEX, List<Edge<VERTEX>>> vertexToListMap = new HashMap<VERTEX, List<Edge<VERTEX>>>();

    private AdjacencyDetector adjacencyDetector;

    private Graph() {
        vertices = new HashSet<VERTEX>();
        edges = new HashSet<Edge<VERTEX>>();
    }

    public void addVertex(VERTEX vertex) {
        if (vertices.contains(vertex)) {
            //??????
        }
        vertices.add(vertex);
    }

    public void addEdge(Edge<VERTEX> edge) {
        if (edges.contains(edge)) {
            //???????
        }
        edges.add(edge);

        List<Edge<VERTEX>> list = vertexToListMap.get(edge.getV1());
        if (list == null) {
            list = new ArrayList<Edge<VERTEX>>();
            vertexToListMap.put(edge.getV1(), list);
        }
        list.add(edge);
    }

    public List<Edge<VERTEX>> findEdges(VERTEX vertex) {
        return vertexToListMap.get(vertex);
    }

    public Set<Edge<VERTEX>> getEdges() {
        return Collections.unmodifiableSet(new HashSet<UndirectedEdge<VERTEX>>(edges));
    }

}
