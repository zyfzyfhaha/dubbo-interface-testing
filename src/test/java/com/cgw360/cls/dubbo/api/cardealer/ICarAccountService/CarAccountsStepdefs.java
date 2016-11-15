package com.cgw360.cls.dubbo.api.cardealer.ICarAccountService;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Assert;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

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
 * @date   2016年4月28日
 */



public class CarAccountsStepdefs {
	
	private static final Logger LOGGER = Logger.getLogger(CarAccountsStepdefs.class);
	private GetAccountsDao getAccountsDao;
	private String config;
	private String consumerPackage = "com/cgw360/cls/dubbo/consumer/cardealer";
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
	private String dealerId = "";
	private String status = "";
	private ICarAccountService service;
	private List<JsonCarAccounts> expectedResults;
	private List<JsonCarAccounts> actualResults;
	private String expectedOutputJsonString = "";
	private String actualOutputJsonString = "";
		
	@Given("^Test environment is ready for ICarAccountService$") 
	public void inti()throws Throwable{
		getAccountsDao = (GetAccountsDao) SpringContextHolder.getBean(GetAccountsDao.class);
		config = consumerPackage + "/ICarAccountService.xml";
		context = new ClassPathXmlApplicationContext(config);
		context.start();
	}
	
	@Given("^The account detail exsit in DB$")
	public void prepareTestDataForAc1(final Map<String, String> args)throws Throwable{
		dealerId = args.get("DEALER_ID");
		status = args.get("STATUS");
		
		if(status == null){
			getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerId");
			getAccountsDao.addSql("GetAccounts","getAccountsWithDealerId");
			Assert.assertTrue(getAccountsDao.isCarDealerAccountExistInDb(dealerId));
			expectedResults = getAccountsDao.getAccountSDetailFromDb(dealerId);
		}
		
		if(status != null){
			getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerIdAndStatus");
			getAccountsDao.addSql("GetAccounts","getAccountsWithDealerIdAndStatus");
			Assert.assertTrue(getAccountsDao.isCarDealerAccountExistInDb2(dealerId,status));
			expectedResults = getAccountsDao.getAccountSDetailFromDb2(dealerId,status);
		}
		
	}
	
	@When("^Call the interface with specific dealer id$")
	public void callService()throws Throwable{
		Long dealer_Id = Long.parseLong(dealerId);
		service = (ICarAccountService)context.getBean("carAccountService");
		actualOutputJsonString = com.alibaba.fastjson.JSONObject.toJSONString(service.getAccounts(dealer_Id));
		LOGGER.info("============= actual RepaymentCardInfo= " + actualOutputJsonString + "=============");
	}
	
	@Then("^The account detail should be mapping with excepted result properly$")
	public void checkResponse()throws Throwable{
		actualResults = getAccountsDao.getJson(actualOutputJsonString);
		Assert.assertTrue(getAccountsDao.compare(expectedResults, actualResults));
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerId");
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerIdAndStatus");
	}
	
	@Given("^The account detail NOT exsit in DB$")
	public void prepareTestDataForAc2(final Map<String, String> args)throws Throwable{
		dealerId = args.get("DEALER_ID");
		status = args.get("STATUS");
		
		if(status == null){
			getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerId");
			getAccountsDao.addSql("GetAccounts","getAccountsWithDealerId");
			Assert.assertFalse(getAccountsDao.isCarDealerAccountExistInDb(dealerId));
			expectedOutputJsonString = "[]";
		}
		
		if(status != null){
			getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerIdAndStatus");
			getAccountsDao.addSql("GetAccounts","getAccountsWithDealerIdAndStatus");
			Assert.assertFalse(getAccountsDao.isCarDealerAccountExistInDb2(dealerId,status));
			expectedOutputJsonString = "[]";
		}
		
	}
	
	@Then("^The null account detail should be mapping with excepted result properly$")
	public void checkResponseNone()throws Throwable{
		Assert.assertEquals(expectedOutputJsonString, actualOutputJsonString);
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerId");
		getAccountsDao.deleteSql("GetAccounts","getAccountsWithDealerIdAndStatus");
	}
	
	@When("^Call the interface with specific dealer id and status$")
	public void callServiceWithStatus()throws Throwable{
		service = (ICarAccountService) context.getBean("carAccountService");
		actualOutputJsonString = com.alibaba.fastjson.JSONObject.toJSONString(service.getAccounts(Long.parseLong(dealerId), Integer.parseInt(status)));
		LOGGER.info("============= actual RepaymentCardInfo= " + actualOutputJsonString + "=============");
	}
	
	
	public static void main(String[] args) {
		try {
			String t = "";
			Integer.parseInt(null);
			
		} catch (Exception e) {
			
			throw e;
			
//			LOGGER.info(e.toString());
			
//		     // 记录debug级别的信息  
//	        LOGGER.debug("This is debug message.");  
//	        // 记录info级别的信息  
//	        LOGGER.info("This is info message.");  
//	        // 记录error级别的信息  
//	        LOGGER.error("This is error message.");  
			
		}

   
	}
	
}
