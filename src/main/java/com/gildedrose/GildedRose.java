package com.gildedrose;

import com.gildedrose.itemhandler.ItemHandler;

class GildedRose extends GildedRoseUpdater {

    private ItemHandler itemHandler = new ItemHandler();

    GildedRose(Item[] items) {
        super(items);
    }

    @Override
    public void updateQuality() {
        for (Item item: items) {
            itemHandler.handle(item);
        }
    }
}
