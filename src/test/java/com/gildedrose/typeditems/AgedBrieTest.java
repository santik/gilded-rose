package com.gildedrose.typeditems;

import com.gildedrose.Item;
import org.junit.Test;

//this test can be treated as a test for the abstract TypedItem class
//it was done not to pull additional dependencies to the project
public class AgedBrieTest {

    @Test(expected = ValidationException.class)
    public void validate_withNegativeQuality_shouldThrowException() throws ValidationException {
        //arrange
        int quality =  TypedItem.MIN_QUALITY -1;
        Item item = new Item("name", 1, quality);

        //act && assert
        new AgedBrie(item);
    }

    @Test(expected = ValidationException.class)
    public void validate_withTooBigQuality_shouldThrowException() throws ValidationException {
        //arrange
        int quality = TypedItem.MAX_QUALITY + 1;
        Item item = new Item("name", 1, quality);

        //act && assert
        new AgedBrie(item);
    }

}
