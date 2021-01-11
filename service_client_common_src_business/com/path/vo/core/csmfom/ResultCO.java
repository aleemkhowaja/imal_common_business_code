package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;
/**
 * this class is created by jihad in order to get message results and boolean value from a function
 * @author jihadlamaa
 *
 */
public class ResultCO extends BaseVO {
	
	String message;
	boolean boolValue;
	BigDecimal bigDecimalRes;
	Integer integerResut;
	Integer integerMsgType;
	public Integer getIntegerMsgType() {
		return integerMsgType;
	}
	public void setIntegerMsgType(Integer integerMsgType) {
		this.integerMsgType = integerMsgType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isBoolValue() {
		return boolValue;
	}
	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}
	public BigDecimal getBigDecimalRes() {
		return bigDecimalRes;
	}
	public void setBigDecimalRes(BigDecimal bigDecimalRes) {
		this.bigDecimalRes = bigDecimalRes;
	}
	public Integer getIntegerResut() {
		return integerResut;
	}
	public void setIntegerResut(Integer integerResut) {
		this.integerResut = integerResut;
	}
	
	

}
