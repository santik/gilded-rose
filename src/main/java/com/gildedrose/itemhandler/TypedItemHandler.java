package com.gildedrose.itemhandler;

import com.gildedrose.items.TypedItem;

public interface TypedItemHandler<T extends TypedItem> {
    void handle(T item);
}
