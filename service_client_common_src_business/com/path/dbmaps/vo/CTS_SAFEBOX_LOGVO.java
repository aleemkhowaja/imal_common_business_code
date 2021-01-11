package com.path.dbmaps.vo;

import java.util.Date;

public class CTS_SAFEBOX_LOGVO extends CTS_SAFEBOX_LOGVOKey {
    /**
     * This field corresponds to the database column CTS_SAFEBOX_LOG.DATE_FROM
     */
    private Date DATE_FROM;

    /**
     * This field corresponds to the database column CTS_SAFEBOX_LOG.DATE_TO
     */
    private Date DATE_TO;

    /**
     * This field corresponds to the database column CTS_SAFEBOX_LOG.COMMENTS
     */
    private String COMMENTS;

    /**
     * This field corresponds to the database column CTS_SAFEBOX_LOG.VISITOR_NAME
     */
    private String VISITOR_NAME;

    /**
     * This field corresponds to the database column CTS_SAFEBOX_LOG.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SAFEBOX_LOG.DATE_FROM
     *
     * @return the value of CTS_SAFEBOX_LOG.DATE_FROM
     */
    public Date getDATE_FROM() {
        return DATE_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SAFEBOX_LOG.DATE_FROM
     *
     * @param DATE_FROM the value for CTS_SAFEBOX_LOG.DATE_FROM
     */
    public void setDATE_FROM(Date DATE_FROM) {
        this.DATE_FROM = DATE_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SAFEBOX_LOG.DATE_TO
     *
     * @return the value of CTS_SAFEBOX_LOG.DATE_TO
     */
    public Date getDATE_TO() {
        return DATE_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SAFEBOX_LOG.DATE_TO
     *
     * @param DATE_TO the value for CTS_SAFEBOX_LOG.DATE_TO
     */
    public void setDATE_TO(Date DATE_TO) {
        this.DATE_TO = DATE_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SAFEBOX_LOG.COMMENTS
     *
     * @return the value of CTS_SAFEBOX_LOG.COMMENTS
     */
    public String getCOMMENTS() {
        return COMMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SAFEBOX_LOG.COMMENTS
     *
     * @param COMMENTS the value for CTS_SAFEBOX_LOG.COMMENTS
     */
    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS == null ? null : COMMENTS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SAFEBOX_LOG.VISITOR_NAME
     *
     * @return the value of CTS_SAFEBOX_LOG.VISITOR_NAME
     */
    public String getVISITOR_NAME() {
        return VISITOR_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SAFEBOX_LOG.VISITOR_NAME
     *
     * @param VISITOR_NAME the value for CTS_SAFEBOX_LOG.VISITOR_NAME
     */
    public void setVISITOR_NAME(String VISITOR_NAME) {
        this.VISITOR_NAME = VISITOR_NAME == null ? null : VISITOR_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SAFEBOX_LOG.USER_ID
     *
     * @return the value of CTS_SAFEBOX_LOG.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SAFEBOX_LOG.USER_ID
     *
     * @param USER_ID the value for CTS_SAFEBOX_LOG.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}