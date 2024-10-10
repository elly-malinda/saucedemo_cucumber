Feature: Login to saucedemo Application

  Scenario Outline: Authenticate Valid User
    Given I launched saucedemo application home page
    When I Login with valid user "<username>" and pwd "<pwd>"
    Then I verify that user is successfully authenticated
    Examples:
    | username       |  pwd           |
    | standard_user  |  secret_sauce  |