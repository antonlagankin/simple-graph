package ru.test.graph.strategies;

public interface AdjacencyDetector {

    <VERTEX> boolean isAdjacency(VERTEX v1, VERTEX v2);

}
