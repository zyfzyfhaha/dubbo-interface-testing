package com.cgw360.cls.dubbo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * cucumber auto test suit.
 * 
 * @author zyf
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@test"}, features = {
		
//		"src/test/resources/features"

//		"src/test/resources/features/inloan/IRepaymentCardInfoService/GetRepaymentCardInfo.feature"
//		"src/test/resources/features/cardealer/ICarAccountService/GetAccountsWithDealerId.feature"
//		"src/test/resources/features/cardealer/ICarAccountService/GetAccountsWithDealerIdAndStatus.feature"
//		"src/test/resources/features/cardealer/ICarAccountService/GetAccountWithAccountId.feature"
		"src/test/resources/features/regression/ConsumerCredit/CustomerCredit.feature" 


		}, monochrome = true, format = {
        "pretty", "html:target/cucumber",
        "json:target/cucumber/test-report.json",
        "junit:target/cucumber/test-report.xml" })


public class ClsDubboRunCukesTest {

	
	
}
