package com.cgw360.cls.dubbo.api.cardealer.ICarAccountService;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Assert;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgw360.cls.api.cardealer.ICarAccountService;
import com.cgw360.cls.dubbo.base.SpringContextHolder;
import com.cgw360.cls.dubbo.dao.ICarAccountService.GetAccountsDao;
import com.cgw360.cls.dubbo.model.ICarAccountService.JsonCarAccounts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */



public class CarAccountStepdefs {

	private static final Logger LOGGER = Logger.getLogger(CarAccountsStepdefs.class);
	private GetAccountsDao getAccountsDao;
	private String config = "";
	private String consumerPage = "com/cgw360/cls/dubbo/consumer/cardealer";
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
	private String accountId = "";
	private ICarAccountService service;
	private JsonCarAccounts expectedResults;
	private JsonCarAccounts actualResults;
	private String expectedOutputJsonString = "";
	private String actualOutputJsonString = "";
		

	@Given("^Test environment is ready for ICarAccountService getAccount with accountId$")
	public void init()throws Throwable{
		getAccountsDao = (GetAccountsDao) SpringContextHolder.getBean(GetAccountsDao.class);
		config = consumerPage + "/ICarAccountService.xml";
		context = new ClassPathXmlApplicationContext(config);
		context.start();
	}
	
	@Given("^Single account detail exsit in DB$")
	public void prepareTestDataForAc1(final Map<String, String> args)throws Throwable{
		accountId = args.get("ACCOUNT_ID");
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithAccountId");
		getAccountsDao.addSql("GetAccounts","getAccountsWithAccountId");
		Assert.assertTrue(getAccountsDao.isCarDealerAccountExistInDb3(accountId));
		expectedResults = getAccountsDao.getAccountSDetailFromDb3(accountId);
	}
	
	@When("^Call the interface with specific account id$")
	public void callServiceWithAccountId()throws Throwable{
		service = (ICarAccountService)context.getBean("carAccountService");
		actualOutputJsonString = com.alibaba.fastjson.JSONObject.toJSONString(service.getAccount(Long.parseLong(accountId)));
		LOGGER.info("============= actual RepaymentCardInfo= " + actualOutputJsonString + "=============");
	}
	
	@Then("^Single account detail should be mapping with excepted result properly$")
	public void checkSingleResponse()throws Throwable{
		actualResults = getAccountsDao.getJson2(actualOutputJsonString);
		Assert.assertEquals(expectedResults, actualResults);
	}
	
	@Given("^Single account detail NOT exsit in DB$")
	public void prepareTestDataForAc2(final Map<String, String> args)throws Throwable{
		accountId = args.get("ACCOUNT_ID");
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithAccountId");
		getAccountsDao.addSql("GetAccounts","getAccountsWithAccountId");
		Assert.assertFalse(getAccountsDao.isCarDealerAccountExistInDb3(accountId));
	}
	
	
	@Then("^Single null account detail should be mapping with excepted result properly$")
	public void checkSingleNullResponse()throws Throwable{
		if(actualOutputJsonString.equals("null")){
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	
		
	}
	
}
