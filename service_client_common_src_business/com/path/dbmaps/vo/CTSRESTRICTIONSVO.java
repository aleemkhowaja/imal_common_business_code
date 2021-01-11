package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import com.path.struts2.lib.common.base.BaseAction;

import java.math.BigDecimal;
import java.util.Date;

public class CTSRESTRICTIONSVO extends BaseAction {
    /**
     * This field corresponds to the database column CTSRESTRICTIONS.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CODE_TYPE
     */
    private BigDecimal CODE_TYPE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.PROG_REF
     */
    private String PROG_REF;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CIF_TYPE
     */
    private BigDecimal CIF_TYPE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CODE_TYPE_DESC
     */
    private String CODE_TYPE_DESC;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.ACC_STATUS
     */
    private String ACC_STATUS;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.FORBID
     */
    private String FORBID;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.CIF_SUB_NO
     */
    private BigDecimal CIF_SUB_NO;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.FROM_CIF_TYPE
     */
    private BigDecimal FROM_CIF_TYPE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.TO_CIF_TYPE
     */
    private BigDecimal TO_CIF_TYPE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.FROM_CIF
     */
    private BigDecimal FROM_CIF;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.TO_CIF
     */
    private BigDecimal TO_CIF;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.FROM_AMOUNT
     */
    private BigDecimal FROM_AMOUNT;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.TO_AMOUNT
     */
    private BigDecimal TO_AMOUNT;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.DELETED_DATE
     */
    private Date DELETED_DATE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.REJECTED_DATE
     */
    private Date REJECTED_DATE;

    /**
     * This field corresponds to the database column CTSRESTRICTIONS.PERSONAL_ACC_ACCESS
     */
    private String PERSONAL_ACC_ACCESS;
    
    /**
     * This field corresponds to the database column CTSRESTRICTIONS.RESTRICTION_LEVEL
     */
    private String RESTRICTION_LEVEL;
    
    /**
     * This field corresponds to the database column CTSRESTRICTIONS.EXCEPT_LOGIN_BR_YN
     */
    private String EXCEPT_LOGIN_BR_YN;
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.APP_NAME
     *
     * @return the value of CTSRESTRICTIONS.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.APP_NAME
     *
     * @param APP_NAME the value for CTSRESTRICTIONS.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.BRANCH_CODE
     *
     * @return the value of CTSRESTRICTIONS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSRESTRICTIONS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CODE
     *
     * @return the value of CTSRESTRICTIONS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CODE
     *
     * @param CODE the value for CTSRESTRICTIONS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CODE_TYPE
     *
     * @return the value of CTSRESTRICTIONS.CODE_TYPE
     */
    public BigDecimal getCODE_TYPE() {
        return CODE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CODE_TYPE
     *
     * @param CODE_TYPE the value for CTSRESTRICTIONS.CODE_TYPE
     */
    public void setCODE_TYPE(BigDecimal CODE_TYPE) {
        this.CODE_TYPE = CODE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.COMP_CODE
     *
     * @return the value of CTSRESTRICTIONS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.COMP_CODE
     *
     * @param COMP_CODE the value for CTSRESTRICTIONS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.PROG_REF
     *
     * @return the value of CTSRESTRICTIONS.PROG_REF
     */
    public String getPROG_REF() {
        return PROG_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.PROG_REF
     *
     * @param PROG_REF the value for CTSRESTRICTIONS.PROG_REF
     */
    public void setPROG_REF(String PROG_REF) {
        this.PROG_REF = PROG_REF == null ? null : PROG_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.GL_CODE
     *
     * @return the value of CTSRESTRICTIONS.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.GL_CODE
     *
     * @param GL_CODE the value for CTSRESTRICTIONS.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CIF_TYPE
     *
     * @return the value of CTSRESTRICTIONS.CIF_TYPE
     */
    public BigDecimal getCIF_TYPE() {
        return CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CIF_TYPE
     *
     * @param CIF_TYPE the value for CTSRESTRICTIONS.CIF_TYPE
     */
    public void setCIF_TYPE(BigDecimal CIF_TYPE) {
        this.CIF_TYPE = CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.STATUS
     *
     * @return the value of CTSRESTRICTIONS.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.STATUS
     *
     * @param STATUS the value for CTSRESTRICTIONS.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CREATED_BY
     *
     * @return the value of CTSRESTRICTIONS.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CREATED_BY
     *
     * @param CREATED_BY the value for CTSRESTRICTIONS.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CREATED_DATE
     *
     * @return the value of CTSRESTRICTIONS.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CREATED_DATE
     *
     * @param CREATED_DATE the value for CTSRESTRICTIONS.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.APPROVED_BY
     *
     * @return the value of CTSRESTRICTIONS.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.APPROVED_BY
     *
     * @param APPROVED_BY the value for CTSRESTRICTIONS.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.APPROVED_DATE
     *
     * @return the value of CTSRESTRICTIONS.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for CTSRESTRICTIONS.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.MODIFIED_BY
     *
     * @return the value of CTSRESTRICTIONS.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTSRESTRICTIONS.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.MODIFIED_DATE
     *
     * @return the value of CTSRESTRICTIONS.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for CTSRESTRICTIONS.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CODE_TYPE_DESC
     *
     * @return the value of CTSRESTRICTIONS.CODE_TYPE_DESC
     */
    public String getCODE_TYPE_DESC() {
        return CODE_TYPE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CODE_TYPE_DESC
     *
     * @param CODE_TYPE_DESC the value for CTSRESTRICTIONS.CODE_TYPE_DESC
     */
    public void setCODE_TYPE_DESC(String CODE_TYPE_DESC) {
        this.CODE_TYPE_DESC = CODE_TYPE_DESC == null ? null : CODE_TYPE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.ACC_STATUS
     *
     * @return the value of CTSRESTRICTIONS.ACC_STATUS
     */
    public String getACC_STATUS() {
        return ACC_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.ACC_STATUS
     *
     * @param ACC_STATUS the value for CTSRESTRICTIONS.ACC_STATUS
     */
    public void setACC_STATUS(String ACC_STATUS) {
        this.ACC_STATUS = ACC_STATUS == null ? null : ACC_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.FORBID
     *
     * @return the value of CTSRESTRICTIONS.FORBID
     */
    public String getFORBID() {
        return FORBID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.FORBID
     *
     * @param FORBID the value for CTSRESTRICTIONS.FORBID
     */
    public void setFORBID(String FORBID) {
        this.FORBID = FORBID == null ? null : FORBID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.LINE_NO
     *
     * @return the value of CTSRESTRICTIONS.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.LINE_NO
     *
     * @param LINE_NO the value for CTSRESTRICTIONS.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CURRENCY_CODE
     *
     * @return the value of CTSRESTRICTIONS.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for CTSRESTRICTIONS.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.CIF_SUB_NO
     *
     * @return the value of CTSRESTRICTIONS.CIF_SUB_NO
     */
    public BigDecimal getCIF_SUB_NO() {
        return CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.CIF_SUB_NO
     *
     * @param CIF_SUB_NO the value for CTSRESTRICTIONS.CIF_SUB_NO
     */
    public void setCIF_SUB_NO(BigDecimal CIF_SUB_NO) {
        this.CIF_SUB_NO = CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.SL_NO
     *
     * @return the value of CTSRESTRICTIONS.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.SL_NO
     *
     * @param SL_NO the value for CTSRESTRICTIONS.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.FROM_CIF_TYPE
     *
     * @return the value of CTSRESTRICTIONS.FROM_CIF_TYPE
     */
    public BigDecimal getFROM_CIF_TYPE() {
        return FROM_CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.FROM_CIF_TYPE
     *
     * @param FROM_CIF_TYPE the value for CTSRESTRICTIONS.FROM_CIF_TYPE
     */
    public void setFROM_CIF_TYPE(BigDecimal FROM_CIF_TYPE) {
        this.FROM_CIF_TYPE = FROM_CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.TO_CIF_TYPE
     *
     * @return the value of CTSRESTRICTIONS.TO_CIF_TYPE
     */
    public BigDecimal getTO_CIF_TYPE() {
        return TO_CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.TO_CIF_TYPE
     *
     * @param TO_CIF_TYPE the value for CTSRESTRICTIONS.TO_CIF_TYPE
     */
    public void setTO_CIF_TYPE(BigDecimal TO_CIF_TYPE) {
        this.TO_CIF_TYPE = TO_CIF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.FROM_CIF
     *
     * @return the value of CTSRESTRICTIONS.FROM_CIF
     */
    public BigDecimal getFROM_CIF() {
        return FROM_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.FROM_CIF
     *
     * @param FROM_CIF the value for CTSRESTRICTIONS.FROM_CIF
     */
    public void setFROM_CIF(BigDecimal FROM_CIF) {
        this.FROM_CIF = FROM_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.TO_CIF
     *
     * @return the value of CTSRESTRICTIONS.TO_CIF
     */
    public BigDecimal getTO_CIF() {
        return TO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.TO_CIF
     *
     * @param TO_CIF the value for CTSRESTRICTIONS.TO_CIF
     */
    public void setTO_CIF(BigDecimal TO_CIF) {
        this.TO_CIF = TO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.FROM_AMOUNT
     *
     * @return the value of CTSRESTRICTIONS.FROM_AMOUNT
     */
    public BigDecimal getFROM_AMOUNT() {
        return FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.FROM_AMOUNT
     *
     * @param FROM_AMOUNT the value for CTSRESTRICTIONS.FROM_AMOUNT
     */
    public void setFROM_AMOUNT(BigDecimal FROM_AMOUNT) {
        this.FROM_AMOUNT = FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.TO_AMOUNT
     *
     * @return the value of CTSRESTRICTIONS.TO_AMOUNT
     */
    public BigDecimal getTO_AMOUNT() {
        return TO_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.TO_AMOUNT
     *
     * @param TO_AMOUNT the value for CTSRESTRICTIONS.TO_AMOUNT
     */
    public void setTO_AMOUNT(BigDecimal TO_AMOUNT) {
        this.TO_AMOUNT = TO_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.DELETED_BY
     *
     * @return the value of CTSRESTRICTIONS.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.DELETED_BY
     *
     * @param DELETED_BY the value for CTSRESTRICTIONS.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.DELETED_DATE
     *
     * @return the value of CTSRESTRICTIONS.DELETED_DATE
     */
    public Date getDELETED_DATE() {
        return DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.DELETED_DATE
     *
     * @param DELETED_DATE the value for CTSRESTRICTIONS.DELETED_DATE
     */
    public void setDELETED_DATE(Date DELETED_DATE) {
        this.DELETED_DATE = DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.REJECTED_BY
     *
     * @return the value of CTSRESTRICTIONS.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.REJECTED_BY
     *
     * @param REJECTED_BY the value for CTSRESTRICTIONS.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.REJECTED_DATE
     *
     * @return the value of CTSRESTRICTIONS.REJECTED_DATE
     */
    public Date getREJECTED_DATE() {
        return REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.REJECTED_DATE
     *
     * @param REJECTED_DATE the value for CTSRESTRICTIONS.REJECTED_DATE
     */
    public void setREJECTED_DATE(Date REJECTED_DATE) {
        this.REJECTED_DATE = REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSRESTRICTIONS.PERSONAL_ACC_ACCESS
     *
     * @return the value of CTSRESTRICTIONS.PERSONAL_ACC_ACCESS
     */
    public String getPERSONAL_ACC_ACCESS() {
        return PERSONAL_ACC_ACCESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSRESTRICTIONS.PERSONAL_ACC_ACCESS
     *
     * @param PERSONAL_ACC_ACCESS the value for CTSRESTRICTIONS.PERSONAL_ACC_ACCESS
     */
    public void setPERSONAL_ACC_ACCESS(String PERSONAL_ACC_ACCESS) {
        this.PERSONAL_ACC_ACCESS = PERSONAL_ACC_ACCESS == null ? null : PERSONAL_ACC_ACCESS.trim();
    }

	
	public String getRESTRICTION_LEVEL()
	{
		return RESTRICTION_LEVEL;
	}

	
	public void setRESTRICTION_LEVEL(String rESTRICTION_LEVEL)
	{
		RESTRICTION_LEVEL = rESTRICTION_LEVEL;
	}

	
	public String getEXCEPT_LOGIN_BR_YN()
	{
		return EXCEPT_LOGIN_BR_YN;
	}

	
	public void setEXCEPT_LOGIN_BR_YN(String eXCEPT_LOGIN_BR_YN)
	{
		EXCEPT_LOGIN_BR_YN = eXCEPT_LOGIN_BR_YN;
	}
}