package com.gildedrose.typeditems;

import com.gildedrose.Item;

public abstract class TypedItem {

    protected Item item;

    public TypedItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
