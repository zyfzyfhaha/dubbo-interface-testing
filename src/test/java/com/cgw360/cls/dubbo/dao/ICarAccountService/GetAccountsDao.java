package com.cgw360.cls.dubbo.dao.ICarAccountService;

import gherkin.deps.com.google.gson.Gson;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cgw360.cls.dubbo.dao.BaseDButil;
import com.cgw360.cls.dubbo.model.ICarAccountService.JsonCarAccounts;
import com.google.common.reflect.TypeToken;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 * @date   2016年5月5日
 */
@Repository
public class GetAccountsDao extends BaseDButil{
	
	
	public List<JsonCarAccounts> getJson(String jsonString)throws Throwable{
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<JsonCarAccounts>>() {}.getType();
		List<JsonCarAccounts> carAccountsList = gson.fromJson(jsonString, collectionType);
		return carAccountsList;
	}
	
	
	public JsonCarAccounts getJson2(String jsonString)throws Throwable{
		Gson gson = new Gson();
		Type collectionType = new TypeToken<JsonCarAccounts>() {}.getType();
		JsonCarAccounts carAccounts = gson.fromJson(jsonString, collectionType);
		return carAccounts;
	}
	

	public boolean isCarDealerAccountExistInDb(String dealerId)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select count(*) from cls.car_dealer_account where dealer_id = '"+ dealerId +"'");
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
		
		if(count == 0){
			return false;
		}
		return true;
	}
	
	
	public boolean isCarDealerAccountExistInDb2(String dealerId, String status)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select count(*) from cls.car_dealer_account where dealer_id = '"+ dealerId +"' and status ='" + status + "'");
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
		
		if(count == 0){
			return false;
		}
		return true;
	}
	
	
	public boolean isCarDealerAccountExistInDb3(String accountId)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select count(*) from cls.car_dealer_account where dealer_id = '"+ accountId +"'");
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
		
		if(count == 0){
			return false;
		}
		return true;
	}
	
	
	public List<JsonCarAccounts> getAccountSDetailFromDb(String dealerId)throws Throwable{
	
	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("select * from cls.car_dealer_account where dealer_id = '"+ dealerId +"'");
	List<JsonCarAccounts> carAccountsList= (List<JsonCarAccounts>)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<JsonCarAccounts>>(){

		@Override
		public List<JsonCarAccounts> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			
			List<JsonCarAccounts> carAccountsList = new ArrayList<JsonCarAccounts>();
			
					while(rs.next()){
						JsonCarAccounts carAccounts = new JsonCarAccounts();
						carAccounts.setAccountName(rs.getString("account_name"));
						carAccounts.setCardNumber(rs.getString("card_number"));
						carAccounts.setCreateTime(rs.getTimestamp("create_time").getTime());
						carAccounts.setDealerId(rs.getString("dealer_id"));
						carAccounts.setId(rs.getString("id"));
						if(rs.getInt("is_deleted") == 0){
							carAccounts.setIsDeleted("false");
						}
						carAccounts.setModifyTime(rs.getTimestamp("modify_time").getTime());
						carAccounts.setOpeningBank(rs.getString("opening_bank"));
						carAccounts.setOrgId(rs.getString("org_id"));
						carAccounts.setStatus(rs.getString("status"));
						carAccounts.setSubBankName(rs.getString("sub_bank_name"));
						carAccounts.setUserId(rs.getString("user_id"));
						carAccounts.setUserName(rs.getString("user_name"));
						carAccountsList.add(carAccounts);
					}
					
			// TODO Auto-generated method stub
			return carAccountsList;
		}
	});	
		return carAccountsList;
	}
	
	
	public List<JsonCarAccounts> getAccountSDetailFromDb2(String dealerId, String status)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.car_dealer_account where dealer_id = '"+ dealerId +"' and status ='" + status + "'");
		List<JsonCarAccounts> carAccountsList= (List<JsonCarAccounts>)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<List<JsonCarAccounts>>(){

			@Override
			public List<JsonCarAccounts> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				
				List<JsonCarAccounts> carAccountsList = new ArrayList<JsonCarAccounts>();
				
						while(rs.next()){
							JsonCarAccounts carAccounts = new JsonCarAccounts();
							carAccounts.setAccountName(rs.getString("account_name"));
							carAccounts.setCardNumber(rs.getString("card_number"));
							carAccounts.setCreateTime(rs.getTimestamp("create_time").getTime());
							carAccounts.setDealerId(rs.getString("dealer_id"));
							carAccounts.setId(rs.getString("id"));
							if(rs.getInt("is_deleted") == 0){
								carAccounts.setIsDeleted("false");
							}
							carAccounts.setModifyTime(rs.getTimestamp("modify_time").getTime());
							carAccounts.setOpeningBank(rs.getString("opening_bank"));
							carAccounts.setOrgId(rs.getString("org_id"));
							carAccounts.setStatus(rs.getString("status"));
							carAccounts.setSubBankName(rs.getString("sub_bank_name"));
							carAccounts.setUserId(rs.getString("user_id"));
							carAccounts.setUserName(rs.getString("user_name"));
							carAccountsList.add(carAccounts);
						}
						
				// TODO Auto-generated method stub
				return carAccountsList;
			}
		});	
			return carAccountsList;
		}
	
	
	public JsonCarAccounts getAccountSDetailFromDb3(String accountId)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from cls.car_dealer_account where dealer_id = '"+ accountId +"'");
		JsonCarAccounts carAccounts= (JsonCarAccounts)jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<JsonCarAccounts>(){

			@Override
			public JsonCarAccounts extractData(ResultSet rs)
					throws SQLException, DataAccessException {
					JsonCarAccounts carAccounts = new JsonCarAccounts();
						while(rs.next()){
							
							carAccounts.setAccountName(rs.getString("account_name"));
							carAccounts.setCardNumber(rs.getString("card_number"));
							carAccounts.setCreateTime(rs.getTimestamp("create_time").getTime());
							carAccounts.setDealerId(rs.getString("dealer_id"));
							carAccounts.setId(rs.getString("id"));
							if(rs.getInt("is_deleted") == 0){
								carAccounts.setIsDeleted("false");
							}
							else {
								carAccounts.setIsDeleted("true");
							}
							carAccounts.setModifyTime(rs.getTimestamp("modify_time").getTime());
							carAccounts.setOpeningBank(rs.getString("opening_bank"));
							carAccounts.setOrgId(rs.getString("org_id"));
							carAccounts.setStatus(rs.getString("status"));
							carAccounts.setSubBankName(rs.getString("sub_bank_name"));
							carAccounts.setUserId(rs.getString("user_id"));
							carAccounts.setUserName(rs.getString("user_name"));
						}
						
				// TODO Auto-generated method stub
				return carAccounts;
			}
		});	
			return carAccounts;
		}
	
	
	
	public boolean compare(List<JsonCarAccounts> expectedResults, List<JsonCarAccounts> actualResults)throws Throwable{
		if(expectedResults.size() != actualResults.size()){
			return false;
		}
		
		for(JsonCarAccounts a : actualResults){
			if(!expectedResults.contains(a)){
				return false;
			}
		}
		return true;
	}
	
	
}
