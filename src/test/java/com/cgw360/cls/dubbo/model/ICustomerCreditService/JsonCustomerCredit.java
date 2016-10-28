package com.cgw360.cls.dubbo.model.ICustomerCreditService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgw360.cls.dubbo.model.ICustomerCreditService.JsonCustomerCreditRelavant;;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class JsonCustomerCredit implements Cloneable {
	
	private Long id;

    private String source;
    
    private String creditNo;

    private String serialNumber;

    private Long customerId;

    private String customerName;

    private String cardType;

    private String cardNo;

    private Integer maritalStatus;

    private Long inquryBankId;
    
    private String inquryBank;

    private Long businessGroupId;
    
    private String businessGroup;

    private Long customerManagerId;

    private String customerManager;

    private Integer creditStatus;

    private String createTime;

    private String submitTime;

    private String modifyTime;
    
    private List<JsonCustomerCreditRelavant> relavants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Long getInquryBankId() {
		return inquryBankId;
	}

	public void setInquryBankId(Long inquryBankId) {
		this.inquryBankId = inquryBankId;
	}

	public String getInquryBank() {
		return inquryBank;
	}

	public void setInquryBank(String inquryBank) {
		this.inquryBank = inquryBank;
	}

	public Long getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(Long businessGroupId) {
		this.businessGroupId = businessGroupId;
	}

	public String getBusinessGroup() {
		return businessGroup;
	}

	public void setBusinessGroup(String businessGroup) {
		this.businessGroup = businessGroup;
	}

	public Long getCustomerManagerId() {
		return customerManagerId;
	}

	public void setCustomerManagerId(Long customerManagerId) {
		this.customerManagerId = customerManagerId;
	}

	public String getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(String customerManager) {
		this.customerManager = customerManager;
	}

	public Integer getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(Integer creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<JsonCustomerCreditRelavant> getRelavants() {
		return relavants;
	}

	public void setRelavants(List<JsonCustomerCreditRelavant> relavants) {
		this.relavants = relavants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessGroup == null) ? 0 : businessGroup.hashCode());
		result = prime * result
				+ ((businessGroupId == null) ? 0 : businessGroupId.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result
				+ ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((creditNo == null) ? 0 : creditNo.hashCode());
		result = prime * result
				+ ((creditStatus == null) ? 0 : creditStatus.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((customerManager == null) ? 0 : customerManager.hashCode());
		result = prime
				* result
				+ ((customerManagerId == null) ? 0 : customerManagerId
						.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inquryBank == null) ? 0 : inquryBank.hashCode());
		result = prime * result
				+ ((inquryBankId == null) ? 0 : inquryBankId.hashCode());
		result = prime * result
				+ ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result
				+ ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result
				+ ((relavants == null) ? 0 : relavants.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((submitTime == null) ? 0 : submitTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonCustomerCredit other = (JsonCustomerCredit) obj;
		if (businessGroup == null) {
			if (other.businessGroup != null)
				return false;
		} else if (!businessGroup.equals(other.businessGroup))
			return false;
		if (businessGroupId == null) {
			if (other.businessGroupId != null)
				return false;
		} else if (!businessGroupId.equals(other.businessGroupId))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creditNo == null) {
			if (other.creditNo != null)
				return false;
		} else if (!creditNo.equals(other.creditNo))
			return false;
		if (creditStatus == null) {
			if (other.creditStatus != null)
				return false;
		} else if (!creditStatus.equals(other.creditStatus))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerManager == null) {
			if (other.customerManager != null)
				return false;
		} else if (!customerManager.equals(other.customerManager))
			return false;
		if (customerManagerId == null) {
			if (other.customerManagerId != null)
				return false;
		} else if (!customerManagerId.equals(other.customerManagerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inquryBank == null) {
			if (other.inquryBank != null)
				return false;
		} else if (!inquryBank.equals(other.inquryBank))
			return false;
		if (inquryBankId == null) {
			if (other.inquryBankId != null)
				return false;
		} else if (!inquryBankId.equals(other.inquryBankId))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (relavants == null) {
			if (other.relavants != null)
				return false;
		} else if (!relavants.equals(other.relavants))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (submitTime == null) {
			if (other.submitTime != null)
				return false;
		} else if (!submitTime.equals(other.submitTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JsonCustomerCredit [id=" + id + ", source=" + source
				+ ", creditNo=" + creditNo + ", serialNumber=" + serialNumber
				+ ", customerId=" + customerId + ", customerName="
				+ customerName + ", cardType=" + cardType + ", cardNo="
				+ cardNo + ", maritalStatus=" + maritalStatus
				+ ", inquryBankId=" + inquryBankId + ", inquryBank="
				+ inquryBank + ", businessGroupId=" + businessGroupId
				+ ", businessGroup=" + businessGroup + ", customerManagerId="
				+ customerManagerId + ", customerManager=" + customerManager
				+ ", creditStatus=" + creditStatus + ", createTime="
				+ createTime + ", submitTime=" + submitTime + ", modifyTime="
				+ modifyTime + ", relavants=" + relavants + "]";
	}

	
	public JsonCustomerCredit clone()throws CloneNotSupportedException{
		JsonCustomerCredit a = (JsonCustomerCredit) super.clone();
		if(this.getRelavants() != null){
			a.setRelavants(new ArrayList<JsonCustomerCreditRelavant>());
			for(JsonCustomerCreditRelavant b : this.getRelavants()){
				a.getRelavants().add(b.clone());
			}
		}
		return a;
	}
	
}
