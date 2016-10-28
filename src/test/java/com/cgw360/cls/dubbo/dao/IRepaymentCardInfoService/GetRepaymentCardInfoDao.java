package com.cgw360.cls.dubbo.dao.IRepaymentCardInfoService;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cgw360.cls.dubbo.dao.BaseDButil;
import com.cgw360.cls.dubbo.model.IRepaymentCardInfoService.JsonRepaymentCardInfo;
import com.cgw360.cls.dubbo.model.IRepaymentCardInfoService.JsonRepaymentCardInfoModule;
import com.google.common.reflect.TypeToken;

@Repository
public class GetRepaymentCardInfoDao extends BaseDButil{
	
	
	public JsonRepaymentCardInfo getJson(String outputString)throws Throwable{
		Gson gson = new Gson();
//		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type collectionType = new TypeToken<JsonRepaymentCardInfo>() {}.getType();
		JsonRepaymentCardInfo repaymentCardInfo = gson.fromJson(outputString, collectionType);
		return repaymentCardInfo;
	}
	
	
	public boolean isRepaymentCardInfoExistInDb(String id)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT count(*) from cls.repayment_card_info where id = '"+ id +"'");
		Integer count = (Integer) jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<Integer>(){

			
			int count = 0;
			@Override
			public Integer extractData(ResultSet rs) throws SQLException,
					DataAccessException {
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
	
	

	public JsonRepaymentCardInfo getRepaymentCardInfoFromDb(String id)throws Throwable{
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT * from cls.repayment_card_info where id = '"+ id +"'");
		
		JsonRepaymentCardInfo repaymentCardInfo = (JsonRepaymentCardInfo) jdbcTemplate.query(stringBuffer.toString(),new ResultSetExtractor<JsonRepaymentCardInfo>(){
			JsonRepaymentCardInfo repaymentCardInfo = new JsonRepaymentCardInfo();
			
			@Override
			public JsonRepaymentCardInfo extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				while(rs.next()){
					JsonRepaymentCardInfoModule repaymentCardInfoModule = new JsonRepaymentCardInfoModule();
					repaymentCardInfoModule.setCardNo(rs.getString("card_no"));
					if(null != rs.getTimestamp("create_time")){
						repaymentCardInfoModule.setCreateTime(rs.getTimestamp("create_time").getTime());
					}
					
					repaymentCardInfoModule.setDeliverAddr(rs.getString("deliver_addr"));
					
					if (null != rs.getTimestamp("deliver_date")){
						repaymentCardInfoModule.setDeliverDate(rs.getTimestamp("deliver_date").getTime());
					}
					
					repaymentCardInfoModule.setDeliverRealname(rs.getString("deliver_realname"));
					repaymentCardInfoModule.setDeliverType(rs.getString("deliver_type"));
					repaymentCardInfoModule.setId(rs.getString("id"));
					if(null != rs.getTimestamp("modify_time")){
						repaymentCardInfoModule.setModifyTime(rs.getTimestamp("modify_time").getTime());
					}
					repaymentCardInfoModule.setNote(rs.getString("note"));
					repaymentCardInfoModule.setProjectId(rs.getString("project_id"));
					repaymentCardInfo.setModule(repaymentCardInfoModule);
				}
					repaymentCardInfo.setSuccess("true");
					
				// TODO Auto-generated method stub
				return repaymentCardInfo;
			}
		});
		return repaymentCardInfo;
	}
	
	
	public String getId(String ProjectId)throws Throwable{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select id from cls.repayment_card_info where project_id = '"+ ProjectId +"'");
		
		String id = (String) jdbcTemplate.query(stringBuffer.toString(), new ResultSetExtractor<String>(){
			String id = "";
			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				while(rs.next()){
					id =  rs.getString("id");
				}
				// TODO Auto-generated method stub
				return id;
			}
		});
		
		return id;
	}
	
}
