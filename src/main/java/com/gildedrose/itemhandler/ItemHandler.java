package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.items.TypedItem;
import com.gildedrose.items.TypedItemFactory;

public class ItemHandler {

    private ItemHandlerProvider itemHandlerProvider = new ItemHandlerProvider();

    public void handle(Item item) {
        TypedItem decoratedItem = TypedItemFactory.getTypedItem(item);
        itemHandlerProvider.provide(decoratedItem).handle(decoratedItem);
    }
}
