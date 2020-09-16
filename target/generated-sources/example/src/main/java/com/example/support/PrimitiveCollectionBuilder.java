package com.example.support;

import java.util.*;
import java.util.function.Consumer;

public class PrimitiveCollectionBuilder<V> {
    protected Collection<V> collection;
    protected  Consumer<V> consumer;

    public PrimitiveCollectionBuilder(Collection<V> collection, Consumer<V> consumer) {
        this.collection = collection;
        this.consumer = consumer;
    }
}