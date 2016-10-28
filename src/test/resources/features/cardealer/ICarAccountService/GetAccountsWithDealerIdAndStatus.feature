#As a consumer, I want to get the account information after call the ICarAccount Service with dealerId and status
#AC1> Get single or multiple car dealer account detail successfully
#AC2> Get null car dealer account detail
Feature: ICarAccountService - getAccounts with dealerId and status

  Background: 
    #Service available
    Given Test environment is ready for ICarAccountService

  @test
  Scenario Outline: Get single or multiple car dealer account detail successfully
    Given The account detail exsit in DB
      | DEALER_ID | <DEALER_ID> |
      | STATUS    | <STATUS>    |
    When Call the interface with specific dealer id and status
    Then The account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get single or multiple car dealer account detail successfully (1025 = single, 1026 = multiple)
      | DEALER_ID | STATUS |
      |      1025 |      1 |
      |      1025 |      0 |
      |      1026 |      1 |
      |      1026 |      0 |

  @test
  Scenario Outline: Get null car dealer account detail
    Given The account detail NOT exsit in DB
      | DEALER_ID | <DEALER_ID> |
      | STATUS    | <STATUS>    |
    When Call the interface with specific dealer id and status
    Then The null account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get none car dealer account detail successfully
      | DEALER_ID | STATUS |
      |      9999 |      1 |
