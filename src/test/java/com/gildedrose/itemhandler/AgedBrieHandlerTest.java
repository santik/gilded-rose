package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.AgedBrie;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieHandlerTest {

    private Faker faker = new Faker();
    private AgedBrieHandler handler = new AgedBrieHandler();


    @Test
    public void handle_shoutIncreaseQualityAndSellIn() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        String name = faker.commerce().productName();
        Item item = new Item(name, originalSellIn, originalQuality);
        AgedBrie agedBrie = new AgedBrie(item);

        //act
        handler.handle(agedBrie);

        //assert
        assertEquals(name, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality + 1, item.quality);
    }

    @Test
    public void withOutdatedAgedBrie_shouldIncreaseQuality() {
        //arrange
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 30);
        String name = faker.commerce().productName();
        Item item = new Item(name, originalSellIn, originalQuality);
        AgedBrie agedBrie = new AgedBrie(item);

        //act
        handler.handle(agedBrie);

        //assert
        assertEquals(name, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality + 2, item.quality);
    }

    @Test
    public void withAgedBrie_shouldKeepQualityBelow50() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 50;
        String name = faker.commerce().productName();
        Item item = new Item(name, originalSellIn, originalQuality);
        AgedBrie agedBrie = new AgedBrie(item);

        //act
        handler.handle(agedBrie);

        //assert
        assertEquals(name, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality, item.quality);
    }
}
