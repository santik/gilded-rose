package com.gildedrose;

import static com.gildedrose.itemhandler.StandardItemHandler.QUALITY_AMOUNT_TO_DECREASE;
import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import org.junit.Test;

public class GildedRoseTest {

    private Faker faker = new Faker();

    private GildedRoseUpdater getApp(Item[] items) {
        return new GildedRoseDeprecated(items);
    }

    @Test
    public void withStandardItem_shouldDecreaseSelInnAndQuality() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE, standardItem.quality);
    }

    @Test
    public void withStandardItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, standardItem.quality);
    }

    @Test
    public void withStandardItem_shouldNotMakeQualityNegative() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -2;
        int originalQuality = 0;
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality, standardItem.quality);
    }

    @Test
    public void withAgedBrie_shouldIncreaseQuality() {
        //arrange
        String agedBrieName = "Aged Brie";
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new Item(agedBrieName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = items[0];

        //assert
        assertEquals(agedBrieName, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality + 1, agedBrie.quality);
    }

    @Test
    public void withOutdatedAgedBrie_shouldIncreaseQuality() {
        //arrange
        String agedBrieName = "Aged Brie";
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new Item(agedBrieName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = items[0];

        //assert
        assertEquals(agedBrieName, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality + 2, agedBrie.quality);
    }

    @Test
    public void withAgedBrie_shouldKeepQualityBelow50() {
        //arrange
        String agedBrieName = "Aged Brie";
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 50;
        Item[] items = new Item[]{new Item(agedBrieName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = items[0];

        //assert
        assertEquals(agedBrieName, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality, agedBrie.quality);
    }

    @Test
    public void withSulfuras_shouldNotChangeQualityAndSellIn() {
        //arrange
        String sulfurasName = "Sulfuras " + faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 80;
        Item[] items = new Item[]{new Item(sulfurasName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item sulfuras = items[0];

        //assert
        assertEquals(sulfurasName, sulfuras.name);
        assertEquals(originalSellIn, sulfuras.sellIn);
        assertEquals(originalQuality, sulfuras.quality);
    }

    @Test
    public void withBackstagePassAndSellInnAbove10_shouldIncreaseQuality() {
        //arrange
        String backstagePassName = "Backstage passes " + faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(11, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new Item(backstagePassName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = items[0];

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 1, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow10_shouldIncreaseQualityBy2() {
        //arrange
        String backstagePassName = "Backstage passes " + faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(6, 9);
        int originalQuality = faker.number().numberBetween(1, 30);
        System.out.println(originalSellIn + " " + originalQuality);
        Item[] items = new Item[]{new Item(backstagePassName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = items[0];

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 2, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow5_shouldIncreaseQualityBy3() {
        //arrange
        String backstagePassName = "Backstage passes " + faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 4);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new Item(backstagePassName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = items[0];

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 3, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellingBelow0_shouldKeepQuality0() {
        //arrange
        String backstagePassName = "Backstage passes " + faker.commerce().productName();
        int originalSellIn = 0;
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new Item(backstagePassName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = items[0];

        //assert
        assertEquals(backstagePassName, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(0, backstagePass.quality);
    }

    @Test
    public void withConjured_shouldDecreaseSelInnAndQuality() {
        //arrange
        String conjuredName = "Conjured " + faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(conjuredName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item conjuredItem = items[0];

        //assert
        assertEquals(conjuredName, conjuredItem.name);
        assertEquals(originalSellIn - 1, conjuredItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, conjuredItem.quality);
    }

    @Test
    public void withConjuredItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String conjuredName = "Conjured " + faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(conjuredName, originalSellIn, originalQuality)};
        GildedRoseUpdater app = getApp(items);

        //act
        app.updateQuality();
        Item conjuredItem = items[0];

        //assert
        assertEquals(conjuredName, conjuredItem.name);
        assertEquals(originalSellIn - 1, conjuredItem.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 4, conjuredItem.quality);
    }
}