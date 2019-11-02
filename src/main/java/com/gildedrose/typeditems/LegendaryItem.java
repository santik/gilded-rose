package com.gildedrose.typeditems;

import com.gildedrose.Item;

public class LegendaryItem extends TypedItem {

    public static final int QUALITY = 80;

    public LegendaryItem(Item item) throws ValidationException {
        super(item);
    }

    @Override
    protected void validate(Item item) throws ValidationException {
        if (item.quality != QUALITY) {
            throw new ValidationException("Quality is illegal for item " + item);
        }
    }
}
