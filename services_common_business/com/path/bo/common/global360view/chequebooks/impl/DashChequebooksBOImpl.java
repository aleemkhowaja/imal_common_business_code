/**
 * 
 */
package com.path.bo.common.global360view.chequebooks.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.global360view.chequebooks.DashChequebooksBO;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.dao.common.global360view.chequebooks.DashChequebooksDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.common.AccRestrictedSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ChequeBooksBOImpl.java used to
 */
public class DashChequebooksBOImpl extends BaseBO implements DashChequebooksBO
{
    private DashChequebooksDAO dashChequebooksDAO;
    private CoreCommonProcedureBO coreCommonProcedureBO;
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int chequebooksListCount(DashboardSC criteria) throws BaseException
    {

	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(criteria.getCif_no());
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCif(criteria.getCif_no());
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(999));
	accRestrictedSC.setAppName(criteria.getAppName());
	accRestrictedSC.setUserId(criteria.getUserId());
	accRestrictedSC.setCompCode(criteria.getCompCode());
	accRestrictedSC.setBranchCode(criteria.getBranchCode());
	accRestrictedSC.setProgRef(criteria.getProgRef());
//	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	
	return dashChequebooksDAO.chequebooksListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<ChequeBookCO> chequebooksList(DashboardSC criteria) throws BaseException
    {
	return dashChequebooksDAO.chequebooksList(criteria);
    }

    /**
     * @return the dashChequebooksDAO
     */
    public DashChequebooksDAO getDashChequebooksDAO()
    {
        return dashChequebooksDAO;
    }

    /**
     * @param dashChequebooksDAO the dashChequebooksDAO to set
     */
    public void setDashChequebooksDAO(DashChequebooksDAO dashChequebooksDAO)
    {
        this.dashChequebooksDAO = dashChequebooksDAO;
    }


    public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO)
    {
        this.coreCommonProcedureBO = coreCommonProcedureBO;
    }

    public CoreCommonProcedureBO getCoreCommonProcedureBO()
    {
        return coreCommonProcedureBO;
    }

}
