package com.cgw360.cls.dubbo.model.IRepaymentCardInfoService;

import java.util.List;

public class JsonRepaymentCardInfo {

	private JsonRepaymentCardInfoModule module;
	private String success;
	public JsonRepaymentCardInfoModule getModule() {
		return module;
	}
	public void setModule(JsonRepaymentCardInfoModule module) {
		this.module = module;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((success == null) ? 0 : success.hashCode());
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
		JsonRepaymentCardInfo other = (JsonRepaymentCardInfo) obj;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (success == null) {
			if (other.success != null)
				return false;
		} else if (!success.equals(other.success))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JsonRepaymentCardInfo [module=" + module + ", success="
				+ success + "]";
	}
	
	
	
}
