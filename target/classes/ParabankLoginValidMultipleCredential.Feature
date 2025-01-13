
@smoke @regression
Feature: login funcation for parabank 

  @positive @TC_1
  Scenario Outline: as a parabank user, login sholud success with valid credential 
    Given open browser
    And go to parabank application login page
    When put valid username <username>
    And put valid password <password>
    And click login button 
    Then login should pass and logout button should visible 
 	
 	

    Examples: 
      | Username | Password  |
      | Row2_Col1| Row2_Col2 |
      | Row3_Col1| Row3_Col2 |
      | Row4_Col1| Row4_Col2 |
      