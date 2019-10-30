package com.gildedrose;

import java.util.Arrays;

class GildedRoseClean extends GildedRose {

    private ItemHandlerProvider itemHandlerProvider = new ItemHandlerProvider();

    public GildedRoseClean(Item[] items) {
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