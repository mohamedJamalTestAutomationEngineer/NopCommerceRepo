Feature: user registeration
    I want to check that user can register in e-commerce website 
Scenario Outline: user registeration
Given the user in homepage
When I click on the register button
And I enter the user "<firstname>" , "<lastname>" , "<email>" , "<password>" 
Then registertion completed successfully 

Examples:
|firstname |lastname |email             |password |
|ahmed     |ahmed    |ahmeqio1jwe@ahmed.com |1234567  | 
