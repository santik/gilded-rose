package com.gildedrose.itemhandler;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.TypedItem;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.StandardItem;

public class ItemHandlerProvider<T extends TypedItem> {

    private final AgedBrieHandler agedBrieHandler = new AgedBrieHandler();
    private final BackstagePassHandler backstagePassHandler = new BackstagePassHandler();
    private final LegendaryItemHandler legendaryItemHandler = new LegendaryItemHandler();
    private final StandardItemHandler standardItemHandler = new StandardItemHandler();
    private final ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

    //it could be something smarter, but we have low
    //number of cases so simple "if" works good
    public TypedItemHandler provide(T item) {
        if (item instanceof AgedBrie) {
            return agedBrieHandler;
        }

        if (item instanceof BackstagePass) {
            return backstagePassHandler;
        }

        if (item instanceof LegendaryItem) {
            return legendaryItemHandler;
        }

        if (item instanceof ConjuredItem) {
            return conjuredItemHandler;
        }

        if (item instanceof StandardItem) {
            return standardItemHandler;
        }

        throw new RuntimeException("No handler for " + item.getClass().getSimpleName());
    }
}
