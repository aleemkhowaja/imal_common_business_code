package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TFS_GOODS_CATEGORYVO extends BaseVO {
    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ARAB
     */
    private String BRIEF_NAME_ARAB;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.LONG_NAME_ARAB
     */
    private String LONG_NAME_ARAB;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SUB_CATEGORY_YN
     */
    private String SUB_CATEGORY_YN;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.PARENT_CATEGORY_CODE
     */
    private BigDecimal PARENT_CATEGORY_CODE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.APPROVED_DATE
     */
    private Date APPROVED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_BY
     */
    private String APPROVE_REJECTED_BY;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_DATE
     */
    private Date APPROVE_REJECTED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.DELETED_DATE
     */
    private Date DELETED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SERVER_APPROVED_DATE
     */
    private Date SERVER_APPROVED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SERVER_APPROVE_REJECTED_DATE
     */
    private Date SERVER_APPROVE_REJECTED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SERVER_CREATED_DATE
     */
    private Date SERVER_CREATED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SERVER_DELETED_DATE
     */
    private Date SERVER_DELETED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.SERVER_MODIFIED_DATE
     */
    private Date SERVER_MODIFIED_DATE;

    /**
     * This field corresponds to the database column TFS_GOODS_CATEGORY.REJECT_REASON
     */
    private String REJECT_REASON;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.CODE
     *
     * @return the value of TFS_GOODS_CATEGORY.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.CODE
     *
     * @param CODE the value for TFS_GOODS_CATEGORY.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.COMP_CODE
     *
     * @return the value of TFS_GOODS_CATEGORY.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.COMP_CODE
     *
     * @param COMP_CODE the value for TFS_GOODS_CATEGORY.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ENG
     *
     * @return the value of TFS_GOODS_CATEGORY.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for TFS_GOODS_CATEGORY.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ARAB
     *
     * @return the value of TFS_GOODS_CATEGORY.BRIEF_NAME_ARAB
     */
    public String getBRIEF_NAME_ARAB() {
        return BRIEF_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.BRIEF_NAME_ARAB
     *
     * @param BRIEF_NAME_ARAB the value for TFS_GOODS_CATEGORY.BRIEF_NAME_ARAB
     */
    public void setBRIEF_NAME_ARAB(String BRIEF_NAME_ARAB) {
        this.BRIEF_NAME_ARAB = BRIEF_NAME_ARAB == null ? null : BRIEF_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.LONG_NAME_ENG
     *
     * @return the value of TFS_GOODS_CATEGORY.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for TFS_GOODS_CATEGORY.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.LONG_NAME_ARAB
     *
     * @return the value of TFS_GOODS_CATEGORY.LONG_NAME_ARAB
     */
    public String getLONG_NAME_ARAB() {
        return LONG_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.LONG_NAME_ARAB
     *
     * @param LONG_NAME_ARAB the value for TFS_GOODS_CATEGORY.LONG_NAME_ARAB
     */
    public void setLONG_NAME_ARAB(String LONG_NAME_ARAB) {
        this.LONG_NAME_ARAB = LONG_NAME_ARAB == null ? null : LONG_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SUB_CATEGORY_YN
     *
     * @return the value of TFS_GOODS_CATEGORY.SUB_CATEGORY_YN
     */
    public String getSUB_CATEGORY_YN() {
        return SUB_CATEGORY_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SUB_CATEGORY_YN
     *
     * @param SUB_CATEGORY_YN the value for TFS_GOODS_CATEGORY.SUB_CATEGORY_YN
     */
    public void setSUB_CATEGORY_YN(String SUB_CATEGORY_YN) {
        this.SUB_CATEGORY_YN = SUB_CATEGORY_YN == null ? null : SUB_CATEGORY_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.PARENT_CATEGORY_CODE
     *
     * @return the value of TFS_GOODS_CATEGORY.PARENT_CATEGORY_CODE
     */
    public BigDecimal getPARENT_CATEGORY_CODE() {
        return PARENT_CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.PARENT_CATEGORY_CODE
     *
     * @param PARENT_CATEGORY_CODE the value for TFS_GOODS_CATEGORY.PARENT_CATEGORY_CODE
     */
    public void setPARENT_CATEGORY_CODE(BigDecimal PARENT_CATEGORY_CODE) {
        this.PARENT_CATEGORY_CODE = PARENT_CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.APPROVED_BY
     *
     * @return the value of TFS_GOODS_CATEGORY.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.APPROVED_BY
     *
     * @param APPROVED_BY the value for TFS_GOODS_CATEGORY.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.APPROVED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.APPROVED_DATE
     */
    public Date getAPPROVED_DATE() {
        return APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.APPROVED_DATE
     *
     * @param APPROVED_DATE the value for TFS_GOODS_CATEGORY.APPROVED_DATE
     */
    public void setAPPROVED_DATE(Date APPROVED_DATE) {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_BY
     *
     * @return the value of TFS_GOODS_CATEGORY.APPROVE_REJECTED_BY
     */
    public String getAPPROVE_REJECTED_BY() {
        return APPROVE_REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_BY
     *
     * @param APPROVE_REJECTED_BY the value for TFS_GOODS_CATEGORY.APPROVE_REJECTED_BY
     */
    public void setAPPROVE_REJECTED_BY(String APPROVE_REJECTED_BY) {
        this.APPROVE_REJECTED_BY = APPROVE_REJECTED_BY == null ? null : APPROVE_REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.APPROVE_REJECTED_DATE
     */
    public Date getAPPROVE_REJECTED_DATE() {
        return APPROVE_REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.APPROVE_REJECTED_DATE
     *
     * @param APPROVE_REJECTED_DATE the value for TFS_GOODS_CATEGORY.APPROVE_REJECTED_DATE
     */
    public void setAPPROVE_REJECTED_DATE(Date APPROVE_REJECTED_DATE) {
        this.APPROVE_REJECTED_DATE = APPROVE_REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.CREATED_BY
     *
     * @return the value of TFS_GOODS_CATEGORY.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.CREATED_BY
     *
     * @param CREATED_BY the value for TFS_GOODS_CATEGORY.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.CREATED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.CREATED_DATE
     *
     * @param CREATED_DATE the value for TFS_GOODS_CATEGORY.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.DATE_UPDATED
     *
     * @return the value of TFS_GOODS_CATEGORY.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for TFS_GOODS_CATEGORY.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.DELETED_BY
     *
     * @return the value of TFS_GOODS_CATEGORY.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.DELETED_BY
     *
     * @param DELETED_BY the value for TFS_GOODS_CATEGORY.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.DELETED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.DELETED_DATE
     */
    public Date getDELETED_DATE() {
        return DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.DELETED_DATE
     *
     * @param DELETED_DATE the value for TFS_GOODS_CATEGORY.DELETED_DATE
     */
    public void setDELETED_DATE(Date DELETED_DATE) {
        this.DELETED_DATE = DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.MODIFIED_BY
     *
     * @return the value of TFS_GOODS_CATEGORY.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TFS_GOODS_CATEGORY.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.MODIFIED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for TFS_GOODS_CATEGORY.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SERVER_APPROVED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.SERVER_APPROVED_DATE
     */
    public Date getSERVER_APPROVED_DATE() {
        return SERVER_APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SERVER_APPROVED_DATE
     *
     * @param SERVER_APPROVED_DATE the value for TFS_GOODS_CATEGORY.SERVER_APPROVED_DATE
     */
    public void setSERVER_APPROVED_DATE(Date SERVER_APPROVED_DATE) {
        this.SERVER_APPROVED_DATE = SERVER_APPROVED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SERVER_APPROVE_REJECTED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.SERVER_APPROVE_REJECTED_DATE
     */
    public Date getSERVER_APPROVE_REJECTED_DATE() {
        return SERVER_APPROVE_REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SERVER_APPROVE_REJECTED_DATE
     *
     * @param SERVER_APPROVE_REJECTED_DATE the value for TFS_GOODS_CATEGORY.SERVER_APPROVE_REJECTED_DATE
     */
    public void setSERVER_APPROVE_REJECTED_DATE(Date SERVER_APPROVE_REJECTED_DATE) {
        this.SERVER_APPROVE_REJECTED_DATE = SERVER_APPROVE_REJECTED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SERVER_CREATED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.SERVER_CREATED_DATE
     */
    public Date getSERVER_CREATED_DATE() {
        return SERVER_CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SERVER_CREATED_DATE
     *
     * @param SERVER_CREATED_DATE the value for TFS_GOODS_CATEGORY.SERVER_CREATED_DATE
     */
    public void setSERVER_CREATED_DATE(Date SERVER_CREATED_DATE) {
        this.SERVER_CREATED_DATE = SERVER_CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SERVER_DELETED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.SERVER_DELETED_DATE
     */
    public Date getSERVER_DELETED_DATE() {
        return SERVER_DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SERVER_DELETED_DATE
     *
     * @param SERVER_DELETED_DATE the value for TFS_GOODS_CATEGORY.SERVER_DELETED_DATE
     */
    public void setSERVER_DELETED_DATE(Date SERVER_DELETED_DATE) {
        this.SERVER_DELETED_DATE = SERVER_DELETED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.SERVER_MODIFIED_DATE
     *
     * @return the value of TFS_GOODS_CATEGORY.SERVER_MODIFIED_DATE
     */
    public Date getSERVER_MODIFIED_DATE() {
        return SERVER_MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.SERVER_MODIFIED_DATE
     *
     * @param SERVER_MODIFIED_DATE the value for TFS_GOODS_CATEGORY.SERVER_MODIFIED_DATE
     */
    public void setSERVER_MODIFIED_DATE(Date SERVER_MODIFIED_DATE) {
        this.SERVER_MODIFIED_DATE = SERVER_MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_GOODS_CATEGORY.REJECT_REASON
     *
     * @return the value of TFS_GOODS_CATEGORY.REJECT_REASON
     */
    public String getREJECT_REASON() {
        return REJECT_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_GOODS_CATEGORY.REJECT_REASON
     *
     * @param REJECT_REASON the value for TFS_GOODS_CATEGORY.REJECT_REASON
     */
    public void setREJECT_REASON(String REJECT_REASON) {
        this.REJECT_REASON = REJECT_REASON == null ? null : REJECT_REASON.trim();
    }
}