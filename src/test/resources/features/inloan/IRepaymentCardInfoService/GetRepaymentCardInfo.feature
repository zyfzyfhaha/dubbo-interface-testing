#As a consumer, I want to get the repayment card infomation after call the IRepaymentCardInfo Service
#AC1> Get repayment card infomation successfully
#AC2> Get the error message
Feature: IRepaymentCardInfoService

  Background: 
    #Service available
    Given Test environment is ready for IRepaymentCardInfoService

  @test
  Scenario Outline: AC1 Get repayment card infomation
    Given The card information exsit in DB
      | PROJECT_ID | <PROJECT_ID> |
    When Call the interface with specific id
    Then The repayment card infomation should be mapping with excepted result properly

    # And The success message should be mapping with excepted result properly
    #   | SUCCESS_MESSAGE | <SUCCESS_MESSAGE> |
    Examples: AC1_Case1: Get repayment card infomation successfully
      | PROJECT_ID |
      |       1025 |

  @test
  Scenario Outline: AC2 Get the error message
    Given The card information NOT exsit in DB
      | ID | <ID> |
    When Call the interface with specific id
    Then The message should be mapping with excepted results properly
      | ERROR_MESSAGE | <ERROR_MESSAGE> |

    Examples: AC2_Case1: Get the error message
      | ID | ERROR_MESSAGE                   |
      | -1 | {"msg":"参数不正确","success":false} |
