package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.bo.core.chequebookdesign.ChequeBookDesignBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

 
/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Chady Assaf
 * 
 * 	ChequeBookDesignDependencyAction.java used for all dependencies related to Design.
 *
 */
public class ChequeBookDesignDependencyAction extends BaseAction
{
	private ChequeBookDesignBO chequeBookDesignBO;
    private BigDecimal COMP_CODE;
    private BigDecimal CODE;
    private String _descReadOnly;
    private CTSCHEQUEBOOK_DESIGNVO designVO = new CTSCHEQUEBOOK_DESIGNVO();
    
    /**
     * Get dependency between Design Code and Description
     * @return
     */
    public String dependencyByDesign()
    {
		try
		{
			SessionCO sessionCO = returnSessionObject();
		    set_recReadOnly("readonly");
			
		    designVO.setCOMP_CODE(sessionCO.getCompanyCode());
		    designVO.setCODE(getCODE());
		    designVO = chequeBookDesignBO.returnDependencyByDesign(designVO);
			
			if(null == designVO)
			{
				designVO = new CTSCHEQUEBOOK_DESIGNVO();
			}
			
		}
		catch(Exception e)
		{
		    log.error(e, "Error in dependencyByDesign method of ChequeBookDesignDependencyAction.java");
		    handleException(e, "ERROR in DesignDependency", null);
		}
		return SUCCESS;	
    }

	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMPCODE) {
		COMP_CODE = cOMPCODE;
	}

	public BigDecimal getCODE() {
		return CODE;
	}

	public void setCODE(BigDecimal cODE) {
		CODE = cODE;
	}

	public void setChequeBookDesignBO(ChequeBookDesignBO chequeBookDesignBO) {
		this.chequeBookDesignBO = chequeBookDesignBO;
	}

	public CTSCHEQUEBOOK_DESIGNVO getDesignVO() {
		return designVO;
	}

	public void setDesignVO(CTSCHEQUEBOOK_DESIGNVO designVO) {
		this.designVO = designVO;
	}

	public String get_descReadOnly() {
		return _descReadOnly;
	}

	public void set_descReadOnly(String descReadOnly) {
		_descReadOnly = descReadOnly;
	}

}
