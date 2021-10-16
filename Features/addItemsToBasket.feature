Feature: Add Items to the Basket
  To Validate user is able to add items to basket successfully

  @regression
  Scenario Outline: Validate that user is able to add first item to the basket and Continue Shopping to add more Items and Validate Grant total after GST
    Given user launches Chrome browser
    When User navigates to "https://demo.cubecart.com/cc6/index.php" the Home page
    And User clicks on Sale Items in the home page
    And Clicks on Add to Basket for the first Item
    Then Validate errors :"<select_required_options_error>"
    When User selects "<installation_service>" from the drop down
    And clicks Add to Basket
    And clicks on cartIcon
    And clicks on View Basket in the Cart menu
    Then validate the no of items added to the basket
    When User clicks on Continue Shopping button
    And User clicks on Sale Items in the home page
    And Clicks on Add to Basket for the second Item
    Then Validate errors :"<select_required_options_error>"
    When User selects "<colour>" colour from the drop down
    And clicks Add to Basket
    And clicks on cartIcon
    And clicks on View Basket in the Cart menu
    Then validate the no of items added to the basket
    And validate grant total of items in the basket

    Examples: 
      | select_required_options_error                                |  | installation_service |  | colour |
      | Please select required options before adding to your basket. |  | No Thanks!           |  | Black  |

  @regression
  Scenario Outline: Validate that user is able to add multiple items to the basket and Validate Grant Total of the items after GST
    Given user launches Chrome browser
    When User navigates to "https://demo.cubecart.com/cc6/index.php" the Home page
    And User clicks on Sale Items in the home page
    And Clicks on Add to Basket for the first Item
    Then Validate errors :"<select_required_options_error>"
    When User selects "<installation_service>" from the drop down
    And clicks Add to Basket
    And User clicks on Sale Items in the home page
    And Clicks on Add to Basket for the second Item
    Then Validate errors :"<select_required_options_error>"
    When User selects "<colour>" colour from the drop down
    And clicks Add to Basket
    And clicks on cartIcon
    And clicks on View Basket in the Cart menu
    Then validate the no of items added to the basket
    And validate grant total of items in the basket

    Examples: 
      | select_required_options_error                                |  | installation_service |  | colour |
      | Please select required options before adding to your basket. |  | No Thanks!           |  | Black  |
