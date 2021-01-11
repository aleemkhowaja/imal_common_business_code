/**
 * 
 */
package com.path.bo.common.global360view.others.impl;

import com.path.dao.common.global360view.others.impl.DashOthersDAOImpl;
import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.global360view.others.DashOthersBO;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.dao.common.global360view.others.DashOthersDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashOthersCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.common.AccRestrictedSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersBOImpl.java used to
 */
public class DashOthersBOImpl extends BaseBO implements DashOthersBO
{
    private DashOthersDAO dashOthersDAO;
    private CoreCommonProcedureBO coreCommonProcedureBO;
    
    public int remittancesListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.remittancesListCount(criteria);
    }

    public List<DashOthersCO> remittancesList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.remittancesList(criteria);
    }
    
    public int specialCondAccListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.specialCondAccListCount(criteria);
    }

    public List<DashOthersCO> specialCondAccList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.specialCondAccList(criteria);
    }
    
    public int specialCondCifListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.specialCondCifListCount(criteria);
    }

    public List<DashOthersCO> specialCondCifList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.specialCondCifList(criteria);
    }
    
    public int authorizedSigListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.authorizedSigListCount(criteria);
    }

    public List<DashOthersCO> authorizedSigList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.authorizedSigList(criteria);
    }
    
    public int linksCifCifListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.linksCifCifListCount(criteria);
    }

    public List<DashOthersCO> linksCifCifList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.linksCifCifList(criteria);
    }
    
    public int linksAccAccListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.linksAccAccListCount(criteria);
    }

    public List<DashOthersCO> linksAccAccList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.linksAccAccList(criteria);
    }
    
    public int linksAccCifListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.linksAccCifListCount(criteria);
    }

    public List<DashOthersCO> linksAccCifList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.linksAccCifList(criteria);
    }
    
    public int linksCifAccListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.linksCifAccListCount(criteria);
    }

    public List<DashOthersCO> linksCifAccList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.linksCifAccList(criteria);
    }
    
    public int soListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.soListCount(criteria);
    }

    public List<DashOthersCO> soList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.soList(criteria);
    }
    
    public int memosListCount(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
  	return dashOthersDAO.memosListCount(criteria);
    }

    public List<DashOthersCO> memosList(DashboardSC criteria) throws BaseException
    {
  	return dashOthersDAO.memosList(criteria);
    }
    
    public DashOthersCO returnLinksExistanceQueryList(DashboardSC criteria) throws BaseException
    {
	fillAccRestricedTmp(criteria) ;
	return dashOthersDAO.returnLinksExistanceQueryList(criteria);
    }


    private void fillAccRestricedTmp(DashboardSC criteria) throws BaseException
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
	// no need to fill the acc restricted everytime, since it is filled once filling the CIF.
	//coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	
    }
    
    public DashOthersDAO getDashOthersDAO()
    {
        return dashOthersDAO;
    }

    public void setDashOthersDAO(DashOthersDAO dashOthersDAO)
    {
        this.dashOthersDAO = dashOthersDAO;
    }

    public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO)
    {
        this.coreCommonProcedureBO = coreCommonProcedureBO;
    }

    @Override
    public int childCifListCount(DashboardSC criteria) throws BaseException
    {
	return dashOthersDAO.childCifListCount(criteria);
    }

    @Override
    public List<DashOthersCO> childCifList(DashboardSC criteria) throws BaseException
    {
	return dashOthersDAO.childCifList(criteria);
    }

   
}
