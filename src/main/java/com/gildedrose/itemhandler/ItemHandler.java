package com.gildedrose.itemhandler;

import com.gildedrose.Item;

public interface ItemHandler<T extends Item> {
    T handle(T item);
}
