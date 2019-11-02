package com.gildedrose;

import com.gildedrose.itemhandler.ItemHandler;
import com.gildedrose.typeditems.ValidationException;

class GildedRose extends GildedRoseUpdater {

    private ItemHandler itemHandler = new ItemHandler();

    GildedRose(Item[] items) {
        super(items);
    }

    @Override
    public void updateQuality() {
        for (Item item: items) {
            try {
                itemHandler.handle(item);
            } catch (ValidationException e) {
                e.printStackTrace(); //should be log
            }
        }
    }
}
