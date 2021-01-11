package com.path.bo.common.general.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.path.bo.common.general.CreditCardEncryptDecryptBO;
import com.path.dao.common.general.CreditCardEncryptDecryptDAO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.FMSCREDITCARD_DETAILSVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.SecurityUtilsExt;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.general.CreditCardEncryptDecryptSC;

public class CreditCardEncryptDecryptBOImpl extends BaseBO implements CreditCardEncryptDecryptBO
{
    private CreditCardEncryptDecryptDAO creditCardEncryptDecryptDAO;

    /**
     * return Masked Credit Card Number
     * 
     * @param Card No unencrypted
     * @param Comp Code
     * @param Branch Code
     * 
     * @return Masked Credit Card Number
     * @throws BaseException
     */
    @Override
    public String maskedCreditCardNumber(String creditCardNumber, BigDecimal compCode, BigDecimal branchCode)
	    throws BaseException
    {
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(compCode);
	ctsControlVO.setBRANCH_CODE(branchCode);
	ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
	if(ctsControlVO == null || StringUtil.isEmptyString(ctsControlVO.getMASK_CARD_CHAR())
		|| NumberUtil.isEmptyDecimal(ctsControlVO.getMASK_CARD_POSITION())
		|| NumberUtil.isEmptyDecimal(ctsControlVO.getMASK_CARD_LENGTH()))
	{
	    return creditCardNumber;
	}

	return maskCreditCardNo(creditCardNumber, ctsControlVO.getMASK_CARD_POSITION(),
		ctsControlVO.getMASK_CARD_LENGTH(), ctsControlVO.getMASK_CARD_CHAR());
    }

    /**
     * return Masked Credit Card Number masking based on MASK_CARD_POSITION,
     * MASK_CARD_LENGTH and MASK_CARD_CHAR
     * 
     * @param Card No unencrypted
     * @param CTSCONTROL.MASK_CARD_POSITION
     * @param CTSCONTROL.MASK_CARD_LENGTH
     * @param CTSCONTROL.MASK_CARD_CHAR
     * 
     * @return Masked Credit Card Number
     * @throws BaseException
     */
    @Override
    public String maskCreditCardNo(String creditCardNumber, BigDecimal mask_card_position, BigDecimal mask_card_length,
	    String mask_char) throws BaseException
    {
	int ll_mask_card_position = mask_card_position.intValue();
	int ll_mask_card_length = mask_card_length.intValue();
	String strippedCreditCard = creditCardNumber.replaceAll("[ -]+", "");
	String maskedCardNumber = null;

	/* 774356,Vysakh,Added to exclude counting from 0th position */
	if(ll_mask_card_position > 0)
	{
	    ll_mask_card_position = ll_mask_card_position - 1;
	}

	if(strippedCreditCard.length() <= (ll_mask_card_position + ll_mask_card_length - 1))
	{
	    if(strippedCreditCard.length() >= ll_mask_card_position)
	    {
		ll_mask_card_length = strippedCreditCard.length() - ll_mask_card_position;
	    }
	    else
	    {
		maskedCardNumber = strippedCreditCard;
		return maskedCardNumber;
	    }
	}

	String subSectionOfCreditCard = strippedCreditCard.substring(ll_mask_card_position,
		ll_mask_card_position + ll_mask_card_length);

	String prefix = strippedCreditCard.substring(0, ll_mask_card_position);

	String middle = String.join("", Collections.nCopies(subSectionOfCreditCard.length(), mask_char));

	String suffix = strippedCreditCard.substring((ll_mask_card_position + ll_mask_card_length),
		strippedCreditCard.length());

	maskedCardNumber = prefix + middle + suffix;
	return maskedCardNumber;
    }

    /**
     * return Masked Credit Card Number masking based on MASK_CARD_POSITION,
     * MASK_CARD_LENGTH and MASK_CARD_CHAR
     * 
     * @param Flag to tell whether to Encrypt(E) or Decrypt(D)
     * @param Card No
     * @param comp_code
     * @param cif
     * @param CTSCONTROL.MASK_CARD_POSITION
     * @param CTSCONTROL.MASK_CARD_LENGTH
     * @param CTSCONTROL.MASK_CARD_CHAR
     * 
     * @return Masked Credit Card Number
     * @throws BaseException
     */
    public String f_encrypt_decrypt_report(String as_indicator, String as_card_no, BigDecimal comp_code, BigDecimal cif,
	    BigDecimal mask_card_position, BigDecimal mask_card_length, String mask_char) throws Exception
    {
	PTH_CTRL1VO ctrlVO = commonLibBO.returnPthCtrl1();
	String encString = null;
	if(CreditCardEncryptDecryptConstant.CARD_ENC_YN_Y.equals(ctrlVO.getCARD_ENC_YN())) // Y
	{
	    switch (as_indicator)
	    {
		case CreditCardEncryptDecryptConstant.AFS_ECNRYPT: // E

		    encString = encryptCreditCardNumber(as_card_no, comp_code, cif);
		    break;
		case CreditCardEncryptDecryptConstant.AFS_DECRYPT: // D
		    try
		    {
			encString = decryptCreditCardNumber(as_card_no, comp_code, cif);
			encString = maskCreditCardNo(encString, mask_card_position, mask_card_length, mask_char);
		    }
		    catch(Exception e)
		    {
			log.error("Decryption failure of card number : " + as_card_no + ", Cif : " + cif);
			return "enc is wrong";
		    }
		    break;
	    }
	}
	return encString;
    }


    // TP#414014;DB160031;Clint.Joy;04/01/2019
    /**
     * return Key To Encrypt / Decrypt
     * 
     * @param companyCode
     * @param cif
     * 
     * @return Key
     * @throws Exception
     */
    public String returnKeyToEncryptDecrypt(BigDecimal compCode, BigDecimal cif) throws Exception
    {
	// Append with 1 in case less string than size 8
	cif = BigDecimal.valueOf(Double.valueOf(String.format("%1$-" + 8 + "s", cif.toString()).replace(' ', '1')));
	// Append with 1 in case less string than size 4
	compCode = BigDecimal
		.valueOf(Double.valueOf(String.format("%1$-" + 4 + "s", compCode.toString()).replace(' ', '1')));

	BigDecimal cumulativeKey = NumberUtil.nullEmptyToValue(cif, BigDecimal.ONE)
		.multiply(NumberUtil.nullEmptyToValue(compCode, BigDecimal.ONE));

	// Truncate the value with size 10(if more than 10 skips remaining
	// and
	// if less that 10 just take as it is)
	String key = cumulativeKey.toString();
	key = key.substring(0, Math.min(key.length(), 10));

	// Append with PAD N in case less string than size 10
	key = String.format("%1$-" + 10 + "s", key).replace(' ', 'N');

	return key;
    }

    /**
     * return Decrypted Card Number
     * 
     * @param encryptedData
     * @param companyCode
     * @param cif
     * 
     * @return Decrypted Card Number
     * @throws Exception
     */
    @Override
    public String decryptCreditCardNumber(String encryptedData, BigDecimal companyCode, BigDecimal cif) throws Exception
    {
	String key = returnKeyToEncryptDecrypt(companyCode, cif);
	String creditCardNumber = null;
	creditCardNumber = SecurityUtilsExt.decryptAES(key + CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS,
		encryptedData);
	return creditCardNumber;
    }

    /**
     * return Encrypted Card Number
     * 
     * @param creditCardNumber
     * @param companyCode
     * @param cif
     * 
     * @return Encrypted Card Number
     * @throws Exception
     */
    @Override
    public String encryptCreditCardNumber(String creditCardNumber, BigDecimal companyCode, BigDecimal cif)
	    throws Exception
    {
	String key = returnKeyToEncryptDecrypt(companyCode, cif);
	return SecurityUtilsExt.encryptAES(key + CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS,
		creditCardNumber);
    }

    @Override
    public void migrateCreditCardNumber() throws Exception
    {
	CreditCardEncryptDecryptSC creditCardEncryptDecryptSC = new CreditCardEncryptDecryptSC();
	FMSCREDITCARD_DETAILSVO fmsCreditCardVO;
	List<CreditCardEncryptDecryptSC> creditCardDetailsList = creditCardEncryptDecryptDAO
		.returnFmsCreditCardDetailsList(creditCardEncryptDecryptSC);

	for(CreditCardEncryptDecryptSC cardDetails : creditCardDetailsList)
	{
	    fmsCreditCardVO = new FMSCREDITCARD_DETAILSVO();
	    if(cardDetails.getUnEncryptedCardNumber() != null)
	    {
		String encryptedData = encryptCreditCardNumber(cardDetails.getUnEncryptedCardNumber(),
			cardDetails.getCompCode(), cardDetails.getCif());

		creditCardEncryptDecryptSC.setUnEncryptedCardNumber(cardDetails.getUnEncryptedCardNumber());
		creditCardEncryptDecryptSC.setEncryptedCardNo(encryptedData);
		creditCardEncryptDecryptSC.setCompCode(cardDetails.getCompCode());
		creditCardEncryptDecryptDAO.updateCreditCardDetailsAfsLog(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsCtsTrs(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsFmsDrawdown(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsAfsDaily(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsTempAfsMonthly(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsDfDummySettle(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsAfsMonthly(creditCardEncryptDecryptSC);

		creditCardEncryptDecryptDAO.updateCreditCardDetailsAfsMonthlyHist(creditCardEncryptDecryptSC);

		fmsCreditCardVO.setCOMP_CODE(cardDetails.getCompCode());
		fmsCreditCardVO.setBRANCH_CODE(cardDetails.getBranchCode());
		fmsCreditCardVO.setAPPLICATION_CODE(cardDetails.getApplCode());
		fmsCreditCardVO.setSUBLIMIT_LINE_NBR(cardDetails.getSubLimitLineNo());
		fmsCreditCardVO.setLINE_NBR(cardDetails.getLineNo());
		fmsCreditCardVO.setCREDIT_CARD_NUMBER(encryptedData);
		fmsCreditCardVO.setFIELD(" ");
		fmsCreditCardVO.setCARD_NUMBER_UNENC_TEMP(" ");
		genericDAO.update(fmsCreditCardVO);
	    }
	}
    }

    @Override
    public List<CreditCardEncryptDecryptSC> returnFmsCreditCardDetailsList(
	    CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws Exception
    {
	List<CreditCardEncryptDecryptSC> creditCardDetailsList = creditCardEncryptDecryptDAO
		.returnFmsCreditCardDetailsList(creditCardEncryptDecryptSC);
	return creditCardDetailsList;
    }

    // /**
    // * return Encrypted Card Number
    // *
    // * @param creditCardNumber
    // * @param key of exact size 10 to be used for Encryption
    // *
    // * @return Encrypted Card Number
    // * @throws BaseException
    // */
    //
    // public String encryptCreditCardNumber(String creditCardNumber, String
    // key) throws Exception
    // {
    // return SecurityUtilsExt.encryptAES(key +
    // CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS,
    // creditCardNumber);
    // }
    //
    // /**
    // * return Decrypted Card Number
    // *
    // * @param Encrypted Card No
    // * @param key of exact size 10 used for Encrypting
    // *
    // * @return Decrypted Card Number
    // * @throws BaseException
    // */
    //
    // public String decryptCreditCardNumber(String encryptedData, String key)
    // throws Exception
    // {
    // String creditCardNumber = null;
    // creditCardNumber = SecurityUtilsExt.decryptAES(key +
    // CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS,
    // encryptedData);
    // return creditCardNumber;
    // }
    //
    // /**
    // * return Masked Credit Card Number masking based on MASK_CARD_POSITION,
    // * MASK_CARD_LENGTH and MASK_CARD_CHAR
    // *
    // * @param Flag to tell whether to Encrypt(E) or Decrypt(D)
    // * @param Card No
    // * @param key of exact size 10 used for Encrypting
    // * @param CTSCONTROL.MASK_CARD_POSITION
    // * @param CTSCONTROL.MASK_CARD_LENGTH
    // * @param CTSCONTROL.MASK_CARD_CHAR
    // *
    // * @return Masked Credit Card Number
    // * @throws BaseException
    // */
    //
    // public String f_encrypt_decrypt_report(String as_indicator, String
    // as_card_no, String as_key,
    // BigDecimal mask_card_position, BigDecimal mask_card_length, String
    // mask_char) throws Exception
    // {
    // PTH_CTRL1VO ctrlVO = commonLibBO.returnPthCtrl1();
    // String encString = null;
    // if(CreditCardEncryptDecryptConstant.CARD_ENC_YN_Y.equals(ctrlVO.getCARD_ENC_YN()))
    // // Y
    // {
    // switch (as_indicator)
    // {
    // case CreditCardEncryptDecryptConstant.AFS_ECNRYPT: // E
    //
    // encString = encryptCreditCardNumber(as_card_no,
    // as_key + CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS);
    // break;
    // case CreditCardEncryptDecryptConstant.AFS_DECRYPT: // D
    //
    // encString = decryptCreditCardNumber(as_card_no,
    // as_key + CreditCardEncryptDecryptConstant.CARD_ENCRYPTION_PASS);
    // encString = maskCreditCardNo(encString, mask_card_position,
    // mask_card_length, mask_char);
    // break;
    // }
    // }
    // return encString;
    // }

    public CreditCardEncryptDecryptDAO getCreditCardEncryptDecryptDAO()
    {
	return creditCardEncryptDecryptDAO;
    }

    public void setCreditCardEncryptDecryptDAO(CreditCardEncryptDecryptDAO creditCardEncryptDecryptDAO)
    {
	this.creditCardEncryptDecryptDAO = creditCardEncryptDecryptDAO;
    }
}
