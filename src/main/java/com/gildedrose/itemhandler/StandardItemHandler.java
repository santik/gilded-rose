package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.StandardItem;

public class StandardItemHandler implements TypedItemHandler<StandardItem> {

    public static final int QUALITY_AMOUNT_TO_DECREASE = 1;

    private static final int MIN_QUALITY = 0;

    @Override
    public void handle(StandardItem standardItem) {
        Item item = standardItem.getItem();
        item.sellIn = item.sellIn - 1;
        item.quality = recalculateQuality(item.sellIn, item.quality);
    }

    int recalculateQuality(int sellIn, int quality) {
        final int newQuality = sellIn > 0
                ? quality - QUALITY_AMOUNT_TO_DECREASE
                : quality - QUALITY_AMOUNT_TO_DECREASE * 2;
        return Math.max(newQuality, MIN_QUALITY);
    }
}
