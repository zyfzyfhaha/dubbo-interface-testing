package com.cgw360.cls.dubbo;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 * @date   2016年4月28日
 */

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import com.cgw360.cls.api.cardealer.ICarAccountService;
import com.cgw360.cls.dubbo.api.credit.ICustomerCreditService.AddCustomerCreditStepdefs;
import com.cgw360.cls.model.flow.BusinessObjectProcessInfo;

public class Sample{
	
	private static String config = "";
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
	private static ICarAccountService service;
	private static String conumerPackage ="com/cgw360/cls/dubbo/consumer/cardealer";
	private static final Logger LOGGER = Logger.getLogger(Sample.class);
	
	public static void main(String[] args) throws Exception{
		
		config = conumerPackage + "/ICarAccountService.xml";
		context = new ClassPathXmlApplicationContext(config);
		context.start();
		service = (ICarAccountService)context.getBean("carAccountService");
		String actualOutputJsonString = com.alibaba.fastjson.JSONObject.toJSONString(service.getAccount(9999L));
		LOGGER.info("=====================actualOutputJsonString =" + actualOutputJsonString +"============================");
		
		
		
	}

}
