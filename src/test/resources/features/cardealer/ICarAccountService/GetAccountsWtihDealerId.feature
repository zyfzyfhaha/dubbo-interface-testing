#As a consumer, I want to get the account information after call the ICarAccount Service with dealerId
#AC1> Get single or multiple car dealer account detail successfully
#AC2> Get null car dealer account detail
Feature: ICarAccountService - getAccounts with dealerId

  Background: 
    #Service available
    Given Test environment is ready for ICarAccountService

  @test
  Scenario Outline: Get single or multiple car dealer account detail successfully
    Given The account detail exsit in DB
      | DEALER_ID | <DEALER_ID> |
    When Call the interface with specific dealer id
    Then The account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get single or multiple car dealer account detail successfully(1025 = single, 1026 = multiple)
      | DEALER_ID |
      |      1025 |
      |      1026 |

  @test
  Scenario Outline: Get null car dealer account detail
    Given The account detail NOT exsit in DB
      | DEALER_ID | <DEALER_ID> |
    When Call the interface with specific dealer id
    Then The null account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get none car dealer account detail successfully
      | DEALER_ID |
      |      9999 |
