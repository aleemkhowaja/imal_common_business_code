package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTSTRS_EXTENDEDVO extends CTSTRS_EXTENDEDVOKey {
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CHEQUE_DIGITS
     */
    private BigDecimal CHEQUE_DIGITS;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.BENEF_REGION
     */
    private BigDecimal BENEF_REGION;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_TRS_DATE
     */
    private Date ORIGINAL_CHQ_TRS_DATE;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_VALUE_DATE
     */
    private Date ORIGINAL_CHQ_VALUE_DATE;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.ORIGNAL_CHQ_DATE
     */
    private Date ORIGNAL_CHQ_DATE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     */
    private BigDecimal TREASURY_EXCH_RATE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     */
    private String SWIFT_CUST_REFERENCE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.UETR
     */
    private String UETR;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.BIRTH_DATE
     */
    private Date BIRTH_DATE;
    
    /**

     * This field corresponds to the database column CTSTRS_EXTENDED.ENCRYPT_KEY
     */
    private String ENCRYPT_KEY;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.DEBIT_VDATE
     */
    private Date DEBIT_VDATE;
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CARD_BR_CODE
     */
    private BigDecimal CARD_BR_CODE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CARD_APP_ID
     */
    private BigDecimal CARD_APP_ID;
    
    /**
     * 
     * This field corresponds to the database column CTSTRS_EXTENDED.SUB_STATUS
     */
    private String SUB_STATUS;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.ORIGIN_COUNTRY_CODE
     */
    private BigDecimal ORIGIN_COUNTRY_CODE;
   

    private String CHQ_TRX_CREATED_YN;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.PAYMENT_CODE
     */
    private BigDecimal PAYMENT_CODE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.OVERDRAW_FROM_ACC
     */
    private String OVERDRAW_FROM_ACC;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.OVERDRAW_TO_ACC
     */
    private String OVERDRAW_TO_ACC;
    
    
    private String NARRATION;
    
    private BigDecimal REMITTANCE_TYPE_CODE;
    private BigDecimal REMITTANCE_RECORD;
    
    private String SYNTHESIS_STATUS;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CERTIFICATE_BRANCH
     */
    private BigDecimal CERTIFICATE_BRANCH;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CERTIFICATE_CODE
     */
    private BigDecimal CERTIFICATE_CODE;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.NUMBER_OF_BILLS
     */
    private BigDecimal NUMBER_OF_BILLS;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.TOTAL_AMOUNT_OF_BILLS
     */
    private BigDecimal TOTAL_AMOUNT_OF_BILLS;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CUSTOMER_BIC_CODE
     */
    private String CUSTOMER_BIC_CODE;

    
    private String CY_PURCHASE_SALE;
    
    private String TRX_CY_EXCH_PUR_SAL_REF;
    
    
    
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.BIOMETRIC_APPROVED_YN
     */
    private String BIOMETRIC_APPROVED_YN;
    
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.CARD_READER_SRL
     */
    private String CARD_READER_SRL;
    
    private BigDecimal PROVIDER_AMOUNT;
    private BigDecimal ADDITIONAL_FEES;
    private BigDecimal PAYMENT_METHOD;
    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.INSTRUCTION_CODE
     */
    private BigDecimal INSTRUCTION_CODE;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.EXC_OFFICE_TICKET_NO
     */
    private BigDecimal EXC_OFFICE_TICKET_NO;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.SUB_INSTRUCTION_CODE
     */
    private BigDecimal SUB_INSTRUCTION_CODE;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.NEGOTIATED_RATE
     */
    private BigDecimal NEGOTIATED_RATE;

    /**
     * This field corresponds to the database column CTSTRS_EXTENDED.TRX_DETAILS
     */
    private String TRX_DETAILS;
    
 
    private String DEPOSITOR_CUST_RELATIONSHIP;
    private String DEPOSIT_PURPOSE;
    private String DEPOSIT_SOURCE;
    private String DEPOSIT_SRC_DOCS_AVAIL_YN;   
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.CHEQUE_DIGITS
     *
     * @return the value of CTSTRS_EXTENDED.CHEQUE_DIGITS
     */
    public BigDecimal getCHEQUE_DIGITS() {
        return CHEQUE_DIGITS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.CHEQUE_DIGITS
     *
     * @param CHEQUE_DIGITS the value for CTSTRS_EXTENDED.CHEQUE_DIGITS
     */
    public void setCHEQUE_DIGITS(BigDecimal CHEQUE_DIGITS) {
        this.CHEQUE_DIGITS = CHEQUE_DIGITS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.BENEF_REGION
     *
     * @return the value of CTSTRS_EXTENDED.BENEF_REGION
     */
    public BigDecimal getBENEF_REGION() {
        return BENEF_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.BENEF_REGION
     *
     * @param BENEF_REGION the value for CTSTRS_EXTENDED.BENEF_REGION
     */
    public void setBENEF_REGION(BigDecimal BENEF_REGION) {
        this.BENEF_REGION = BENEF_REGION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_TRS_DATE
     *
     * @return the value of CTSTRS_EXTENDED.ORIGINAL_CHQ_TRS_DATE
     */
    public Date getORIGINAL_CHQ_TRS_DATE() {
        return ORIGINAL_CHQ_TRS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_TRS_DATE
     *
     * @param ORIGINAL_CHQ_TRS_DATE the value for CTSTRS_EXTENDED.ORIGINAL_CHQ_TRS_DATE
     */
    public void setORIGINAL_CHQ_TRS_DATE(Date ORIGINAL_CHQ_TRS_DATE) {
        this.ORIGINAL_CHQ_TRS_DATE = ORIGINAL_CHQ_TRS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_VALUE_DATE
     *
     * @return the value of CTSTRS_EXTENDED.ORIGINAL_CHQ_VALUE_DATE
     */
    public Date getORIGINAL_CHQ_VALUE_DATE() {
        return ORIGINAL_CHQ_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.ORIGINAL_CHQ_VALUE_DATE
     *
     * @param ORIGINAL_CHQ_VALUE_DATE the value for CTSTRS_EXTENDED.ORIGINAL_CHQ_VALUE_DATE
     */
    public void setORIGINAL_CHQ_VALUE_DATE(Date ORIGINAL_CHQ_VALUE_DATE) {
        this.ORIGINAL_CHQ_VALUE_DATE = ORIGINAL_CHQ_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.ORIGNAL_CHQ_DATE
     *
     * @return the value of CTSTRS_EXTENDED.ORIGNAL_CHQ_DATE
     */
    public Date getORIGNAL_CHQ_DATE() {
        return ORIGNAL_CHQ_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.ORIGNAL_CHQ_DATE
     *
     * @param ORIGNAL_CHQ_DATE the value for CTSTRS_EXTENDED.ORIGNAL_CHQ_DATE
     */
    public void setORIGNAL_CHQ_DATE(Date ORIGNAL_CHQ_DATE) {
        this.ORIGNAL_CHQ_DATE = ORIGNAL_CHQ_DATE;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     *
     * @return the value of CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     */
    public BigDecimal getTREASURY_EXCH_RATE()
    {
        return TREASURY_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     *
     * @param TREASURY_EXCH_RATE the value for CTSTRS_EXTENDED.TREASURY_EXCH_RATE
     */
    public void setTREASURY_EXCH_RATE(BigDecimal tREASURY_EXCH_RATE)
    {
        TREASURY_EXCH_RATE = tREASURY_EXCH_RATE;
    }




    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.SWIFT_CUST_REFERENCE
     *
     * @return the value of CTSTRS_EXTENDED.SWIFT_CUST_REFERENCE
     */
     
    
    public String getSWIFT_CUST_REFERENCE()
    {
        return SWIFT_CUST_REFERENCE;
    }
 

    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.SWIFT_CUST_REFERENCE
     *
     * @param SWIFT_CUST_REFERENCE the value for CTSTRS_EXTENDED.SWIFT_CUST_REFERENCE
     */

    public void setSWIFT_CUST_REFERENCE(String sWIFT_CUST_REFERENCE)
    {
        SWIFT_CUST_REFERENCE = sWIFT_CUST_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS.UETR
     *
     * @param UETR the value for CTSTRS.UETR
     */
    public void setUETR(String UETR) {
        this.UETR = UETR == null ? null : UETR.trim();
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS.BIOMETRIC_APPROVED_YN
     *
     * @return the value of CTSTRS.BIOMETRIC_APPROVED_YN
     */
    public String getUETR() {
	return UETR;
    }  

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.BIRTH_DATE
     *
     * @return the value of CTSTRS_EXTENDED.BIRTH_DATE
     */
    
    public Date getBIRTH_DATE()
    {
        return BIRTH_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.BIRTH_DATE
     *
     * @param BIRTH_DATE the value for CTSTRS_EXTENDED.BIRTH_DATE
     */

    public void setBIRTH_DATE(Date bIRTH_DATE)
    {
        BIRTH_DATE = bIRTH_DATE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS.ENCRYPT_KEY
     *
     * @param ENCRYPT_KEY the value for CTSTRS.ENCRYPT_KEY
     */
    public String getENCRYPT_KEY()
    {
        return ENCRYPT_KEY;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS.ENCRYPT_KEY
     *
     * @return the value of CTSTRS.ENCRYPT_KEY
     */
    public void setENCRYPT_KEY(String eNCRYPT_KEY)
    {
        ENCRYPT_KEY = eNCRYPT_KEY;
    } 
    
    
    public BigDecimal getCARD_BR_CODE()
    {
        return CARD_BR_CODE;
    }

    public void setCARD_BR_CODE(BigDecimal cARD_BR_CODE)
    {
        CARD_BR_CODE = cARD_BR_CODE;
    }


    public BigDecimal getCARD_APP_ID()
    {
        return CARD_APP_ID;
    }

    public void setCARD_APP_ID(BigDecimal cARD_APP_ID)
    {
        CARD_APP_ID = cARD_APP_ID;
    }

    public String getSUB_STATUS()
    {
        return SUB_STATUS;
    }

    public void setSUB_STATUS(String sUB_STATUS)
    {
        SUB_STATUS = sUB_STATUS;
    }

    public BigDecimal getORIGIN_COUNTRY_CODE()
    {
	return ORIGIN_COUNTRY_CODE;
    }

    public void setORIGIN_COUNTRY_CODE(BigDecimal oRIGIN_COUNTRY_CODE)
    {
	ORIGIN_COUNTRY_CODE = oRIGIN_COUNTRY_CODE;
    }
    
    public String getCHQ_TRX_CREATED_YN()
    {
        return CHQ_TRX_CREATED_YN;
    }

    public void setCHQ_TRX_CREATED_YN(String cHQ_TRX_CREATED_YN)
    {
        CHQ_TRX_CREATED_YN = cHQ_TRX_CREATED_YN;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.PAYMENT_CODE
     *
     * @return the value of CTSTRS_EXTENDED.PAYMENT_CODE
     */
    public BigDecimal getPAYMENT_CODE() {
        return PAYMENT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.PAYMENT_CODE
     *
     * @param PAYMENT_CODE the value for CTSTRS_EXTENDED.PAYMENT_CODE
     */
    public void setPAYMENT_CODE(BigDecimal PAYMENT_CODE) {
        this.PAYMENT_CODE = PAYMENT_CODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS.OVERDRAW_FROM_ACC
     *
     * @param OVERDRAW_FROM_ACC the value for CTSTRS.OVERDRAW_FROM_ACC
     */
    public String getOVERDRAW_FROM_ACC()
    {
        return OVERDRAW_FROM_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS.OVERDRAW_FROM_ACC
     *
     * @return the value of CTSTRS.OVERDRAW_FROM_ACC
     */
    public void setOVERDRAW_FROM_ACC(String oVERDRAW_FROM_ACC)
    {
        OVERDRAW_FROM_ACC = oVERDRAW_FROM_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS.OVERDRAW_TO_ACC
     *
     * @param OVERDRAW_TO_ACC the value for CTSTRS.OVERDRAW_TO_ACC
     */
    public String getOVERDRAW_TO_ACC()
    {
        return OVERDRAW_TO_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS.OVERDRAW_TO_ACC
     *
     * @return the value of CTSTRS.OVERDRAW_TO_ACC
     */
    public void setOVERDRAW_TO_ACC(String oVERDRAW_TO_ACC)
    {
        OVERDRAW_TO_ACC = oVERDRAW_TO_ACC;
    }

    public String getNARRATION()
    {
        return NARRATION;
    }

    public void setNARRATION(String nARRATION)
    {
        NARRATION = nARRATION;
    }

    public BigDecimal getREMITTANCE_TYPE_CODE()
    {
        return REMITTANCE_TYPE_CODE;
    }

    public void setREMITTANCE_TYPE_CODE(BigDecimal rEMITTANCE_TYPE_CODE)
    {
        REMITTANCE_TYPE_CODE = rEMITTANCE_TYPE_CODE;
    }

    public BigDecimal getREMITTANCE_RECORD()
    {
        return REMITTANCE_RECORD;
    }

    public void setREMITTANCE_RECORD(BigDecimal rEMITTANCE_RECORD)
    {
        REMITTANCE_RECORD = rEMITTANCE_RECORD;
    }
    
    public String getSYNTHESIS_STATUS()
    {
        return SYNTHESIS_STATUS;
    }

    public void setSYNTHESIS_STATUS(String sYNTHESIS_STATUS)
    {
        SYNTHESIS_STATUS = sYNTHESIS_STATUS;
    }
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.DEBIT_VDATE
     *
     * @return the value of CTSTRS_EXTENDED.DEBIT_VDATE
     */
    public Date getDEBIT_VDATE() {
        return DEBIT_VDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.DEBIT_VDATE
     *
     * @param DEBIT_VDATE the value for CTSTRS_EXTENDED.DEBIT_VDATE
     */
    public void setDEBIT_VDATE(Date DEBIT_VDATE) {
        this.DEBIT_VDATE = DEBIT_VDATE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.CERTIFICATE_BRANCH
     *
     * @return the value of CTSTRS_EXTENDED.CERTIFICATE_BRANCH
     */
    public BigDecimal getCERTIFICATE_BRANCH()
    {
        return CERTIFICATE_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.CERTIFICATE_BRANCH
     *
     * @param CERTIFICATE_BRANCH the value for CTSTRS_EXTENDED.CERTIFICATE_BRANCH
     */
    public void setCERTIFICATE_BRANCH(BigDecimal cERTIFICATEBRANCH)
    {
	CERTIFICATE_BRANCH = cERTIFICATEBRANCH;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.CERTIFICATE_CODE
     *
     * @return the value of CTSTRS_EXTENDED.CERTIFICATE_CODE
     */
    public BigDecimal getCERTIFICATE_CODE()
    {
        return CERTIFICATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.CERTIFICATE_CODE
     *
     * @param CERTIFICATE_CODE the value for CTSTRS_EXTENDED.CERTIFICATE_CODE
     */
    public void setCERTIFICATE_CODE(BigDecimal cERTIFICATECODE)
    {
	CERTIFICATE_CODE = cERTIFICATECODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.NUMBER_OF_BILLS
     *
     * @return the value of CTSTRS_EXTENDED.NUMBER_OF_BILLS
     */
    public BigDecimal getNUMBER_OF_BILLS()
    {
        return NUMBER_OF_BILLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.NUMBER_OF_BILLS
     *
     * @param NUMBER_OF_BILLS the value for CTSTRS_EXTENDED.NUMBER_OF_BILLS
     */
    public void setNUMBER_OF_BILLS(BigDecimal NUMBER_OF_BILLS)
    {
	this.NUMBER_OF_BILLS = NUMBER_OF_BILLS;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_EXTENDED.TOTAL_AMOUNT_OF_BILLS
     *
     * @return the value of CTSTRS_EXTENDED.TOTAL_AMOUNT_OF_BILLS
     */
    public BigDecimal getTOTAL_AMOUNT_OF_BILLS()
    {
        return TOTAL_AMOUNT_OF_BILLS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_EXTENDED.TOTAL_AMOUNT_OF_BILLS
     *
     * @param TOTAL_AMOUNT_OF_BILLS the value for CTSTRS_EXTENDED.TOTAL_AMOUNT_OF_BILLS
     */
    public void setTOTAL_AMOUNT_OF_BILLS(BigDecimal TOTAL_AMOUNT_OF_BILLS)
    {
	this.TOTAL_AMOUNT_OF_BILLS = TOTAL_AMOUNT_OF_BILLS;
    }
    
    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSTRS.CUSTOMER_BIC_CODE
     *
     * @param CUSTOMER_BIC_CODE the value for CTSTRS.CUSTOMER_BIC_CODE
     */
    public void setCUSTOMER_BIC_CODE(String CUSTOMER_BIC_CODE)
    {
	this.CUSTOMER_BIC_CODE = CUSTOMER_BIC_CODE == null ? null : CUSTOMER_BIC_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSTRS.CUSTOMER_BIC_CODE
     *
     * @return the value of CTSTRS.CUSTOMER_BIC_CODE
     */
    public String getCUSTOMER_BIC_CODE()
    {
	return CUSTOMER_BIC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSTRS.BIOMETRIC_APPROVED_YN
     *
     * @param BIOMETRIC_APPROVED_YN the value for CTSTRS.BIOMETRIC_APPROVED_YN
     */
    public void setBIOMETRIC_APPROVED_YN(String BIOMETRIC_APPROVED_YN)
    {
	this.BIOMETRIC_APPROVED_YN = BIOMETRIC_APPROVED_YN == null ? null : BIOMETRIC_APPROVED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSTRS.BIOMETRIC_APPROVED_YN
     *
     * @return the value of CTSTRS.BIOMETRIC_APPROVED_YN
     */
    public String getBIOMETRIC_APPROVED_YN()
    {
	return BIOMETRIC_APPROVED_YN;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTSTRS.CARD_READER_SRL
     *
     * @return the value of CTSTRS.CARD_READER_SRL
     */
    public String getCARD_READER_SRL()
    {
	return CARD_READER_SRL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTSTRS.CARD_READER_SRL
     *
     * @param CARD_READER_SRL the value for CTSTRS.CARD_READER_SRL
     */
    public void setCARD_READER_SRL(String cARD_READER_SRL)
    {
	CARD_READER_SRL = cARD_READER_SRL;
    }
 
    public String getCY_PURCHASE_SALE()
    {
        return CY_PURCHASE_SALE;
    }

    public void setCY_PURCHASE_SALE(String cY_PURCHASE_SALE)
    {
        CY_PURCHASE_SALE = cY_PURCHASE_SALE;
    }

    public String getTRX_CY_EXCH_PUR_SAL_REF()
    {
        return TRX_CY_EXCH_PUR_SAL_REF;
    }

    public void setTRX_CY_EXCH_PUR_SAL_REF(String tRX_CY_EXCH_PUR_SAL_REF)
    {
        TRX_CY_EXCH_PUR_SAL_REF = tRX_CY_EXCH_PUR_SAL_REF;
    }

    public BigDecimal getINSTRUCTION_CODE()
    {
        return INSTRUCTION_CODE;
    }

    public void setINSTRUCTION_CODE(BigDecimal iNSTRUCTION_CODE)
    {
        INSTRUCTION_CODE = iNSTRUCTION_CODE;
    }

    public BigDecimal getEXC_OFFICE_TICKET_NO()
    {
        return EXC_OFFICE_TICKET_NO;
    }

    public void setEXC_OFFICE_TICKET_NO(BigDecimal eXC_OFFICE_TICKET_NO)
    {
        EXC_OFFICE_TICKET_NO = eXC_OFFICE_TICKET_NO;
    }

    public BigDecimal getSUB_INSTRUCTION_CODE()
    {
        return SUB_INSTRUCTION_CODE;
    }

    public void setSUB_INSTRUCTION_CODE(BigDecimal sUB_INSTRUCTION_CODE)
    {
        SUB_INSTRUCTION_CODE = sUB_INSTRUCTION_CODE;
    }

    public BigDecimal getNEGOTIATED_RATE()
    {
        return NEGOTIATED_RATE;
    }

    public void setNEGOTIATED_RATE(BigDecimal nEGOTIATED_RATE)
    {
        NEGOTIATED_RATE = nEGOTIATED_RATE;
    }

    public String getTRX_DETAILS()
    {
        return TRX_DETAILS;
    }

    public void setTRX_DETAILS(String tRX_DETAILS)
    {
        TRX_DETAILS = tRX_DETAILS;
    }
    
	    
	    public BigDecimal getPROVIDER_AMOUNT() {
		return PROVIDER_AMOUNT;
	}

	public void setPROVIDER_AMOUNT(BigDecimal pROVIDER_AMOUNT) {
		PROVIDER_AMOUNT = pROVIDER_AMOUNT;
	}

	public BigDecimal getADDITIONAL_FEES() {
		return ADDITIONAL_FEES;
	}

	public void setADDITIONAL_FEES(BigDecimal aDDITIONAL_FEES) {
		ADDITIONAL_FEES = aDDITIONAL_FEES;
	}

	public BigDecimal getPAYMENT_METHOD()
	{
	    return PAYMENT_METHOD;
	}

	public void setPAYMENT_METHOD(BigDecimal pAYMENT_METHOD)
	{
	    PAYMENT_METHOD = pAYMENT_METHOD;
	}
	
	    public String getDEPOSITOR_CUST_RELATIONSHIP()
	    {
	        return DEPOSITOR_CUST_RELATIONSHIP;
	    }

	    public void setDEPOSITOR_CUST_RELATIONSHIP(String dEPOSITOR_CUST_RELATIONSHIP)
	    {
	        DEPOSITOR_CUST_RELATIONSHIP = dEPOSITOR_CUST_RELATIONSHIP;
	    }

	    public String getDEPOSIT_PURPOSE()
	    {
	        return DEPOSIT_PURPOSE;
	    }

	    public void setDEPOSIT_PURPOSE(String dEPOSIT_PURPOSE)
	    {
	        DEPOSIT_PURPOSE = dEPOSIT_PURPOSE;
	    }

	    public String getDEPOSIT_SOURCE()
	    {
	        return DEPOSIT_SOURCE;
	    }

	    public void setDEPOSIT_SOURCE(String dEPOSIT_SOURCE)
	    {
	        DEPOSIT_SOURCE = dEPOSIT_SOURCE;
	    }

	    public String getDEPOSIT_SRC_DOCS_AVAIL_YN()
	    {
	        return DEPOSIT_SRC_DOCS_AVAIL_YN;
	    }

	    public void setDEPOSIT_SRC_DOCS_AVAIL_YN(String dEPOSIT_SRC_DOCS_AVAIL_YN)
	    {
	        DEPOSIT_SRC_DOCS_AVAIL_YN = dEPOSIT_SRC_DOCS_AVAIL_YN;
	    }	
    
}