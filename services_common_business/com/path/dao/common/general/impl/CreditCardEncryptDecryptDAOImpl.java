package com.path.dao.common.general.impl;

import java.util.List;

import com.path.dao.common.general.CreditCardEncryptDecryptDAO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.general.CreditCardEncryptDecryptSC;

public class CreditCardEncryptDecryptDAOImpl extends BaseDAO implements CreditCardEncryptDecryptDAO
{
    @Override
    public String returnCreditCardEncryptKey(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("CreditCardEncryptDecryptMapper.returnCreditCardEncryptKey",
		creditCardEncryptDecryptSC);
    }

    @Override
    public CTSCONTROLVO returnCreditCardMaskingDetails(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	return (CTSCONTROLVO) getSqlMap().queryForObject(
		"CreditCardEncryptDecryptMapper.returnCreditCardMaskingDetails", creditCardEncryptDecryptSC);
    }

    @Override
    public String returnFmsCreditCardDetails(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("CreditCardEncryptDecryptMapper.returnFmsCreditCardDetails",
		creditCardEncryptDecryptSC);
    }

    @Override
    public List<CreditCardEncryptDecryptSC> returnFmsCreditCardDetailsList(
	    CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException
    {
	return getSqlMap().queryForList("CreditCardEncryptDecryptMapper.returnFmsCreditCardDetailsList",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsAfsLog(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsAfsLog", creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsCtsTrs(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsCtsTrs", creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsFmsDrawdown(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsFmsDrawdown",
		creditCardEncryptDecryptSC);

	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsFmsDrawdownArab",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsAfsMonthly(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsAfsMonthly",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsTempAfsMonthly(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsTempAfsMonthly",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsDfDummySettle(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsDfDummySettle",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsAfsMonthlyHist(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsAfsMonthlyHist",
		creditCardEncryptDecryptSC);
    }

    @Override
    public void updateCreditCardDetailsAfsDaily(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException
    {
	getSqlMap().update("CreditCardEncryptDecryptMapper.updateCreditCardDetailsAfsDaily",
		creditCardEncryptDecryptSC);
    }

}
