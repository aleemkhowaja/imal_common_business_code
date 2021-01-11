package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_TRSFR_ACCVO extends CTS_TRSFR_ACCVOKey {
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TRANSFER_TYPE
     */
    private String TRANSFER_TYPE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.REASON_CODE
     */
    private BigDecimal REASON_CODE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.RANGE_DEFINITION
     */
    private String RANGE_DEFINITION;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.ORIGINAL_GL
     */
    private BigDecimal ORIGINAL_GL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.DESTINATION_GL
     */
    private BigDecimal DESTINATION_GL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.DESTINATION_BRANCH
     */
    private BigDecimal DESTINATION_BRANCH;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.FROM_ACC_BR
     */
    private BigDecimal FROM_ACC_BR;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.FROM_ACC_CY
     */
    private BigDecimal FROM_ACC_CY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.FROM_ACC_GL
     */
    private BigDecimal FROM_ACC_GL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.FROM_ACC_CIF
     */
    private BigDecimal FROM_ACC_CIF;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.FROM_ACC_SL
     */
    private BigDecimal FROM_ACC_SL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_ACC_BR
     */
    private BigDecimal TO_ACC_BR;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_ACC_CY
     */
    private BigDecimal TO_ACC_CY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_ACC_GL
     */
    private BigDecimal TO_ACC_GL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_ACC_CIF
     */
    private BigDecimal TO_ACC_CIF;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_ACC_SL
     */
    private BigDecimal TO_ACC_SL;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TRANSFERED_BY
     */
    private String TRANSFERED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TRANSFERED_DATE
     */
    private Date TRANSFERED_DATE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_BE_CANCELED_BY
     */
    private String TO_BE_CANCELED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TO_BE_CANCELED_DATE
     */
    private Date TO_BE_CANCELED_DATE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.CANCELED_BY
     */
    private String CANCELED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.CANCELED_DATE
     */
    private Date CANCELED_DATE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.REJECTED_DATE
     */
    private Date REJECTED_DATE;
    
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.TRANSFER_CARDS_YN
     */
    private String TRANSFER_CARDS_YN;
    
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC.DEST_BRANCH_IN_SAME_LOCATION_YN
     */
    private Date DEST_BRANCH_IN_SAME_LOCATION_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TRANSFER_TYPE
     *
     * @return the value of CTS_TRSFR_ACC.TRANSFER_TYPE
     */
    public String getTRANSFER_TYPE() {
        return TRANSFER_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TRANSFER_TYPE
     *
     * @param TRANSFER_TYPE the value for CTS_TRSFR_ACC.TRANSFER_TYPE
     */
    public void setTRANSFER_TYPE(String TRANSFER_TYPE) {
        this.TRANSFER_TYPE = TRANSFER_TYPE == null ? null : TRANSFER_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.REASON_CODE
     *
     * @return the value of CTS_TRSFR_ACC.REASON_CODE
     */
    public BigDecimal getREASON_CODE() {
        return REASON_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.REASON_CODE
     *
     * @param REASON_CODE the value for CTS_TRSFR_ACC.REASON_CODE
     */
    public void setREASON_CODE(BigDecimal REASON_CODE) {
        this.REASON_CODE = REASON_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.RANGE_DEFINITION
     *
     * @return the value of CTS_TRSFR_ACC.RANGE_DEFINITION
     */
    public String getRANGE_DEFINITION() {
        return RANGE_DEFINITION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.RANGE_DEFINITION
     *
     * @param RANGE_DEFINITION the value for CTS_TRSFR_ACC.RANGE_DEFINITION
     */
    public void setRANGE_DEFINITION(String RANGE_DEFINITION) {
        this.RANGE_DEFINITION = RANGE_DEFINITION == null ? null : RANGE_DEFINITION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.ORIGINAL_GL
     *
     * @return the value of CTS_TRSFR_ACC.ORIGINAL_GL
     */
    public BigDecimal getORIGINAL_GL() {
        return ORIGINAL_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.ORIGINAL_GL
     *
     * @param ORIGINAL_GL the value for CTS_TRSFR_ACC.ORIGINAL_GL
     */
    public void setORIGINAL_GL(BigDecimal ORIGINAL_GL) {
        this.ORIGINAL_GL = ORIGINAL_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.CIF_NO
     *
     * @return the value of CTS_TRSFR_ACC.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.CIF_NO
     *
     * @param CIF_NO the value for CTS_TRSFR_ACC.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.DESTINATION_GL
     *
     * @return the value of CTS_TRSFR_ACC.DESTINATION_GL
     */
    public BigDecimal getDESTINATION_GL() {
        return DESTINATION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.DESTINATION_GL
     *
     * @param DESTINATION_GL the value for CTS_TRSFR_ACC.DESTINATION_GL
     */
    public void setDESTINATION_GL(BigDecimal DESTINATION_GL) {
        this.DESTINATION_GL = DESTINATION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.STATUS
     *
     * @return the value of CTS_TRSFR_ACC.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.STATUS
     *
     * @param STATUS the value for CTS_TRSFR_ACC.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.DESTINATION_BRANCH
     *
     * @return the value of CTS_TRSFR_ACC.DESTINATION_BRANCH
     */
    public BigDecimal getDESTINATION_BRANCH() {
        return DESTINATION_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.DESTINATION_BRANCH
     *
     * @param DESTINATION_BRANCH the value for CTS_TRSFR_ACC.DESTINATION_BRANCH
     */
    public void setDESTINATION_BRANCH(BigDecimal DESTINATION_BRANCH) {
        this.DESTINATION_BRANCH = DESTINATION_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.FROM_ACC_BR
     *
     * @return the value of CTS_TRSFR_ACC.FROM_ACC_BR
     */
    public BigDecimal getFROM_ACC_BR() {
        return FROM_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.FROM_ACC_BR
     *
     * @param FROM_ACC_BR the value for CTS_TRSFR_ACC.FROM_ACC_BR
     */
    public void setFROM_ACC_BR(BigDecimal FROM_ACC_BR) {
        this.FROM_ACC_BR = FROM_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.FROM_ACC_CY
     *
     * @return the value of CTS_TRSFR_ACC.FROM_ACC_CY
     */
    public BigDecimal getFROM_ACC_CY() {
        return FROM_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.FROM_ACC_CY
     *
     * @param FROM_ACC_CY the value for CTS_TRSFR_ACC.FROM_ACC_CY
     */
    public void setFROM_ACC_CY(BigDecimal FROM_ACC_CY) {
        this.FROM_ACC_CY = FROM_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.FROM_ACC_GL
     *
     * @return the value of CTS_TRSFR_ACC.FROM_ACC_GL
     */
    public BigDecimal getFROM_ACC_GL() {
        return FROM_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.FROM_ACC_GL
     *
     * @param FROM_ACC_GL the value for CTS_TRSFR_ACC.FROM_ACC_GL
     */
    public void setFROM_ACC_GL(BigDecimal FROM_ACC_GL) {
        this.FROM_ACC_GL = FROM_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.FROM_ACC_CIF
     *
     * @return the value of CTS_TRSFR_ACC.FROM_ACC_CIF
     */
    public BigDecimal getFROM_ACC_CIF() {
        return FROM_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.FROM_ACC_CIF
     *
     * @param FROM_ACC_CIF the value for CTS_TRSFR_ACC.FROM_ACC_CIF
     */
    public void setFROM_ACC_CIF(BigDecimal FROM_ACC_CIF) {
        this.FROM_ACC_CIF = FROM_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.FROM_ACC_SL
     *
     * @return the value of CTS_TRSFR_ACC.FROM_ACC_SL
     */
    public BigDecimal getFROM_ACC_SL() {
        return FROM_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.FROM_ACC_SL
     *
     * @param FROM_ACC_SL the value for CTS_TRSFR_ACC.FROM_ACC_SL
     */
    public void setFROM_ACC_SL(BigDecimal FROM_ACC_SL) {
        this.FROM_ACC_SL = FROM_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_ACC_BR
     *
     * @return the value of CTS_TRSFR_ACC.TO_ACC_BR
     */
    public BigDecimal getTO_ACC_BR() {
        return TO_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_ACC_BR
     *
     * @param TO_ACC_BR the value for CTS_TRSFR_ACC.TO_ACC_BR
     */
    public void setTO_ACC_BR(BigDecimal TO_ACC_BR) {
        this.TO_ACC_BR = TO_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_ACC_CY
     *
     * @return the value of CTS_TRSFR_ACC.TO_ACC_CY
     */
    public BigDecimal getTO_ACC_CY() {
        return TO_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_ACC_CY
     *
     * @param TO_ACC_CY the value for CTS_TRSFR_ACC.TO_ACC_CY
     */
    public void setTO_ACC_CY(BigDecimal TO_ACC_CY) {
        this.TO_ACC_CY = TO_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_ACC_GL
     *
     * @return the value of CTS_TRSFR_ACC.TO_ACC_GL
     */
    public BigDecimal getTO_ACC_GL() {
        return TO_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_ACC_GL
     *
     * @param TO_ACC_GL the value for CTS_TRSFR_ACC.TO_ACC_GL
     */
    public void setTO_ACC_GL(BigDecimal TO_ACC_GL) {
        this.TO_ACC_GL = TO_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_ACC_CIF
     *
     * @return the value of CTS_TRSFR_ACC.TO_ACC_CIF
     */
    public BigDecimal getTO_ACC_CIF() {
        return TO_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_ACC_CIF
     *
     * @param TO_ACC_CIF the value for CTS_TRSFR_ACC.TO_ACC_CIF
     */
    public void setTO_ACC_CIF(BigDecimal TO_ACC_CIF) {
        this.TO_ACC_CIF = TO_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_ACC_SL
     *
     * @return the value of CTS_TRSFR_ACC.TO_ACC_SL
     */
    public BigDecimal getTO_ACC_SL() {
        return TO_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_ACC_SL
     *
     * @param TO_ACC_SL the value for CTS_TRSFR_ACC.TO_ACC_SL
     */
    public void setTO_ACC_SL(BigDecimal TO_ACC_SL) {
        this.TO_ACC_SL = TO_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.DATE_UPDATED
     *
     * @return the value of CTS_TRSFR_ACC.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for CTS_TRSFR_ACC.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.CREATED_BY
     *
     * @return the value of CTS_TRSFR_ACC.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.CREATED_BY
     *
     * @param CREATED_BY the value for CTS_TRSFR_ACC.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.CREATED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.CREATED_DATE
     *
     * @param CREATED_DATE the value for CTS_TRSFR_ACC.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.APPROVED_BY
     *
     * @return the value of CTS_TRSFR_ACC.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.APPROVED_BY
     *
     * @param APPROVED_BY the value for CTS_TRSFR_ACC.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.APPROVED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for CTS_TRSFR_ACC.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TRANSFERED_BY
     *
     * @return the value of CTS_TRSFR_ACC.TRANSFERED_BY
     */
    public String getTRANSFERED_BY() {
        return TRANSFERED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TRANSFERED_BY
     *
     * @param TRANSFERED_BY the value for CTS_TRSFR_ACC.TRANSFERED_BY
     */
    public void setTRANSFERED_BY(String TRANSFERED_BY) {
        this.TRANSFERED_BY = TRANSFERED_BY == null ? null : TRANSFERED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TRANSFERED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.TRANSFERED_DATE
     */
    public Date getTRANSFERED_DATE() {
        return TRANSFERED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TRANSFERED_DATE
     *
     * @param TRANSFERED_DATE the value for CTS_TRSFR_ACC.TRANSFERED_DATE
     */
    public void setTRANSFERED_DATE(Date TRANSFERED_DATE) {
        this.TRANSFERED_DATE = TRANSFERED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_BE_CANCELED_BY
     *
     * @return the value of CTS_TRSFR_ACC.TO_BE_CANCELED_BY
     */
    public String getTO_BE_CANCELED_BY() {
        return TO_BE_CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_BE_CANCELED_BY
     *
     * @param TO_BE_CANCELED_BY the value for CTS_TRSFR_ACC.TO_BE_CANCELED_BY
     */
    public void setTO_BE_CANCELED_BY(String TO_BE_CANCELED_BY) {
        this.TO_BE_CANCELED_BY = TO_BE_CANCELED_BY == null ? null : TO_BE_CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.TO_BE_CANCELED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.TO_BE_CANCELED_DATE
     */
    public Date getTO_BE_CANCELED_DATE() {
        return TO_BE_CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.TO_BE_CANCELED_DATE
     *
     * @param TO_BE_CANCELED_DATE the value for CTS_TRSFR_ACC.TO_BE_CANCELED_DATE
     */
    public void setTO_BE_CANCELED_DATE(Date TO_BE_CANCELED_DATE) {
        this.TO_BE_CANCELED_DATE = TO_BE_CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.CANCELED_BY
     *
     * @return the value of CTS_TRSFR_ACC.CANCELED_BY
     */
    public String getCANCELED_BY() {
        return CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.CANCELED_BY
     *
     * @param CANCELED_BY the value for CTS_TRSFR_ACC.CANCELED_BY
     */
    public void setCANCELED_BY(String CANCELED_BY) {
        this.CANCELED_BY = CANCELED_BY == null ? null : CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.CANCELED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.CANCELED_DATE
     */
    public Date getCANCELED_DATE() {
        return CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.CANCELED_DATE
     *
     * @param CANCELED_DATE the value for CTS_TRSFR_ACC.CANCELED_DATE
     */
    public void setCANCELED_DATE(Date CANCELED_DATE) {
        this.CANCELED_DATE = CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.REJECTED_BY
     *
     * @return the value of CTS_TRSFR_ACC.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.REJECTED_BY
     *
     * @param REJECTED_BY the value for CTS_TRSFR_ACC.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC.REJECTED_DATE
     *
     * @return the value of CTS_TRSFR_ACC.REJECTED_DATE
     */
    public Date getREJECTED_DATE() {
        return REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC.REJECTED_DATE
     *
     * @param REJECTED_DATE the value for CTS_TRSFR_ACC.REJECTED_DATE
     */
    public void setREJECTED_DATE(Date REJECTED_DATE) {
        this.REJECTED_DATE = REJECTED_DATE;
    }

    
    public String getMODIFIED_BY()
    {
	return MODIFIED_BY;
    }

    public void setMODIFIED_BY(String MODIFIED_BY)
    {
	this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    public Date getDATE_MODIFIED()
    {
	return DATE_MODIFIED;
    }

    public void setDATE_MODIFIED(Date DATE_MODIFIED)
    {
	this.DATE_MODIFIED = DATE_MODIFIED;
    }

    public String getTRANSFER_CARDS_YN()
    {
        return TRANSFER_CARDS_YN;
    }

    public void setTRANSFER_CARDS_YN(String tRANSFER_CARDS_YN)
    {
        TRANSFER_CARDS_YN = tRANSFER_CARDS_YN;
    }

    public Date getDEST_BRANCH_IN_SAME_LOCATION_YN()
    {
        return DEST_BRANCH_IN_SAME_LOCATION_YN;
    }

    public void setDEST_BRANCH_IN_SAME_LOCATION_YN(Date dEST_BRANCH_IN_SAME_LOCATION_YN)
    {
        DEST_BRANCH_IN_SAME_LOCATION_YN = dEST_BRANCH_IN_SAME_LOCATION_YN;
    }
    
    
}