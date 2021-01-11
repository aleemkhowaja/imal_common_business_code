package com.path.dbmaps.vo;

public class CTSCITDET2VO extends CTSCITDET2VOKey {
    /**
     * This field corresponds to the database column CTSCITDET2.INCLUDE_AS_EX_RV
     */
    private String INCLUDE_AS_EX_RV;

    /**
     * This field corresponds to the database column CTSCITDET2.INCLUDE_LIABILITY
     */
    private String INCLUDE_LIABILITY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCITDET2.INCLUDE_AS_EX_RV
     *
     * @return the value of CTSCITDET2.INCLUDE_AS_EX_RV
     */
    public String getINCLUDE_AS_EX_RV() {
        return INCLUDE_AS_EX_RV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCITDET2.INCLUDE_AS_EX_RV
     *
     * @param INCLUDE_AS_EX_RV the value for CTSCITDET2.INCLUDE_AS_EX_RV
     */
    public void setINCLUDE_AS_EX_RV(String INCLUDE_AS_EX_RV) {
        this.INCLUDE_AS_EX_RV = INCLUDE_AS_EX_RV == null ? null : INCLUDE_AS_EX_RV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCITDET2.INCLUDE_LIABILITY
     *
     * @return the value of CTSCITDET2.INCLUDE_LIABILITY
     */
    public String getINCLUDE_LIABILITY() {
        return INCLUDE_LIABILITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCITDET2.INCLUDE_LIABILITY
     *
     * @param INCLUDE_LIABILITY the value for CTSCITDET2.INCLUDE_LIABILITY
     */
    public void setINCLUDE_LIABILITY(String INCLUDE_LIABILITY) {
        this.INCLUDE_LIABILITY = INCLUDE_LIABILITY == null ? null : INCLUDE_LIABILITY.trim();
    }
}