Feature: Change Currency
As A user I can change webiste currecny

Scenario Outline: currecny change
Given user search for a product "<productName>"
When user click on currency drop down list and choose currecny
Then currecny has been changed

Examples:
|productName|
|mac|
 
