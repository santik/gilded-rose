package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.TypedItem;
import com.gildedrose.typeditems.TypedItemFactory;

public class ItemHandler {

    private TypedItemHandlerProvider<TypedItem> provider = new TypedItemHandlerProvider<>();

    public void handle(Item item) {
        TypedItem typedItem = TypedItemFactory.getTypedItem(item);
        TypedItemHandler<TypedItem> typedItemHandler = provider.provide(typedItem);
        typedItemHandler.handle(typedItem);
    }
}
