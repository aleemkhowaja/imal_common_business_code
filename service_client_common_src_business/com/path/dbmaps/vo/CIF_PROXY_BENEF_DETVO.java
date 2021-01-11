package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CIF_PROXY_BENEF_DETVO extends CIF_PROXY_BENEF_DETVOKey
{

    private String ADDITIONAL_REFERENCE;
    private BigDecimal CURRENCY_CODE;
    private BigDecimal BANK_CIF_NO;
    private String TRANSFER_TYPE;
    private String BANK_BRANCH;
    private String BANK_ACC_NO;
    private String BANK_ADDRESS_1;
    private String BANK_ADDRESS_2;
    private String BANK_ADDRESS_3;
    private String BANK_BIC_CODE;
    private String BENEF_ACC_NO;
    private String PURPOSE_OF_REGISTR;
    private String IDENTIFICATION_NO;
    private String IFSC_CODE;
    private String BENEFICIARY_TYPE;
    private BigDecimal BILLER_ID;
    private String BILLER_NAME;

    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    private String ULTIMATE_BENEF_TYPE_DDL;
    private Date REGISTRATION_DATE;
    private String DELETE_REASON;
    private String CANCEL_REASON;
    private String MOTHER_FIRST_NAME;
    private String MOTHER_LAST_NAME;
    private BigDecimal SHAREHOLD_PERC;
    private String OFFICIAL_POSITION;
    //
    
    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.COUNTRY_OF_ISSUANCE
     */
    private BigDecimal COUNTRY_OF_ISSUANCE;    
    
    
    
    public String getPURPOSE_OF_REGISTR()
    {
        return PURPOSE_OF_REGISTR;
    }

    public void setPURPOSE_OF_REGISTR(String pURPOSEOFREGISTR)
    {
        PURPOSE_OF_REGISTR = pURPOSEOFREGISTR;
    }

    public BigDecimal getBANK_CIF_NO()
    {
        return BANK_CIF_NO;
    }

    public void setBANK_CIF_NO(BigDecimal bANKCIFNO)
    {
        BANK_CIF_NO = bANKCIFNO;
    }

    public String getBANK_BRANCH()
    {
        return BANK_BRANCH;
    }

    public void setBANK_BRANCH(String bANKBRANCH)
    {
        BANK_BRANCH = bANKBRANCH;
    }

    public String getBANK_ACC_NO()
    {
        return BANK_ACC_NO;
    }

    public void setBANK_ACC_NO(String bANKACCNO)
    {
        BANK_ACC_NO = bANKACCNO;
    }

    public String getBANK_ADDRESS_1()
    {
        return BANK_ADDRESS_1;
    }

    public void setBANK_ADDRESS_1(String bANKADDRESS_1)
    {
        BANK_ADDRESS_1 = bANKADDRESS_1;
    }

    public String getBANK_ADDRESS_2()
    {
        return BANK_ADDRESS_2;
    }

    public void setBANK_ADDRESS_2(String bANKADDRESS_2)
    {
        BANK_ADDRESS_2 = bANKADDRESS_2;
    }

    public String getBANK_ADDRESS_3()
    {
        return BANK_ADDRESS_3;
    }

    public void setBANK_ADDRESS_3(String bANKADDRESS_3)
    {
        BANK_ADDRESS_3 = bANKADDRESS_3;
    }

    public String getBANK_BIC_CODE()
    {
        return BANK_BIC_CODE;
    }

    public void setBANK_BIC_CODE(String bANKBICCODE)
    {
        BANK_BIC_CODE = bANKBICCODE;
    }

    public String getBENEF_ACC_NO()
    {
        return BENEF_ACC_NO;
    }

    public void setBENEF_ACC_NO(String bENEFACCNO)
    {
        BENEF_ACC_NO = bENEFACCNO;
    }

    public String getADDITIONAL_REFERENCE()
    {
	return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE)
    {
	ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
    }

    public BigDecimal getCURRENCY_CODE()
    {
	return CURRENCY_CODE;
    }

    public void setCURRENCY_CODE(BigDecimal cURRENCYCODE)
    {
	CURRENCY_CODE = cURRENCYCODE;
    }

    public String getTRANSFER_TYPE()
    {
	return TRANSFER_TYPE;
    }

    public void setTRANSFER_TYPE(String tRANSFERTYPE)
    {
	TRANSFER_TYPE = tRANSFERTYPE;
    }

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.LANGUAGE
     */
    private String LANGUAGE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.FIRST_NAME_L
     */
    private String FIRST_NAME_L;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.SECOND_NAME_L
     */
    private String SECOND_NAME_L;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.THIRD_NAME_L
     */
    private String THIRD_NAME_L;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.LAST_NAME_L
     */
    private String LAST_NAME_L;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.FIRST_NAME_O
     */
    private String FIRST_NAME_O;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.SECOND_NAME_O
     */
    private String SECOND_NAME_O;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.THIRD_NAME_O
     */
    private String THIRD_NAME_O;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.LAST_NAME_O
     */
    private String LAST_NAME_O;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.REGION_CODE
     */
    private BigDecimal REGION_CODE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ADDRESS_1
     */
    private String ADDRESS_1;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ADDRESS_2
     */
    private String ADDRESS_2;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ADDRESS_3
     */
    private String ADDRESS_3;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ADDRESS_4
     */
    private String ADDRESS_4;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.CITY
     */
    private String CITY;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.COUNTRY_CODE
     */
    private BigDecimal COUNTRY_CODE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.CITY_CODE
     */
    private BigDecimal CITY_CODE;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.SECTOR
     */
    private BigDecimal SECTOR;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.POSTAL_CODE
     */
    private String POSTAL_CODE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.DESCRIPTION_CODE
     */
    private BigDecimal DESCRIPTION_CODE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.TO_DATE
     */
    private Date TO_DATE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.TELEPHONE
     */
    private String TELEPHONE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.WORK_TELEPHONE
     */
    private String WORK_TELEPHONE;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.MOBILE
     */
    private String MOBILE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.OTHER_TEL
     */
    private String OTHER_TEL;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.FAX
     */
    private String FAX;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.EMAIL
     */
    private String EMAIL;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.EXPIRY_DATE
     */
    private Date EXPIRY_DATE;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.ID_TYPE
     */
    private BigDecimal ID_TYPE;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.ID_NO
     */
    private String ID_NO;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ID_EXPIRY_DATE
     */
    private Date ID_EXPIRY_DATE;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ID_DATE_OF_BIRTH
     */
    private Date ID_DATE_OF_BIRTH;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ID_NATIONALITY
     */
    private BigDecimal ID_NATIONALITY;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.ID_PLACE_OF_BIRTH
     */
    private BigDecimal ID_PLACE_OF_BIRTH;

    /**
     * This field corresponds to the database column CIF_PROXY_BENEF_DET.PO_BOX
     */
    private String PO_BOX;

    /**
     * This field corresponds to the database column
     * CIF_PROXY_BENEF_DET.PO_BOX_AREA
     */
    private BigDecimal PO_BOX_AREA;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.LANGUAGE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.LANGUAGE
     */
    public String getLANGUAGE()
    {
	return LANGUAGE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.LANGUAGE
     * 
     * @param LANGUAGE the value for CIF_PROXY_BENEF_DET.LANGUAGE
     */
    public void setLANGUAGE(String LANGUAGE)
    {
	this.LANGUAGE = LANGUAGE == null ? null : LANGUAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.FIRST_NAME_L
     * 
     * @return the value of CIF_PROXY_BENEF_DET.FIRST_NAME_L
     */
    public String getFIRST_NAME_L()
    {
	return FIRST_NAME_L;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.FIRST_NAME_L
     * 
     * @param FIRST_NAME_L the value for CIF_PROXY_BENEF_DET.FIRST_NAME_L
     */
    public void setFIRST_NAME_L(String FIRST_NAME_L)
    {
	this.FIRST_NAME_L = FIRST_NAME_L == null ? null : FIRST_NAME_L.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.SECOND_NAME_L
     * 
     * @return the value of CIF_PROXY_BENEF_DET.SECOND_NAME_L
     */
    public String getSECOND_NAME_L()
    {
	return SECOND_NAME_L;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.SECOND_NAME_L
     * 
     * @param SECOND_NAME_L the value for CIF_PROXY_BENEF_DET.SECOND_NAME_L
     */
    public void setSECOND_NAME_L(String SECOND_NAME_L)
    {
	this.SECOND_NAME_L = SECOND_NAME_L == null ? null : SECOND_NAME_L.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.THIRD_NAME_L
     * 
     * @return the value of CIF_PROXY_BENEF_DET.THIRD_NAME_L
     */
    public String getTHIRD_NAME_L()
    {
	return THIRD_NAME_L;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.THIRD_NAME_L
     * 
     * @param THIRD_NAME_L the value for CIF_PROXY_BENEF_DET.THIRD_NAME_L
     */
    public void setTHIRD_NAME_L(String THIRD_NAME_L)
    {
	this.THIRD_NAME_L = THIRD_NAME_L == null ? null : THIRD_NAME_L.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.LAST_NAME_L
     * 
     * @return the value of CIF_PROXY_BENEF_DET.LAST_NAME_L
     */
    public String getLAST_NAME_L()
    {
	return LAST_NAME_L;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.LAST_NAME_L
     * 
     * @param LAST_NAME_L the value for CIF_PROXY_BENEF_DET.LAST_NAME_L
     */
    public void setLAST_NAME_L(String LAST_NAME_L)
    {
	this.LAST_NAME_L = LAST_NAME_L == null ? null : LAST_NAME_L.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.FIRST_NAME_O
     * 
     * @return the value of CIF_PROXY_BENEF_DET.FIRST_NAME_O
     */
    public String getFIRST_NAME_O()
    {
	return FIRST_NAME_O;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.FIRST_NAME_O
     * 
     * @param FIRST_NAME_O the value for CIF_PROXY_BENEF_DET.FIRST_NAME_O
     */
    public void setFIRST_NAME_O(String FIRST_NAME_O)
    {
	this.FIRST_NAME_O = FIRST_NAME_O == null ? null : FIRST_NAME_O.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.SECOND_NAME_O
     * 
     * @return the value of CIF_PROXY_BENEF_DET.SECOND_NAME_O
     */
    public String getSECOND_NAME_O()
    {
	return SECOND_NAME_O;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.SECOND_NAME_O
     * 
     * @param SECOND_NAME_O the value for CIF_PROXY_BENEF_DET.SECOND_NAME_O
     */
    public void setSECOND_NAME_O(String SECOND_NAME_O)
    {
	this.SECOND_NAME_O = SECOND_NAME_O == null ? null : SECOND_NAME_O.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.THIRD_NAME_O
     * 
     * @return the value of CIF_PROXY_BENEF_DET.THIRD_NAME_O
     */
    public String getTHIRD_NAME_O()
    {
	return THIRD_NAME_O;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.THIRD_NAME_O
     * 
     * @param THIRD_NAME_O the value for CIF_PROXY_BENEF_DET.THIRD_NAME_O
     */
    public void setTHIRD_NAME_O(String THIRD_NAME_O)
    {
	this.THIRD_NAME_O = THIRD_NAME_O == null ? null : THIRD_NAME_O.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.LAST_NAME_O
     * 
     * @return the value of CIF_PROXY_BENEF_DET.LAST_NAME_O
     */
    public String getLAST_NAME_O()
    {
	return LAST_NAME_O;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.LAST_NAME_O
     * 
     * @param LAST_NAME_O the value for CIF_PROXY_BENEF_DET.LAST_NAME_O
     */
    public void setLAST_NAME_O(String LAST_NAME_O)
    {
	this.LAST_NAME_O = LAST_NAME_O == null ? null : LAST_NAME_O.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.REGION_CODE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.REGION_CODE
     */
    public BigDecimal getREGION_CODE()
    {
	return REGION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.REGION_CODE
     * 
     * @param REGION_CODE the value for CIF_PROXY_BENEF_DET.REGION_CODE
     */
    public void setREGION_CODE(BigDecimal REGION_CODE)
    {
	this.REGION_CODE = REGION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_1
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ADDRESS_1
     */
    public String getADDRESS_1()
    {
	return ADDRESS_1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_1
     * 
     * @param ADDRESS_1 the value for CIF_PROXY_BENEF_DET.ADDRESS_1
     */
    public void setADDRESS_1(String ADDRESS_1)
    {
	this.ADDRESS_1 = ADDRESS_1 == null ? null : ADDRESS_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_2
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ADDRESS_2
     */
    public String getADDRESS_2()
    {
	return ADDRESS_2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_2
     * 
     * @param ADDRESS_2 the value for CIF_PROXY_BENEF_DET.ADDRESS_2
     */
    public void setADDRESS_2(String ADDRESS_2)
    {
	this.ADDRESS_2 = ADDRESS_2 == null ? null : ADDRESS_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_3
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ADDRESS_3
     */
    public String getADDRESS_3()
    {
	return ADDRESS_3;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_3
     * 
     * @param ADDRESS_3 the value for CIF_PROXY_BENEF_DET.ADDRESS_3
     */
    public void setADDRESS_3(String ADDRESS_3)
    {
	this.ADDRESS_3 = ADDRESS_3 == null ? null : ADDRESS_3.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_4
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ADDRESS_4
     */
    public String getADDRESS_4()
    {
	return ADDRESS_4;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ADDRESS_4
     * 
     * @param ADDRESS_4 the value for CIF_PROXY_BENEF_DET.ADDRESS_4
     */
    public void setADDRESS_4(String ADDRESS_4)
    {
	this.ADDRESS_4 = ADDRESS_4 == null ? null : ADDRESS_4.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.CITY
     * 
     * @return the value of CIF_PROXY_BENEF_DET.CITY
     */
    public String getCITY()
    {
	return CITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.CITY
     * 
     * @param CITY the value for CIF_PROXY_BENEF_DET.CITY
     */
    public void setCITY(String CITY)
    {
	this.CITY = CITY == null ? null : CITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.COUNTRY_CODE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.COUNTRY_CODE
     */
    public BigDecimal getCOUNTRY_CODE()
    {
	return COUNTRY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.COUNTRY_CODE
     * 
     * @param COUNTRY_CODE the value for CIF_PROXY_BENEF_DET.COUNTRY_CODE
     */
    public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE)
    {
	this.COUNTRY_CODE = COUNTRY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.CITY_CODE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.CITY_CODE
     */
    public BigDecimal getCITY_CODE()
    {
	return CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.CITY_CODE
     * 
     * @param CITY_CODE the value for CIF_PROXY_BENEF_DET.CITY_CODE
     */
    public void setCITY_CODE(BigDecimal CITY_CODE)
    {
	this.CITY_CODE = CITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.SECTOR
     * 
     * @return the value of CIF_PROXY_BENEF_DET.SECTOR
     */
    public BigDecimal getSECTOR()
    {
	return SECTOR;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.SECTOR
     * 
     * @param SECTOR the value for CIF_PROXY_BENEF_DET.SECTOR
     */
    public void setSECTOR(BigDecimal SECTOR)
    {
	this.SECTOR = SECTOR;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.POSTAL_CODE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.POSTAL_CODE
     */
    public String getPOSTAL_CODE()
    {
	return POSTAL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.POSTAL_CODE
     * 
     * @param POSTAL_CODE the value for CIF_PROXY_BENEF_DET.POSTAL_CODE
     */
    public void setPOSTAL_CODE(String POSTAL_CODE)
    {
	this.POSTAL_CODE = POSTAL_CODE == null ? null : POSTAL_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.DESCRIPTION_CODE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.DESCRIPTION_CODE
     */
    public BigDecimal getDESCRIPTION_CODE()
    {
	return DESCRIPTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.DESCRIPTION_CODE
     * 
     * @param DESCRIPTION_CODE the value for
     *            CIF_PROXY_BENEF_DET.DESCRIPTION_CODE
     */
    public void setDESCRIPTION_CODE(BigDecimal DESCRIPTION_CODE)
    {
	this.DESCRIPTION_CODE = DESCRIPTION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.FROM_DATE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.FROM_DATE
     */
    public Date getFROM_DATE()
    {
	return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.FROM_DATE
     * 
     * @param FROM_DATE the value for CIF_PROXY_BENEF_DET.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE)
    {
	this.FROM_DATE = FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.TO_DATE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.TO_DATE
     */
    public Date getTO_DATE()
    {
	return TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.TO_DATE
     * 
     * @param TO_DATE the value for CIF_PROXY_BENEF_DET.TO_DATE
     */
    public void setTO_DATE(Date TO_DATE)
    {
	this.TO_DATE = TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.TELEPHONE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.TELEPHONE
     */
    public String getTELEPHONE()
    {
	return TELEPHONE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.TELEPHONE
     * 
     * @param TELEPHONE the value for CIF_PROXY_BENEF_DET.TELEPHONE
     */
    public void setTELEPHONE(String TELEPHONE)
    {
	this.TELEPHONE = TELEPHONE == null ? null : TELEPHONE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.WORK_TELEPHONE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.WORK_TELEPHONE
     */
    public String getWORK_TELEPHONE()
    {
	return WORK_TELEPHONE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.WORK_TELEPHONE
     * 
     * @param WORK_TELEPHONE the value for CIF_PROXY_BENEF_DET.WORK_TELEPHONE
     */
    public void setWORK_TELEPHONE(String WORK_TELEPHONE)
    {
	this.WORK_TELEPHONE = WORK_TELEPHONE == null ? null : WORK_TELEPHONE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.MOBILE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.MOBILE
     */
    public String getMOBILE()
    {
	return MOBILE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.MOBILE
     * 
     * @param MOBILE the value for CIF_PROXY_BENEF_DET.MOBILE
     */
    public void setMOBILE(String MOBILE)
    {
	this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.OTHER_TEL
     * 
     * @return the value of CIF_PROXY_BENEF_DET.OTHER_TEL
     */
    public String getOTHER_TEL()
    {
	return OTHER_TEL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.OTHER_TEL
     * 
     * @param OTHER_TEL the value for CIF_PROXY_BENEF_DET.OTHER_TEL
     */
    public void setOTHER_TEL(String OTHER_TEL)
    {
	this.OTHER_TEL = OTHER_TEL == null ? null : OTHER_TEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.FAX
     * 
     * @return the value of CIF_PROXY_BENEF_DET.FAX
     */
    public String getFAX()
    {
	return FAX;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.FAX
     * 
     * @param FAX the value for CIF_PROXY_BENEF_DET.FAX
     */
    public void setFAX(String FAX)
    {
	this.FAX = FAX == null ? null : FAX.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.EMAIL
     * 
     * @return the value of CIF_PROXY_BENEF_DET.EMAIL
     */
    public String getEMAIL()
    {
	return EMAIL;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.EMAIL
     * 
     * @param EMAIL the value for CIF_PROXY_BENEF_DET.EMAIL
     */
    public void setEMAIL(String EMAIL)
    {
	this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.EXPIRY_DATE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.EXPIRY_DATE
     */
    public Date getEXPIRY_DATE()
    {
	return EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.EXPIRY_DATE
     * 
     * @param EXPIRY_DATE the value for CIF_PROXY_BENEF_DET.EXPIRY_DATE
     */
    public void setEXPIRY_DATE(Date EXPIRY_DATE)
    {
	this.EXPIRY_DATE = EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_TYPE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_TYPE
     */
    public BigDecimal getID_TYPE()
    {
	return ID_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_TYPE
     * 
     * @param ID_TYPE the value for CIF_PROXY_BENEF_DET.ID_TYPE
     */
    public void setID_TYPE(BigDecimal ID_TYPE)
    {
	this.ID_TYPE = ID_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_NO
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_NO
     */
    public String getID_NO()
    {
	return ID_NO;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_NO
     * 
     * @param ID_NO the value for CIF_PROXY_BENEF_DET.ID_NO
     */
    public void setID_NO(String ID_NO)
    {
	this.ID_NO = ID_NO == null ? null : ID_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_EXPIRY_DATE
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_EXPIRY_DATE
     */
    public Date getID_EXPIRY_DATE()
    {
	return ID_EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_EXPIRY_DATE
     * 
     * @param ID_EXPIRY_DATE the value for CIF_PROXY_BENEF_DET.ID_EXPIRY_DATE
     */
    public void setID_EXPIRY_DATE(Date ID_EXPIRY_DATE)
    {
	this.ID_EXPIRY_DATE = ID_EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_DATE_OF_BIRTH
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_DATE_OF_BIRTH
     */
    public Date getID_DATE_OF_BIRTH()
    {
	return ID_DATE_OF_BIRTH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_DATE_OF_BIRTH
     * 
     * @param ID_DATE_OF_BIRTH the value for
     *            CIF_PROXY_BENEF_DET.ID_DATE_OF_BIRTH
     */
    public void setID_DATE_OF_BIRTH(Date ID_DATE_OF_BIRTH)
    {
	this.ID_DATE_OF_BIRTH = ID_DATE_OF_BIRTH;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_NATIONALITY
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_NATIONALITY
     */
    public BigDecimal getID_NATIONALITY()
    {
	return ID_NATIONALITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_NATIONALITY
     * 
     * @param ID_NATIONALITY the value for CIF_PROXY_BENEF_DET.ID_NATIONALITY
     */
    public void setID_NATIONALITY(BigDecimal ID_NATIONALITY)
    {
	this.ID_NATIONALITY = ID_NATIONALITY;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.ID_PLACE_OF_BIRTH
     * 
     * @return the value of CIF_PROXY_BENEF_DET.ID_PLACE_OF_BIRTH
     */
    public BigDecimal getID_PLACE_OF_BIRTH()
    {
	return ID_PLACE_OF_BIRTH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.ID_PLACE_OF_BIRTH
     * 
     * @param ID_PLACE_OF_BIRTH the value for
     *            CIF_PROXY_BENEF_DET.ID_PLACE_OF_BIRTH
     */
    public void setID_PLACE_OF_BIRTH(BigDecimal ID_PLACE_OF_BIRTH)
    {
	this.ID_PLACE_OF_BIRTH = ID_PLACE_OF_BIRTH;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.PO_BOX
     * 
     * @return the value of CIF_PROXY_BENEF_DET.PO_BOX
     */
    public String getPO_BOX()
    {
	return PO_BOX;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.PO_BOX
     * 
     * @param PO_BOX the value for CIF_PROXY_BENEF_DET.PO_BOX
     */
    public void setPO_BOX(String PO_BOX)
    {
	this.PO_BOX = PO_BOX == null ? null : PO_BOX.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CIF_PROXY_BENEF_DET.PO_BOX_AREA
     * 
     * @return the value of CIF_PROXY_BENEF_DET.PO_BOX_AREA
     */
    public BigDecimal getPO_BOX_AREA()
    {
	return PO_BOX_AREA;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CIF_PROXY_BENEF_DET.PO_BOX_AREA
     * 
     * @param PO_BOX_AREA the value for CIF_PROXY_BENEF_DET.PO_BOX_AREA
     */
    public void setPO_BOX_AREA(BigDecimal PO_BOX_AREA)
    {
	this.PO_BOX_AREA = PO_BOX_AREA;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_PROXY_BENEF_DET.COUNTRY_OF_ISSUANCE
     *
     * @return the value of CIF_PROXY_BENEF_DET.COUNTRY_OF_ISSUANCE
     */
    public BigDecimal getCOUNTRY_OF_ISSUANCE() {
        return COUNTRY_OF_ISSUANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_PROXY_BENEF_DET.COUNTRY_OF_ISSUANCE
     *
     * @param COUNTRY_OF_ISSUANCE the value for CIF_PROXY_BENEF_DET.COUNTRY_OF_ISSUANCE
     */
    public void setCOUNTRY_OF_ISSUANCE(BigDecimal COUNTRY_OF_ISSUANCE) {
        this.COUNTRY_OF_ISSUANCE = COUNTRY_OF_ISSUANCE;
    }

    public String getIDENTIFICATION_NO()
    {
        return IDENTIFICATION_NO;
    }

    public void setIDENTIFICATION_NO(String iDENTIFICATION_NO)
    {
        IDENTIFICATION_NO = iDENTIFICATION_NO;
    }

    public String getIFSC_CODE()
    {
        return IFSC_CODE;
    }

    public void setIFSC_CODE(String iFSC_CODE)
    {
        IFSC_CODE = iFSC_CODE;
    }

    public String getBENEFICIARY_TYPE()
    {
        return BENEFICIARY_TYPE;
    }

    public void setBENEFICIARY_TYPE(String bENEFICIARY_TYPE)
    {
        BENEFICIARY_TYPE = bENEFICIARY_TYPE;
    }

    public BigDecimal getBILLER_ID()
    {
        return BILLER_ID;
    }

    public void setBILLER_ID(BigDecimal bILLER_ID)
    {
        BILLER_ID = bILLER_ID;
    }

    public String getBILLER_NAME()
    {
        return BILLER_NAME;
    }

    public void setBILLER_NAME(String bILLER_NAME)
    {
        BILLER_NAME = bILLER_NAME;
    }
    
    public String getULTIMATE_BENEF_TYPE_DDL()
    {
        return ULTIMATE_BENEF_TYPE_DDL;
    }

    public void setULTIMATE_BENEF_TYPE_DDL(String uLTIMATE_BENEF_TYPE_DDL)
    {
        ULTIMATE_BENEF_TYPE_DDL = uLTIMATE_BENEF_TYPE_DDL;
    }

    public Date getREGISTRATION_DATE()
    {
        return REGISTRATION_DATE;
    }

    public void setREGISTRATION_DATE(Date rEGISTRATION_DATE)
    {
        REGISTRATION_DATE = rEGISTRATION_DATE;
    }

    public String getDELETE_REASON()
    {
        return DELETE_REASON;
    }

    public void setDELETE_REASON(String dELETE_REASON)
    {
        DELETE_REASON = dELETE_REASON;
    }

    public String getCANCEL_REASON()
    {
        return CANCEL_REASON;
    }

    public void setCANCEL_REASON(String cANCEL_REASON)
    {
        CANCEL_REASON = cANCEL_REASON;
    }

    public String getMOTHER_FIRST_NAME()
    {
        return MOTHER_FIRST_NAME;
    }

    public void setMOTHER_FIRST_NAME(String mOTHER_FIRST_NAME)
    {
        MOTHER_FIRST_NAME = mOTHER_FIRST_NAME;
    }

    public String getMOTHER_LAST_NAME()
    {
        return MOTHER_LAST_NAME;
    }

    public void setMOTHER_LAST_NAME(String mOTHER_LAST_NAME)
    {
        MOTHER_LAST_NAME = mOTHER_LAST_NAME;
    }

    public BigDecimal getSHAREHOLD_PERC()
    {
        return SHAREHOLD_PERC;
    }

    public void setSHAREHOLD_PERC(BigDecimal sHAREHOLD_PERC)
    {
        SHAREHOLD_PERC = sHAREHOLD_PERC;
    }

    public String getOFFICIAL_POSITION()
    {
        return OFFICIAL_POSITION;
    }

    public void setOFFICIAL_POSITION(String oFFICIAL_POSITION)
    {
        OFFICIAL_POSITION = oFFICIAL_POSITION;
    }
}