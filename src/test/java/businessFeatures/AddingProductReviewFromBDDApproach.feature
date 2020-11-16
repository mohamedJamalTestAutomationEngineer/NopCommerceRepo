Feature: review product
    user can review product 
Scenario Outline: user review product
Given user register in website with "<firstname>" , "<lastname>" , "<email>" , "<password>" 
When user can search for a product "<productName>"
Then user able to review product and log out "<reviewTitle>" , "<reviewMessageBox>"

Examples: 
|firstname |lastname |email                 |password |productName |reviewTitle    |reviewMessageBox |
|ahmeda    |ahmeda   |ahm2t210tyuie1q@ahmed.com    |1234567  |mac |review tioptle1  |review description for titleyu1 |

 