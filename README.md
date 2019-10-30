
# Gilded Rose refactoring project  
  
Project contains 2 branches: master and [mutable-items](https://github.com/santik/gilded-rose/tree/mutable-items).  
   
Refactoring with immutability and strict typing and generic interfaces is in the master branch
Then realised that in [`TexttestFixture`](https://github.com/santik/gilded-rose/blob/master/src/test/java/com/gildedrose/TexttestFixture.java) initial objects are printed as a result after updating.  
So probably that objects supposed be mutated and used outside of the current functionality.  
If this is the case the task becomes a little bit easier with this limitation but code is not that "fancy" and robust.  
  
I decided to keep both version:  
* Master branch is for bigger refactoring.  
* [Mutable-items](https://github.com/santik/gilded-rose/tree/mutable-items) branch is for limited refactoring.  

In both branches initial `GildedRose` class was renamed to `GildedRoseDeprecated` with little changes to be able to run tests against old and refactored versions.
 