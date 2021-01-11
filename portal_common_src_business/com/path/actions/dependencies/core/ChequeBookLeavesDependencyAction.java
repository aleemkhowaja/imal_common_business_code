package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.bo.core.chequebookleaves.ChequeBookLeavesBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Chady Assaf
 * 
 *         ChequeBookLeavesDependencyAction.java used for all dependencies
 *         related to Leaves.
 * 
 */
public class ChequeBookLeavesDependencyAction extends BaseAction
{
    private ChequeBookLeavesBO chequeBookLeavesBO;
    private BigDecimal COMP_CODE;
    private BigDecimal CODE;
    private String _descReadOnly;
    private String _noLeavesReadOnly;
    private CTSCHEQUEBOOK_LEAVESVO leavesVO = new CTSCHEQUEBOOK_LEAVESVO();

    /**
     * Get dependency between Leaves Code and Description
     * 
     * @return
     */
    public String dependencyByLeaves()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    set_recReadOnly("readonly");
	    leavesVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    leavesVO.setCODE(getCODE());
	    leavesVO = chequeBookLeavesBO.returnDependencyByLeaves(leavesVO);

	    if(null == leavesVO)
	    {
		leavesVO = new CTSCHEQUEBOOK_LEAVESVO();
		set_noLeavesReadOnly("readonly");
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByLeaves method of ChequeBookLeavesDependencyAction.java");
	    handleException(e, "ERROR in LeavesDependency", null);
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

    public CTSCHEQUEBOOK_LEAVESVO getLeavesVO()
    {
	return leavesVO;
    }

    public void setLeavesVO(CTSCHEQUEBOOK_LEAVESVO leavesVO)
    {
	this.leavesVO = leavesVO;
    }

    public void setChequeBookLeavesBO(ChequeBookLeavesBO chequeBookLeavesBO)
    {
	this.chequeBookLeavesBO = chequeBookLeavesBO;
    }

    public String get_descReadOnly()
    {
	return _descReadOnly;
    }

    public void set_descReadOnly(String descReadOnly)
    {
	_descReadOnly = descReadOnly;
    }

    public String get_noLeavesReadOnly()
    {
	return _noLeavesReadOnly;
    }

    public void set_noLeavesReadOnly(String noLeavesReadOnly)
    {
	_noLeavesReadOnly = noLeavesReadOnly;
    }

}
