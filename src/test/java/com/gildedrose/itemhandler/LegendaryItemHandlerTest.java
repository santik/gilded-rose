package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.LegendaryItem;
import com.gildedrose.typeditems.ValidationException;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegendaryItemHandlerTest {

    @Test
    public void handle_withSulfuras_shouldNotChangeQualityAndSellIn() throws ValidationException {
        //arrange
        Faker faker = new Faker();
        String legendaryName = faker.company().name();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = LegendaryItem.QUALITY;
        Item item = new Item(legendaryName, originalSellIn, originalQuality);
        LegendaryItem legendaryItem = new LegendaryItem(item);
        LegendaryItemHandler handler = new LegendaryItemHandler();

        //act
        handler.handle(legendaryItem);

        //assert
        assertEquals(legendaryName, item.name);
        assertEquals(originalSellIn, item.sellIn);
        assertEquals(originalQuality, item.quality);
    }
}
