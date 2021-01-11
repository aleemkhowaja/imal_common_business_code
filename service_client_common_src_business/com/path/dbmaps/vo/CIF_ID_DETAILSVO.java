package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;


public class CIF_ID_DETAILSVO extends CIF_ID_DETAILSVOKey {
    /**
     * This field corresponds to the database column CIF_ID_DETAILS.ID_NO
     */
    private String ID_NO;

    /**
     * This field corresponds to the database column CIF_ID_DETAILS.COUNTRY_OF_ISSUANCE
     */
    private BigDecimal COUNTRY_OF_ISSUANCE;
    
    
    /**
     * This field corresponds to the database column CIF_ID_DETAILS.ID_EXPIRY_DATE
     */
    
    
    /*ADDED BY NANCY 21/06/2017- SBI170061 - Pensioner Account*/    
    private Date ID_EXPIRY_DATE;
    
    /**
     * This field corresponds to the database column CIF_ID_DETAILS.ID_ISSUANCE_DATE
     */
    
    private Date ID_ISSUANCE_DATE;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ID_DETAILS.ID_ISSUANCE_DATE
     *
     * @return the value of CIF_ID_DETAILS.ID_ISSUANCE_DATE
     */
    public Date getID_ISSUANCE_DATE() {
        return ID_ISSUANCE_DATE;
    }
    
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ID_DETAILS.ID_EXPIRY_DATE
     *
     * @return the value of CIF_ID_DETAILS.ID_EXPIRY_DATE
     */
    public Date getID_EXPIRY_DATE() {
        return ID_EXPIRY_DATE;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ID_DETAILS.ID_EXPIRY_DATE
     *
     * @param ID_NO the value for CIF_ID_DETAILS.ID_EXPIRY_DATE
     */
    public void setID_EXPIRY_DATE(Date ID_EXPIRY_DATE) {
        this.ID_EXPIRY_DATE = ID_EXPIRY_DATE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ID_DETAILS.ID_NO
     *
     * @param ID_NO the value for CIF_ID_DETAILS.ID_NO
     */
    public void setID_ISSUANCE_DATE(Date ID_ISSUANCE_DATE) {
        this.ID_ISSUANCE_DATE = ID_ISSUANCE_DATE;
    }
    
    /* END NANCY */ 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_ID_DETAILS.ID_NO
     *
     * @return the value of CIF_ID_DETAILS.ID_NO
     */
    public String getID_NO() {
        return ID_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_ID_DETAILS.ID_NO
     *
     * @param ID_NO the value for CIF_ID_DETAILS.ID_NO
     */
    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO == null ? null : ID_NO.trim();
    }

    public BigDecimal getCOUNTRY_OF_ISSUANCE() {
        return COUNTRY_OF_ISSUANCE;
    }

    public void setCOUNTRY_OF_ISSUANCE(BigDecimal COUNTRY_OF_ISSUANCE) {
        this.COUNTRY_OF_ISSUANCE = COUNTRY_OF_ISSUANCE;
    }
}