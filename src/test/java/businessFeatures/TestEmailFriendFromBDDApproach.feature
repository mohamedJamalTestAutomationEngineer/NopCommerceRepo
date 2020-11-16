Feature: email friend
I want to email friend with to tell him about product

Scenario Outline: user can email friend about product
Given user register with "<firstname>" , "<lastname>" , "<email>" , "<password>" 
When  user also can search for a product "<productName>"
And   user can successfully email friend with data "<friendmail>" , "<txtMessage>"   
Then  user can logout at the end

Examples:
|firstname|lastname|email|password|productName|friendmail|txtMessage|
|friend1|friend2|friend21@friend2.com|123456|mac|anotherFriend12@friend.com|hi this txt message |