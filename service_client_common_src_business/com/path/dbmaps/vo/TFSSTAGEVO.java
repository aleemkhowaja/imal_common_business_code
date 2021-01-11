package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TFSSTAGEVO extends BaseVO {
    /**
     * This field corresponds to the database column TFSSTAGE.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFSSTAGE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSSTAGE.LC_NBR
     */
    private BigDecimal LC_NBR;

    /**
     * This field corresponds to the database column TFSSTAGE.LC_TYPE
     */
    private String LC_TYPE;

    /**
     * This field corresponds to the database column TFSSTAGE.LC_YEAR
     */
    private BigDecimal LC_YEAR;

    /**
     * This field corresponds to the database column TFSSTAGE.STAGE_NBR
     */
    private BigDecimal STAGE_NBR;

    /**
     * This field corresponds to the database column TFSSTAGE.STAGE_PERC
     */
    private BigDecimal STAGE_PERC;

    /**
     * This field corresponds to the database column TFSSTAGE.STAGE_AMOUNT
     */
    private BigDecimal STAGE_AMOUNT;

    /**
     * This field corresponds to the database column TFSSTAGE.STAGE_UTILIZED
     */
    private BigDecimal STAGE_UTILIZED;

    /**
     * This field corresponds to the database column TFSSTAGE.STAGE_NARRATIVE
     */
    private String STAGE_NARRATIVE;

    /**
     * This field corresponds to the database column TFSSTAGE.CREDIT_AVAILABILITY_DAYS
     */
    private BigDecimal CREDIT_AVAILABILITY_DAYS;

    /**
     * This field corresponds to the database column TFSSTAGE.MEANS_OF_TRANSPORT
     */
    private String MEANS_OF_TRANSPORT;

    /**
     * This field corresponds to the database column TFSSTAGE.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.BRANCH
     *
     * @return the value of TFSSTAGE.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.BRANCH
     *
     * @param BRANCH the value for TFSSTAGE.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.COMP_CODE
     *
     * @return the value of TFSSTAGE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.COMP_CODE
     *
     * @param COMP_CODE the value for TFSSTAGE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.LC_NBR
     *
     * @return the value of TFSSTAGE.LC_NBR
     */
    public BigDecimal getLC_NBR() {
        return LC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.LC_NBR
     *
     * @param LC_NBR the value for TFSSTAGE.LC_NBR
     */
    public void setLC_NBR(BigDecimal LC_NBR) {
        this.LC_NBR = LC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.LC_TYPE
     *
     * @return the value of TFSSTAGE.LC_TYPE
     */
    public String getLC_TYPE() {
        return LC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.LC_TYPE
     *
     * @param LC_TYPE the value for TFSSTAGE.LC_TYPE
     */
    public void setLC_TYPE(String LC_TYPE) {
        this.LC_TYPE = LC_TYPE == null ? null : LC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.LC_YEAR
     *
     * @return the value of TFSSTAGE.LC_YEAR
     */
    public BigDecimal getLC_YEAR() {
        return LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.LC_YEAR
     *
     * @param LC_YEAR the value for TFSSTAGE.LC_YEAR
     */
    public void setLC_YEAR(BigDecimal LC_YEAR) {
        this.LC_YEAR = LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.STAGE_NBR
     *
     * @return the value of TFSSTAGE.STAGE_NBR
     */
    public BigDecimal getSTAGE_NBR() {
        return STAGE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.STAGE_NBR
     *
     * @param STAGE_NBR the value for TFSSTAGE.STAGE_NBR
     */
    public void setSTAGE_NBR(BigDecimal STAGE_NBR) {
        this.STAGE_NBR = STAGE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.STAGE_PERC
     *
     * @return the value of TFSSTAGE.STAGE_PERC
     */
    public BigDecimal getSTAGE_PERC() {
        return STAGE_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.STAGE_PERC
     *
     * @param STAGE_PERC the value for TFSSTAGE.STAGE_PERC
     */
    public void setSTAGE_PERC(BigDecimal STAGE_PERC) {
        this.STAGE_PERC = STAGE_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.STAGE_AMOUNT
     *
     * @return the value of TFSSTAGE.STAGE_AMOUNT
     */
    public BigDecimal getSTAGE_AMOUNT() {
        return STAGE_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.STAGE_AMOUNT
     *
     * @param STAGE_AMOUNT the value for TFSSTAGE.STAGE_AMOUNT
     */
    public void setSTAGE_AMOUNT(BigDecimal STAGE_AMOUNT) {
        this.STAGE_AMOUNT = STAGE_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.STAGE_UTILIZED
     *
     * @return the value of TFSSTAGE.STAGE_UTILIZED
     */
    public BigDecimal getSTAGE_UTILIZED() {
        return STAGE_UTILIZED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.STAGE_UTILIZED
     *
     * @param STAGE_UTILIZED the value for TFSSTAGE.STAGE_UTILIZED
     */
    public void setSTAGE_UTILIZED(BigDecimal STAGE_UTILIZED) {
        this.STAGE_UTILIZED = STAGE_UTILIZED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.STAGE_NARRATIVE
     *
     * @return the value of TFSSTAGE.STAGE_NARRATIVE
     */
    public String getSTAGE_NARRATIVE() {
        return STAGE_NARRATIVE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.STAGE_NARRATIVE
     *
     * @param STAGE_NARRATIVE the value for TFSSTAGE.STAGE_NARRATIVE
     */
    public void setSTAGE_NARRATIVE(String STAGE_NARRATIVE) {
        this.STAGE_NARRATIVE = STAGE_NARRATIVE == null ? null : STAGE_NARRATIVE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.CREDIT_AVAILABILITY_DAYS
     *
     * @return the value of TFSSTAGE.CREDIT_AVAILABILITY_DAYS
     */
    public BigDecimal getCREDIT_AVAILABILITY_DAYS() {
        return CREDIT_AVAILABILITY_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.CREDIT_AVAILABILITY_DAYS
     *
     * @param CREDIT_AVAILABILITY_DAYS the value for TFSSTAGE.CREDIT_AVAILABILITY_DAYS
     */
    public void setCREDIT_AVAILABILITY_DAYS(BigDecimal CREDIT_AVAILABILITY_DAYS) {
        this.CREDIT_AVAILABILITY_DAYS = CREDIT_AVAILABILITY_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.MEANS_OF_TRANSPORT
     *
     * @return the value of TFSSTAGE.MEANS_OF_TRANSPORT
     */
    public String getMEANS_OF_TRANSPORT() {
        return MEANS_OF_TRANSPORT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.MEANS_OF_TRANSPORT
     *
     * @param MEANS_OF_TRANSPORT the value for TFSSTAGE.MEANS_OF_TRANSPORT
     */
    public void setMEANS_OF_TRANSPORT(String MEANS_OF_TRANSPORT) {
        this.MEANS_OF_TRANSPORT = MEANS_OF_TRANSPORT == null ? null : MEANS_OF_TRANSPORT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSSTAGE.DATE_UPDATED
     *
     * @return the value of TFSSTAGE.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSSTAGE.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for TFSSTAGE.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }
}