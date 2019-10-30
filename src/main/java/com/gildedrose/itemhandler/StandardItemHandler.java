package com.gildedrose.itemhandler;

import com.gildedrose.Item;

public class StandardItemHandler implements ItemHandler<Item> {

    public static final int QUALITY_AMOUNT_TO_DECREASE = 1;

    private static final int MIN_QUALITY = 0;

    @Override
    public Item handle(Item item) {
        final int newSellIn = item.sellIn - 1;
        return new Item(item.name, newSellIn, recalculateQuality(newSellIn, item.quality));
    }

    int recalculateQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality - QUALITY_AMOUNT_TO_DECREASE
                : quality - QUALITY_AMOUNT_TO_DECREASE * 2;
        return Math.max(newQuality, MIN_QUALITY);
    }
}
