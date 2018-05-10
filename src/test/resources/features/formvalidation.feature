# language: en
@formvalidation
Feature: Form validation

  Scenario Outline: Verification of user data in the registration form
    Given Open the browser and registration page
    When Enter incorrect the <surname>, <name>, <login>, <email>, <password>, <repeat password>
    And Choose or do not choose the following items: <birth day>, <birth month>, <birth year>, <country>, <city>
    Then The registration button is clicked and data is checked

  Examples:
    # true - choose, false - do not choose
    |surname|name|login    |email       |password|repeat password|birth day    |birth month |birth year|country|city  |
    |Test   |Test|ts       |            |pass12  |passwd         |false        |false       |true      |true   |false |
    |       |    |testlogin|test@mail.ru|        |               |true         |true        |false     |false  |false |