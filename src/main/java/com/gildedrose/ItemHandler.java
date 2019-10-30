package com.gildedrose;

public interface ItemHandler<T extends Item> {
    T handle(T item);
}
