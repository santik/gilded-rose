package com.gildedrose.itemhandler;

import com.gildedrose.GildedRoseUpdater;
import com.gildedrose.Item;
import com.github.javafaker.Faker;
import org.junit.Test;

import static com.gildedrose.itemhandler.StandardItemHandler.QUALITY_AMOUNT_TO_DECREASE;
import static org.junit.Assert.assertEquals;

public class StandardItemHandlerTest {

    private Faker faker = new Faker();

    @Test
    public void handle_withStandardItem_shouldDecreaseSelInnAndQuality() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItemHandler handler = new StandardItemHandler();

        //act
        Item handledItem = handler.handle(item);

        //assert
        assertEquals(standardName, handledItem.name);
        assertEquals(originalSellIn - 1, handledItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE, handledItem.quality);
    }

    @Test
    public void withStandardItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItemHandler handler = new StandardItemHandler();

        //act
        Item handledItem = handler.handle(item);

        //assert
        assertEquals(standardName, handledItem.name);
        assertEquals(originalSellIn - 1, handledItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, handledItem.quality);
    }

    @Test
    public void withStandardItem_shouldNotMakeQualityNegative() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -2;
        int originalQuality = 0;
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItemHandler handler = new StandardItemHandler();

        //act
        Item handledItem = handler.handle(item);

        //assert
        assertEquals(standardName, handledItem.name);
        assertEquals(originalSellIn - 1, handledItem.sellIn);
        assertEquals(originalQuality, handledItem.quality);
    }
}
