package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.BackstagePass;

public class BackstagePassHandler implements TypedItemHandler<BackstagePass> {

    private static final int MAX_QUALITY = 50;

    @Override
    public void handle(BackstagePass backstagePass) {
        Item item = backstagePass.getItem();
        //it is interesting that in original code first quality recalculated and then sellIn
        //so keeping that order here
        item.quality = recalculateQuality(item.sellIn, item.quality);
        item.sellIn = item.sellIn - 1;
    }

    private int recalculateQuality(int sellIn, int quality) {
        final int newQuality;
        if (sellIn <= 0) {
            newQuality = 0;
        } else if (sellIn < 6) {
            newQuality = quality + 3;
        } else if (sellIn < 11) {
            newQuality = quality + 2;
        } else {
            newQuality = quality + 1;
        }
        return Math.min(newQuality, MAX_QUALITY);
    }
}
