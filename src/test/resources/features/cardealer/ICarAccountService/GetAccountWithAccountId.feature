#As a consumer, I want to get the account information after call the ICarAccount Service with accountId
#AC1> Get single car dealer account detail successfully
#AC2> Get null car dealer account detail
Feature: ICarAccountService - getAccounts with accountId

  Background: 
    #Service available
    Given Test environment is ready for ICarAccountService getAccount with accountId

  @test
  Scenario Outline: Get single or multiple car dealer account detail successfully
    Given Single account detail exsit in DB
      | ACCOUNT_ID | <ACCOUNT_ID> |
    When Call the interface with specific account id
    Then Single account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get single car dealer account detail successfully
      | ACCOUNT_ID |
      |       1025 |

  @test
  Scenario Outline: Get null car dealer account detail
    Given Single account detail NOT exsit in DB
      | ACCOUNT_ID | <ACCOUNT_ID> |
    When Call the interface with specific account id
    Then Single null account detail should be mapping with excepted result properly

    Examples: AC2_Case1: Single account detail NOT exsit in DB
      | ACCOUNT_ID |
      |       9999 |
