package ru.test.graph.builders;

import ru.test.graph.UndirectedEdge;

public interface EdgeBuilder<VERTEX> {

    EdgeBuilder<VERTEX> withV1(VERTEX v1);
    EdgeBuilder<VERTEX> withV2(VERTEX v2);
    UndirectedEdge<VERTEX> build();

}
