package com.gildedrose.itemhandler;

import com.gildedrose.items.ConjuredItem;

public class ConjuredItemHandler implements ItemHandler<ConjuredItem> {

    private static final int MIN_QUALITY = 0;

    @Override
    public ConjuredItem handle(ConjuredItem item) {
        final int newSellIn = item.sellIn - 1;
        return new ConjuredItem(item.name, newSellIn, recalculateQuality(newSellIn, item.quality));
    }

    private int recalculateQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality - 2
                : quality - 4;
        return Math.max(newQuality, MIN_QUALITY);
    }
}
