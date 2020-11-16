Feature: add product to shopping cart
user can add product to shopping cart

Scenario Outline: adding product to shopping cart

Given user able to search for a product "<productName>"
When user can add product to shopping cart 
Then user can remove product from shopping cart

Examples:
|productName|
|mac|