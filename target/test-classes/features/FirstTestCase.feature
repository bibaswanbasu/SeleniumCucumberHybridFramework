Feature: Title of your feature
  I want to use this template for my feature file
  
  Background:
  	Given I am on Tools QA Home Page

  @smoke1 @regression @skip
  Scenario: Validate Page Title
    Then the user should see the title "DEMOQA"
    
    
  @smoke1
  Scenario: Validate Training page should open by clicking on the Grid
    When click on Training Iamge
    Then user Navigate to Traing page
    And Below options should be there in the Page:
    | HOME |
    | SELENIUM TRAINING |
    | DEMO SITE |
    | ABOUT |
    
  @smoke1
  Scenario: ISTQB preparation should be under QA Practice
  	When click on Training Iamge
    Then user Navigate to Traing page
    Given Clicking on the Tutorials mennu
    And Mouseover on QA Practices
    Then ISTQB preparation should be visible
    
    
  @smoke2
  Scenario: Successful form submission with valid data
    Given I am on the Student Registration Form page
	  When I enter the following valid information:
	  
	@smoke
  Scenario: Validate Bookstore Table
    Given I am on the Book Store page
	  When Fetch The data from book store