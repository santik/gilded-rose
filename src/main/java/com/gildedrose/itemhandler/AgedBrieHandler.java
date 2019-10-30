package com.gildedrose.itemhandler;

import com.gildedrose.items.AgedBrie;

public class AgedBrieHandler implements ItemHandler<AgedBrie> {

    private static final int MAX_QUALITY = 50;

    @Override
    public AgedBrie handle(AgedBrie item) {
        final int newSellIn = item.sellIn - 1;
        return new AgedBrie(newSellIn, recalculateQuality(newSellIn, item.quality));
    }

    private int recalculateQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality + 1
                : quality + 2;
        return Math.min(newQuality, MAX_QUALITY);
    }
}
