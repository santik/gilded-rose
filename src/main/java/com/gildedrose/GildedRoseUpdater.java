package com.gildedrose;

public abstract class GildedRoseUpdater {

    protected Item[] items;

    public GildedRoseUpdater(Item[] items) {
        this.items = items;
    }

    abstract void updateQuality();
}
