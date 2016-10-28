package com.cgw360.cls.dubbo.model.IRepaymentCardInfoService;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class JsonRepaymentCardInfoModule {

	private String cardNo;
	private Long createTime;
	private String deliverAddr;
	private Long deliverDate;
	private String deliverRealname;
	private String deliverType;
	private String id;
	private Long modifyTime;
	private String note;
	private String projectId;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getDeliverAddr() {
		return deliverAddr;
	}
	public void setDeliverAddr(String deliverAddr) {
		this.deliverAddr = deliverAddr;
	}
	public Long getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Long deliverDate) {
		this.deliverDate = deliverDate;
	}
	public String getDeliverRealname() {
		return deliverRealname;
	}
	public void setDeliverRealname(String deliverRealname) {
		this.deliverRealname = deliverRealname;
	}
	public String getDeliverType() {
		return deliverType;
	}
	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((deliverAddr == null) ? 0 : deliverAddr.hashCode());
		result = prime * result
				+ ((deliverDate == null) ? 0 : deliverDate.hashCode());
		result = prime * result
				+ ((deliverRealname == null) ? 0 : deliverRealname.hashCode());
		result = prime * result
				+ ((deliverType == null) ? 0 : deliverType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
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
		JsonRepaymentCardInfoModule other = (JsonRepaymentCardInfoModule) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (deliverAddr == null) {
			if (other.deliverAddr != null)
				return false;
		} else if (!deliverAddr.equals(other.deliverAddr))
			return false;
		if (deliverDate == null) {
			if (other.deliverDate != null)
				return false;
		} else if (!deliverDate.equals(other.deliverDate))
			return false;
		if (deliverRealname == null) {
			if (other.deliverRealname != null)
				return false;
		} else if (!deliverRealname.equals(other.deliverRealname))
			return false;
		if (deliverType == null) {
			if (other.deliverType != null)
				return false;
		} else if (!deliverType.equals(other.deliverType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JsonRepaymentCardInfoModule [cardNo=" + cardNo
				+ ", createTime=" + createTime + ", deliverAddr=" + deliverAddr
				+ ", deliverDate=" + deliverDate + ", deliverRealname="
				+ deliverRealname + ", deliverType=" + deliverType + ", id="
				+ id + ", modifyTime=" + modifyTime + ", note=" + note
				+ ", projectId=" + projectId + "]";
	}
	
	
	
}
