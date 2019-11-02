package com.gildedrose.typeditems;

import com.gildedrose.Item;

public class TypedItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_PREFIX = "Backstage passes";
    private static final String SULFURAS_PREFIX = "Sulfuras";
    private static final String CONJURED_PREFIX = "Conjured";

    private static boolean isAgedBrie(Item item) {
        return item.name.startsWith(AGED_BRIE);
    }

    private static boolean isBackstagePasses(Item item) {
        return item.name.startsWith(BACKSTAGE_PASSES_PREFIX);
    }

    private static boolean isSulfuras(Item item) {
        return item.name.startsWith(SULFURAS_PREFIX);
    }

    private static boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED_PREFIX);
    }

    public static TypedItem getTypedItem(Item item) throws ValidationException {
        if (isAgedBrie(item)) {
            return new AgedBrie(item);
        }

        if (isBackstagePasses(item)) {
            return new BackstagePass(item);
        }

        if (isSulfuras(item)) {
            return new LegendaryItem(item);
        }

        if (isConjured(item)) {
            return new ConjuredItem(item);
        }

        return new StandardItem(item);
    }
}
