package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AMF_DATA_ADD_FIELDSVO extends AMF_DATA_ADD_FIELDSVOKey {
    /**
     * This field corresponds to the database column AMF_DATA_ADD_FIELDS.ADD_NUM
     */
    private BigDecimal ADD_NUM;

    /**
     * This field corresponds to the database column AMF_DATA_ADD_FIELDS.ADD_VC
     */
    private String ADD_VC;

    /**
     * This field corresponds to the database column AMF_DATA_ADD_FIELDS.ADD_DT
     */
    private Date ADD_DT;

    private String ADD_DR;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DATA_ADD_FIELDS.ADD_NUM
     *
     * @return the value of AMF_DATA_ADD_FIELDS.ADD_NUM
     */
    public BigDecimal getADD_NUM() {
        return ADD_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DATA_ADD_FIELDS.ADD_NUM
     *
     * @param ADD_NUM the value for AMF_DATA_ADD_FIELDS.ADD_NUM
     */
    public void setADD_NUM(BigDecimal ADD_NUM) {
        this.ADD_NUM = ADD_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DATA_ADD_FIELDS.ADD_VC
     *
     * @return the value of AMF_DATA_ADD_FIELDS.ADD_VC
     */
    public String getADD_VC() {
        return ADD_VC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DATA_ADD_FIELDS.ADD_VC
     *
     * @param ADD_VC the value for AMF_DATA_ADD_FIELDS.ADD_VC
     */
    public void setADD_VC(String ADD_VC) {
        this.ADD_VC = ADD_VC == null ? null : ADD_VC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_DATA_ADD_FIELDS.ADD_DT
     *
     * @return the value of AMF_DATA_ADD_FIELDS.ADD_DT
     */
    public Date getADD_DT() {
        return ADD_DT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_DATA_ADD_FIELDS.ADD_DT
     *
     * @param ADD_DT the value for AMF_DATA_ADD_FIELDS.ADD_DT
     */
    public void setADD_DT(Date ADD_DT) {
        this.ADD_DT = ADD_DT;
    }

    public String getADD_DR()
    {
        return ADD_DR;
    }

    public void setADD_DR(String aDD_DR)
    {
        ADD_DR = aDD_DR;
    }
    
    
}