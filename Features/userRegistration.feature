Feature: userRegistration
  To Validate user valid and invalid registration of a user

  @sanity
  Scenario Outline: Validate user valid and invalid registration
    Given user launches Chrome browser
    When User navigates to "https://demo.cubecart.com/cc6/index.php" the Home page
    And User clicks on Register link in the home page
    And Clicks on Register button
    Then Validate errors :"<firstname_error>""<lastname_error>""<emailaddress_error>""<phoneno_error>""<pwd_error>""<c_pwd_error>""<agree_terms_error>"
    When User enters "<firstname>" in the First Name field
    And User enters "<lastname>" in the Last Name field
    And User enters email in the Email Field
    And User enters "<phone>" in the Phone Field
    And User enters password in the Password field and confirm password in the Confirm Password field
    And User agrees to the terms and conditions
    And User clicks on Register button
    Then Validate errors are gone: "<firstname_error>""<lastname_error>""<emailaddress_error>""<phoneno_error>""<pwd_error>""<c_pwd_error>""<agree_terms_error>"

    Examples: 
      | firstname |  | lastname |  | phone       |  | firstname_error               |  | lastname_error               |  | emailaddress_error                  |  | phoneno_error                          |  | pwd_error                |  | c_pwd_error                  |  | agree_terms_error                       |
      | Amy       |  | Nithin   |  | 02102673739 |  | Please enter your first name. |  | Please enter your last name. |  | Please enter a valid email address. |  | Please enter a valid telephone number. |  | Please enter a password. |  | Your passwords do not match. |  | Please agree to the Terms & Conditions. |
