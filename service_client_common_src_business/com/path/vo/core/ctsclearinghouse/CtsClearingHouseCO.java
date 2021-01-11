package com.path.vo.core.ctsclearinghouse;

import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.vo.core.common.RetailBaseVO;


public class CtsClearingHouseCO extends RetailBaseVO  
{
	 private CTSCLEARINGHOUSEVO ctsClearingHouseVO;
	 private String ACC_ON_NAME;
	 private String ACC_OFF_NAME;
	 private String CY_DESC ;
 
	 
	public String getACC_ON_NAME() {
		return ACC_ON_NAME;
	}
	public void setACC_ON_NAME(String aCCONNAME) {
		ACC_ON_NAME = aCCONNAME;
	}
	public String getACC_OFF_NAME() {
		return ACC_OFF_NAME;
	}
	public void setACC_OFF_NAME(String aCCOFFNAME) {
		ACC_OFF_NAME = aCCOFFNAME;
	}
	public String getCY_DESC() {
		return CY_DESC;
	}
	public void setCY_DESC(String cYDESC) {
		CY_DESC = cYDESC;
	}
	public CTSCLEARINGHOUSEVO getCtsClearingHouseVO() {
		return ctsClearingHouseVO;
	}
	public void setCtsClearingHouseVO(CTSCLEARINGHOUSEVO ctsClearingHouseVO) {
		this.ctsClearingHouseVO = ctsClearingHouseVO;
	}


}
