package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.BackstagePass;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassHandlerTest {

    private Faker faker = new Faker();
    private BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

    @Test
    public void handle_withBackstagePassAndSellInnAbove10_shouldIncreaseQuality() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(11, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item item = new Item(backstagePassName, originalSellIn, originalQuality);
        BackstagePass backstagePass = new BackstagePass(item);

        //act
        backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality + 1, item.quality);
    }

    @Test
    public void handle_withBackstagePassAndSellInnBelow10_shouldIncreaseQualityBy2() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(6, 9);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item item = new Item(backstagePassName, originalSellIn, originalQuality);
        BackstagePass backstagePass = new BackstagePass(item);

        //act
        backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality + 2, item.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow5_shouldIncreaseQualityBy3() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 4);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item item = new Item(backstagePassName, originalSellIn, originalQuality);
        BackstagePass backstagePass = new BackstagePass(item);

        //act
        backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality + 3, item.quality);
    }

    @Test
    public void handle_withBackstagePassAndSellingBelow0_shouldKeepQuality0() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = 0;
        int originalQuality = faker.number().numberBetween(1, 30);
        Item item = new Item(backstagePassName, originalSellIn, originalQuality);
        BackstagePass backstagePass = new BackstagePass(item);

        //act
        backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
