Feature: Sign in to Amazaon

	Background: 
	Given Chrome browser is invoked
	When Prerequisite when
	And I am landed on amazaon home page
	Then Prerequisite then
  @tag1
  Scenario: Sign in to Amazaon with valid credentials
    Given User is on amazon homepage
    And page is loaded
    When user clicks on sign in button
    And enter valid user name and password
    Then user will be navigated to home page
    And user name will appear

  @SmokeTest
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      
      
   @tag3
    Scenario: Check data flow
    Given User is on amazon homepage
    When user clicks on sign in button
    Then user will be navigated to home page
    And the following details will appear
    |Abhishek|Kumar|12345|ak2@gmail.com|Password
