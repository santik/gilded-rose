package com.gildedrose.itemhandler;

import com.gildedrose.items.AgedBrie;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieHandlerTest {

    private Faker faker = new Faker();

    @Test
    public void handle_shoutIncreaseQualityAndSellIn() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        AgedBrie agedBrie = new AgedBrie(originalSellIn, originalQuality);
        AgedBrieHandler handler = new AgedBrieHandler();

        //act
        AgedBrie handledAgedBrie = handler.handle(agedBrie);

        //assert
        assertEquals(originalSellIn - 1, handledAgedBrie.sellIn);
        assertEquals(originalQuality + 1, handledAgedBrie.quality);
    }

    @Test
    public void withOutdatedAgedBrie_shouldIncreaseQuality() {
        //arrange
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 30);
        AgedBrie agedBrie = new AgedBrie(originalSellIn, originalQuality);
        AgedBrieHandler handler = new AgedBrieHandler();

        //act
        AgedBrie handledAgedBrie = handler.handle(agedBrie);

        //assert
        assertEquals(originalSellIn - 1, handledAgedBrie.sellIn);
        assertEquals(originalQuality + 2, handledAgedBrie.quality);
    }

    @Test
    public void withAgedBrie_shouldKeepQualityBelow50() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 50;
        AgedBrie agedBrie = new AgedBrie(originalSellIn, originalQuality);
        AgedBrieHandler handler = new AgedBrieHandler();

        //act
        AgedBrie handledAgedBrie = handler.handle(agedBrie);

        //assert
        assertEquals(originalSellIn - 1, handledAgedBrie.sellIn);
        assertEquals(originalQuality, handledAgedBrie.quality);
    }
}
