package com.cgw360.cls.dubbo.dao.ICustomerCreditService;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.JsonDeserializer;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Flags.Flag;

import org.apache.poi.ss.formula.functions.Count;
import org.aspectj.apache.bcel.generic.NEW;
import org.aspectj.apache.bcel.generic.RETURN;
import org.nfunk.jep.function.If;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cgw360.cls.dubbo.dao.BaseDButil;
import com.cgw360.cls.dubbo.model.ICustomerCreditService.JsonCustomerCredit;
import com.cgw360.cls.dubbo.model.ICustomerCreditService.JsonCustomerCreditRelavant;
import com.cgw360.cls.dubbo.model.flow.JsonBusinessObjectProcessInfo;
import com.cgw360.cls.model.credit.CustomerCredit;
import com.cgw360.cls.model.credit.CustomerCreditRelavant;
import com.cgw360.cls.model.flow.BusinessObjectProcessInfo;
import com.google.common.reflect.TypeToken;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

@Repository
public class AddCustomerCreditDao extends BaseDButil{

	public JsonCustomerCredit getCustomerCreditJson(String jsonString)throws Throwable{
		Gson gson = new Gson();
		Type typeCollection = new TypeToken<JsonCustomerCredit>(){}.getType();
		JsonCustomerCredit customerCredit = gson.fromJson(jsonString, typeCollection);
		return customerCredit;
	}
	
	public List<JsonBusinessObjectProcessInfo> getBusinessObjectProcessInfoJson(String jsonString)throws Throwable{
		Gson gson = new Gson();
		Type typeCollection = new TypeToken<List<JsonBusinessObjectProcessInfo>>() {}.getType();
		List<JsonBusinessObjectProcessInfo> businessObjectProcessInfoList = gson.fromJson(jsonString, typeCollection);
		return businessObjectProcessInfoList;
	}
	
	
	
	
	public boolean isCustomerCreditExistInDb(String cardId){
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select count(*) from customer_credit where card_no in ("+ cardId +")");
		Integer count = (Integer) jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				int count = 0;
				while(rs.next()){
					count = rs.getInt("count(*)");
				}
				// TODO Auto-generated method stub
				return count;
			}
		});
		
		if(count != 0){
			return false;
		}
		return true;
	}
	
	
	
	
	public List<JsonCustomerCreditRelavant> getCustomerCreditRelavantsListFromDb(String cardNo)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.customer_credit_relavant "
				+ "where credit_id in(select id from cls.customer_credit where card_no in (" + cardNo +"))");
		 List<JsonCustomerCreditRelavant> customerCreditRelavantsList = ( List<JsonCustomerCreditRelavant>) jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<JsonCustomerCreditRelavant>>(){

			@Override
			public List<JsonCustomerCreditRelavant> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
					
				List<JsonCustomerCreditRelavant> customerCreditRelavantsList = new ArrayList<JsonCustomerCreditRelavant>();
				
				while(rs.next()){
					JsonCustomerCreditRelavant customerCreditRelavant = new JsonCustomerCreditRelavant();
					customerCreditRelavant.setBorrowerRelationship(rs.getInt("borrower_relationship"));
					customerCreditRelavant.setCardId(rs.getString("card_id"));
					customerCreditRelavant.setCardType(rs.getInt("card_type"));
					customerCreditRelavant.setCreditId(rs.getLong("credit_id"));
					customerCreditRelavant.setFullName(rs.getString("full_name"));
					customerCreditRelavant.setGuaranteeRelationship(rs.getInt("guarantee_relationship"));
					customerCreditRelavant.setId(rs.getLong("id"));
					customerCreditRelavant.setMobile(rs.getString("mobile"));
					if(rs.getInt("check_type") != 0){
						customerCreditRelavant.setCheckType(rs.getInt("check_type"));
					}
					if(rs.getInt("check_result") != 0){
						customerCreditRelavant.setCheckResult(rs.getInt("check_result"));
					}
					if(rs.getString("credit_remark")!=null){
						customerCreditRelavant.setCreditRemark(rs.getString("credit_remark"));
					}
					
					customerCreditRelavantsList.add(customerCreditRelavant);
				}
				// TODO Auto-generated method stub
				return customerCreditRelavantsList;
			}

		 });
		return customerCreditRelavantsList;
		
	}
	
	
public JsonCustomerCredit getCustomerCreditFromDb(String cardNo)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.customer_credit where card_no in ("+ cardNo +")");
		JsonCustomerCredit customerCredit = (JsonCustomerCredit) jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<JsonCustomerCredit>(){

			@Override
			public JsonCustomerCredit extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				JsonCustomerCredit customerCredit = new JsonCustomerCredit();
				while(rs.next()){
					customerCredit.setBusinessGroup(rs.getString("business_group"));
					customerCredit.setBusinessGroupId(rs.getLong("business_group_id"));
					customerCredit.setCardNo(rs.getString("card_no"));
					customerCredit.setCardType(rs.getString("card_type"));
					customerCredit.setCreditNo(rs.getString("credit_no"));
					customerCredit.setCreditStatus(rs.getInt("credit_status"));
					customerCredit.setCustomerId(rs.getLong("customer_id"));
					customerCredit.setCustomerManager(rs.getString("customer_manager"));
					customerCredit.setCustomerManagerId(rs.getLong("customer_manager_id"));
					customerCredit.setCustomerName(rs.getString("customer_name"));
					customerCredit.setId(rs.getLong("id"));
					customerCredit.setInquryBank(rs.getString("inqury_bank"));
					customerCredit.setInquryBankId(rs.getLong("inqury_bank_id"));
					customerCredit.setMaritalStatus(rs.getInt("marital_status"));
					customerCredit.setSource(rs.getString("source"));
				}
				return customerCredit;
			}
		 });
		return customerCredit;
	}

public BusinessObjectProcessInfo getInputBusinessObjectProcessInfoFromDb(BusinessObjectProcessInfo expectedBusinessObjectProcessInfo,String cardNo)throws Throwable {

	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("select * from cls.customer_credit where card_no in ("+ cardNo +")");
	
	BusinessObjectProcessInfo businessObjectProcessInfo = (BusinessObjectProcessInfo)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<BusinessObjectProcessInfo>(){

		@Override
		public BusinessObjectProcessInfo extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			
			while(rs.next()){
				expectedBusinessObjectProcessInfo.setBorrowerId(rs.getLong("customer_id"));
				expectedBusinessObjectProcessInfo.setBorrowerName(rs.getString("customer_name"));
				expectedBusinessObjectProcessInfo.setBusinessNum(rs.getString("credit_no"));
				expectedBusinessObjectProcessInfo.setBusinessObjectId(rs.getLong("id"));
			}
			
			return expectedBusinessObjectProcessInfo;
		}
		
	});
	
	

	return expectedBusinessObjectProcessInfo;
}

public CustomerCredit setIdToInputCustomerCredit(CustomerCredit inputCustomerCredit, String cardNo)throws Throwable {

	
	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("select * from cls.customer_credit where card_no in ("+ cardNo +")");
	
	CustomerCredit input = (CustomerCredit)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<CustomerCredit>(){

		@Override
		public CustomerCredit extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			
			while(rs.next()){
				inputCustomerCredit.setId(rs.getLong("id"));
				inputCustomerCredit.setCreditNo(rs.getString("credit_no"));
				inputCustomerCredit.setCustomerId(rs.getLong("customer_id"));
			}
			return inputCustomerCredit;
		}
		
	});
	
	return input;
}

public BusinessObjectProcessInfo setIdToExpectedBusinessObjectProcessInfo(BusinessObjectProcessInfo expectedBusinessObjectProcessInfo,String cardNo) {

	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("select * from cls.business_object_process_info where business_object_id in (select id from cls.customer_credit where card_no in (" + cardNo +"))");
	
	BusinessObjectProcessInfo businessObjectProcessInfo = (BusinessObjectProcessInfo)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<BusinessObjectProcessInfo>(){

		@Override
		public BusinessObjectProcessInfo extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			
			while(rs.next()){
				expectedBusinessObjectProcessInfo.setId(rs.getLong("id"));
			}
			
			return expectedBusinessObjectProcessInfo;
		}
		
	});
	

	return businessObjectProcessInfo;
}


	public Boolean isSubmitSuccessfullyBetween1And2Node(String cardNo)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.business_object_process_info "
				+ "where business_object_id in (select id from customer_credit where card_no in ("+ cardNo +"))");		
		
		List<BusinessObjectProcessInfo> businessObjectProcessInfoList = (List<BusinessObjectProcessInfo>)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<BusinessObjectProcessInfo>>(){

			@Override
			public List<BusinessObjectProcessInfo> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				
				List<BusinessObjectProcessInfo> businessObjectProcessInfoList = new ArrayList<BusinessObjectProcessInfo>();
				
				while(rs.next()){
					BusinessObjectProcessInfo businessObjectProcessInfo = new BusinessObjectProcessInfo();
					businessObjectProcessInfo.setId(rs.getLong("id"));
					businessObjectProcessInfo.setNodeName(rs.getString("node_name"));
					businessObjectProcessInfoList.add(businessObjectProcessInfo);
				}
				return businessObjectProcessInfoList;
			}});
		
		
		int count = businessObjectProcessInfoList.size();
		if(count != 2){
			return false;
		}
		else {
			
				if((businessObjectProcessInfoList.get(0).getNodeName().equals("征信开始") && businessObjectProcessInfoList.get(1).getNodeName().equals("征信录入"))||
						(businessObjectProcessInfoList.get(0).getNodeName().equals("征信录入") && businessObjectProcessInfoList.get(1).getNodeName().equals("征信开始"))){
					return true;
				}
				else {
					return false;
				}
		}
	}

	
	
//	public Boolean isSubmitSuccessfullyBetween2And3Node(String cardNo)throws Throwable{
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append("select * from cls.business_object_process_info "
//				+ "where business_object_id in (select id from customer_credit where card_no in ("+ cardNo +"))");		
//		
//		List<BusinessObjectProcessInfo> businessObjectProcessInfoList = (List<BusinessObjectProcessInfo>)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<BusinessObjectProcessInfo>>(){
//
//			@Override
//			public List<BusinessObjectProcessInfo> extractData(ResultSet rs)
//					throws SQLException, DataAccessException {
//				
//				List<BusinessObjectProcessInfo> businessObjectProcessInfoList = new ArrayList<BusinessObjectProcessInfo>();
//				
//				while(rs.next()){
//					BusinessObjectProcessInfo businessObjectProcessInfo = new BusinessObjectProcessInfo();
//					businessObjectProcessInfo.setId(rs.getLong("id"));
//					businessObjectProcessInfo.setNodeName(rs.getString("node_name"));
//					businessObjectProcessInfoList.add(businessObjectProcessInfo);
//				}
//				return businessObjectProcessInfoList;
//			}});
//		
//		
//		int count = businessObjectProcessInfoList.size();
//		if(count != 3){
//			return false;
//		}
//		else {
//			
//			for()
//			
//		}
//	}
	
	
	
	
	public BusinessObjectProcessInfo getBusinessObjectProcessInfoFromDbFor23Node(String cardNo, String nodeIndex) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.business_object_process_info where "
				+ "business_object_id in (select id from cls.customer_credit where card_no in ("+ cardNo +")) "
						+ "and node_index in ("+ nodeIndex +")");
		
		BusinessObjectProcessInfo businessObjectProcessInfo = (BusinessObjectProcessInfo)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<BusinessObjectProcessInfo>(){

			@Override
			public BusinessObjectProcessInfo extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				
				
				BusinessObjectProcessInfo expectedBusinessObjectProcessInfo = new BusinessObjectProcessInfo();
				while(rs.next()){
					
					expectedBusinessObjectProcessInfo.setApprovalDateTime(new Date());
					expectedBusinessObjectProcessInfo.setCreateDateTime(new Date());
					expectedBusinessObjectProcessInfo.setBusinessType(rs.getString("business_type"));
					expectedBusinessObjectProcessInfo.setFlowIndex(rs.getInt("flow_index"));
					if(rs.getInt("is_submitted") == 0){
						expectedBusinessObjectProcessInfo.setIsSubmitted(false);
					}
					else {
						expectedBusinessObjectProcessInfo.setIsSubmitted(true);
					}
					
					if(rs.getInt("is_finished") == 0){
						expectedBusinessObjectProcessInfo.setIsFinished(false);
					}
					else {
						expectedBusinessObjectProcessInfo.setIsSubmitted(true);
					}
					
					if(rs.getInt("is_read") == 0){
						expectedBusinessObjectProcessInfo.setIsRead(false);
					}
					else {
						expectedBusinessObjectProcessInfo.setIsRead(true);
					}
					
					expectedBusinessObjectProcessInfo.setNodeIndex(rs.getInt("node_index"));
					expectedBusinessObjectProcessInfo.setNodeKey(rs.getString("node_key"));
					expectedBusinessObjectProcessInfo.setNodeName(rs.getString("node_name"));
					expectedBusinessObjectProcessInfo.setOperatorId(rs.getLong("operator_id"));
					expectedBusinessObjectProcessInfo.setOperatorName(rs.getString("operator_name"));
					expectedBusinessObjectProcessInfo.setApprovalResult(-1);
					expectedBusinessObjectProcessInfo.setLaunchOrganizationId(rs.getLong("launch_organization_id"));
					expectedBusinessObjectProcessInfo.setLaunchOrganizationName(rs.getString("launch_organization_name"));
					expectedBusinessObjectProcessInfo.setLaunchUserId(rs.getLong("launch_user_id"));
					expectedBusinessObjectProcessInfo.setLaunchUserName(rs.getString("launch_user_name"));
					expectedBusinessObjectProcessInfo.setBusinessGroupId(rs.getLong("business_group_id"));
					expectedBusinessObjectProcessInfo.setBusinessGroupName(rs.getString("business_group_name"));
					
					expectedBusinessObjectProcessInfo.setBorrowerId(rs.getLong("borrower_id"));
					expectedBusinessObjectProcessInfo.setBorrowerName(rs.getString("borrower_name"));
					expectedBusinessObjectProcessInfo.setBusinessNum(rs.getString("business_num"));
					expectedBusinessObjectProcessInfo.setBusinessObjectId(rs.getLong("business_object_id"));
//					expectedBusinessObjectProcessInfo.setId(rs.getLong("id"));
				}
				
				return expectedBusinessObjectProcessInfo;
			}
			
		});
		return businessObjectProcessInfo;
	}
	
	
	public Long getCreditIdFromDb(String cardNo)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.customer_credit where card_no in ("+ cardNo +")");
		
		Long creditId = (Long)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<Long>(){

			@Override
			public Long extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Long creditId = null;
				while(rs.next()){
					creditId = rs.getLong("id");
				}
				
				return creditId;
			}
		});
		
		return creditId;
	}

	public boolean checkCreditStatus(String cardNo)throws Throwable {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.customer_credit where card_no in ("+ cardNo +")");
		
		Integer creditStatus = (Integer)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				int creditStatus = 0;
				
				while(rs.next()){
					creditStatus = rs.getInt("credit_status");
				}
				
				return creditStatus;
			}
		});
		
		if(creditStatus != 2){
			return false;
		}
		
		else {
			return true;
		}
	}
	
	
	
	public List<BusinessObjectProcessInfo> businessObjectProcessInfoAfter3Node(String cardNo)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.business_object_process_info "
				+ "where business_object_id in (select id from customer_credit where card_no in ("+ cardNo +"))");		
		
		List<BusinessObjectProcessInfo> businessObjectProcessInfoList = (List<BusinessObjectProcessInfo>)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<BusinessObjectProcessInfo>>(){

			@Override
			public List<BusinessObjectProcessInfo> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				
				List<BusinessObjectProcessInfo> businessObjectProcessInfoList = new ArrayList<BusinessObjectProcessInfo>();
				
				while(rs.next()){
					BusinessObjectProcessInfo businessObjectProcessInfo = new BusinessObjectProcessInfo();
//					businessObjectProcessInfo.setId(rs.getLong("id"));
					businessObjectProcessInfo.setNodeIndex(rs.getInt("node_index"));
					businessObjectProcessInfo.setNodeName(rs.getString("node_name"));
					if(rs.getInt("is_submitted") == 0){
						businessObjectProcessInfo.setIsSubmitted(false);
					}
					else {
						businessObjectProcessInfo.setIsSubmitted(true);
					}
					
					if(rs.getInt("is_finished") == 0){
						businessObjectProcessInfo.setIsFinished(false);
					}
					else {
						businessObjectProcessInfo.setIsFinished(true);
					}
					
					if(rs.getInt("is_read") == 0){
						businessObjectProcessInfo.setIsRead(false);
					}
					else {
						businessObjectProcessInfo.setIsRead(true);
					}
					
					businessObjectProcessInfoList.add(businessObjectProcessInfo);
				}
				return businessObjectProcessInfoList;
			}});
		return businessObjectProcessInfoList;
	}

	
	public boolean compare(List<JsonBusinessObjectProcessInfo> expectedResults, List<JsonBusinessObjectProcessInfo> actualResults)throws Throwable{
		if(expectedResults.size() != actualResults.size()){
			return false;
		}
		
		else {
			for(JsonBusinessObjectProcessInfo a : actualResults){
				if(!expectedResults.contains(a)){
					return false;
				}
			}
		}
		
		return true;
	}
}
