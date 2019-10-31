package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.items.AgedBrie;

public class AgedBrieHandler implements TypedItemHandler<AgedBrie> {

    private static final int MAX_QUALITY = 50;

    @Override
    public void handle(AgedBrie agedBrie) {
        Item item = agedBrie.getItem();
        item.sellIn = item.sellIn - 1;
        item.quality = recalculateQuality(item.sellIn, item.quality);
    }

    private int recalculateQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality + 1
                : quality + 2;
        return Math.min(newQuality, MAX_QUALITY);
    }
}
