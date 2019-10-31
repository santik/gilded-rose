package com.gildedrose.itemhandler;

import com.gildedrose.typeditems.TypedItem;

public interface TypedItemHandler<T extends TypedItem> {
    void handle(T item);
}
