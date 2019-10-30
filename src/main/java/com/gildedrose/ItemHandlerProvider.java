package com.gildedrose;

import com.gildedrose.itemhandler.AgedBrieHandler;
import com.gildedrose.itemhandler.BackstagePassHandler;
import com.gildedrose.itemhandler.ConjuredItemHandler;
import com.gildedrose.itemhandler.LegendaryItemHandler;
import com.gildedrose.itemhandler.StandardItemHandler;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.LegendaryItem;

public class ItemHandlerProvider<T extends Item> {

    private final AgedBrieHandler agedBrieHandler = new AgedBrieHandler();
    private final BackstagePassHandler backstagePassHandler = new BackstagePassHandler();
    private final LegendaryItemHandler legendaryItemHandler = new LegendaryItemHandler();
    private final StandardItemHandler standardItemHandler = new StandardItemHandler();
    private final ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

    //it could be something smarter, but we have low
    //number of cases so simple "if" works good
    public ItemHandler provide(T item) {
        if (item instanceof AgedBrie)  {
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

        return standardItemHandler;
    }
}
