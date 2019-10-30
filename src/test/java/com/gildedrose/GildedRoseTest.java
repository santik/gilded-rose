package com.gildedrose;

import static org.junit.Assert.assertEquals;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Sulfuras;
import com.github.javafaker.Faker;
import org.junit.Test;

public class GildedRoseTest {

    private Faker faker = new Faker();

    private GildedRose getApp(Item[] items) {
        return new GildedRose(items);
    }

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = getApp(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void withStandardItem_shouldDecreaseSelInnAndQuality() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = app.items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality - 1, standardItem.quality);
    }

    @Test
    public void withStandardItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = app.items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality - 2, standardItem.quality);
    }

    @Test
    public void withStandardItem_shouldNotMakeQualityNegative() {
        //arrange
        String standardName = faker.commerce().productName();
        int originalSellIn = -2;
        int originalQuality = 0;
        Item[] items = new Item[]{new Item(standardName, originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item standardItem = app.items[0];

        //assert
        assertEquals(standardName, standardItem.name);
        assertEquals(originalSellIn - 1, standardItem.sellIn);
        assertEquals(originalQuality, standardItem.quality);
    }

    @Test
    public void withAgedBrie_shouldIncreaseQuality() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new AgedBrie(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = app.items[0];

        //assert
        assertEquals(AgedBrie.NAME, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality + 1, agedBrie.quality);
    }

    @Test
    public void withOutdatedAgedBrie_shouldIncreaseQuality() {
        //arrange
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new AgedBrie(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = app.items[0];

        //assert
        assertEquals(AgedBrie.NAME, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality + 2, agedBrie.quality);
    }

    @Test
    public void withAgedBrie_shouldKeepQualityBelow50() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 50;
        Item[] items = new Item[]{new AgedBrie(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item agedBrie = app.items[0];

        //assert
        assertEquals(AgedBrie.NAME, agedBrie.name);
        assertEquals(originalSellIn - 1, agedBrie.sellIn);
        assertEquals(originalQuality, agedBrie.quality);
    }

    @Test
    public void withSulfuras_shouldNotChangeQualityAndSellIn() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = 80;
        Item[] items = new Item[]{new Sulfuras(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item sulfuras = app.items[0];

        //assert
        assertEquals(Sulfuras.NAME, sulfuras.name);
        assertEquals(originalSellIn, sulfuras.sellIn);
        assertEquals(originalQuality, sulfuras.quality);
    }

    @Test
    public void withBackstagePassAndSellInnAbove10_shouldIncreaseQuality() {
        //arrange
        int originalSellIn = faker.number().numberBetween(11, 100);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new BackstagePass(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = app.items[0];

        //assert
        assertEquals(BackstagePass.NAME, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 1, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow10_shouldIncreaseQualityBy2() {
        //arrange
        int originalSellIn = faker.number().numberBetween(6, 9);
        int originalQuality = faker.number().numberBetween(1, 30);
        System.out.println(originalSellIn + " " + originalQuality);
        Item[] items = new Item[]{new BackstagePass(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = app.items[0];

        //assert
        assertEquals(BackstagePass.NAME, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 2, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellInnBelow5_shouldIncreaseQualityBy3() {
        //arrange
        int originalSellIn = faker.number().numberBetween(1, 4);
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new BackstagePass(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = app.items[0];

        //assert
        assertEquals(BackstagePass.NAME, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(originalQuality + 3, backstagePass.quality);
    }

    @Test
    public void withBackstagePassAndSellingBelow0_shouldKeepQuality0() {
        //arrange
        int originalSellIn = 0;
        int originalQuality = faker.number().numberBetween(1, 30);
        Item[] items = new Item[]{new BackstagePass(originalSellIn, originalQuality)};
        GildedRose app = getApp(items);

        //act
        app.updateQuality();
        Item backstagePass = app.items[0];

        //assert
        assertEquals(backstagePass.name, backstagePass.name);
        assertEquals(originalSellIn - 1, backstagePass.sellIn);
        assertEquals(0, backstagePass.quality);
    }
}
