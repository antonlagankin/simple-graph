package ru.test.graph.builders;

import ru.test.graph.Graph;

public interface GraphBuilder<VERTEX> {
    Graph<VERTEX> build();
}
