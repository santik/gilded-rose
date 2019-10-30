package com.gildedrose.itemhandler;

import com.gildedrose.items.ConjuredItem;
import com.github.javafaker.Faker;
import org.junit.Test;

import static com.gildedrose.itemhandler.StandardItemHandler.QUALITY_AMOUNT_TO_DECREASE;
import static org.junit.Assert.assertEquals;

public class ConjuredItemHandlerTest {

    private Faker faker = new Faker();

    @Test
    public void handle_withConjured_shouldDecreaseSelInnAndQuality() {
        //arrange
        String conjuredName = faker.commerce().productName();
        int originalSellIn = faker.number().numberBetween(1, 100);
        int originalQuality = faker.number().numberBetween(1, 50);
        ConjuredItem conjuredItem = new ConjuredItem(conjuredName, originalSellIn, originalQuality);
        ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

        //act
        ConjuredItem conjuredItemHandled = conjuredItemHandler.handle(conjuredItem);

        //assert
        assertEquals(conjuredName, conjuredItemHandled.name);
        assertEquals(originalSellIn - 1, conjuredItemHandled.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 2, conjuredItemHandled.quality);
    }

    @Test
    public void withConjuredItem_ShouldDecreaseQualityByTwoWhenSellInPassed() {
        //arrange
        String conjuredName = faker.commerce().productName();
        int originalSellIn = -1;
        int originalQuality = faker.number().numberBetween(1, 50);
        ConjuredItem conjuredItem = new ConjuredItem(conjuredName, originalSellIn, originalQuality);
        ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

        //act
        ConjuredItem conjuredItemHandled = conjuredItemHandler.handle(conjuredItem);

        //assert
        assertEquals(conjuredName, conjuredItemHandled.name);
        assertEquals(originalSellIn - 1, conjuredItemHandled.sellIn);
        assertEquals(originalQuality - QUALITY_AMOUNT_TO_DECREASE * 4, conjuredItemHandled.quality);
    }
}
