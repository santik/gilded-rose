package com.gildedrose;

import com.gildedrose.itemhandler.ItemHandlerProvider;

import java.util.Arrays;

class GildedRose extends GildedRoseUpdater {

    private ItemHandlerProvider itemHandlerProvider = new ItemHandlerProvider();

    public GildedRose(Item[] items) {
        super(items);
    }

    @Override
    public void updateQuality() {
        items = Arrays.stream(items).map(this::updateItem).toArray(Item[]::new);
    }

    private Item updateItem(Item item) {
        return itemHandlerProvider.provide(item).handle(item);
    }
}
