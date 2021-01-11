package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.ctsclearinghouse.CtsClearingHouseBO;
import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseDependencyAction.java used to
 */
public class CtsClearingHouseDependencyAction extends RetailBaseAction
{

    private CtsClearingHouseBO ctsClearingHouseBO;
    private CTSCLEARINGHOUSEVO ctsClearingHouseVO;
    private CtsClearingHouseSC criteria = new CtsClearingHouseSC();
    private BigDecimal clearingHouseCode;
    private BigDecimal currnecyCode;
    
    public String dependencyByClearingHouse(){
	try{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCurrencyCode(getCurrnecyCode());
	    criteria.setClearingHouseCode(getClearingHouseCode());
	    ctsClearingHouseVO = ctsClearingHouseBO.returnCtsClearingHouseById(criteria);
	}catch (Exception e) {
	    log.error(e, "Error in dependencyByClearingHouse method of CtsClearingHouseDependencyAction");
	    handleException(e, "ERROR IN CTS CLEARING HOUSE", null);
	}
	return SUCCESS;
    }
    
    
    public String clearingHouseDepByCode(){
	    SessionCO sessionCO = returnSessionObject();
	    try {
	    	criteria.setCompCode( sessionCO.getCompanyCode());
	    	criteria.setClearingHouseCode( criteria.getClearingHouseCode());
			ctsClearingHouseVO = ctsClearingHouseBO.clearingHouseDepByCode(criteria);
		} catch (BaseException e) {
			ctsClearingHouseVO = null;
			handleException(e, null, null);
		}
    	return SUCCESS;
    }

    
    
    
    
    
    public CTSCLEARINGHOUSEVO getCtsClearingHouseVO()
    {
	return ctsClearingHouseVO;
    }

    public void setCtsClearingHouseVO(CTSCLEARINGHOUSEVO ctsClearingHouseVO)
    {
	this.ctsClearingHouseVO = ctsClearingHouseVO;
    }
    
    public BigDecimal getClearingHouseCode()
    {
        return clearingHouseCode;
    }

    public void setClearingHouseCode(BigDecimal clearingHouseCode)
    {
        this.clearingHouseCode = clearingHouseCode;
    }

    public BigDecimal getCurrnecyCode()
    {
        return currnecyCode;
    }

    public void setCurrnecyCode(BigDecimal currnecyCode)
    {
        this.currnecyCode = currnecyCode;
    }

    public void setCtsClearingHouseBO(CtsClearingHouseBO ctsClearingHouseBO)
    {
    	this.ctsClearingHouseBO = ctsClearingHouseBO;
    }
    
	public CtsClearingHouseSC getCriteria() {
		return criteria;
	}
	public void setCriteria(CtsClearingHouseSC criteria) {
		this.criteria = criteria;
	}

}
