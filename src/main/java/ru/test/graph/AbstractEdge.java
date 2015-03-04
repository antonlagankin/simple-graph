package ru.test.graph;

public abstract class AbstractEdge<VERTEX> implements Edge<VERTEX> {

    private VERTEX v1;
    private VERTEX v2;

    public AbstractEdge(VERTEX v1, VERTEX v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public VERTEX getV1() {
        return v1;
    }

    public VERTEX getV2() {
        return v2;
    }

    public abstract boolean isBetween(VERTEX v1, VERTEX v2);

}
