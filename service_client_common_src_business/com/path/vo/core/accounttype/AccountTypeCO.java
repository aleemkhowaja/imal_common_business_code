package com.path.vo.core.accounttype;

import java.io.Serializable;

import com.path.dbmaps.vo.RIFATTVO;
import com.path.vo.core.common.RetailBaseVO;

public class AccountTypeCO extends RetailBaseVO implements Serializable
{
    private RIFATTVO rifattVO =new RIFATTVO();
    private int returnValue;
	public RIFATTVO getRifattVO() {
		return rifattVO;
	}
	public void setRifattVO(RIFATTVO rifattVO) {
		this.rifattVO = rifattVO;
	}
	public int getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(int returnValue) {
		this.returnValue = returnValue;
	}
}
