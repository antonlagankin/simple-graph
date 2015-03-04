package ru.test.graph;

import java.util.*;

public class DeepFirstSearch<VERTEX> {

    private Set<VERTEX> visited = new HashSet<VERTEX>();

    public List<VERTEX> find(VERTEX from, VERTEX to, Graph<VERTEX> graph) {
        List<UndirectedEdge<VERTEX>> fromEdges = graph.findEdges(from);

        if (fromEdges == null || fromEdges.isEmpty()) {
            return Collections.emptyList();
        }
        visited.clear();
        visited.add(from);

        List<VERTEX> list = visit(from, to, graph, fromEdges);
        if (!list.isEmpty()) {
            list.add(0, from);
        }
        return list;
    }

    private List<VERTEX> visit(VERTEX from, VERTEX to, Graph<VERTEX> graph, List<UndirectedEdge<VERTEX>> fromEdges) {

        for (UndirectedEdge<VERTEX> fromEdge : fromEdges) {
            if (to.equals(fromEdge.getV2())) {
                List<VERTEX> result = new LinkedList<VERTEX>();
                result.add(fromEdge.getV2());
                return result;
            }

            if (!visited.contains(fromEdge.getV2())) {
                visited.add(fromEdge.getV1());
                List<UndirectedEdge<VERTEX>> foundEdges = graph.findEdges(fromEdge.getV2());
                if (foundEdges != null && !foundEdges.isEmpty()) {
                    List<VERTEX> list = visit(from, to, graph, graph.findEdges(fromEdge.getV2()));
                    if (!list.isEmpty()) {
                        list.add(0, fromEdge.getV2());
                        return list;
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
