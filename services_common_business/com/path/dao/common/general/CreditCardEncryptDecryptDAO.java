package com.path.dao.common.general;

import java.util.List;

import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.general.CreditCardEncryptDecryptSC;

public interface CreditCardEncryptDecryptDAO
{

    String returnCreditCardEncryptKey(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    CTSCONTROLVO returnCreditCardMaskingDetails(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException;

    String returnFmsCreditCardDetails(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    List<CreditCardEncryptDecryptSC> returnFmsCreditCardDetailsList(
	    CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    void updateCreditCardDetailsAfsLog(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    void updateCreditCardDetailsCtsTrs(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    void updateCreditCardDetailsFmsDrawdown(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    void updateCreditCardDetailsAfsMonthly(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

    void updateCreditCardDetailsTempAfsMonthly(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException;

    void updateCreditCardDetailsDfDummySettle(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException;

    void updateCreditCardDetailsAfsMonthlyHist(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC)
	    throws DAOException;

    void updateCreditCardDetailsAfsDaily(CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws DAOException;

}
