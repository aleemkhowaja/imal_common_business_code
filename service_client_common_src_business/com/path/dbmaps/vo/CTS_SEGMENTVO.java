package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_SEGMENTVO extends CTS_SEGMENTVOKey {
    /**
     * This field corresponds to the database column CTS_SEGMENT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.SEGMENT_DESC
     */
    private String SEGMENT_DESC;

    /**
     * This field corresponds to the database column CTS_SEGMENT.PRIORITY
     */
    private BigDecimal PRIORITY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column CTS_SEGMENT.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DATE_CREATED
     */
    
    /**
     * This field corresponds to the database column CTS_SEGMENT.START_DATE
     */
    
    //added by Ali
    private Date START_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.END_DATE
     */
    private Date END_DATE;
    
    /**
     * This field corresponds to the database column CTS_SEGMENT.APP_NAME
     */
    private String APP_NAME;
    
    /**
     * This field corresponds to the database column CTS_SEGMENT.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;
    // ADDED BY NOUR FOR #864398

    /**
     * This field corresponds to the database column CTS_SEGMENT.SUSPEND_REASON_CODE
     */
    private BigDecimal SUSPEND_REASON_CODE;
    
    /**
     * This field corresponds to the database column IMAL141_AML_O18.CTS_SEGMENT.PERIODICITY
     */
    private String PERIODICITY;


    /**
     * This field corresponds to the database column CTS_SEGMENT.AUTOMATIC_APPROVE_YN
     */
    private String AUTOMATIC_APPROVE_YN;

    
    
    /**
     * This field corresponds to the database column IMAL141_AML_O18.CTS_SEGMENT.DAY
     */
    private BigDecimal DAY;

    
	public Date getSTART_DATE()
	{
		return START_DATE;
	}

	
	public void setSTART_DATE(Date sTART_DATE)
	{
		START_DATE = sTART_DATE;
	}

	
	public Date getEND_DATE()
	{
		return END_DATE;
	}

	
	public void setEND_DATE(Date eND_DATE)
	{
		END_DATE = eND_DATE;
	}

	
	public String getAPP_NAME()
	{
		return APP_NAME;
	}

	
	public void setAPP_NAME(String aPP_NAME)
	{
		APP_NAME = aPP_NAME;
	}

	
	public String getLONG_DESC_ENG()
	{
		return LONG_DESC_ENG;
	}

	
	public void setLONG_DESC_ENG(String lONG_DESC_ENG)
	{
		LONG_DESC_ENG = lONG_DESC_ENG;
	}
	//End Ali
	private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CTS_SEGMENT.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column CTS_SEGMENT.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column CTS_SEGMENT.REJECTED_BY
     */
    private String REJECTED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DATE_REJECTED
     */
    private Date DATE_REJECTED;

    /**
     * This field corresponds to the database column CTS_SEGMENT.OLD_STATUS
     */
    private String OLD_STATUS;

    /**
     * This field corresponds to the database column CTS_SEGMENT.SEGMENT_TYPE
     */
    private String SEGMENT_TYPE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.SUSPENDED_BY
     */
    private String SUSPENDED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.SUSPENDED_DATE
     */
    private Date SUSPENDED_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.REACTIVATED_BY
     */
    private String REACTIVATED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.REACTIVATED_DATE
     */
    private Date REACTIVATED_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.CANCELED_BY
     */
    private String CANCELED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.CANCELED_DATE
     */
    private Date CANCELED_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_SUSPEND_BY
     */
    private String TO_SUSPEND_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_SUSPEND_DATE
     */
    private Date TO_SUSPEND_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_REACTIVATE_BY
     */
    private String TO_REACTIVATE_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_REACTIVATE_DATE
     */
    private Date TO_REACTIVATE_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_CANCEL_BY
     */
    private String TO_CANCEL_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.TO_CANCEL_DATE
     */
    private Date TO_CANCEL_DATE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.GROUP_CODE
     */
    private BigDecimal GROUP_CODE;

    /**
     * This field corresponds to the database column CTS_SEGMENT.AMENDED_PRIORITY
     */
    private BigDecimal AMENDED_PRIORITY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column CTS_SEGMENT.DELETED_DATE
     */
    private Date DELETED_DATE;
    
    /**
     * This field corresponds to the database column CTS_SEGMENT.MAIN_SCORE_YN
     */
    private String MAIN_SCORE_YN;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.BRANCH_CODE
     *
     * @return the value of CTS_SEGMENT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTS_SEGMENT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.SEGMENT_DESC
     *
     * @return the value of CTS_SEGMENT.SEGMENT_DESC
     */
    public String getSEGMENT_DESC() {
        return SEGMENT_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.SEGMENT_DESC
     *
     * @param SEGMENT_DESC the value for CTS_SEGMENT.SEGMENT_DESC
     */
    public void setSEGMENT_DESC(String SEGMENT_DESC) {
        this.SEGMENT_DESC = SEGMENT_DESC == null ? null : SEGMENT_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.PRIORITY
     *
     * @return the value of CTS_SEGMENT.PRIORITY
     */
    public BigDecimal getPRIORITY() {
        return PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.PRIORITY
     *
     * @param PRIORITY the value for CTS_SEGMENT.PRIORITY
     */
    public void setPRIORITY(BigDecimal PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.STATUS
     *
     * @return the value of CTS_SEGMENT.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.STATUS
     *
     * @param STATUS the value for CTS_SEGMENT.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.CREATED_BY
     *
     * @return the value of CTS_SEGMENT.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.CREATED_BY
     *
     * @param CREATED_BY the value for CTS_SEGMENT.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DATE_CREATED
     *
     * @return the value of CTS_SEGMENT.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DATE_CREATED
     *
     * @param DATE_CREATED the value for CTS_SEGMENT.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.MODIFIED_BY
     *
     * @return the value of CTS_SEGMENT.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTS_SEGMENT.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DATE_MODIFIED
     *
     * @return the value of CTS_SEGMENT.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for CTS_SEGMENT.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DATE_UPDATED
     *
     * @return the value of CTS_SEGMENT.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for CTS_SEGMENT.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.APPROVED_BY
     *
     * @return the value of CTS_SEGMENT.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.APPROVED_BY
     *
     * @param APPROVED_BY the value for CTS_SEGMENT.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DATE_APPROVED
     *
     * @return the value of CTS_SEGMENT.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for CTS_SEGMENT.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.REJECTED_BY
     *
     * @return the value of CTS_SEGMENT.REJECTED_BY
     */
    public String getREJECTED_BY() {
        return REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.REJECTED_BY
     *
     * @param REJECTED_BY the value for CTS_SEGMENT.REJECTED_BY
     */
    public void setREJECTED_BY(String REJECTED_BY) {
        this.REJECTED_BY = REJECTED_BY == null ? null : REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DATE_REJECTED
     *
     * @return the value of CTS_SEGMENT.DATE_REJECTED
     */
    public Date getDATE_REJECTED() {
        return DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DATE_REJECTED
     *
     * @param DATE_REJECTED the value for CTS_SEGMENT.DATE_REJECTED
     */
    public void setDATE_REJECTED(Date DATE_REJECTED) {
        this.DATE_REJECTED = DATE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.OLD_STATUS
     *
     * @return the value of CTS_SEGMENT.OLD_STATUS
     */
    public String getOLD_STATUS() {
        return OLD_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.OLD_STATUS
     *
     * @param OLD_STATUS the value for CTS_SEGMENT.OLD_STATUS
     */
    public void setOLD_STATUS(String OLD_STATUS) {
        this.OLD_STATUS = OLD_STATUS == null ? null : OLD_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.SEGMENT_TYPE
     *
     * @return the value of CTS_SEGMENT.SEGMENT_TYPE
     */
    public String getSEGMENT_TYPE() {
        return SEGMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.SEGMENT_TYPE
     *
     * @param SEGMENT_TYPE the value for CTS_SEGMENT.SEGMENT_TYPE
     */
    public void setSEGMENT_TYPE(String SEGMENT_TYPE) {
        this.SEGMENT_TYPE = SEGMENT_TYPE == null ? null : SEGMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.SUSPENDED_BY
     *
     * @return the value of CTS_SEGMENT.SUSPENDED_BY
     */
    public String getSUSPENDED_BY() {
        return SUSPENDED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.SUSPENDED_BY
     *
     * @param SUSPENDED_BY the value for CTS_SEGMENT.SUSPENDED_BY
     */
    public void setSUSPENDED_BY(String SUSPENDED_BY) {
        this.SUSPENDED_BY = SUSPENDED_BY == null ? null : SUSPENDED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.SUSPENDED_DATE
     *
     * @return the value of CTS_SEGMENT.SUSPENDED_DATE
     */
    public Date getSUSPENDED_DATE() {
        return SUSPENDED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.SUSPENDED_DATE
     *
     * @param SUSPENDED_DATE the value for CTS_SEGMENT.SUSPENDED_DATE
     */
    public void setSUSPENDED_DATE(Date SUSPENDED_DATE) {
        this.SUSPENDED_DATE = SUSPENDED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.REACTIVATED_BY
     *
     * @return the value of CTS_SEGMENT.REACTIVATED_BY
     */
    public String getREACTIVATED_BY() {
        return REACTIVATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.REACTIVATED_BY
     *
     * @param REACTIVATED_BY the value for CTS_SEGMENT.REACTIVATED_BY
     */
    public void setREACTIVATED_BY(String REACTIVATED_BY) {
        this.REACTIVATED_BY = REACTIVATED_BY == null ? null : REACTIVATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.REACTIVATED_DATE
     *
     * @return the value of CTS_SEGMENT.REACTIVATED_DATE
     */
    public Date getREACTIVATED_DATE() {
        return REACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.REACTIVATED_DATE
     *
     * @param REACTIVATED_DATE the value for CTS_SEGMENT.REACTIVATED_DATE
     */
    public void setREACTIVATED_DATE(Date REACTIVATED_DATE) {
        this.REACTIVATED_DATE = REACTIVATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.CANCELED_BY
     *
     * @return the value of CTS_SEGMENT.CANCELED_BY
     */
    public String getCANCELED_BY() {
        return CANCELED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.CANCELED_BY
     *
     * @param CANCELED_BY the value for CTS_SEGMENT.CANCELED_BY
     */
    public void setCANCELED_BY(String CANCELED_BY) {
        this.CANCELED_BY = CANCELED_BY == null ? null : CANCELED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.CANCELED_DATE
     *
     * @return the value of CTS_SEGMENT.CANCELED_DATE
     */
    public Date getCANCELED_DATE() {
        return CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.CANCELED_DATE
     *
     * @param CANCELED_DATE the value for CTS_SEGMENT.CANCELED_DATE
     */
    public void setCANCELED_DATE(Date CANCELED_DATE) {
        this.CANCELED_DATE = CANCELED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_SUSPEND_BY
     *
     * @return the value of CTS_SEGMENT.TO_SUSPEND_BY
     */
    public String getTO_SUSPEND_BY() {
        return TO_SUSPEND_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_SUSPEND_BY
     *
     * @param TO_SUSPEND_BY the value for CTS_SEGMENT.TO_SUSPEND_BY
     */
    public void setTO_SUSPEND_BY(String TO_SUSPEND_BY) {
        this.TO_SUSPEND_BY = TO_SUSPEND_BY == null ? null : TO_SUSPEND_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_SUSPEND_DATE
     *
     * @return the value of CTS_SEGMENT.TO_SUSPEND_DATE
     */
    public Date getTO_SUSPEND_DATE() {
        return TO_SUSPEND_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_SUSPEND_DATE
     *
     * @param TO_SUSPEND_DATE the value for CTS_SEGMENT.TO_SUSPEND_DATE
     */
    public void setTO_SUSPEND_DATE(Date TO_SUSPEND_DATE) {
        this.TO_SUSPEND_DATE = TO_SUSPEND_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_REACTIVATE_BY
     *
     * @return the value of CTS_SEGMENT.TO_REACTIVATE_BY
     */
    public String getTO_REACTIVATE_BY() {
        return TO_REACTIVATE_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_REACTIVATE_BY
     *
     * @param TO_REACTIVATE_BY the value for CTS_SEGMENT.TO_REACTIVATE_BY
     */
    public void setTO_REACTIVATE_BY(String TO_REACTIVATE_BY) {
        this.TO_REACTIVATE_BY = TO_REACTIVATE_BY == null ? null : TO_REACTIVATE_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_REACTIVATE_DATE
     *
     * @return the value of CTS_SEGMENT.TO_REACTIVATE_DATE
     */
    public Date getTO_REACTIVATE_DATE() {
        return TO_REACTIVATE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_REACTIVATE_DATE
     *
     * @param TO_REACTIVATE_DATE the value for CTS_SEGMENT.TO_REACTIVATE_DATE
     */
    public void setTO_REACTIVATE_DATE(Date TO_REACTIVATE_DATE) {
        this.TO_REACTIVATE_DATE = TO_REACTIVATE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_CANCEL_BY
     *
     * @return the value of CTS_SEGMENT.TO_CANCEL_BY
     */
    public String getTO_CANCEL_BY() {
        return TO_CANCEL_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_CANCEL_BY
     *
     * @param TO_CANCEL_BY the value for CTS_SEGMENT.TO_CANCEL_BY
     */
    public void setTO_CANCEL_BY(String TO_CANCEL_BY) {
        this.TO_CANCEL_BY = TO_CANCEL_BY == null ? null : TO_CANCEL_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.TO_CANCEL_DATE
     *
     * @return the value of CTS_SEGMENT.TO_CANCEL_DATE
     */
    public Date getTO_CANCEL_DATE() {
        return TO_CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.TO_CANCEL_DATE
     *
     * @param TO_CANCEL_DATE the value for CTS_SEGMENT.TO_CANCEL_DATE
     */
    public void setTO_CANCEL_DATE(Date TO_CANCEL_DATE) {
        this.TO_CANCEL_DATE = TO_CANCEL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.GROUP_CODE
     *
     * @return the value of CTS_SEGMENT.GROUP_CODE
     */
    public BigDecimal getGROUP_CODE() {
        return GROUP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.GROUP_CODE
     *
     * @param GROUP_CODE the value for CTS_SEGMENT.GROUP_CODE
     */
    public void setGROUP_CODE(BigDecimal GROUP_CODE) {
        this.GROUP_CODE = GROUP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.AMENDED_PRIORITY
     *
     * @return the value of CTS_SEGMENT.AMENDED_PRIORITY
     */
    public BigDecimal getAMENDED_PRIORITY() {
        return AMENDED_PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.AMENDED_PRIORITY
     *
     * @param AMENDED_PRIORITY the value for CTS_SEGMENT.AMENDED_PRIORITY
     */
    public void setAMENDED_PRIORITY(BigDecimal AMENDED_PRIORITY) {
        this.AMENDED_PRIORITY = AMENDED_PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DELETED_BY
     *
     * @return the value of CTS_SEGMENT.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DELETED_BY
     *
     * @param DELETED_BY the value for CTS_SEGMENT.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.DELETED_DATE
     *
     * @return the value of CTS_SEGMENT.DELETED_DATE
     */
    public Date getDELETED_DATE() {
        return DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.DELETED_DATE
     *
     * @param DELETED_DATE the value for CTS_SEGMENT.DELETED_DATE
     */
    public void setDELETED_DATE(Date DELETED_DATE) {
        this.DELETED_DATE = DELETED_DATE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.SUSPEND_REASON_CODE
     *
     * @return the value of CTS_SEGMENT.SUSPEND_REASON_CODE
     */
    public BigDecimal getSUSPEND_REASON_CODE() {
        return SUSPEND_REASON_CODE;
    }
    
    /**
     * This field corresponds to the database column IMAL141_AML_O18.CTS_SEGMENT.SUSPEND_REASON_REF
     */
    private String SUSPEND_REASON_REF;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.SUSPEND_REASON_CODE
     *
     * @param SUSPEND_REASON_CODE the value for CTS_SEGMENT.SUSPEND_REASON_CODE
     */
    public void setSUSPEND_REASON_CODE(BigDecimal SUSPEND_REASON_CODE) {
        this.SUSPEND_REASON_CODE = SUSPEND_REASON_CODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_AML_O18.CTS_SEGMENT.SUSPEND_REASON_REF
     *
     * @return the value of IMAL141_AML_O18.CTS_SEGMENT.SUSPEND_REASON_REF
     */
    public String getSUSPEND_REASON_REF() {
        return SUSPEND_REASON_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_AML_O18.CTS_SEGMENT.SUSPEND_REASON_REF
     *
     * @param SUSPEND_REASON_REF the value for IMAL141_AML_O18.CTS_SEGMENT.SUSPEND_REASON_REF
     */
    public void setSUSPEND_REASON_REF(String SUSPEND_REASON_REF) {
        this.SUSPEND_REASON_REF = SUSPEND_REASON_REF == null ? null : SUSPEND_REASON_REF.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_AML_O18.CTS_SEGMENT.PERIODICITY
     *
     * @return the value of IMAL141_AML_O18.CTS_SEGMENT.PERIODICITY
     */
    public String getPERIODICITY() {
        return PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_AML_O18.CTS_SEGMENT.PERIODICITY
     *
     * @param PERIODICITY the value for IMAL141_AML_O18.CTS_SEGMENT.PERIODICITY
     */
    public void setPERIODICITY(String PERIODICITY) {
        this.PERIODICITY = PERIODICITY == null ? null : PERIODICITY.trim();
    }

  

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_AML_O18.CTS_SEGMENT.DAY
     *
     * @return the value of IMAL141_AML_O18.CTS_SEGMENT.DAY
     */
    public BigDecimal getDAY() {
        return DAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_AML_O18.CTS_SEGMENT.DAY
     *
     * @param DAY the value for IMAL141_AML_O18.CTS_SEGMENT.DAY
     */
    public void setDAY(BigDecimal DAY) {
        this.DAY = DAY;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT.MAIN_SCORE_YN
     *
     * @return the value of CTS_SEGMENT.MAIN_SCORE_YN
     */
    public String getMAIN_SCORE_YN() {
        return MAIN_SCORE_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT.MAIN_SCORE_YN
     *
     * @param MAIN_SCORE_YN the value for CTS_SEGMENT.MAIN_SCORE_YN
     */
    public void setMAIN_SCORE_YN(String MAIN_SCORE_YN) {
        this.MAIN_SCORE_YN = MAIN_SCORE_YN == null ? null : MAIN_SCORE_YN.trim();
    }
    
    
    public String getAUTOMATIC_APPROVE_YN()
    {
        return AUTOMATIC_APPROVE_YN;
    }

    public void setAUTOMATIC_APPROVE_YN(String aUTOMATIC_APPROVE_YN)
    {
        AUTOMATIC_APPROVE_YN = aUTOMATIC_APPROVE_YN;
    }
    
}