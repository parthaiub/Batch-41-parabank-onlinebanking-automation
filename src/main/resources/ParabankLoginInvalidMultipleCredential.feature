
@smoke @regression
Feature: login funcation for parabank 



  @positive @TC_1
  Scenario Outline: as a parabank user, login sholud fail with invalid credential 
    Given open browser
    And go to parabank application login page
   
   
    When put invalid username <Username>
    And put invalid password <Password>
    And click login button 
    Then login should fail and logout button should visible 
 	
 	

    Examples: 
      | Username | Password  | 
      | arthaiub | 2345      | 
      | artha    |rtha@12345 | 
      | artha    |    2345   | 
      
      
      
      
      
      