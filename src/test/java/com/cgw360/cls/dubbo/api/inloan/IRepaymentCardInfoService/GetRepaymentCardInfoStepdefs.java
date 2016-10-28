package com.cgw360.cls.dubbo.api.inloan.IRepaymentCardInfoService;

/**
 * Author: zyf
 * Time: 03-31-2016
 */

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.codehaus.jackson.io.JsonStringEncoder;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;


import com.cgw360.cls.api.inloan.IRepaymentCardInfoService;
import com.cgw360.cls.dubbo.base.SpringContextHolder;
import com.cgw360.cls.dubbo.common.AbstractStepdefs;
import com.cgw360.cls.dubbo.dao.IRepaymentCardInfoService.GetRepaymentCardInfoDao;
import com.cgw360.cls.dubbo.model.IRepaymentCardInfoService.JsonRepaymentCardInfo;
import com.cgw360.cls.dubbo.model.IRepaymentCardInfoService.JsonRepaymentCardInfoModule;
import com.cgw360.cls.dao.inloan.IRepaymentCardInfoDao;
import com.cgw360.cls.model.inloan.RepaymentCardInfo;
import com.google.common.reflect.TypeToken;
import com.za.model.ZaUser;
import com.za.util.ResultDO;

import org.h2.util.New;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ro.Datefiind;

public class GetRepaymentCardInfoStepdefs {
	
	private String config = "";
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
	private static final Logger LOGGER = Logger.getLogger(GetRepaymentCardInfoStepdefs.class);
	private IRepaymentCardInfoService service;
	private JsonRepaymentCardInfo expectedresults;
	private JsonRepaymentCardInfo actualResults;
	private String projectId = "";
	private String id = "";
	private String conumerPackage ="com/cgw360/cls/dubbo/consumer/inloan";
	private String actualOutputJsonString = "";
	private String expectedErrorMessageString = "";
	private GetRepaymentCardInfoDao repaymentCardInfoDao;
	
	@Given("^Test environment is ready for IRepaymentCardInfoService$")
	public void inti()throws Throwable{
		repaymentCardInfoDao = (GetRepaymentCardInfoDao) SpringContextHolder.getBean(GetRepaymentCardInfoDao.class);
		config = conumerPackage + "/IRepaymentCardInfoService.xml";
		context = new ClassPathXmlApplicationContext(config);
		context.start();
		
	}
	
	@Given("^The card information exsit in DB$")
	public void prepareTestDataForAc1(final Map<String, String> args) throws Throwable{
//		Clear duplicate test data 
		repaymentCardInfoDao.deleteSql("RepaymentCardInfo","getRepaymentCardInfo");
		
//		Insert new test data
		repaymentCardInfoDao.addSql("RepaymentCardInfo","getRepaymentCardInfo");
		
		projectId = args.get("PROJECT_ID");
		id = repaymentCardInfoDao.getId(projectId);
		Assert.assertTrue(repaymentCardInfoDao.isRepaymentCardInfoExistInDb(id));
		if(repaymentCardInfoDao.isRepaymentCardInfoExistInDb(id)){
			expectedresults = repaymentCardInfoDao.getRepaymentCardInfoFromDb(id);
		}
	}

	@Given("^The card information NOT exsit in DB$")
	public void prepareTestDataForAc2(final Map<String, String> args) throws Throwable{
		id = args.get("ID");
		Assert.assertFalse(repaymentCardInfoDao.isRepaymentCardInfoExistInDb(id));
		
	}
	
	@When("^Call the interface with specific id$")
	public void callInterface()throws Throwable{
		long cardId = Long.parseLong(id);
		service = (IRepaymentCardInfoService)context.getBean("repaymentCardInfoService");
		actualOutputJsonString = com.alibaba.fastjson.JSONObject.toJSONString(service.getRepaymentCardInfo(cardId));
		LOGGER.info("============= etRepaymentCardInfo= " + actualOutputJsonString + "=============");
	}
      
	@Then("^The repayment card infomation should be mapping with excepted result properly$")
	public void compareOutputJson() throws Throwable{
		actualResults = repaymentCardInfoDao.getJson(actualOutputJsonString);
		Assert.assertEquals(expectedresults, actualResults);
//		Clear test data
		repaymentCardInfoDao.deleteSql("RepaymentCardInfo","getRepaymentCardInfo");
		
	}
	
	@Then("^The message should be mapping with excepted results properly$")
	public void checkErrorMrssage(final Map<String, String> args)throws Throwable{
		expectedErrorMessageString = args.get("ERROR_MESSAGE");
		Assert.assertEquals(expectedErrorMessageString, actualOutputJsonString);

	}
}