@Smoke @Regression @Functional
Feature: login function test
Background:
   Given open browser
   And go to parabank application login page

  
  
  @Positive @TC_PARA-1
  Scenario: as a parabank user, login sholud success with valid credential 

    When put valid username
    And put valid password
    And click login button
    Then login should pass and logout button should visible 
   
  @Negative @TC_PARA-2
  Scenario: as a parabank user, login sholud fail with invalid username and valid password
   
    When put invalid username
    And put valid password
    And click login button
    Then login should fail and dsiplay message password error
  
  @Negative @TC_PARA-3
  Scenario: as a parabank user, login sholud fail with valid username and invalid password
  
    When put valid username
    And put invalid password
    And click login button
    Then login should fail and dsiplay username error
  
  @Negative @TC_PARA-4
  Scenario: as a parabank user, login sholud fail with null username and password
   
    When put null username
    And put null password
    And click login button
    Then login should fail and dsiplay username error message Please enter a username and password
    
    
    @Negative @TC_PARA-5
  Scenario: as a parabank user, login sholud fail with null username and valid password

    When put null username
    And put valid password
    And click login button
    Then login should fail and dsiplay error message username require
    
    @Negative @TC_PARA-6
  Scenario: as a parabank user, login sholud fail with valid username and nullpassword
   
    When put valid username
    And put null password
    And click login button
    Then login should fail and dsiplay error message password require