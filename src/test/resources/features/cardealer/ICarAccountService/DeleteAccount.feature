#As a consumer, I want to delete car account after call the ICarAccount Service with accountId
#AC1> Delete single car dealer account detail successfully

Feature: ICarAccountService - delete Account

  Background: 
    #Service available
    Given Test environment is ready for ICarAccountService getAccount with accountId

  @test
  Scenario Outline: Get single car dealer account detail successfully
    Given Single account detail exsit in DB
      | ACCOUNT_ID | <ACCOUNT_ID> |
    When Call the interface with specific account id
    Then Single account detail should be mapping with excepted result properly

    Examples: AC1_Case1: Get single car dealer account detail successfully
      | ACCOUNT_ID |
      |       1025 |
