package com.gildedrose.itemhandler;

import com.gildedrose.items.BackstagePass;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassHandlerTest {

    private Faker faker = new Faker();

    @Test
    public void handle_withBackstagePassAndSellInnAbove10_shouldIncreaseQuality() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(11, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        BackstagePass backstagePass = new BackstagePass(backstagePassName, originalSellIn, originalQuality);
        BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

        //act
        BackstagePass handledBackstagePass = backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, handledBackstagePass.sellIn);
        assertEquals(originalQuality + 1, handledBackstagePass.quality);
    }

    @Test
    public void handle_withBackstagePassAndSellInnBelow10_shouldIncreaseQualityBy2() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(6, 9);
        int originalQuality = faker.number().numberBetween(1, 30);
        BackstagePass backstagePass = new BackstagePass(backstagePassName, originalSellIn, originalQuality);
        BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

        //act
        BackstagePass handledBackstagePass = backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, handledBackstagePass.sellIn);
        assertEquals(originalQuality + 2, handledBackstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow5_shouldIncreaseQualityBy3() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 4);
        int originalQuality = faker.number().numberBetween(1, 30);
        BackstagePass backstagePass = new BackstagePass(backstagePassName, originalSellIn, originalQuality);
        BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

        //act
        BackstagePass handledBackstagePass = backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, handledBackstagePass.sellIn);
        assertEquals(originalQuality + 3, handledBackstagePass.quality);
    }

    @Test
    public void handle_withBackstagePassAndSellingBelow0_shouldKeepQuality0() {
        //arrange
        String backstagePassName = faker.commerce().productName();
        int originalSellIn = 0;
        int originalQuality = faker.number().numberBetween(1, 30);
        BackstagePass backstagePass = new BackstagePass(backstagePassName, originalSellIn, originalQuality);
        BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

        //act
        BackstagePass handledBackstagePass = backstagePassHandler.handle(backstagePass);

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, handledBackstagePass.sellIn);
        assertEquals(0, handledBackstagePass.quality);
    }
}
