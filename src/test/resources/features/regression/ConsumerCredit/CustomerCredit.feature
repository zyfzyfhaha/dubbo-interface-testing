#As a customer, I want to start a credit process
#AC1> Normal process with one relavant - spinsterhood
#AC2> Normal process with one relavant - married
Feature: Regression - ConsumerCredit

  Background: 
    #Service available
    Given Test environment is ready for ICustomerCreditService and IBaseProcessAction

  @test
  Scenario: AC1: Normal process with one relavant - spinsterhood
    Given The consumer credit NOT exist in DB
      | CARD_NO              |
      | '330106198810250017' |
    And Prepare credit expected relavant results
      | fullName | cardType | cardId             | mobile      | borrowerRelationship | guaranteeRelationship | staffId | staffName | creditRemark |
      | 征信测试0    |        1 | 330106198810250017 | 15800000001 |                    1 |                     1 |    3324 | 朱云峰       | Test for AC1 |
      | 征信测试1    |        1 | 330106198810250033 | 15800000002 |                    3 |                     1 |    3324 | 朱云峰       | Test for AC1 |
    When Call ICustomerCreditService.addCustomerCredit to start a credit with credit detail
      | source | customerName | cardType | cardNo             | maritalStatus | inquryBankId | inquryBank      | businessGroupId | businessGroup       | customerManagerId | customerManager | creditStatus |
      |      2 | 征信测试0        |        1 | 330106198810250017 |             2 |          103 | Automation Bank |            1028 | Automation Business |              3324 | 朱云峰             |            0 |
    Then First node expected customer credit should be mapping with DB results and actual response
    And Call 3 BO process interfaces:creditFlowActionAdapterImpl.inti, creditProcessEnterActionImpl.preSubmit and creditProcessLaunchActionImpl.submit2NextNode
      | uId  | userName    | password    | realName | level | companyId | departmentId | bzGroupId | companyName        | departmentName        | bzGroupName         | addrProvince | addrCity | addrArea | status | sysType           | businessType | launchUserId | launchUserName | launchOrganizationId | launchOrganizationName | businessGroupId | businessGroupName   | isSubmitted | isRead | isFinished | nodeKey      | nodeName | nodeIndex | flowIndex | operatorId | operatorName | approvalResult |
      | 3324 | 15868473551 | 15868473551 | 朱云峰      |    20 |      1026 |         1027 |      1028 | Automation Company | Automation Department | Automation Business |       330000 |   330100 |   330106 | NORMAL | CLS_WEB/CLS_ADMIN | CREDIT_FLOW  |         3324 | 朱云峰            |                 1026 | Automation Company     |            1028 | Automation Business |           1 |      1 |          0 | CREDIT_START | 征信开始     |         1 |         1 |       3324 | 朱云峰          |              1 |
    Then Call ICustomerCreditService.editCustomerCreditRelavant to save the credit
      | checkType | checkResult | creditRemark                    |
      |         1 |           1 | customer credit regression test |
      |         1 |           1 | customer credit regression test |
    And Call 2 BO process interfaces: CreditProcessEnterActionImpl.preSubmit and CreditProcessLaunchActionImpl.submit2NextNode
      | NODE_INDEX |
      | '2'        |
    And Call ICustomerCreditService.determinedCustomerCredit to accept credit
      | isAccpeted | creditStatus |
      | true       |            2 |
    Then Call 2 BO process interfaces: CreditProcessAcceptActionImpl.preSubmit and CreditProcessAcceptActionImpl.submit2NextNode
      | NODE_INDEX_STRING | nodeIndex | nodeName | isRead | isFinished | isSubmitted |
      | '3'               |         3 | 征信接受     | true   | true       | true        |
      | '2'               |         2 | 征信录入     | true   | true       | true        |
      | '1'               |         1 | 征信开始     | true   | true       | true        |

  @test
  Scenario: AC2: Normal process with one relavant - married
    Given The consumer credit NOT exist in DB
      | CARD_NO              |
      | '510113199010250010' |
    And Prepare credit expected relavant results
      | fullName | cardType | cardId             | mobile      | borrowerRelationship | guaranteeRelationship | checkType | checkResult | staffId | staffName | creditRemark | netResult | riskStatus |
      | 征信测试0    |        1 | 510113199010250010 | 15800000003 |                    1 |                     1 |         1 |           1 |    3324 | 朱云峰       | Test for AC2 |         1 |          0 |
      | 征信测试1    |        1 | 510113199010250037 | 15800000004 |                    2 |                     1 |         1 |           1 |    3324 | 朱云峰       | Test for AC2 |         1 |          0 |
      | 征信测试2    |        1 | 510113199010250053 | 15800000005 |                    3 |                     1 |         1 |           1 |    3324 | 朱云峰       | Test for AC2 |         1 |          0 |
    When Call ICustomerCreditService.addCustomerCredit to start a credit with credit detail
      | source | customerName | cardType | cardNo             | maritalStatus | inquryBankId | inquryBank      | businessGroupId | businessGroup       | customerManagerId | customerManager | creditStatus |
      |      2 | 征信测试0        |        1 | 510113199010250010 |             2 |          103 | Automation Bank |            1028 | Automation Business |              3324 | 朱云峰             |            0 |
    Then First node expected customer credit should be mapping with DB results and actual response
    And Call 3 BO process interfaces:creditFlowActionAdapterImpl.inti, creditProcessEnterActionImpl.preSubmit and creditProcessLaunchActionImpl.submit2NextNode
      | uId  | userName    | password    | realName | level | companyId | departmentId | bzGroupId | companyName        | departmentName        | bzGroupName         | addrProvince | addrCity | addrArea | status | sysType           | businessType | launchUserId | launchUserName | launchOrganizationId | launchOrganizationName | businessGroupId | businessGroupName   | isSubmitted | isRead | isFinished | nodeKey      | nodeName | nodeIndex | flowIndex | operatorId | operatorName | approvalResult |
      | 3324 | 15868473551 | 15868473551 | 朱云峰      |    20 |      1026 |         1027 |      1028 | Automation Company | Automation Department | Automation Business |       330000 |   330100 |   330106 | NORMAL | CLS_WEB/CLS_ADMIN | CREDIT_FLOW  |         3324 | 朱云峰            |                 1026 | Automation Company     |            1028 | Automation Business |           1 |      1 |          0 | CREDIT_START | 征信开始     |         1 |         1 |       3324 | 朱云峰          |              1 |
    Then Call ICustomerCreditService.editCustomerCreditRelavant to save the credit
      | checkType | checkResult | creditRemark                    |
      |         1 |           1 | customer credit regression test |
      |         1 |           1 | customer credit regression test |
      |         1 |           1 | customer credit regression test |
    And Call 2 BO process interfaces: CreditProcessEnterActionImpl.preSubmit and CreditProcessLaunchActionImpl.submit2NextNode
      | NODE_INDEX |
      | '2'        |
    And Call ICustomerCreditService.determinedCustomerCredit to accept credit
      | isAccpeted | creditStatus |
      | true       |            2 |
    Then Call 2 BO process interfaces: CreditProcessAcceptActionImpl.preSubmit and CreditProcessAcceptActionImpl.submit2NextNode
      | NODE_INDEX_STRING | nodeIndex | nodeName | isRead | isFinished | isSubmitted |
      | '3'               |         3 | 征信接受     | true   | true       | true        |
      | '2'               |         2 | 征信录入     | true   | true       | true        |
      | '1'               |         1 | 征信开始     | true   | true       | true        |
