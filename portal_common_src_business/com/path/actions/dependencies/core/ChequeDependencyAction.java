/**
 * Chady Assaf
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import org.apache.struts2.json.JSONException;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cheque.ChequeBO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cheque.ChequeCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          LinkDependencyAction.java used to
 */
public class ChequeDependencyAction extends RetailBaseAction
{
    private ChequeBO chequeBO;
    private BigDecimal chequeCode;
    private String chequeBriefName;
    private ChequeCO chequeCO = new ChequeCO();
    private String _descReadOnly;

    public Object getModel()
    {
	return chequeCO;
    }
    
    public String dependencyByBillsCode() throws JSONException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    set_recReadOnly("readonly");
	    CTSCHEQUESVO ctsCheques = new CTSCHEQUESVO();
	    ctsCheques.setCOMP_CODE(sessionCO.getCompanyCode());
//	    if(null != getChequeBriefName() && !"".equals(getChequeBriefName()))
//	    {
//		ctsCheques.setBRIEF_NAME_ENG(getChequeBriefName());
//		chequeCO.setCtsCheques(ctsCheques);
//		chequeCO = chequeBO.loadChequeRequestByCode(chequeCO);
//	    }

	    if(!NumberUtil.isEmptyDecimal(getChequeCode()))
	    {
		ctsCheques.setCODE(getChequeCode());
		chequeCO.setCtsCheques(ctsCheques);
		chequeCO = chequeBO.loadChequeRequestByCode(chequeCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    

    /**
     * To manage the dependency by link code...
     * 
     * @return
     */
    public String dependencyByChequeCode() throws JSONException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    set_recReadOnly("readonly");
	    CTSCHEQUESVO ctsCheques = new CTSCHEQUESVO();
	    ctsCheques.setCOMP_CODE(sessionCO.getCompanyCode());
//	    if(null != getChequeBriefName() && !"".equals(getChequeBriefName()))
//	    {
//		ctsCheques.setBRIEF_NAME_ENG(getChequeBriefName());
//		chequeCO.setCtsCheques(ctsCheques);
//		chequeCO = chequeBO.loadChequeRequestByCode(chequeCO);
//	    }

	    if(!NumberUtil.isEmptyDecimal(getChequeCode()))
	    {
		ctsCheques.setCODE(getChequeCode());
		chequeCO.setCtsCheques(ctsCheques);
		chequeCO = chequeBO.loadChequeRequestByCode(chequeCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public void setChequeBO(ChequeBO chequeBO)
    {
	this.chequeBO = chequeBO;
    }

    public BigDecimal getChequeCode()
    {
	return chequeCode;
    }

    public void setChequeCode(BigDecimal chequeCode)
    {
	this.chequeCode = chequeCode;
    }

    public ChequeCO getChequeCO()
    {
	return chequeCO;
    }

    public void setChequeCO(ChequeCO chequeCO)
    {
	this.chequeCO = chequeCO;
    }

    public String getChequeBriefName()
    {
	return chequeBriefName;
    }

    public void setChequeBriefName(String chequeBriefName)
    {
	this.chequeBriefName = chequeBriefName;
    }

    public String get_descReadOnly()
    {
	return _descReadOnly;
    }

    public void set_descReadOnly(String descReadOnly)
    {
	_descReadOnly = descReadOnly;
    }
}
