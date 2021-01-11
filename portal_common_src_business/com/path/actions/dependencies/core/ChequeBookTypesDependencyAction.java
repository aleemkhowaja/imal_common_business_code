package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.bo.core.chequebooktypes.ChequeBookTypesBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Chady Assaf
 * 
 *         ChequeBookTypesDependencyAction.java used for all dependencies
 *         related to Types.
 * 
 */
public class ChequeBookTypesDependencyAction extends BaseAction
{
    private ChequeBookTypesBO chequeBookTypesBO;
    private BigDecimal COMP_CODE;
    private BigDecimal CODE;
    private CTSCHEQUEBOOK_TYPESVO typesVO = new CTSCHEQUEBOOK_TYPESVO();

    /**
     * Get dependency between Types Code and Description
     * 
     * @return
     */
    public String dependencyByTypes()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    set_recReadOnly("readonly");
	    typesVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    typesVO.setCODE(getCODE());
	    typesVO = chequeBookTypesBO.returnDependencyByTypes(typesVO);

	    if(null == typesVO)
	    {
		typesVO = new CTSCHEQUEBOOK_TYPESVO();
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByTypes method of ChequeBookTypesDependencyAction.java");
	    handleException(e, "ERROR in TypesDependency", null);
	}
	return SUCCESS;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public CTSCHEQUEBOOK_TYPESVO getTypesVO()
    {
	return typesVO;
    }

    public void setTypesVO(CTSCHEQUEBOOK_TYPESVO typesVO)
    {
	this.typesVO = typesVO;
    }

    public void setChequeBookTypesBO(ChequeBookTypesBO chequeBookTypesBO)
    {
	this.chequeBookTypesBO = chequeBookTypesBO;
    }

}
