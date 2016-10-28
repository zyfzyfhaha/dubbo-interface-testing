package com.cgw360.cls.dubbo.api.credit.ICustomerCreditService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.util.Args;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.aspectj.weaver.ast.Call;
import org.junit.Assert;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import com.cgw360.cls.api.cardealer.ICarAccountService;
import com.cgw360.cls.api.credit.ICustomerCreditService;
import com.cgw360.cls.api.flow.BusinessType;
import com.cgw360.cls.api.flow.FlowApprovalResult;
import com.cgw360.cls.api.flow.SubmitParam;
import com.cgw360.cls.base.flow.spi.IBaseProcessAction;
import com.cgw360.cls.bss.flow.credit.CreditFlowActionAdapterImpl;
import com.cgw360.cls.bss.flow.credit.impl.CreditProcessAcceptActionImpl;
import com.cgw360.cls.bss.flow.credit.impl.CreditProcessEnterActionImpl;
import com.cgw360.cls.bss.flow.credit.impl.CreditProcessLaunchActionImpl;
import com.cgw360.cls.dubbo.base.SpringContextHolder;
import com.cgw360.cls.dubbo.dao.ICustomerCreditService.AddCustomerCreditDao;
import com.cgw360.cls.dubbo.model.ICustomerCreditService.JsonCustomerCredit;
import com.cgw360.cls.dubbo.model.ICustomerCreditService.JsonCustomerCreditRelavant;
import com.cgw360.cls.dubbo.model.flow.JsonBusinessObjectProcessInfo;
import com.cgw360.cls.model.credit.CustomerCredit;
import com.cgw360.cls.model.credit.CustomerCreditRelavant;


import com.cgw360.cls.model.flow.BusinessObjectProcessInfo;
import com.cgw360.cls.service.credit.impl.CustomerCreditServiceImpl;
import com.za.api.IZaUserService;
import com.za.cls.model.FlowNode;
import com.za.model.ZaUser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class AddCustomerCreditStepdefs {
	
	private static final Logger LOGGER = Logger.getLogger(AddCustomerCreditStepdefs.class);

	//	init
	private AddCustomerCreditDao addCustomerCreditDao;
	String configPath = "";
	String userConfigPath = "";
	private String consumerPackage = "com/cgw360/cls/dubbo/consumer/credit";
	private ClassPathXmlApplicationContext ctx;
	private ICustomerCreditService service;
	
	private String cardNo = "";
	private ZaUser user = new ZaUser();
	
//	input
	private List<CustomerCreditRelavant> inputCustomerCreditRelavantList = new ArrayList<CustomerCreditRelavant>();
	private CustomerCredit inputCustomerCredit = new CustomerCredit(); 
	
//	actual 
	private CustomerCreditRelavant actualCustomerCreditRelavant = new CustomerCreditRelavant();
	private CustomerCredit actualCustomerCredit = new CustomerCredit();
	private JsonCustomerCredit actualCustomerCredit2 = new JsonCustomerCredit();
	
//	expected
	private JsonCustomerCreditRelavant expectedCustomerCreditRelavant = new JsonCustomerCreditRelavant();
	private List<JsonCustomerCreditRelavant> expectedCustomerCreditRelavantList = new ArrayList<JsonCustomerCreditRelavant>();
	private JsonCustomerCredit expectedCustomerCredit = new JsonCustomerCredit();
	
	
	@Given("^Test environment is ready for ICustomerCreditService and IBaseProcessAction$")
	public void inti()throws Throwable{
	    ctx = new ClassPathXmlApplicationContext("applicationContext.xml",consumerPackage + "/ICustomerCreditService.xml");
	    ctx.start();
		addCustomerCreditDao = ctx.getBean(AddCustomerCreditDao.class);
		
	}
	
	@Given("^The consumer credit NOT exist in DB$")
	public void prepareTestDataForAc1(final List<Map<String, String>> args)throws Throwable{

//		Clean dirty data in DB
		addCustomerCreditDao.deleteSql("ICustomerCreditService","addCustomerCredit");
	
//		Check the result that if the test data all clean from db 
		cardNo = args.get(0).get("CARD_NO");
		Assert.assertTrue(addCustomerCreditDao.isCustomerCreditExistInDb(cardNo));
	}
	
	@And("^Prepare credit expected relavant results$")
	public void prepareInputCreditRelavant(final List<Map<String, String>> args)throws Throwable{
		
//		Set up expectedCustomerCreditRelavantList input (just for call service, use developer's model)
		
		int count = args.size();
		for(int i=0; i<count; i++){
			String fullName = args.get(i).get("fullName");
			String cardType = args.get(i).get("cardType");
			String cardId = args.get(i).get("cardId");
			String mobile = args.get(i).get("mobile");
			String borrowerRelationship = args.get(i).get("borrowerRelationship");
			String guaranteeRelationship = args.get(i).get("guaranteeRelationship");
			
			CustomerCreditRelavant inputCustomerCreditRelavant = new CustomerCreditRelavant();
			inputCustomerCreditRelavant.setFullName(fullName);
			inputCustomerCreditRelavant.setCardType(Integer.parseInt(cardType));
			inputCustomerCreditRelavant.setCardId(cardId);
			inputCustomerCreditRelavant.setMobile(mobile);
			inputCustomerCreditRelavant.setBorrowerRelationship(Integer.parseInt(borrowerRelationship));
			inputCustomerCreditRelavant.setGuaranteeRelationship(Integer.parseInt(guaranteeRelationship));
			inputCustomerCreditRelavantList.add(inputCustomerCreditRelavant);
			
			
//			Set up expectedCustomerCreditRelavantList(use test model) at the same time
			JsonCustomerCreditRelavant a = new JsonCustomerCreditRelavant();
			a.setFullName(fullName);
			a.setCardType(Integer.parseInt(cardType));
			a.setCardId(cardId);
			a.setMobile(mobile);
			a.setBorrowerRelationship(Integer.parseInt(borrowerRelationship));
			a.setGuaranteeRelationship(Integer.parseInt(guaranteeRelationship));
			expectedCustomerCreditRelavantList.add(a);
		}
		
	}


	@When("^Call ICustomerCreditService.addCustomerCredit to start a credit with credit detail$")
	public void addCustomerCredit(final List<Map<String, String>> args)throws Throwable{
		
//		Set up CustomerCredit input (just for call service, use developer's model)
		String customerName = args.get(0).get("customerName");
		String source = args.get(0).get("source");
		String cardType = args.get(0).get("cardType");
		String cardNo = args.get(0).get("cardNo");
		String maritalStatus = args.get(0).get("maritalStatus");
		String inquryBankId = args.get(0).get("inquryBankId");
		String inquryBank = args.get(0).get("inquryBank");
		String businessGroupId = args.get(0).get("businessGroupId");
		String businessGroup = args.get(0).get("businessGroup");
		String customerManagerId = args.get(0).get("customerManagerId");
		String customerManager = args.get(0).get("customerManager");
		
		inputCustomerCredit.setCustomerName(customerName);
		inputCustomerCredit.setSource(source);
		inputCustomerCredit.setCardType(cardType);
		inputCustomerCredit.setCardNo(cardNo);
		inputCustomerCredit.setMaritalStatus(Integer.parseInt(maritalStatus));
		inputCustomerCredit.setInquryBankId(Long.parseLong(inquryBankId));
		inputCustomerCredit.setInquryBank(inquryBank);
		inputCustomerCredit.setBusinessGroupId(Long.parseLong(businessGroupId));
		inputCustomerCredit.setBusinessGroup(businessGroup);
		inputCustomerCredit.setCustomerManagerId(Long.parseLong(customerManagerId));
		inputCustomerCredit.setCustomerManager(customerManager);
		inputCustomerCredit.setRelavants(inputCustomerCreditRelavantList);
		
		
//		Set up expectedCustomerCredit(use test model) at the same time
		expectedCustomerCredit.setCustomerName(customerName);
		expectedCustomerCredit.setSource(source);
		expectedCustomerCredit.setCardType(cardType);
		expectedCustomerCredit.setCardNo(cardNo);
		expectedCustomerCredit.setMaritalStatus(Integer.parseInt(maritalStatus));
		expectedCustomerCredit.setInquryBankId(Long.parseLong(inquryBankId));
		expectedCustomerCredit.setInquryBank(inquryBank);
		expectedCustomerCredit.setBusinessGroupId(Long.parseLong(businessGroupId));
		expectedCustomerCredit.setBusinessGroup(businessGroup);
		expectedCustomerCredit.setCustomerManagerId(Long.parseLong(customerManagerId));
		expectedCustomerCredit.setCustomerManager(customerManager);
		expectedCustomerCredit.setRelavants(expectedCustomerCreditRelavantList);
		
//		Call the service, get the actualCustomerCredit
		service = (ICustomerCreditService)ctx.getBean("customerCreditService");
		actualCustomerCredit = service.addCustomerCredit(inputCustomerCredit);
		
//		Transfer this result's model, used in this method only
		String actualCustomerCreditResults = com.alibaba.fastjson.JSONObject.toJSONString(actualCustomerCredit);
		actualCustomerCredit2 = addCustomerCreditDao.getCustomerCreditJson(actualCustomerCreditResults);
		actualCustomerCredit2.setCreateTime(null);
		int count = actualCustomerCredit2.getRelavants().size();
		for(int i=0; i<count; i++){
			actualCustomerCredit2.getRelavants().get(i).setCreateTime(null);
		}
	}
	
	
	@Then("^First node expected customer credit should be mapping with DB results and actual response$")
	public void checkStep1Response()throws Throwable{
//		get actual results from DB
		List<JsonCustomerCreditRelavant> dbCustomerCreditRelavantsList = addCustomerCreditDao.getCustomerCreditRelavantsListFromDb(cardNo);
		JsonCustomerCredit dbCustomerCredit = addCustomerCreditDao.getCustomerCreditFromDb(cardNo);
		dbCustomerCredit.setRelavants(dbCustomerCreditRelavantsList);
		

//		prepare expected Db CustomerCredit results
		JsonCustomerCredit expectedDbCustomerCredit = dbCustomerCredit.clone();
		expectedDbCustomerCredit.setCreditNo(null);
		expectedDbCustomerCredit.setCustomerId(null);
		expectedDbCustomerCredit.setId(null);
		expectedDbCustomerCredit.setCreditStatus(null);
		int count = expectedDbCustomerCredit.getRelavants().size();
		for(int i=0; i<count; i++){
			expectedDbCustomerCredit.getRelavants().get(i).setCreditId(null);
			expectedDbCustomerCredit.getRelavants().get(i).setId(null);
		}
		
//		copmare expected result with db results 
		Assert.assertEquals(expectedCustomerCredit, expectedDbCustomerCredit);
		
//		compare db result with actual results
		Assert.assertEquals(dbCustomerCredit, actualCustomerCredit2);
	}
	

	@And("^Call 3 BO process interfaces:creditFlowActionAdapterImpl.inti, creditProcessEnterActionImpl.preSubmit and creditProcessLaunchActionImpl.submit2NextNode$")
	public void preSubmit(final List<Map<String, String>> args)throws Throwable{
	
//		Get ZaUser value for init service from feature
		String uId = args.get(0).get("uId");
		String userName = args.get(0).get("userName");
		String password = args.get(0).get("password");
		String realName = args.get(0).get("realName");
		String level = args.get(0).get("level");
		String companyId = args.get(0).get("companyId");
		String departmentId = args.get(0).get("departmentId");
		String bzGroupId = args.get(0).get("bzGroupId");
		String companyName = args.get(0).get("companyName");
		String departmentName = args.get(0).get("departmentName");
		String bzGroupName = args.get(0).get("bzGroupName");
		String addrProvince = args.get(0).get("addrProvince");
		String addrCity = args.get(0).get("addrCity");
		String addrArea = args.get(0).get("addrArea");
		String status = args.get(0).get("status");
		String sysType = args.get(0).get("sysType");
		
		
		user.setUid(Long.parseLong(uId));
		user.setUsername(userName);
		user.setPassword(password);
		user.setRealname(realName);
		user.setLevel(Long.parseLong(level));
		user.setCompanyId(Long.parseLong(companyId));
		user.setDepartmentId(Long.parseLong(departmentId));
		user.setBzGroupId(Long.parseLong(bzGroupId));
		user.setCompanyName(companyName);
		user.setDepartmentName(departmentName);
		user.setBzGroupName(bzGroupName);
		user.setAddrProvince(addrProvince);
		user.setAddrCity(addrCity);
		user.setAddrArea(addrArea);
		user.setStatus(status);
		user.setSysType(sysType);
		
		
////		Get expected BusinessObjectProcessInfo from feature and DB
//		
//		String businessType = args.get(0).get("businessType");
//		String flowIndex = args.get(0).get("flowIndex");
//		String isSubmitted = args.get(0).get("isSubmitted");
//		String isFinished = args.get(0).get("isFinished");
//		String isRead = args.get(0).get("isRead");
//		String nodeIndex = args.get(0).get("nodeIndex");
//		String nodeKey = args.get(0).get("nodeKey");
//		String nodeName = args.get(0).get("nodeName");
//		String operatorId = args.get(0).get("operatorId");
//		String operatorName = args.get(0).get("operatorName");
////		String createDateTime = args.get(0).get("createDateTime");
//		String approvalResult = args.get(0).get("approvalResult");
////		String approvalDateTime = args.get(0).get("approvalDateTime");
//		String launchOrganizationId = args.get(0).get("launchOrganizationId");
//		String launchOrganizationName = args.get(0).get("launchOrganizationName");
//		String launchUserId = args.get(0).get("launchUserId");
//		String launchUserName = args.get(0).get("launchUserName");
//		
//		String businessGroupId = args.get(0).get("businessGroupId");
//		String businessGroupName = args.get(0).get("businessGroupName");
//
//		/*		
//	 	*Should be get from DB
//		 *
//		 *String setBorrowerId = args.get(0).get("borrowerId");
//		 *String setBorrowerName = args.get(0).get("borrowerName");
//		 *String setBusinessNum = args.get(0).get("businessNum");
//		 *String setBusinessObjectId = args.get(0).get("businessObjectId");
//		*/		
//
////		Set up BusinessObjectProcessInfo input
//		BusinessObjectProcessInfo expectedBusinessObjectProcessInfo = new BusinessObjectProcessInfo();
//		
//		expectedBusinessObjectProcessInfo = addCustomerCreditDao.getInputBusinessObjectProcessInfoFromDb(expectedBusinessObjectProcessInfo,cardNo);
//		
//		expectedBusinessObjectProcessInfo.setBusinessType(businessType);
//		expectedBusinessObjectProcessInfo.setFlowIndex(Integer.parseInt(flowIndex));
//		expectedBusinessObjectProcessInfo.setIsSubmitted(Boolean.parseBoolean(isSubmitted));
//		expectedBusinessObjectProcessInfo.setIsFinished(Boolean.parseBoolean(isFinished));
//		expectedBusinessObjectProcessInfo.setIsRead(Boolean.parseBoolean(isRead));
//		expectedBusinessObjectProcessInfo.setNodeIndex(Integer.parseInt(nodeIndex));
//		expectedBusinessObjectProcessInfo.setNodeKey(nodeKey);
//		expectedBusinessObjectProcessInfo.setNodeName(nodeName);
//		expectedBusinessObjectProcessInfo.setOperatorId(Long.parseLong(operatorId));
//		expectedBusinessObjectProcessInfo.setOperatorName(operatorName);
//		expectedBusinessObjectProcessInfo.setCreateDateTime(new Date());
//		expectedBusinessObjectProcessInfo.setApprovalResult(Integer.parseInt(approvalResult));
//		expectedBusinessObjectProcessInfo.setLaunchOrganizationId(Long.parseLong(launchOrganizationId));
//		expectedBusinessObjectProcessInfo.setLaunchOrganizationName(launchOrganizationName);
//		expectedBusinessObjectProcessInfo.setLaunchUserId(Long.parseLong(launchUserId));
//		expectedBusinessObjectProcessInfo.setLaunchUserName(launchUserName);
//		expectedBusinessObjectProcessInfo.setBusinessGroupId(Long.parseLong(businessGroupId));
//		expectedBusinessObjectProcessInfo.setBusinessGroupName(businessGroupName);
		
		
		
		
//		Call inti Service
		// 	Set id, customer_id, credit_no into inputCustomerCredit where get from Customer_Credit table 
		inputCustomerCredit = addCustomerCreditDao.setIdToInputCustomerCredit(inputCustomerCredit, cardNo);
		CreditFlowActionAdapterImpl creditFlowActionAdapterImpl = (CreditFlowActionAdapterImpl)ctx.getBean("creditFlowProcessActionAdapterImpl");
		BusinessObjectProcessInfo inti = creditFlowActionAdapterImpl.init(user, inputCustomerCredit, null);
		

		CreditProcessLaunchActionImpl creditProcessLaunchActionImpl = (CreditProcessLaunchActionImpl)ctx.getBean("creditProcessLaunchActionImpl");

		//		Call preSubmit service with inti results
		SubmitParam actualPreSubmitResults = creditProcessLaunchActionImpl.preSubmit(inti);
//		Call submit 2 next node service
		SubmitParam actualSubmit2NextNodeResults = creditProcessLaunchActionImpl.submit2NextNode(actualPreSubmitResults.getNextUsers().get(0).getUid(), actualPreSubmitResults.getNextUsers().get(0).getRealname(), actualPreSubmitResults.getCurrentBOPInfo());
		
		
		Assert.assertTrue(addCustomerCreditDao.isSubmitSuccessfullyBetween1And2Node(cardNo));
	}
	
	
	@Then("^Call ICustomerCreditService.editCustomerCreditRelavant to save the credit$")
	public void editCustomerCreditRelavant(final List<Map<String, String>> args)throws Throwable{
		
		String checkType = args.get(0).get("checkType"); 
		String checkResult = args.get(0).get("checkResult"); 
		String creditRemark = args.get(0).get("creditRemark");
		
//		prepare input customer credit relavant
		int expectedCount = args.size();
		for(int i=0; i<expectedCount; i++){
			if(expectedCount == actualCustomerCredit.getRelavants().size()){
				actualCustomerCredit.setCreditStatus(1);
				for(CustomerCreditRelavant ccr : actualCustomerCredit.getRelavants()){
					ccr.setCheckType(Integer.parseInt(checkType));
					ccr.setCheckResult(Integer.parseInt(checkResult));
					ccr.setCreditRemark(creditRemark);	
				}
			
			}
			
			else {
				Assert.assertTrue("actualcount not mapping with expectedCount", false);
			}
		}
		
//		Check the service.updateCreditResult result
		int p = 0;
		if(expectedCount == 2){
			p = service.updateCreditResult(actualCustomerCredit.getRelavants().get(0),actualCustomerCredit.getRelavants().get(1));
		}
		if(expectedCount == 3){
			p = service.updateCreditResult(actualCustomerCredit.getRelavants().get(0),actualCustomerCredit.getRelavants().get(1),actualCustomerCredit.getRelavants().get(2));
		}
		Assert.assertEquals(expectedCount, p);
		
		
//		Check the actual result and db results
		List<JsonCustomerCreditRelavant> actualDbCustomerCreditRelavant = addCustomerCreditDao.getCustomerCreditRelavantsListFromDb(cardNo);
		JsonCustomerCredit actualDbCustomerCredit = addCustomerCreditDao.getCustomerCreditFromDb(cardNo);
		actualDbCustomerCredit.setRelavants(actualDbCustomerCreditRelavant);
		
		//	Translate CustomerCredit to JsonCustomerCredit
		String actualCustomerCreditResults = com.alibaba.fastjson.JSONObject.toJSONString(actualCustomerCredit);
		actualCustomerCredit2 = addCustomerCreditDao.getCustomerCreditJson(actualCustomerCreditResults);
		
		actualCustomerCredit2.setCreateTime(null);
		int count = actualCustomerCredit2.getRelavants().size();
		for(int i=0; i<count; i++){
			actualCustomerCredit2.getRelavants().get(i).setCreateTime(null);
		}
		
		Assert.assertEquals(actualDbCustomerCredit, actualCustomerCredit2);
	}
	
	
	@And("Call 2 BO process interfaces: CreditProcessEnterActionImpl.preSubmit and CreditProcessLaunchActionImpl.submit2NextNode")
	public void callBoProcessInterfaceBwtween2And3(final List<Map<String, String>> args)throws Throwable{
		
		String nodeIndex = args.get(0).get("NODE_INDEX");
			
//		prepare businessObjectProcessInfo
		BusinessObjectProcessInfo businessObjectProcessInfo = addCustomerCreditDao.getBusinessObjectProcessInfoFromDbFor23Node(cardNo,nodeIndex);
		businessObjectProcessInfo = addCustomerCreditDao.setIdToExpectedBusinessObjectProcessInfo(businessObjectProcessInfo, cardNo);		
		

		CreditProcessEnterActionImpl creditProcessEnterActionImpl = (CreditProcessEnterActionImpl)ctx.getBean("creditProcessEnterActionImpl");

//		Call CreditProcessEnterActionImpl.preSubmit service
		SubmitParam actualPreSubmitResults = creditProcessEnterActionImpl.preSubmit(businessObjectProcessInfo);
		
//		Call CreditProcessEnterActionImpl.submit2NextNode service
		SubmitParam actualSubmit2NextNodeResults = creditProcessEnterActionImpl.submit2NextNode(actualPreSubmitResults.getNextUsers().get(0).getUid(), actualPreSubmitResults.getNextUsers().get(0).getRealname(), actualPreSubmitResults.getCurrentBOPInfo());
	}
	
	
	@And("^Call ICustomerCreditService.determinedCustomerCredit to accept credit$")
	public void acceptCredit(final List<Map<String, String>> args)throws Throwable{
	
		String isAccepted = args.get(0).get("isAccpeted");
		String creditStatus = args.get(0).get("creditStatus");
		
		Long customerCreditId = addCustomerCreditDao.getCreditIdFromDb(cardNo);
		int expectedCount = 0;
		
//		prepare expectedCount
		if(Integer.parseInt(creditStatus) == 2){
			expectedCount = 1;
		}
		else{
			expectedCount = 2;
		}
		int actualCount = service.determinedCustomerCredit(user, customerCreditId, Boolean.parseBoolean(isAccepted));

//		check the actual results 
		Assert.assertEquals(expectedCount, actualCount);
		
//		check credit status in db
		Assert.assertTrue(addCustomerCreditDao.checkCreditStatus(cardNo));
	}
	
	@Then("^Call 2 BO process interfaces: CreditProcessAcceptActionImpl.preSubmit and CreditProcessAcceptActionImpl.submit2NextNode$")
	public void callBoProcessInterfaceAfter3(final List<Map<String, String>> args)throws Throwable{
		
		int count = args.size();
		String NODE_INDEX_STRING = args.get(0).get("NODE_INDEX_STRING");
		
		
//		prepare businessObjectProcessInfo
		BusinessObjectProcessInfo businessObjectProcessInfo = addCustomerCreditDao.getBusinessObjectProcessInfoFromDbFor23Node(cardNo,NODE_INDEX_STRING);
		businessObjectProcessInfo = addCustomerCreditDao.setIdToExpectedBusinessObjectProcessInfo(businessObjectProcessInfo, cardNo);
		
		CreditProcessAcceptActionImpl creditProcessAcceptActionImpl = (CreditProcessAcceptActionImpl)ctx.getBean("creditProcessAcceptActionImpl");
		
//		Call CreditProcessAcceptActionImpl.preSubmit service
		SubmitParam actualPreSubmitResults = creditProcessAcceptActionImpl.preSubmit(businessObjectProcessInfo);

//		Call CreditProcessAcceptActionImpl.submit2NextNode service
		SubmitParam actualSubmit2NextNodeResults = creditProcessAcceptActionImpl.submit2NextNode(actualPreSubmitResults.getNextUsers().get(0).getUid(), actualPreSubmitResults.getNextUsers().get(0).getRealname(), actualPreSubmitResults.getCurrentBOPInfo());
		
		
//		Prepare expected result for List<BusinessObjectProcessInfo>
		List<BusinessObjectProcessInfo> expectedBopiList = new ArrayList<BusinessObjectProcessInfo>();
		for(int i=0; i<count; i++){
			BusinessObjectProcessInfo expectedBopi = new BusinessObjectProcessInfo();

			expectedBopi.setNodeIndex(Integer.parseInt(args.get(i).get("nodeIndex")));
			expectedBopi.setNodeName(args.get(i).get("nodeName"));
			expectedBopi.setIsRead(Boolean.parseBoolean(args.get(i).get("isRead")));
			expectedBopi.setIsFinished(Boolean.parseBoolean(args.get(i).get("isFinished")));
			expectedBopi.setIsSubmitted(Boolean.parseBoolean(args.get(i).get("isSubmitted")));
			expectedBopiList.add(expectedBopi);
		}
		
		List<BusinessObjectProcessInfo> actualBopiList = addCustomerCreditDao.businessObjectProcessInfoAfter3Node(cardNo);
		
//		Transfer to test model
		List<JsonBusinessObjectProcessInfo> expectedBopiList2 = addCustomerCreditDao.getBusinessObjectProcessInfoJson(com.alibaba.fastjson.JSONObject.toJSONString(expectedBopiList));
		List<JsonBusinessObjectProcessInfo> actualBopiList2 = addCustomerCreditDao.getBusinessObjectProcessInfoJson(com.alibaba.fastjson.JSONObject.toJSONString(actualBopiList));
		
		Assert.assertTrue(addCustomerCreditDao.compare(expectedBopiList2, actualBopiList2));
		
//		Clean test data in DB
		addCustomerCreditDao.deleteSql("ICustomerCreditService","addCustomerCredit");
		
	}
	
	

}
