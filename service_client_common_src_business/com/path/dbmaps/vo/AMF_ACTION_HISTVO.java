package com.path.dbmaps.vo;

public class AMF_ACTION_HISTVO extends AMF_ACTION_HISTVOKey {
    /**
     * This field corresponds to the database column AMF_ACTION_HIST.ACTION_TYPE
     */
    private String ACTION_TYPE;

    /**
     * This field corresponds to the database column AMF_ACTION_HIST.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_ACTION_HIST.ACTION_TYPE
     *
     * @return the value of AMF_ACTION_HIST.ACTION_TYPE
     */
    public String getACTION_TYPE() {
        return ACTION_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_ACTION_HIST.ACTION_TYPE
     *
     * @param ACTION_TYPE the value for AMF_ACTION_HIST.ACTION_TYPE
     */
    public void setACTION_TYPE(String ACTION_TYPE) {
        this.ACTION_TYPE = ACTION_TYPE == null ? null : ACTION_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AMF_ACTION_HIST.USER_ID
     *
     * @return the value of AMF_ACTION_HIST.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AMF_ACTION_HIST.USER_ID
     *
     * @param USER_ID the value for AMF_ACTION_HIST.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}