package com.gildedrose.typeditems;

import com.gildedrose.Item;
import org.junit.Test;

public class LegendaryItemTest {

    @Test(expected = ValidationException.class)
    public void validate_withIncorrectQuality_shouldThrowException() throws ValidationException {
        //arrange
        int quality = LegendaryItem.QUALITY + 1;
        Item item = new Item("name", 1, quality);

        //act && assert
        new LegendaryItem(item);
    }
}
