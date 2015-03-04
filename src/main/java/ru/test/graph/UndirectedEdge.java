package ru.test.graph;


public class UndirectedEdge<VERTEX> extends AbstractEdge<VERTEX> {

    public UndirectedEdge(VERTEX v1, VERTEX v2) {
        super(v1, v2);
    }

    @Override
    public boolean isBetween(VERTEX v1, VERTEX v2) {
        return (getV1().equals(v1) && getV2().equals(v2)) ||
                (getV1().equals(v2) && getV2().equals(v1));
    }

}
