Feature: products compare

Scenario Outline: user can compare between two products
Given user can find first product "<product1>" and add it to compare list 
When user can find second product "<product2>" and add it to compare list 
And user can compare between two products
Then user can remove two products from compare list 

Examples:
|product1 | product2|
|mac |asus |