package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ACC_VAT_BR_CYVO extends ACC_VAT_BR_CYVOKey {
    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.VAT_PERCT
     */
    private BigDecimal VAT_PERCT;

    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.SUPERIOR_MARGIN
     */
    private BigDecimal SUPERIOR_MARGIN;

    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.INFERIOR_MARGIN
     */
    private BigDecimal INFERIOR_MARGIN;
    
    private BigDecimal ZONE_CODE;
    
    private BigDecimal NATION_CODE;
    
    private Date DATE_FROM;
    
    private Date DATE_TO;
    
    private BigDecimal RES_VAT_PERCT;
    
    private BigDecimal RES_IN_ACC_CY;
    
    private BigDecimal RES_IN_ACC_GL;
    
    private BigDecimal RES_IN_ACC_CIF;
    
    private BigDecimal RES_IN_ACC_SL;
    
    private BigDecimal RES_OUT_ACC_CY;
    
    private BigDecimal RES_OUT_ACC_GL;
    
    private BigDecimal RES_OUT_ACC_CIF;
   
    private BigDecimal RES_OUT_ACC_SL;
    
    private BigDecimal NONRES_VAT_PERCT;
    
    private BigDecimal NONRES_IN_ACC_CY;
    
    private BigDecimal NONRES_IN_ACC_GL;
    
    private BigDecimal NONRES_IN_ACC_CIF;
    
    private BigDecimal NONRES_IN_ACC_SL; 
    
    private BigDecimal NONRES_OUT_ACC_CY;
    
    private BigDecimal NONRES_OUT_ACC_GL;
    
    private BigDecimal NONRES_OUT_ACC_CIF;
   
    private BigDecimal NONRES_OUT_ACC_SL;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.VAT_PERCT
     *
     * @return the value of ACC_VAT_BR_CY.VAT_PERCT
     */
    public BigDecimal getVAT_PERCT() {
        return VAT_PERCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.VAT_PERCT
     *
     * @param VAT_PERCT the value for ACC_VAT_BR_CY.VAT_PERCT
     */
    public void setVAT_PERCT(BigDecimal VAT_PERCT) {
        this.VAT_PERCT = VAT_PERCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.SUPERIOR_MARGIN
     *
     * @return the value of ACC_VAT_BR_CY.SUPERIOR_MARGIN
     */
    public BigDecimal getSUPERIOR_MARGIN() {
        return SUPERIOR_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.SUPERIOR_MARGIN
     *
     * @param SUPERIOR_MARGIN the value for ACC_VAT_BR_CY.SUPERIOR_MARGIN
     */
    public void setSUPERIOR_MARGIN(BigDecimal SUPERIOR_MARGIN) {
        this.SUPERIOR_MARGIN = SUPERIOR_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.INFERIOR_MARGIN
     *
     * @return the value of ACC_VAT_BR_CY.INFERIOR_MARGIN
     */
    public BigDecimal getINFERIOR_MARGIN() {
        return INFERIOR_MARGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.INFERIOR_MARGIN
     *
     * @param INFERIOR_MARGIN the value for ACC_VAT_BR_CY.INFERIOR_MARGIN
     */
    public void setINFERIOR_MARGIN(BigDecimal INFERIOR_MARGIN) {
        this.INFERIOR_MARGIN = INFERIOR_MARGIN;
    }

	public BigDecimal getZONE_CODE() {
		return ZONE_CODE;
	}

	public void setZONE_CODE(BigDecimal zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}

	public BigDecimal getNATION_CODE() {
		return NATION_CODE;
	}

	public void setNATION_CODE(BigDecimal nATION_CODE) {
		NATION_CODE = nATION_CODE;
	}

	public Date getDATE_FROM() {
		return DATE_FROM;
	}

	public void setDATE_FROM(Date dATE_FROM) {
		DATE_FROM = dATE_FROM;
	}

	public Date getDATE_TO() {
		return DATE_TO;
	}

	public void setDATE_TO(Date dATE_TO) {
		DATE_TO = dATE_TO;
	}

	public BigDecimal getRES_VAT_PERCT() {
		return RES_VAT_PERCT;
	}

	public void setRES_VAT_PERCT(BigDecimal rES_VAT_PERCT) {
		RES_VAT_PERCT = rES_VAT_PERCT;
	}

	public BigDecimal getRES_IN_ACC_CY() {
		return RES_IN_ACC_CY;
	}

	public void setRES_IN_ACC_CY(BigDecimal rES_IN_ACC_CY) {
		RES_IN_ACC_CY = rES_IN_ACC_CY;
	}

	public BigDecimal getRES_IN_ACC_GL() {
		return RES_IN_ACC_GL;
	}

	public void setRES_IN_ACC_GL(BigDecimal rES_IN_ACC_GL) {
		RES_IN_ACC_GL = rES_IN_ACC_GL;
	}

	public BigDecimal getRES_IN_ACC_CIF() {
		return RES_IN_ACC_CIF;
	}

	public void setRES_IN_ACC_CIF(BigDecimal rES_IN_ACC_CIF) {
		RES_IN_ACC_CIF = rES_IN_ACC_CIF;
	}

	public BigDecimal getRES_IN_ACC_SL() {
		return RES_IN_ACC_SL;
	}

	public void setRES_IN_ACC_SL(BigDecimal rES_IN_ACC_SL) {
		RES_IN_ACC_SL = rES_IN_ACC_SL;
	}

	public BigDecimal getRES_OUT_ACC_CY() {
		return RES_OUT_ACC_CY;
	}

	public void setRES_OUT_ACC_CY(BigDecimal rES_OUT_ACC_CY) {
		RES_OUT_ACC_CY = rES_OUT_ACC_CY;
	}

	public BigDecimal getRES_OUT_ACC_GL() {
		return RES_OUT_ACC_GL;
	}

	public void setRES_OUT_ACC_GL(BigDecimal rES_OUT_ACC_GL) {
		RES_OUT_ACC_GL = rES_OUT_ACC_GL;
	}

	public BigDecimal getRES_OUT_ACC_CIF() {
		return RES_OUT_ACC_CIF;
	}

	public void setRES_OUT_ACC_CIF(BigDecimal rES_OUT_ACC_CIF) {
		RES_OUT_ACC_CIF = rES_OUT_ACC_CIF;
	}

	public BigDecimal getRES_OUT_ACC_SL() {
		return RES_OUT_ACC_SL;
	}

	public void setRES_OUT_ACC_SL(BigDecimal rES_OUT_ACC_SL) {
		RES_OUT_ACC_SL = rES_OUT_ACC_SL;
	}

	public BigDecimal getNONRES_VAT_PERCT() {
		return NONRES_VAT_PERCT;
	}

	public void setNONRES_VAT_PERCT(BigDecimal nONRES_VAT_PERCT) {
		NONRES_VAT_PERCT = nONRES_VAT_PERCT;
	}

	public BigDecimal getNONRES_IN_ACC_CY() {
		return NONRES_IN_ACC_CY;
	}

	public void setNONRES_IN_ACC_CY(BigDecimal nONRES_IN_ACC_CY) {
		NONRES_IN_ACC_CY = nONRES_IN_ACC_CY;
	}

	public BigDecimal getNONRES_IN_ACC_GL() {
		return NONRES_IN_ACC_GL;
	}

	public void setNONRES_IN_ACC_GL(BigDecimal nONRES_IN_ACC_GL) {
		NONRES_IN_ACC_GL = nONRES_IN_ACC_GL;
	}

	public BigDecimal getNONRES_IN_ACC_CIF() {
		return NONRES_IN_ACC_CIF;
	}

	public void setNONRES_IN_ACC_CIF(BigDecimal nONRES_IN_ACC_CIF) {
		NONRES_IN_ACC_CIF = nONRES_IN_ACC_CIF;
	}

	public BigDecimal getNONRES_IN_ACC_SL() {
		return NONRES_IN_ACC_SL;
	}

	public void setNONRES_IN_ACC_SL(BigDecimal nONRES_IN_ACC_SL) {
		NONRES_IN_ACC_SL = nONRES_IN_ACC_SL;
	}

	public BigDecimal getNONRES_OUT_ACC_CY() {
		return NONRES_OUT_ACC_CY;
	}

	public void setNONRES_OUT_ACC_CY(BigDecimal nONRES_OUT_ACC_CY) {
		NONRES_OUT_ACC_CY = nONRES_OUT_ACC_CY;
	}

	public BigDecimal getNONRES_OUT_ACC_GL() {
		return NONRES_OUT_ACC_GL;
	}

	public void setNONRES_OUT_ACC_GL(BigDecimal nONRES_OUT_ACC_GL) {
		NONRES_OUT_ACC_GL = nONRES_OUT_ACC_GL;
	}

	public BigDecimal getNONRES_OUT_ACC_CIF() {
		return NONRES_OUT_ACC_CIF;
	}

	public void setNONRES_OUT_ACC_CIF(BigDecimal nONRES_OUT_ACC_CIF) {
		NONRES_OUT_ACC_CIF = nONRES_OUT_ACC_CIF;
	}

	public BigDecimal getNONRES_OUT_ACC_SL() {
		return NONRES_OUT_ACC_SL;
	}

	public void setNONRES_OUT_ACC_SL(BigDecimal nONRES_OUT_ACC_SL) {
		NONRES_OUT_ACC_SL = nONRES_OUT_ACC_SL;
	}
}