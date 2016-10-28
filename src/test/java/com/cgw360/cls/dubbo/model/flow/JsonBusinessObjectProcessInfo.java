package com.cgw360.cls.dubbo.model.flow;

import java.util.Date;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class JsonBusinessObjectProcessInfo {
	
	private Long id;

    /**
     * 业务对像ID
     */
    private Long businessObjectId;

    /**
     * 业务类型，标识此为哪一种业务对象
     */
    private String businessType;

    /**
     * 用户ID
     */
    private Long borrowerId;

    /**
     * 客户名称
     */
    private String borrowerName;

    /**
     * 发起人ID
     */
    private Long launchUserId;

    /**
     * 发起人姓名
     */
    private String launchUserName;

    /**
     * 发起机构ID（分公司ID）
     */
    private Long launchOrganizationId;

    /**
     * 发起机构名称（分公司名称）
     */
    private String launchOrganizationName;

    /**
     * 业务组ID
     */
    private Long businessGroupId;

    /**
     * 业务组名称
     */
    private String businessGroupName;

    /**
     * 业务编码
     */
    private String businessNum;

    /**
     * 是否已提交至下一节点，0：未提交，1：已提交
     */
    private Boolean isSubmitted = false;

    /**
     * 是否已读（0：未读，1：已读）
     */
    private Boolean isRead = false;

    /**
     * 流程是否已结束（0：未结束，1：已结束）
     */
    private Boolean isFinished = false;

    /**
     * 上一节点key
     */
    private String lastNodeKey;

    /**
     * 上一流程节点名称
     */
    private String lastNodeName;

    /**
     * 上一节点索引
     */
    private Integer lastNodeIndex;

    /**
     * 流程节点的key
     */
    private String nodeKey;

    /**
     * 流程节点名称
     */
    private String nodeName;

    /**
     * 节点索引，表示此节点是流程中的第几个节点，这个值在流程确定后不会改变
     */
    private Integer nodeIndex;

    /**
     * 流程索引，一个业务对象走流程后，每一次操作，此值顺序递增
     */
    private Integer flowIndex;

    /**
     * 标识流程的版本
     */
    private String flowVersion;

    /**
     * 流程类型
     */
    private String flowType;

    /**
     * 操作角色Key
     */
    private String operationRoleKey;

    /**
     * 角色名称
     */
    private String operationRoleName;

    /**
     * 操作人外键
     */
    private Long operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 审批结果，-1：待办；0：不同意；1：同意；2：补件。【2主要是经营管理部审批结果选项】;3：关闭项目（贷款项目在区域经理时，可以关闭此贷款）
     */
    private Integer approvalResult;

    /**
     * 创建时间，即：流转到当前节点的时间
     */
    private Date createDateTime;

    /**
     * 审批时间
     */
    private Date approvalDateTime;

    /**
     * 提交到下一节点的时间
     */
    private Date submittedDateTime;

    /**
     * 审批意见
     */
    private String approvalNote;

    /**
     * 不同意原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    private String declineReasonKey;

    /**
     * 补件原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    private String rfeReasonKey;

    /**
     * 更新时间
     */
    private Date modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusinessObjectId() {
		return businessObjectId;
	}

	public void setBusinessObjectId(Long businessObjectId) {
		this.businessObjectId = businessObjectId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Long getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public Long getLaunchUserId() {
		return launchUserId;
	}

	public void setLaunchUserId(Long launchUserId) {
		this.launchUserId = launchUserId;
	}

	public String getLaunchUserName() {
		return launchUserName;
	}

	public void setLaunchUserName(String launchUserName) {
		this.launchUserName = launchUserName;
	}

	public Long getLaunchOrganizationId() {
		return launchOrganizationId;
	}

	public void setLaunchOrganizationId(Long launchOrganizationId) {
		this.launchOrganizationId = launchOrganizationId;
	}

	public String getLaunchOrganizationName() {
		return launchOrganizationName;
	}

	public void setLaunchOrganizationName(String launchOrganizationName) {
		this.launchOrganizationName = launchOrganizationName;
	}

	public Long getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(Long businessGroupId) {
		this.businessGroupId = businessGroupId;
	}

	public String getBusinessGroupName() {
		return businessGroupName;
	}

	public void setBusinessGroupName(String businessGroupName) {
		this.businessGroupName = businessGroupName;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}

	public Boolean getIsSubmitted() {
		return isSubmitted;
	}

	public void setIsSubmitted(Boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getLastNodeKey() {
		return lastNodeKey;
	}

	public void setLastNodeKey(String lastNodeKey) {
		this.lastNodeKey = lastNodeKey;
	}

	public String getLastNodeName() {
		return lastNodeName;
	}

	public void setLastNodeName(String lastNodeName) {
		this.lastNodeName = lastNodeName;
	}

	public Integer getLastNodeIndex() {
		return lastNodeIndex;
	}

	public void setLastNodeIndex(Integer lastNodeIndex) {
		this.lastNodeIndex = lastNodeIndex;
	}

	public String getNodeKey() {
		return nodeKey;
	}

	public void setNodeKey(String nodeKey) {
		this.nodeKey = nodeKey;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Integer getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(Integer nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public Integer getFlowIndex() {
		return flowIndex;
	}

	public void setFlowIndex(Integer flowIndex) {
		this.flowIndex = flowIndex;
	}

	public String getFlowVersion() {
		return flowVersion;
	}

	public void setFlowVersion(String flowVersion) {
		this.flowVersion = flowVersion;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getOperationRoleKey() {
		return operationRoleKey;
	}

	public void setOperationRoleKey(String operationRoleKey) {
		this.operationRoleKey = operationRoleKey;
	}

	public String getOperationRoleName() {
		return operationRoleName;
	}

	public void setOperationRoleName(String operationRoleName) {
		this.operationRoleName = operationRoleName;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getApprovalResult() {
		return approvalResult;
	}

	public void setApprovalResult(Integer approvalResult) {
		this.approvalResult = approvalResult;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getApprovalDateTime() {
		return approvalDateTime;
	}

	public void setApprovalDateTime(Date approvalDateTime) {
		this.approvalDateTime = approvalDateTime;
	}

	public Date getSubmittedDateTime() {
		return submittedDateTime;
	}

	public void setSubmittedDateTime(Date submittedDateTime) {
		this.submittedDateTime = submittedDateTime;
	}

	public String getApprovalNote() {
		return approvalNote;
	}

	public void setApprovalNote(String approvalNote) {
		this.approvalNote = approvalNote;
	}

	public String getDeclineReasonKey() {
		return declineReasonKey;
	}

	public void setDeclineReasonKey(String declineReasonKey) {
		this.declineReasonKey = declineReasonKey;
	}

	public String getRfeReasonKey() {
		return rfeReasonKey;
	}

	public void setRfeReasonKey(String rfeReasonKey) {
		this.rfeReasonKey = rfeReasonKey;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((approvalDateTime == null) ? 0 : approvalDateTime.hashCode());
		result = prime * result
				+ ((approvalNote == null) ? 0 : approvalNote.hashCode());
		result = prime * result
				+ ((approvalResult == null) ? 0 : approvalResult.hashCode());
		result = prime * result
				+ ((borrowerId == null) ? 0 : borrowerId.hashCode());
		result = prime * result
				+ ((borrowerName == null) ? 0 : borrowerName.hashCode());
		result = prime * result
				+ ((businessGroupId == null) ? 0 : businessGroupId.hashCode());
		result = prime
				* result
				+ ((businessGroupName == null) ? 0 : businessGroupName
						.hashCode());
		result = prime * result
				+ ((businessNum == null) ? 0 : businessNum.hashCode());
		result = prime
				* result
				+ ((businessObjectId == null) ? 0 : businessObjectId.hashCode());
		result = prime * result
				+ ((businessType == null) ? 0 : businessType.hashCode());
		result = prime * result
				+ ((createDateTime == null) ? 0 : createDateTime.hashCode());
		result = prime
				* result
				+ ((declineReasonKey == null) ? 0 : declineReasonKey.hashCode());
		result = prime * result
				+ ((flowIndex == null) ? 0 : flowIndex.hashCode());
		result = prime * result
				+ ((flowType == null) ? 0 : flowType.hashCode());
		result = prime * result
				+ ((flowVersion == null) ? 0 : flowVersion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isFinished == null) ? 0 : isFinished.hashCode());
		result = prime * result + ((isRead == null) ? 0 : isRead.hashCode());
		result = prime * result
				+ ((isSubmitted == null) ? 0 : isSubmitted.hashCode());
		result = prime * result
				+ ((lastNodeIndex == null) ? 0 : lastNodeIndex.hashCode());
		result = prime * result
				+ ((lastNodeKey == null) ? 0 : lastNodeKey.hashCode());
		result = prime * result
				+ ((lastNodeName == null) ? 0 : lastNodeName.hashCode());
		result = prime
				* result
				+ ((launchOrganizationId == null) ? 0 : launchOrganizationId
						.hashCode());
		result = prime
				* result
				+ ((launchOrganizationName == null) ? 0
						: launchOrganizationName.hashCode());
		result = prime * result
				+ ((launchUserId == null) ? 0 : launchUserId.hashCode());
		result = prime * result
				+ ((launchUserName == null) ? 0 : launchUserName.hashCode());
		result = prime * result
				+ ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result
				+ ((nodeIndex == null) ? 0 : nodeIndex.hashCode());
		result = prime * result + ((nodeKey == null) ? 0 : nodeKey.hashCode());
		result = prime * result
				+ ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime
				* result
				+ ((operationRoleKey == null) ? 0 : operationRoleKey.hashCode());
		result = prime
				* result
				+ ((operationRoleName == null) ? 0 : operationRoleName
						.hashCode());
		result = prime * result
				+ ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result
				+ ((operatorName == null) ? 0 : operatorName.hashCode());
		result = prime * result
				+ ((rfeReasonKey == null) ? 0 : rfeReasonKey.hashCode());
		result = prime
				* result
				+ ((submittedDateTime == null) ? 0 : submittedDateTime
						.hashCode());
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
		JsonBusinessObjectProcessInfo other = (JsonBusinessObjectProcessInfo) obj;
		if (approvalDateTime == null) {
			if (other.approvalDateTime != null)
				return false;
		} else if (!approvalDateTime.equals(other.approvalDateTime))
			return false;
		if (approvalNote == null) {
			if (other.approvalNote != null)
				return false;
		} else if (!approvalNote.equals(other.approvalNote))
			return false;
		if (approvalResult == null) {
			if (other.approvalResult != null)
				return false;
		} else if (!approvalResult.equals(other.approvalResult))
			return false;
		if (borrowerId == null) {
			if (other.borrowerId != null)
				return false;
		} else if (!borrowerId.equals(other.borrowerId))
			return false;
		if (borrowerName == null) {
			if (other.borrowerName != null)
				return false;
		} else if (!borrowerName.equals(other.borrowerName))
			return false;
		if (businessGroupId == null) {
			if (other.businessGroupId != null)
				return false;
		} else if (!businessGroupId.equals(other.businessGroupId))
			return false;
		if (businessGroupName == null) {
			if (other.businessGroupName != null)
				return false;
		} else if (!businessGroupName.equals(other.businessGroupName))
			return false;
		if (businessNum == null) {
			if (other.businessNum != null)
				return false;
		} else if (!businessNum.equals(other.businessNum))
			return false;
		if (businessObjectId == null) {
			if (other.businessObjectId != null)
				return false;
		} else if (!businessObjectId.equals(other.businessObjectId))
			return false;
		if (businessType == null) {
			if (other.businessType != null)
				return false;
		} else if (!businessType.equals(other.businessType))
			return false;
		if (createDateTime == null) {
			if (other.createDateTime != null)
				return false;
		} else if (!createDateTime.equals(other.createDateTime))
			return false;
		if (declineReasonKey == null) {
			if (other.declineReasonKey != null)
				return false;
		} else if (!declineReasonKey.equals(other.declineReasonKey))
			return false;
		if (flowIndex == null) {
			if (other.flowIndex != null)
				return false;
		} else if (!flowIndex.equals(other.flowIndex))
			return false;
		if (flowType == null) {
			if (other.flowType != null)
				return false;
		} else if (!flowType.equals(other.flowType))
			return false;
		if (flowVersion == null) {
			if (other.flowVersion != null)
				return false;
		} else if (!flowVersion.equals(other.flowVersion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isFinished == null) {
			if (other.isFinished != null)
				return false;
		} else if (!isFinished.equals(other.isFinished))
			return false;
		if (isRead == null) {
			if (other.isRead != null)
				return false;
		} else if (!isRead.equals(other.isRead))
			return false;
		if (isSubmitted == null) {
			if (other.isSubmitted != null)
				return false;
		} else if (!isSubmitted.equals(other.isSubmitted))
			return false;
		if (lastNodeIndex == null) {
			if (other.lastNodeIndex != null)
				return false;
		} else if (!lastNodeIndex.equals(other.lastNodeIndex))
			return false;
		if (lastNodeKey == null) {
			if (other.lastNodeKey != null)
				return false;
		} else if (!lastNodeKey.equals(other.lastNodeKey))
			return false;
		if (lastNodeName == null) {
			if (other.lastNodeName != null)
				return false;
		} else if (!lastNodeName.equals(other.lastNodeName))
			return false;
		if (launchOrganizationId == null) {
			if (other.launchOrganizationId != null)
				return false;
		} else if (!launchOrganizationId.equals(other.launchOrganizationId))
			return false;
		if (launchOrganizationName == null) {
			if (other.launchOrganizationName != null)
				return false;
		} else if (!launchOrganizationName.equals(other.launchOrganizationName))
			return false;
		if (launchUserId == null) {
			if (other.launchUserId != null)
				return false;
		} else if (!launchUserId.equals(other.launchUserId))
			return false;
		if (launchUserName == null) {
			if (other.launchUserName != null)
				return false;
		} else if (!launchUserName.equals(other.launchUserName))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (nodeIndex == null) {
			if (other.nodeIndex != null)
				return false;
		} else if (!nodeIndex.equals(other.nodeIndex))
			return false;
		if (nodeKey == null) {
			if (other.nodeKey != null)
				return false;
		} else if (!nodeKey.equals(other.nodeKey))
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		if (operationRoleKey == null) {
			if (other.operationRoleKey != null)
				return false;
		} else if (!operationRoleKey.equals(other.operationRoleKey))
			return false;
		if (operationRoleName == null) {
			if (other.operationRoleName != null)
				return false;
		} else if (!operationRoleName.equals(other.operationRoleName))
			return false;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		} else if (!operatorId.equals(other.operatorId))
			return false;
		if (operatorName == null) {
			if (other.operatorName != null)
				return false;
		} else if (!operatorName.equals(other.operatorName))
			return false;
		if (rfeReasonKey == null) {
			if (other.rfeReasonKey != null)
				return false;
		} else if (!rfeReasonKey.equals(other.rfeReasonKey))
			return false;
		if (submittedDateTime == null) {
			if (other.submittedDateTime != null)
				return false;
		} else if (!submittedDateTime.equals(other.submittedDateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JsonBusinessObjectProcessInfo [id=" + id
				+ ", businessObjectId=" + businessObjectId + ", businessType="
				+ businessType + ", borrowerId=" + borrowerId
				+ ", borrowerName=" + borrowerName + ", launchUserId="
				+ launchUserId + ", launchUserName=" + launchUserName
				+ ", launchOrganizationId=" + launchOrganizationId
				+ ", launchOrganizationName=" + launchOrganizationName
				+ ", businessGroupId=" + businessGroupId
				+ ", businessGroupName=" + businessGroupName + ", businessNum="
				+ businessNum + ", isSubmitted=" + isSubmitted + ", isRead="
				+ isRead + ", isFinished=" + isFinished + ", lastNodeKey="
				+ lastNodeKey + ", lastNodeName=" + lastNodeName
				+ ", lastNodeIndex=" + lastNodeIndex + ", nodeKey=" + nodeKey
				+ ", nodeName=" + nodeName + ", nodeIndex=" + nodeIndex
				+ ", flowIndex=" + flowIndex + ", flowVersion=" + flowVersion
				+ ", flowType=" + flowType + ", operationRoleKey="
				+ operationRoleKey + ", operationRoleName=" + operationRoleName
				+ ", operatorId=" + operatorId + ", operatorName="
				+ operatorName + ", approvalResult=" + approvalResult
				+ ", createDateTime=" + createDateTime + ", approvalDateTime="
				+ approvalDateTime + ", submittedDateTime=" + submittedDateTime
				+ ", approvalNote=" + approvalNote + ", declineReasonKey="
				+ declineReasonKey + ", rfeReasonKey=" + rfeReasonKey
				+ ", modifyTime=" + modifyTime + "]";
	}
    
    
    

}
