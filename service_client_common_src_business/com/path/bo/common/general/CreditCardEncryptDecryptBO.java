package com.path.bo.common.general;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.general.CreditCardEncryptDecryptSC;

public interface CreditCardEncryptDecryptBO
{
    // String encryptCreditCardNumber(String creditCardNumber, String key)
    // throws Exception;

    String encryptCreditCardNumber(String creditCardNumber, BigDecimal companyCode, BigDecimal cif) throws Exception;

    // String decryptCreditCardNumber(String encryptedData, String key) throws
    // Exception;

    String decryptCreditCardNumber(String encryptedData, BigDecimal companyCode, BigDecimal cif) throws Exception;

    String maskedCreditCardNumber(String creditCardNumber, BigDecimal compCode, BigDecimal branchCode)
	    throws BaseException;

    String maskCreditCardNo(String creditCardNumber, BigDecimal ll_mask_card_position, BigDecimal ll_mask_card_length,
	    String mask_char) throws BaseException;

    // String f_encrypt_decrypt_report(String as_indicator, String as_card_no,
    // String as_key,
    // BigDecimal mask_card_position, BigDecimal mask_card_length, String
    // mask_char) throws Exception;

    String f_encrypt_decrypt_report(String as_indicator, String as_card_no, BigDecimal comp_code, BigDecimal cif,
	    BigDecimal mask_card_position, BigDecimal mask_card_length, String mask_char) throws Exception;

    public String returnKeyToEncryptDecrypt(BigDecimal compCode, BigDecimal cif) throws Exception;

    void migrateCreditCardNumber() throws Exception;

    List<CreditCardEncryptDecryptSC> returnFmsCreditCardDetailsList(
	    CreditCardEncryptDecryptSC creditCardEncryptDecryptSC) throws Exception;
}
