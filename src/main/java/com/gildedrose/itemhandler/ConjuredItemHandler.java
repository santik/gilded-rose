package com.gildedrose.itemhandler;

import com.gildedrose.items.ConjuredItem;

public class ConjuredItemHandler implements ItemHandler<ConjuredItem> {

    private StandardItemHandler standardItemHandler = new StandardItemHandler();

    @Override
    public ConjuredItem handle(ConjuredItem item) {
        final int newSellIn = item.sellIn - 1;
        return new ConjuredItem(item.name, newSellIn, recalculateQuality(newSellIn, item.quality));
    }

    //should do twice as standard
    private int recalculateQuality(int sellIn, int quality) {
        int firstRecalculation = standardItemHandler.recalculateQuality(sellIn, quality);
        return standardItemHandler.recalculateQuality(sellIn, firstRecalculation);
    }
}
