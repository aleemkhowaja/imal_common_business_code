package com.path.vo.common.global360view;

import com.path.dbmaps.vo.FMSCOLLATERALVO;
import com.path.dbmaps.vo.TRSCOLLATERALDETVO;
import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealsCollateralCO extends RetailBaseVO {
	
	private TRSCOLLATERALDETVO trsCollateralDetVO;
	private FMSCOLLATERALVO fmsCollateralVO;
	private String collateralType;
	private String currDecimalPoints;
	
	
	public TRSCOLLATERALDETVO getTrsCollateralDetVO() {
		return trsCollateralDetVO;
	}
	public void setTrsCollateralDetVO(TRSCOLLATERALDETVO trsCollateralDetVO) {
		this.trsCollateralDetVO = trsCollateralDetVO;
	}
	public FMSCOLLATERALVO getFmsCollateralVO() {
		return fmsCollateralVO;
	}
	public void setFmsCollateralVO(FMSCOLLATERALVO fmsCollateralVO) {
		this.fmsCollateralVO = fmsCollateralVO;
	}
	public String getCollateralType() {
		return collateralType;
	}
	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}
	public void setCurrDecimalPoints(String currDecimalPoints) {
		this.currDecimalPoints = currDecimalPoints;
	}
	public String getCurrDecimalPoints() {
		return currDecimalPoints;
	}
	
	
	

}
