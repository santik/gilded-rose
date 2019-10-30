package com.gildedrose.itemhandler;

import com.gildedrose.items.LegendaryItem;

public class LegendaryItemHandler implements ItemHandler<LegendaryItem> {

    //here is the interesting case for immutability
    //Legendary items are never sold out or change quality
    //does that mean they are always the same?
    @Override
    public LegendaryItem handle(LegendaryItem item) {
        return item;
    }
}
