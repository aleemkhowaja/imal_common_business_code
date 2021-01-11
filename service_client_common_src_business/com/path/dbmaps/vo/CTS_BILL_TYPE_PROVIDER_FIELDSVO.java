package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTS_BILL_TYPE_PROVIDER_FIELDSVO extends CTS_BILL_TYPE_PROVIDER_FIELDSVOKey {
    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_POSITION
     */
    private BigDecimal FIELD_POSITION;

    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LENGTH
     */
    private BigDecimal FIELD_LENGTH;

    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_TYPE
     */
    private String FIELD_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_POSITION
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_POSITION
     */
    public BigDecimal getFIELD_POSITION() {
        return FIELD_POSITION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_POSITION
     *
     * @param FIELD_POSITION the value for CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_POSITION
     */
    public void setFIELD_POSITION(BigDecimal FIELD_POSITION) {
        this.FIELD_POSITION = FIELD_POSITION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LENGTH
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LENGTH
     */
    public BigDecimal getFIELD_LENGTH() {
        return FIELD_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LENGTH
     *
     * @param FIELD_LENGTH the value for CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LENGTH
     */
    public void setFIELD_LENGTH(BigDecimal FIELD_LENGTH) {
        this.FIELD_LENGTH = FIELD_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_TYPE
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_TYPE
     */
    public String getFIELD_TYPE() {
        return FIELD_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_TYPE
     *
     * @param FIELD_TYPE the value for CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_TYPE
     */
    public void setFIELD_TYPE(String FIELD_TYPE) {
        this.FIELD_TYPE = FIELD_TYPE == null ? null : FIELD_TYPE.trim();
    }
}