package com.path.bo.core.passbook.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.passbook.PassbookBO;
import com.path.dao.core.passbook.PassbookDAO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.passbook.PassBookCO;
import com.path.vo.core.passbook.PassbookSC;
import com.path.vo.core.passbookinventory.PassBookinventoryCO;
import com.path.vo.core.passbookinventory.PassBookinventorySC;

public class PassbookBOImpl extends BaseBO implements PassbookBO
{
    private PassbookDAO passbookDAO;
    private CoreCommonBO coreCommonBO;

    public PassbookDAO getPassbookDAO()
    {
	return passbookDAO;
    }

    public void setPassbookDAO(PassbookDAO passbookDAO)
    {
	this.passbookDAO = passbookDAO;
    }

    @Override
    public List passbookList(PassbookSC criteria) throws BaseException
    {
	return passbookDAO.passbookList(criteria);
    }

    @Override
    public int passbookListCount(PassbookSC criteria) throws BaseException
    {
	return passbookDAO.passbookListCount(criteria);
    }

    public CoreCommonBO getCoreCommonBO()
    {
	return coreCommonBO;
    }

    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
	this.coreCommonBO = coreCommonBO;
    }

    @Override
    public PassBookCO returnPassbookById(PassbookSC criteria) throws BaseException
    {
    	PassBookCO passBookCO = new PassBookCO();
	CTSPASSBOOK_TYPEVO ctsPassBookTypeVO = (CTSPASSBOOK_TYPEVO) passbookDAO.returnPassbookById(criteria);
	if(null == ctsPassBookTypeVO)
	{
	    throw new BOException(MessageCodes.Invalid_Missing_Passbook_Type);
	}
	if(criteria.isCheckPassBkMinimumAlert())
	{
	    PassBookinventorySC passBookinventorySC = new PassBookinventorySC();
	    passBookinventorySC.setCompCode(criteria.getCompCode());
	    passBookinventorySC.setBranchCode(criteria.getBranchCode());
	    passBookinventorySC.setPassbookType(criteria.getPassbookCode());
	    passBookinventorySC.setVaultNo(returnPassBookMainVault(criteria));
	    if (!NumberUtil.isEmptyDecimal(passBookinventorySC.getVaultNo()))
	    {
	    PassBookinventoryCO passBookinventoryCO = checkQuantityMinimumAlert(passBookinventorySC);
	    if(null != passBookinventoryCO && null != passBookinventoryCO.getPassbookInventoryVO())
	    {
		if(NumberUtil.nullToZero(passBookinventoryCO.getPassbookInventoryVO().getQUANTITY()).compareTo(
			BigDecimal.ZERO) <= 0)
		{
		    throw new BOException(MessageCodes.PASSBOOK_TYPE_HAS_NO_QUANTITY, new String[] { criteria
			    .getPassbookCode().toString() }, true);
		}
		else if(null != passBookinventoryCO.getCtsPassBookTypeVO()
			&& NumberUtil.nullToZero(passBookinventoryCO.getCtsPassBookTypeVO().getMIN_ALERT_NUM())
				.compareTo(
					NumberUtil.nullToZero(passBookinventoryCO.getPassbookInventoryVO()
						.getQUANTITY())) >= 0)
		{
		    //Hasan Bug##418550 18/07/2016
		    passBookCO.setLanguage(StringUtil.nullToEmpty(criteria.getPreferredLanguage()));
		    passBookCO.getListWarningMsg().add(
			    commonLibBO.returnTranslErrorMessage(MessageCodes.PASSBOOK_REACHED_MINIMUM_ALERT,
				    new String[] { criteria.getPassbookCode().toString() }, passBookCO.getLanguage()));
		    /*throw new BOException(MessageCodes.PASSBOOK_REACHED_MINIMUM_ALERT, new String[] { criteria
			    .getPassbookCode().toString() }, true);*/
		}
	    }
	    }
	}
	passBookCO.setPassBookTypeVO(ctsPassBookTypeVO);
	return passBookCO;
    }

    /**
     * return mainvault of the current company and branch code, fill the needed
     * parameter to be sent to the common function retunMainVault in
     * corecommonLib
     * 
     * @author SarahElHusseini
     * @param passBookCO
     * @return
     * @throws BaseException
     */
    public BigDecimal returnPassBookMainVault(PassbookSC passbookSC) throws BaseException
    {
	/*
	 * Filling the attribute vaultNo needed to get the quantity of passBook
	 * in stock
	 */
	BigDecimal tellerCode = null;
	CTSTELLERSC ctsTellersC = new CTSTELLERSC();
	ctsTellersC.setCompCode(passbookSC.getCompCode());
	ctsTellersC.setBranchCode(passbookSC.getBranchCode());
	ctsTellersC.setPreferredLanguage(passbookSC.getPreferredLanguage());
	ctsTellersC.setVaultType(returnPassBookVaultType(passbookSC));

	CTSTELLERVO ctstellerVO = coreCommonBO.returnMainVault(ctsTellersC);
	if (null != ctstellerVO)
	{
	    tellerCode = ctstellerVO.getCODE();  
	}
	return tellerCode;
    }

    /**
     * return vaultType for the current branch and compCode vaultType is needed
     * to return the main vault (parameter to be filled for ctstellersSC for
     * returnMainVault)
     * 
     * @param passBookCO
     * @return
     * @throws BaseException
     */
    private BigDecimal returnPassBookVaultType(PassbookSC passbookSC) throws BaseException
    {
	/* Get the code and the description of the main vault */
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(passbookSC.getCompCode());
	ctsControlVO.setBRANCH_CODE(passbookSC.getBranchCode());
	ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);

	if(null == ctsControlVO.getVAULT_TYPE())
	{
	    ctsControlVO.setVAULT_TYPE(new BigDecimal(-1));
	}

	return ctsControlVO.getVAULT_TYPE();
    }

    public PassBookinventoryCO checkQuantityMinimumAlert(PassBookinventorySC passBookinventorySC) throws DAOException
    {
	return (PassBookinventoryCO) passbookDAO.checkQuantityMinimumAlert(passBookinventorySC);
    }

    @Override
    public CTSPASSBOOK_TYPEVO returnDefaultedPassbookByCifTypeCode(PassbookSC criteria) throws BaseException
    {
	return (CTSPASSBOOK_TYPEVO) passbookDAO.returnDefaultedPassbookByCifTypeCode(criteria);
    }

}
