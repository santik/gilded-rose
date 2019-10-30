package com.gildedrose.itemhandler;

import com.gildedrose.items.LegendaryItem;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegendaryItemHandlerTest {

    private Faker faker = new Faker();

    @Test
    public void handle_withSulfuras_shouldNotChangeQualityAndSellIn() {
        //arrange
        String legendaryName = faker.company().name();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 80;
        LegendaryItem legendaryItem = new LegendaryItem(legendaryName, originalSellIn, originalQuality);
        LegendaryItemHandler handler = new LegendaryItemHandler();

        //act
        LegendaryItem handledItem = handler.handle(legendaryItem);

        //assert
        assertEquals(legendaryName, handledItem.name);
        assertEquals(originalSellIn, handledItem.sellIn);
        assertEquals(originalQuality, handledItem.quality);
    }
}
