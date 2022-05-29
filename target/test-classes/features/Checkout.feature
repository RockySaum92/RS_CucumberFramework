Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search experience for product search in both Home and Offers page

Given user is on GreenKart landing page 
When user searched with shortcut <Name> and extracted actual name of product 
And added "3" items of the selected product to cart
Then user proceeds to checkout and validate the <Name> items on checkout page
And Validate user has ability to enter promo code and place the order

Examples:
|	Name	|
|	Tom		|