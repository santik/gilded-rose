package com.gildedrose.typeditems;

import com.gildedrose.Item;

public abstract class TypedItem {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    private Item item;

    public TypedItem(Item item) throws ValidationException {
        validate(item);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    protected void validate(Item item) throws ValidationException {
        if (item.quality > MAX_QUALITY || item.quality < MIN_QUALITY) {
            throw new ValidationException("Quality is invalid for the item " + item);
        }
    }
}
