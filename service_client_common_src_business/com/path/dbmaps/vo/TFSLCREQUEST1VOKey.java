package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class TFSLCREQUEST1VOKey extends BaseVO
{
    /**
     * This field corresponds to the database column TFSLCREQUEST1.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFSLCREQUEST1.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFSLCREQUEST1.LC_NBR
     */
    private BigDecimal LC_NBR;

    /**
     * This field corresponds to the database column TFSLCREQUEST1.LC_TYPE
     */
    private String LC_TYPE;

    /**
     * This field corresponds to the database column TFSLCREQUEST1.LC_YEAR
     */
    private BigDecimal LC_YEAR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLCREQUEST1.BRANCH
     * 
     * @return the value of TFSLCREQUEST1.BRANCH
     */
    public BigDecimal getBRANCH()
    {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLCREQUEST1.BRANCH
     * 
     * @param BRANCH the value for TFSLCREQUEST1.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH)
    {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLCREQUEST1.COMP_CODE
     * 
     * @return the value of TFSLCREQUEST1.COMP_CODE
     */
    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLCREQUEST1.COMP_CODE
     * 
     * @param COMP_CODE the value for TFSLCREQUEST1.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE)
    {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLCREQUEST1.LC_NBR
     * 
     * @return the value of TFSLCREQUEST1.LC_NBR
     */
    public BigDecimal getLC_NBR()
    {
        return LC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLCREQUEST1.LC_NBR
     * 
     * @param LC_NBR the value for TFSLCREQUEST1.LC_NBR
     */
    public void setLC_NBR(BigDecimal LC_NBR)
    {
        this.LC_NBR = LC_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLCREQUEST1.LC_TYPE
     * 
     * @return the value of TFSLCREQUEST1.LC_TYPE
     */
    public String getLC_TYPE()
    {
        return LC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLCREQUEST1.LC_TYPE
     * 
     * @param LC_TYPE the value for TFSLCREQUEST1.LC_TYPE
     */
    public void setLC_TYPE(String LC_TYPE)
    {
        this.LC_TYPE = LC_TYPE == null ? null : LC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFSLCREQUEST1.LC_YEAR
     * 
     * @return the value of TFSLCREQUEST1.LC_YEAR
     */
    public BigDecimal getLC_YEAR()
    {
        return LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFSLCREQUEST1.LC_YEAR
     * 
     * @param LC_YEAR the value for TFSLCREQUEST1.LC_YEAR
     */
    public void setLC_YEAR(BigDecimal LC_YEAR)
    {
        this.LC_YEAR = LC_YEAR;
    }
}
