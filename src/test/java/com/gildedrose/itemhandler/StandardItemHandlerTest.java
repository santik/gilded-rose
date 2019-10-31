package com.gildedrose.itemhandler;

import com.gildedrose.GildedRoseUpdater;
import com.gildedrose.Item;
import com.gildedrose.typeditems.StandardItem;
import com.github.javafaker.Faker;
import org.junit.Test;

import static com.gildedrose.itemhandler.StandardItemHandler.QUALITY_AMOUNT_TO_DECREASE;
import static org.junit.Assert.assertEquals;

public class StandardItemHandlerTest {

    private Faker faker = new Faker();
    private StandardItemHandler handler = new StandardItemHandler();

    @Test
    public void handle_withStandardItem_shouldDecreaseSelInnAndQuality() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItem standardItem = new StandardItem(item);


        //act
        handler.handle(standardItem);

        //assert
        assertEquals(standardName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE, item.quality);
    }

    @Test
    public void withStandardItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItem standardItem = new StandardItem(item);


        //act
        handler.handle(standardItem);

        //assert
        assertEquals(standardName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, item.quality);
    }

    @Test
    public void withStandardItem_shouldNotMakeQualityNegative() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -2;
        int originalQuality = 0;
        Item item = new Item(standardName, originalSellIn, originalQuality);
        StandardItem standardItem = new StandardItem(item);


        //act
        handler.handle(standardItem);

        //assert
        assertEquals(standardName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality, item.quality);
    }
}
