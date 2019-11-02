package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.ConjuredItem;
import com.gildedrose.typeditems.ValidationException;
import com.github.javafaker.Faker;
import org.junit.Test;

import static com.gildedrose.itemhandler.StandardItemHandler.QUALITY_AMOUNT_TO_DECREASE;
import static org.junit.Assert.assertEquals;

public class ConjuredItemHandlerTest {

    private Faker faker = new Faker();
    private ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

    @Test
    public void handle_withConjured_shouldDecreaseSelInnAndQuality() throws ValidationException {
        //arrange
        String conjuredName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(conjuredName, originalSellIn, originalQuality);
        ConjuredItem conjuredItem = new ConjuredItem(item);

        //act
        conjuredItemHandler.handle(conjuredItem);

        //assert
        assertEquals(conjuredName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, item.quality);
    }

    @Test
    public void withConjuredItem_ShouldDecreaseQualityByTwoWhenSellInPassed() throws ValidationException {
        //arrange
        String conjuredName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        Item item = new Item(conjuredName, originalSellIn, originalQuality);
        ConjuredItem conjuredItem = new ConjuredItem(item);

        //act
        conjuredItemHandler.handle(conjuredItem);

        //assert
        assertEquals(conjuredName, item.name);
        assertEquals(originalSellIn - 1, item.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 4, item.quality);
    }
}
