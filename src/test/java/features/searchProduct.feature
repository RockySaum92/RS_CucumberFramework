Feature: Search and Place order for products
@SearchProduct
Scenario Outline: Search experience for product search in both Home and Offers page

Given user is on GreenKart landing page 
When user searched with shortcut <Name> and extracted actual name of product 
Then user searched for <Name> shortcut in offers page
And Validate product name in offer page matches withlanding page

Examples:
|	Name	|
|	Tom		|
|	Beet	|