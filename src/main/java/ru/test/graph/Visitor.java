package ru.test.graph;

public interface Visitor<VERTEX> {

    void visit(UndirectedEdge<VERTEX> edge);

}
