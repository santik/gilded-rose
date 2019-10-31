package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.ConjuredItem;

public class ConjuredItemHandler implements TypedItemHandler<ConjuredItem> {

    private StandardItemHandler standardItemHandler = new StandardItemHandler();

    @Override
    public void handle(ConjuredItem conjuredItem) {
        Item item = conjuredItem.getItem();
        item.sellIn = item.sellIn - 1;
        item.quality = recalculateQuality(item.sellIn, item.quality);
    }

    //should do twice as standard
    private int recalculateQuality(int sellIn, int quality) {
        int firstRecalculation = standardItemHandler.recalculateQuality(sellIn, quality);
        return standardItemHandler.recalculateQuality(sellIn, firstRecalculation);
    }
}
