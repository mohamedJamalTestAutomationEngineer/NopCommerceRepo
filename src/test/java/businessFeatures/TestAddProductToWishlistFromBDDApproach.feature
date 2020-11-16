Feature: product wishlist
I want to add product to wishlist

Scenario Outline: user add product to wishlist
Given user is able to search for a product "<productName>"
When user can add product to wishlist
Then user can remove product from wishlist

Examples:
|productName|
|mac|