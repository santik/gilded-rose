package com.gildedrose.items;

import com.gildedrose.Item;

public class TypedItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_PREFIX = "Backstage passes";
    private static final String SULFURAS_PREFIX = "Sulfuras";
    private static final String CONJURED_PREFIX = "Conjured";

    public static boolean isAgedBrie(Item item) {
        return item.name.startsWith(AGED_BRIE);
    }

    public static boolean isBackstagePasses(Item item) {
        return item.name.startsWith(BACKSTAGE_PASSES_PREFIX);
    }

    public static boolean isSulfuras(Item item) {
        return item.name.startsWith(SULFURAS_PREFIX);
    }

    public static boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED_PREFIX);
    }

    public static TypedItem getTypedItem(Item item) {
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
