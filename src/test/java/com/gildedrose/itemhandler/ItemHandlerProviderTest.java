package com.gildedrose.itemhandler;

import com.gildedrose.Item;
import com.gildedrose.typeditems.AgedBrie;
import com.gildedrose.typeditems.BackstagePass;
import com.gildedrose.typeditems.ConjuredItem;
import com.gildedrose.typeditems.LegendaryItem;
import com.gildedrose.typeditems.StandardItem;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemHandlerProviderTest {

    private TypedItemHandlerProvider provider = new TypedItemHandlerProvider();
    private Item item = new Item("somename", 1, 1);

    @Test
    public void provide_withAgedBrie_shouldReturnAgedBrieHandler() {
        //arrange
        AgedBrie agedBrie = new AgedBrie(item);

        //act && assert
        assertTrue(provider.provide(agedBrie) instanceof AgedBrieHandler);
    }

    @Test
    public void provide_withBackstagePass_shouldReturnBackstagePassHandler() {
        //arrange
        BackstagePass backstagePass = new BackstagePass(item);

        //act && assert
        assertTrue(provider.provide(backstagePass) instanceof BackstagePassHandler);
    }

    @Test
    public void provide_withLegendaryItem_shouldReturnLegendaryItemHandler() {
        //arrange
        LegendaryItem legendaryItem = new LegendaryItem(item);

        //act && assert
        assertTrue(provider.provide(legendaryItem) instanceof LegendaryItemHandler);
    }

    @Test
    public void provide_withConjuredItem_shouldReturnConjuredItemHandler() {
        //arrange
        ConjuredItem conjuredItem = new ConjuredItem(item);

        //act && assert
        assertTrue(provider.provide(conjuredItem) instanceof ConjuredItemHandler);
    }

    @Test
    public void provide_withStandardItem_shouldReturnStandardItemHandler() {
        //arrange
        StandardItem standardItem = new StandardItem(item);

        //act && assert
        assertTrue(provider.provide(standardItem) instanceof StandardItemHandler);
    }
}
