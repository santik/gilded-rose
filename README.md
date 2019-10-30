# Gilded Rose refactoring project

Project contains 2 branches: master and mutable-items.

I made all the refactoring with immutability and strict typing in the master branch and then realized that in TexttestFixture initial objects are used.
So probably that objects supposed be mutated and used outside of the current functionality.

If it is the case the task becomes a little bit easier with this limitation but code is not that "fancy".

I decided to keep both version:
* Master branch is for bigger refactoring.
* Mutable-items branch is for limited refactoring.
