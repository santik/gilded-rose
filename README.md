
# Gilded Rose refactoring project  

The biggest challenge of this assignment was the requirement not to change `Items`.
It limits possibilities for decoupling code, but requirements are requirements.

_I personally think that items should be immutable. Aged cheese today is not the same as tomorrow. It is different product_  

For each `Item` in the list application performs the sequence of operations:
* Decorate `Item` into `TypedItem` object based on its name with the `TypedItemFactory`
    * _For example item with the name "Aged Brie" should be `AgedBrie`_
* Validate initial `Item` for the correct quantity
* Based on type of `TypedItem` detect suitable handler with `TypedItemHandlerProvider`
    * _For example for `BackstagePass` it should be `BackstagePassHandler`_
* Handler keeps knowledge how to update properties of wrapped `Item`     
  
Initial `GildedRose` class was renamed to `GildedRoseDeprecated` with little changes to be able to run tests against old and refactored versions.

