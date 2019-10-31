package com.gildedrose.typeditems;

import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TypedItemFactoryTest {

    @Test
    public void getTypedItem_withAgedBrie_shouldCreateAgedBrie() {
        //arrange
        String name = "Aged Brie super aged";
        Item item = new Item(name, 1, 1);

        //act && assert
        assertTrue(TypedItemFactory.getTypedItem(item) instanceof AgedBrie);
    }

    @Test
    public void getTypedItem_withBackstagePass_shouldCreateBackstagePass() {
        //arrange
        String name = "Backstage passes in awesome club";
        Item item = new Item(name, 1, 1);

        //act && assert
        assertTrue(TypedItemFactory.getTypedItem(item) instanceof BackstagePass);
    }

    @Test
    public void getTypedItem_withConjuredItem_shouldCreateConjuredItem() {
        //arrange
        String name = "Conjured Mana Cake";
        Item item = new Item(name, 1, 1);

        //act && assert
        assertTrue(TypedItemFactory.getTypedItem(item) instanceof ConjuredItem);
    }

    @Test
    public void getTypedItem_withLegendaryItem_shouldCreateLegendaryItem() {
        //arrange
        String name = "Sulfuras, Hand of Ragnaros";
        Item item = new Item(name, 1, 1);

        //act && assert
        assertTrue(TypedItemFactory.getTypedItem(item) instanceof LegendaryItem);
    }

    @Test
    public void getTypedItem_withStandardItem_shouldCreateStandardItem() {
        //arrange
        String name = "someothername";
        Item item = new Item(name, 1, 1);

        //act && assert
        assertTrue(TypedItemFactory.getTypedItem(item) instanceof StandardItem);
    }
}
