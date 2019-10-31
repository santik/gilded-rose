package com.gildedrose;

import com.gildedrose.itemhandler.ItemHandler;

class GildedRose extends GildedRoseUpdater {

    private ItemHandler itemHandler = new ItemHandler();

    public GildedRose(Item[] items) {
        super(items);
    }

    @Override
    public void updateQuality() {
        for (Item item: items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        itemHandler.handle(item);
    }
}
