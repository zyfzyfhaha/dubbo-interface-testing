package com.cgw360.cls.dubbo.model.ICustomerCreditService;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.cgw360.cls.model.credit.CustomerCreditFile;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class JsonCustomerCreditRelavant implements Cloneable{
	
	private Long id;

    private Long creditId;

    private String fullName;

    private Integer cardType;

    private String cardId;

    private String mobile;

    private Integer borrowerRelationship;

    private Integer guaranteeRelationship;

    private Integer checkType;

    private Integer checkResult;

    private Integer checkResultStatus;

    private Long staffId;

    private String staffName;

    private String checkDate;

    private String creditRemark;

    private Byte netResult;
    
    private String netReportDate;

    private String creditReportId;
    
    private String creditReportInfo;
    
    private Integer riskStatus;
    
    private String riskTime;
    
    private String riskDetail;

    private String createTime;

    private Date modifyTime;
    
    private List<CustomerCreditFile> creditFiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getBorrowerRelationship() {
		return borrowerRelationship;
	}

	public void setBorrowerRelationship(Integer borrowerRelationship) {
		this.borrowerRelationship = borrowerRelationship;
	}

	public Integer getGuaranteeRelationship() {
		return guaranteeRelationship;
	}

	public void setGuaranteeRelationship(Integer guaranteeRelationship) {
		this.guaranteeRelationship = guaranteeRelationship;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}

	public Integer getCheckResultStatus() {
		return checkResultStatus;
	}

	public void setCheckResultStatus(Integer checkResultStatus) {
		this.checkResultStatus = checkResultStatus;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCreditRemark() {
		return creditRemark;
	}

	public void setCreditRemark(String creditRemark) {
		this.creditRemark = creditRemark;
	}

	public Byte getNetResult() {
		return netResult;
	}

	public void setNetResult(Byte netResult) {
		this.netResult = netResult;
	}

	public String getNetReportDate() {
		return netReportDate;
	}

	public void setNetReportDate(String netReportDate) {
		this.netReportDate = netReportDate;
	}

	public String getCreditReportId() {
		return creditReportId;
	}

	public void setCreditReportId(String creditReportId) {
		this.creditReportId = creditReportId;
	}

	public String getCreditReportInfo() {
		return creditReportInfo;
	}

	public void setCreditReportInfo(String creditReportInfo) {
		this.creditReportInfo = creditReportInfo;
	}

	public Integer getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(Integer riskStatus) {
		this.riskStatus = riskStatus;
	}

	public String getRiskTime() {
		return riskTime;
	}

	public void setRiskTime(String riskTime) {
		this.riskTime = riskTime;
	}

	public String getRiskDetail() {
		return riskDetail;
	}

	public void setRiskDetail(String riskDetail) {
		this.riskDetail = riskDetail;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<CustomerCreditFile> getCreditFiles() {
		return creditFiles;
	}

	public void setCreditFiles(List<CustomerCreditFile> creditFiles) {
		this.creditFiles = creditFiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((borrowerRelationship == null) ? 0 : borrowerRelationship
						.hashCode());
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
		result = prime * result
				+ ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result
				+ ((checkDate == null) ? 0 : checkDate.hashCode());
		result = prime * result
				+ ((checkResult == null) ? 0 : checkResult.hashCode());
		result = prime
				* result
				+ ((checkResultStatus == null) ? 0 : checkResultStatus
						.hashCode());
		result = prime * result
				+ ((checkType == null) ? 0 : checkType.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((creditFiles == null) ? 0 : creditFiles.hashCode());
		result = prime * result
				+ ((creditId == null) ? 0 : creditId.hashCode());
		result = prime * result
				+ ((creditRemark == null) ? 0 : creditRemark.hashCode());
		result = prime * result
				+ ((creditReportId == null) ? 0 : creditReportId.hashCode());
		result = prime
				* result
				+ ((creditReportInfo == null) ? 0 : creditReportInfo.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime
				* result
				+ ((guaranteeRelationship == null) ? 0 : guaranteeRelationship
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result
				+ ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result
				+ ((netReportDate == null) ? 0 : netReportDate.hashCode());
		result = prime * result
				+ ((netResult == null) ? 0 : netResult.hashCode());
		result = prime * result
				+ ((riskDetail == null) ? 0 : riskDetail.hashCode());
		result = prime * result
				+ ((riskStatus == null) ? 0 : riskStatus.hashCode());
		result = prime * result
				+ ((riskTime == null) ? 0 : riskTime.hashCode());
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
		result = prime * result
				+ ((staffName == null) ? 0 : staffName.hashCode());
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
		JsonCustomerCreditRelavant other = (JsonCustomerCreditRelavant) obj;
		if (borrowerRelationship == null) {
			if (other.borrowerRelationship != null)
				return false;
		} else if (!borrowerRelationship.equals(other.borrowerRelationship))
			return false;
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (checkDate == null) {
			if (other.checkDate != null)
				return false;
		} else if (!checkDate.equals(other.checkDate))
			return false;
		if (checkResult == null) {
			if (other.checkResult != null)
				return false;
		} else if (!checkResult.equals(other.checkResult))
			return false;
		if (checkResultStatus == null) {
			if (other.checkResultStatus != null)
				return false;
		} else if (!checkResultStatus.equals(other.checkResultStatus))
			return false;
		if (checkType == null) {
			if (other.checkType != null)
				return false;
		} else if (!checkType.equals(other.checkType))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creditFiles == null) {
			if (other.creditFiles != null)
				return false;
		} else if (!creditFiles.equals(other.creditFiles))
			return false;
		if (creditId == null) {
			if (other.creditId != null)
				return false;
		} else if (!creditId.equals(other.creditId))
			return false;
		if (creditRemark == null) {
			if (other.creditRemark != null)
				return false;
		} else if (!creditRemark.equals(other.creditRemark))
			return false;
		if (creditReportId == null) {
			if (other.creditReportId != null)
				return false;
		} else if (!creditReportId.equals(other.creditReportId))
			return false;
		if (creditReportInfo == null) {
			if (other.creditReportInfo != null)
				return false;
		} else if (!creditReportInfo.equals(other.creditReportInfo))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (guaranteeRelationship == null) {
			if (other.guaranteeRelationship != null)
				return false;
		} else if (!guaranteeRelationship.equals(other.guaranteeRelationship))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (netReportDate == null) {
			if (other.netReportDate != null)
				return false;
		} else if (!netReportDate.equals(other.netReportDate))
			return false;
		if (netResult == null) {
			if (other.netResult != null)
				return false;
		} else if (!netResult.equals(other.netResult))
			return false;
		if (riskDetail == null) {
			if (other.riskDetail != null)
				return false;
		} else if (!riskDetail.equals(other.riskDetail))
			return false;
		if (riskStatus == null) {
			if (other.riskStatus != null)
				return false;
		} else if (!riskStatus.equals(other.riskStatus))
			return false;
		if (riskTime == null) {
			if (other.riskTime != null)
				return false;
		} else if (!riskTime.equals(other.riskTime))
			return false;
		if (staffId == null) {
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		if (staffName == null) {
			if (other.staffName != null)
				return false;
		} else if (!staffName.equals(other.staffName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JsonCustomerCreditRelavant [id=" + id + ", creditId="
				+ creditId + ", fullName=" + fullName + ", cardType="
				+ cardType + ", cardId=" + cardId + ", mobile=" + mobile
				+ ", borrowerRelationship=" + borrowerRelationship
				+ ", guaranteeRelationship=" + guaranteeRelationship
				+ ", checkType=" + checkType + ", checkResult=" + checkResult
				+ ", checkResultStatus=" + checkResultStatus + ", staffId="
				+ staffId + ", staffName=" + staffName + ", checkDate="
				+ checkDate + ", creditRemark=" + creditRemark + ", netResult="
				+ netResult + ", netReportDate=" + netReportDate
				+ ", creditReportId=" + creditReportId + ", creditReportInfo="
				+ creditReportInfo + ", riskStatus=" + riskStatus
				+ ", riskTime=" + riskTime + ", riskDetail=" + riskDetail
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", creditFiles=" + creditFiles + "]";
	}

	
	public JsonCustomerCreditRelavant clone()throws CloneNotSupportedException{
		JsonCustomerCreditRelavant a = (JsonCustomerCreditRelavant) super.clone();
		return a;
		
	}
    
}
