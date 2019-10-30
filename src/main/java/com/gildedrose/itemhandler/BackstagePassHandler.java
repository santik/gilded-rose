package com.gildedrose.itemhandler;

import com.gildedrose.items.BackstagePass;

public class BackstagePassHandler implements ItemHandler<BackstagePass> {

    private static final int MAX_QUALITY = 50;

    @Override
    public BackstagePass handle(BackstagePass item) {
        //it is interesting that in original code first quality recalculated and then sellIn
        //so keeping that order here
        final int newQuality = recalculateQuality(item.sellIn, item.quality);
        return new BackstagePass(item.name, item.sellIn - 1, newQuality);
    }

    private int recalculateQuality(int sellIn, int quality) {
        final int newQuality;
        if (sellIn <= 0) {
            newQuality = 0;
        } else if (sellIn <= 5) {
            newQuality = quality + 3;
        } else if (sellIn <= 10) {
            newQuality = quality + 2;
        } else {
            newQuality = quality + 1;
        }
        return Math.min(newQuality, MAX_QUALITY);
    }
}
