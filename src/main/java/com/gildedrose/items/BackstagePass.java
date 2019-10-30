package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }
}
