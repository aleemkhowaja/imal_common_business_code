/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTS_DUESVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          DashboardDuesCO.java used to
 */
public class DashboardDuesCO extends RetailBaseVO
{
    private CTS_DUESVO ctsDuesVO;

    // credit account number concatenated
    String accountNumber;
    String statusDesc;
    String paymentModeDesc;
    String dueTypeDesc;
    BigDecimal decimalPoints;

    public CTS_DUESVO getCtsDuesVO()
    {
	return ctsDuesVO;
    }

    public void setCtsDuesVO(CTS_DUESVO ctsDuesVO)
    {
	this.ctsDuesVO = ctsDuesVO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public BigDecimal getDecimalPoints()
    {
	return decimalPoints;
    }

    public void setDecimalPoints(BigDecimal decimalPoints)
    {
	this.decimalPoints = decimalPoints;
    }

    public String getPaymentModeDesc()
    {
	return paymentModeDesc;
    }

    public void setPaymentModeDesc(String paymentModeDesc)
    {
	this.paymentModeDesc = paymentModeDesc;
    }

    public String getAccountNumber()
    {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
	this.accountNumber = accountNumber;
    }

    public String getDueTypeDesc()
    {
	return dueTypeDesc;
    }

    public void setDueTypeDesc(String dueTypeDesc)
    {
	this.dueTypeDesc = dueTypeDesc;
    }

}
