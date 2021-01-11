package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class CEFTS_RESPONSE_CODEVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CEFTS_RESPONSE_CODE.CODE
     */
    private String CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CEFTS_RESPONSE_CODE.CODE
     *
     * @return the value of CEFTS_RESPONSE_CODE.CODE
     */
    public String getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CEFTS_RESPONSE_CODE.CODE
     *
     * @param CODE the value for CEFTS_RESPONSE_CODE.CODE
     */
    public void setCODE(String CODE) {
        this.CODE = CODE == null ? null : CODE.trim();
    }
}