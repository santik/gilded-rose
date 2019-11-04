
# Gilded Rose refactoring project  

For each `Item` in the list application performs the sequence of operations:
* Decorate `Item` into `TypedItem` object based on its name with the `TypedItemFactory`
    * _For example item with the name "Aged Brie" should be `AgedBrie`_
* Validate initial `Item` for the correct quantity
* Based on type of `TypedItem` detect suitable handler with `TypedItemHandlerProvider`
    * _For example for `BackstagePass` it should be `BackstagePassHandler`_
* Handler keeps knowledge how to update properties of wrapped `Item`
  
Initial `GildedRose` class was renamed to `GildedRoseDeprecated` with little changes to be able to change versions inside tests.

Possible improvements:
* Would be nice to implement dependency injection, but it would mean more code and I wanted to keep it short.
* Add more unit tests. For now coverage is around 98-99% but it is only because in `GildedRoseTest` the full flow is tested.
* In my opinion `Item` should be immutable. Cheese today is not the same as cheese tomorrow. But this clashes with the requirement do not change `GildedRose::items`.
* Add proper logging. 