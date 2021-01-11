/**
 * 
 */
package com.path.bo.common.requests.csm.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.StatusUtil;
import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.bo.core.currency.CurrencyBO;
import com.path.bo.core.gl.GLBO;
import com.path.dao.common.requests.csm.CtsRequestDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCTRVO;
import com.path.dbmaps.vo.CTSTELLERACCDETVO;
import com.path.dbmaps.vo.CTS_REQUESTVO;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.currency.CurrencySC;
import com.path.vo.core.gl.GLSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequestBOImpl.java used to
 */
public class CtsRequestBOImpl extends BaseBO implements CtsRequestBO
{
    CtsRequestDAO ctsRequestDAO;
    BranchesBO branchesBO;
    CurrencyBO currencyBO;
    GLBO glBO;
    
    
    public CtsRequestDAO getCtsRequestDAO()
    {
	return ctsRequestDAO;
    }

    public void setCtsRequestDAO(CtsRequestDAO ctsRequestDAO)
    {
	this.ctsRequestDAO = ctsRequestDAO;
    }
    
    public void setBranchesBO(BranchesBO branchesBO)
    {
        this.branchesBO = branchesBO;
    }

    public void setCurrencyBO(CurrencyBO currencyBO)
    {
        this.currencyBO = currencyBO;
    }

    public void setGlBO(GLBO glBO)
    {
        this.glBO = glBO;
    }
    
    
    

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.bo.core.ctsrequest.CtsRequestBO#ctsRequestById(com.path.vo.core
     * .ctsrequest.CtsRequestSC)
     */
    @Override
    public CTS_REQUEST_TYPEVO returnCtsRequestTypeById(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestTypeById(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.bo.core.ctsrequest.CtsRequestBO#ctsRequestList(com.path.vo.core
     * .ctsrequest.CtsRequestSC)
     */
    @Override
    public List<CTS_REQUEST_TYPEVO> returnCtsRequestTypeList(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestTypeList(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.bo.core.ctsrequest.CtsRequestBO#ctsRequestListCount(com.path
     * .vo.core.ctsrequest.CtsRequestSC)
     */
    @Override
    public int returnCtsRequestTypeListCount(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestTypeListCount(criteria);
    }

    @Override
    public List<CtsRequestCO> returnCtsRequestList(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestList(criteria);
    }

    @Override
    public int returnCtsRequestListCount(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestListCount(criteria);
    }

    @Override
    public BigDecimal returnCtsctrCounter(BigDecimal companyCode, BigDecimal branchCode, String trsType, String cbInd)
	    throws BaseException
    {
	CTSCTRVO ctsctrVO = new CTSCTRVO();
	ctsctrVO.setCOMP_CODE(companyCode);
	ctsctrVO.setBRANCH_CODE(branchCode);
	ctsctrVO.setTRS_NO(BigDecimal.ZERO);
	ctsctrVO.setTRS_TYPE(trsType);
	ctsctrVO.setCB_IND(cbInd);

	CtsRequestSC criteria = new CtsRequestSC();
	criteria.setCompCode(companyCode);
	criteria.setBranchCode(branchCode);
	criteria.setTrsType(trsType);
	criteria.setCbInd(cbInd);
	BigDecimal counter = BigDecimal.ONE;
	CTSCTRVO ctsctr = (CTSCTRVO) genericDAO.selectByPK(ctsctrVO);
	if(ctsctr == null)
	{
	    genericDAO.insert(ctsctrVO);
	}
	else
	{
	    counter = ctsRequestDAO.returnLastTrsNbrFromCtsCtr(criteria);
	    if(NumberUtil.isEmptyDecimal(counter))
	    {
		counter = BigDecimal.ZERO;
	    }
	    counter = counter.add(BigDecimal.ONE);
	}
	ctsctrVO.setTRS_NO(counter);
	genericDAO.update(ctsctrVO);
	return counter;
    }

    public List<StatusCO> generateRequestStatusList(Object obj, List<String> colList, SelectSC lovCriteria)
	    throws BaseException
    {
	Object returnedObj = genericDAO.selectByPK(obj);
	CTS_REQUESTVO obj1 = new CTS_REQUESTVO();
	PathPropertyUtil.copyProperties(returnedObj, obj1);
	return StatusUtil.generateStatusList(obj1, colList, commonLibBO.returnLOVMap(lovCriteria));

    }

    @Override
    public BigDecimal returnCtsRequestTypeCodeByReference(CtsRequestSC criteria) throws BaseException
    {
	return ctsRequestDAO.returnCtsRequestTypeCodeByReference(criteria);
    }
    
    
    
    private CtsRequestCO dependencyByPaymentType(CtsRequestCO ctsRequestCO, boolean fromDependency) throws BaseException
    {
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = ctsRequestCO.getHmSysParam(); 
	if(CtsRequestConstant.PAYMENT_TYPE_CASH.equals(ctsRequestCO.getPaymentType()))
	{
	    if(fromDependency)
	    {

		CTSTELLERACCDETVO ctsTellerAccDet = new CTSTELLERACCDETVO();
		ctsTellerAccDet.setCOMP_CODE(ctsRequestCO.getLoginCompCode());
		ctsTellerAccDet.setBRANCH_CODE(ctsRequestCO.getLoginBraCode());
		ctsTellerAccDet.setCODE(ctsRequestCO.getLoginTellerCode());
		//#BUG 337003, teller account is retrieved by request currency (no more by Base currency)
		ctsTellerAccDet.setCY_CODE(NumberUtil.nullEmptyToValue(ctsRequestCO.getRequestCy(), ctsRequestCO
			.getBaseCurrencyCode()));
		ctsTellerAccDet.setTRX_TYPE(BigDecimal.ZERO);
		ctsTellerAccDet = (CTSTELLERACCDETVO) genericDAO.selectByPK(ctsTellerAccDet);

		if(null == ctsTellerAccDet)
		{
		    hm = applyDynScreenDisplay(new String[] { "chr_ac_br", "chr_ac_cy", "chr_ac_gl", "chr_ac_cif",
			    "lookuptxt_chr_ac_sl", "lookuptxt_chr_ac_add_ref" }, ConstantsCommon.ACTION_TYPE_READONLY,
			    "0", ctsRequestCO.getHmSysParam(), null);
		    return ctsRequestCO;
		}

		AMFVO amfVO = new AMFVO();
		amfVO.setCOMP_CODE(ctsRequestCO.getLoginCompCode());
		amfVO.setBRANCH_CODE(ctsTellerAccDet.getBRANCH_CODE());
		amfVO.setCURRENCY_CODE(ctsTellerAccDet.getCY_CODE());
		amfVO.setGL_CODE(ctsTellerAccDet.getACC_GL());
		amfVO.setCIF_SUB_NO(ctsTellerAccDet.getACC_CIF());
		amfVO.setSL_NO(ctsTellerAccDet.getACC_SL());
		amfVO = (AMFVO) genericDAO.selectByPK(amfVO);
		if(null != amfVO)
		{
		    if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(ctsRequestCO.getLoginPreferrredLanguage()))
		    {
			amfVO.setBRIEF_NAME_ENG(amfVO.getBRIEF_NAME_ARAB());
		    }
		    ctsRequestCO.setAmfVO(amfVO);
		}

	    }
	    hm = applyDynScreenDisplay(new String[] { "chr_ac_br", "chr_ac_cy", "chr_ac_gl", "chr_ac_cif",
		    "lookuptxt_chr_ac_sl", "lookuptxt_chr_ac_add_ref" }, ConstantsCommon.ACTION_TYPE_READONLY, "1",
		    ctsRequestCO.getHmSysParam(), null);
	}
	else
	{
	    if(fromDependency)
	    {
		ctsRequestCO.getAmfVO().setCURRENCY_CODE(ctsRequestCO.getRequestCy());
	    }
	    // if the cif is not defined, then it should be enable,
	    // otherwise it will be disabled and defaulted
	    if(NumberUtil.isEmptyDecimal(ctsRequestCO.getRequestCif()))
	    {

		if(fromDependency)
		{
		    ctsRequestCO.getAmfVO().setCIF_SUB_NO(null);
		}
		hm = applyDynScreenDisplay(new String[] { "chr_ac_cif" }, ConstantsCommon.ACTION_TYPE_READONLY, "0",
			hm, null);
	    }
	    else
	    {

		if(fromDependency)
		{
		    ctsRequestCO.getAmfVO().setCIF_SUB_NO(
			    NumberUtil.nullEmptyToValue(ctsRequestCO.getRequestCif(), null));
		}
		hm = applyDynScreenDisplay(new String[] { "chr_ac_cif" }, ConstantsCommon.ACTION_TYPE_READONLY, "1",
			hm, null);
	    }
	    // 337003
	    hm = applyDynScreenDisplay(new String[] { "chr_ac_br", "chr_ac_cy", "chr_ac_gl", "lookuptxt_chr_ac_sl",
		    "lookuptxt_chr_ac_add_ref"}, ConstantsCommon.ACTION_TYPE_READONLY, "0", hm, null);
	}
	ctsRequestCO.setHmSysParam(hm);
	return ctsRequestCO;
    }

    
    
    public CtsRequestCO dependencyByPaymentType(CtsRequestCO ctsRequestCO) throws BaseException
    {
	dependencyByPaymentType(ctsRequestCO, true);
	return ctsRequestCO;
    }

    /**
     * return charges details related to the request
     */
    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestCO ctsRequestCOParam) throws BaseException
    {

	CtsRequestCO ctsRequestCO = ctsRequestCOParam;

	if(NumberUtil.isEmptyDecimal(ctsRequestCO.getCtsRequestVO().getREQ_NO()))
	{
	    defaultValuesOnLoad(ctsRequestCO, ctsRequestCOParam);
	}
	else
	{
	    CtsRequestSC criteria = new CtsRequestSC();
	    criteria.setCompCode(ctsRequestCOParam.getLoginCompCode());
	    criteria.setBranchCode(ctsRequestCOParam.getLoginBraCode());
	    criteria.setCode(ctsRequestCOParam.getCtsRequestVO().getREQ_NO());
	    criteria.setPreferredLanguage(ctsRequestCOParam.getLoginPreferrredLanguage());
	    ctsRequestCO = ctsRequestDAO.returnCtsRqstInfoChargesDet(criteria);
	    if(ctsRequestCO == null)
	    {
		// 337003,if the request has no charges
		ctsRequestCO = new CtsRequestCO();
		defaultValuesOnLoad(ctsRequestCO, ctsRequestCOParam);
		ctsRequestCO.setRequestCy(ctsRequestCOParam.getRequestCy());
		ctsRequestCO.setRequestCif(ctsRequestCOParam.getRequestCif());
	    }
	    else
	    {
		ctsRequestCOParam.setPaymentType(ctsRequestCO.getPaymentType());
		ctsRequestCO.setRequestCy(ctsRequestCOParam.getRequestCy());
		ctsRequestCO.setRequestCif(ctsRequestCOParam.getRequestCif());
	    }
	}
	dependencyByPaymentType(ctsRequestCOParam, false);
	ctsRequestCO.setHmSysParam(ctsRequestCOParam.getHmSysParam());

	return ctsRequestCO;
    }
    
    /**
     * return charges details related to the request
     */
    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestSC ctsRequestSC) throws BaseException
    {
	return ctsRequestDAO.returnCtsRqstInfoChargesDet(ctsRequestSC);
    }
    
    /**
     * defaulting for some values upon load the screen, in case new request, or
     * existed request that has no charges
     * @param ctsRequestCOParam 
     * @param ctsRequestCO 
     */
    private void defaultValuesOnLoad(CtsRequestCO ctsRequestCO, CtsRequestCO ctsRequestCOParam)
    {
	ctsRequestCO.setPaymentType(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT);
	//should default the values on create mode, or when status is active
	if(!StringUtil.isNotEmpty(ctsRequestCOParam.getCtsRequestVO().getSTATUS()) || CtsRequestConstant.STATUS_CREATE.equals(ctsRequestCOParam.getCtsRequestVO().getSTATUS()))
	{
	    ctsRequestCO.getAmfVO().setCURRENCY_CODE(ctsRequestCOParam.getRequestCy());
	    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.nullEmptyToValue(ctsRequestCOParam.getRequestCif(), null));

	}
    }
    
    
    
    
    /**
     * aed by jihad to delete requets charges
     * @author: jihadlamaa
     * @date: Jan 23, 2015
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public Integer deleteRequestChargesDetails(CtsRequestSC criteria) throws BaseException
    {
        return ctsRequestDAO.deleteRequestChargesDetails(criteria);
    }
    
    /**
     * used to get the 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public CTS_REQUESTVO returnCtsRequestData(CTS_REQUESTVO criteria) throws BaseException
    {
        return (CTS_REQUESTVO)genericDAO.selectByPK(criteria);
    }

    @Override
    public CtsRequestCO dependencyByExpiryDate(CtsRequestCO ctsRequestCO) throws BaseException
    {
	if(ctsRequestCO.getCtsRequestVO().getREQ_DATE() != null)
	{
	    if(ctsRequestCO.getCtsRequestVO().getREQ_EXP_DATE().compareTo(ctsRequestCO.getRunningDate()) < 0)
	    {
		throw new BOException(MessageCodes.DATE_CANNOT_BE_LESS_THAN_RUNNING_DATE);
	    }
	    if(ctsRequestCO.getCtsRequestVO().getREQ_DATE() != null
		    && ctsRequestCO.getCtsRequestVO().getREQ_DATE().compareTo( ctsRequestCO.getCtsRequestVO().getREQ_EXP_DATE()) > 0)
	    {
		// check if the message should be 901207
		throw new BOException(MessageCodes.EXPIRY_DATE_CANNOT_BE_LESS_THAN_STARTING_DATE);
	    }
		
//	    long daysDiff = DateUtil.numberOfDays(ctsRequestCO.getCtsRequestVO().getREQ_DATE(), ctsRequestCO
//		    .getCtsRequestVO().getREQ_EXP_DATE());
//	    CTS_REQUEST_TYPEVO requestTYPEVO = new CTS_REQUEST_TYPEVO();
//	    requestTYPEVO.setCOMP_CODE(ctsRequestCO.getLoginCompCode());
//	    requestTYPEVO.setCODE(ctsRequestCO.getCtsRequestVO().getTYPE());
//	    requestTYPEVO = (CTS_REQUEST_TYPEVO) genericDAO.selectByPK(requestTYPEVO);
//	    if(requestTYPEVO != null)
//	    {
//		BigDecimal expiryDays = NumberUtil.nullToZero(requestTYPEVO.getEXP_PER_DAYS());
//		if(daysDiff > expiryDays.longValue())
//		{
//		    //check the message
//		    throw new BOException(1);
//		}
//	    }
	}
	return ctsRequestCO;
    }

    @Override
    public CtsRequestCO dependencyAccBranch(CtsRequestCO ctsRequestCO) throws BaseException
    {
	BranchesSC criteria = new BranchesSC();
	criteria.setBranchCode(ctsRequestCO.getAmfVO().getBRANCH_CODE());
	// criteria.setUserId(sessionCO.getUserName());
	criteria.setCompCode(ctsRequestCO.getLoginCompCode());

	branchesBO.checkBranchValidation(criteria);
	if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
	{
	    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
	}
	ctsRequestCO.getAmfVO().setCURRENCY_CODE(null);
	ctsRequestCO.getAmfVO().setGL_CODE(null);
	ctsRequestCO.getAmfVO().setSL_NO(null);
	ctsRequestCO.getAmfVO().setADDITIONAL_REFERENCE(null);
	ctsRequestCO.getAmfVO().setBRIEF_NAME_ENG(null);
	return ctsRequestCO;
    }
    
    
    
    @Override
    public CtsRequestCO dependencyAccCurrency(CtsRequestCO ctsRequestCO) throws BaseException
    {
	CurrencySC criteria = new CurrencySC();

	criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(ctsRequestCO.getAmfVO().getCURRENCY_CODE()));
	criteria.setCompCode(ctsRequestCO.getLoginCompCode());
	currencyBO.checkCurrencyValidation(criteria);

	if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
	{
	    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
	}
	ctsRequestCO.getAmfVO().setGL_CODE(null);
	ctsRequestCO.getAmfVO().setSL_NO(null);
	ctsRequestCO.getAmfVO().setADDITIONAL_REFERENCE(null);
	ctsRequestCO.getAmfVO().setBRIEF_NAME_ENG(null);
	return ctsRequestCO;
    }

    @Override
    public CtsRequestCO dependencyAccGl(CtsRequestCO ctsRequestCO) throws BaseException
    {
	GLSC criteria = new GLSC();

	criteria.setGlCode(NumberUtil.emptyDecimalToNull(ctsRequestCO.getAmfVO().getGL_CODE()));
	criteria.setCompCode(ctsRequestCO.getLoginCompCode());
	glBO.checkGLValidation(criteria);

	if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
	{
	    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
	}
	ctsRequestCO.getAmfVO().setSL_NO(null);
	ctsRequestCO.getAmfVO().setADDITIONAL_REFERENCE(null);
	ctsRequestCO.getAmfVO().setBRIEF_NAME_ENG(null);
	return ctsRequestCO;
    }
    

}
