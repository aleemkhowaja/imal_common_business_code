package com.path.vo.core.chargesschema;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChargesSchemaSC  extends GridParamsSC {

    private BigDecimal cif_type_code;
    private BigDecimal cif_flag;
    private BigDecimal code;
    private BigDecimal currencyCode;
    private BigDecimal raControl;
    private String showMessage;
    
    
    private String ENTITY_TYPE;
    private String PRODUCT_TYPE;
    private String SCHEMA_TYPE;


    private BigDecimal ENTITY_CODE;
    private String PRODUCT_CODE;
    private BigDecimal SCHEMA_CODE;
    private String USER_ID;


    private BigDecimal SEQ;
    private BigDecimal PERCENTAGE;


    private BigDecimal MIN_AMT;


    private BigDecimal MAX_AMT;

  
    private BigDecimal DISC_AMT;
    
    private BigDecimal LINE_NO;

    private BigDecimal AMOUNT;
	
    private String ctsForeignChargesTierGridJson;
	

    private boolean fromSegmentation;
    
    private BigDecimal CHARGE_CODE;
    
	public BigDecimal getCif_type_code()
	{
		return cif_type_code;
	}

	public void setCif_type_code(BigDecimal cifTypeCode)
	{
		cif_type_code = cifTypeCode;
	}


	public BigDecimal getCif_flag()
	{
		return cif_flag;
	}


	public void setCif_flag(BigDecimal cifFlag)
	{
		cif_flag = cifFlag;
	}

	/**
	 * @return the code
	 */
	public BigDecimal getCode()
	{
	    return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(BigDecimal code)
	{
	    this.code = code;
	}

	public BigDecimal getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(BigDecimal currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getRaControl() {
		return raControl;
	}

	public void setRaControl(BigDecimal raControl) {
		this.raControl = raControl;
	}

	public String getShowMessage()
	{
	    return showMessage;
	}

	public void setShowMessage(String showMessage)
	{
	    this.showMessage = showMessage;
	}

	
	public BigDecimal getSEQ()
	{
	    return SEQ;
	}

	public void setSEQ(BigDecimal sEQ)
	{
	    SEQ = sEQ;
	}

	public BigDecimal getPERCENTAGE()
	{
	    return PERCENTAGE;
	}

	public void setPERCENTAGE(BigDecimal pERCENTAGE)
	{
	    PERCENTAGE = pERCENTAGE;
	}

	public BigDecimal getMIN_AMT()
	{
	    return MIN_AMT;
	}

	public void setMIN_AMT(BigDecimal mIN_AMT)
	{
	    MIN_AMT = mIN_AMT;
	}

	public BigDecimal getMAX_AMT()
	{
	    return MAX_AMT;
	}

	public void setMAX_AMT(BigDecimal mAX_AMT)
	{
	    MAX_AMT = mAX_AMT;
	}

	public BigDecimal getDISC_AMT()
	{
	    return DISC_AMT;
	}

	public void setDISC_AMT(BigDecimal dISC_AMT)
	{
	    DISC_AMT = dISC_AMT;
	}

	public BigDecimal getLINE_NO()
	{
	    return LINE_NO;
	}

	public void setLINE_NO(BigDecimal lINE_NO)
	{
	    LINE_NO = lINE_NO;
	}

	public BigDecimal getAMOUNT()
	{
	    return AMOUNT;
	}

	public void setAMOUNT(BigDecimal aMOUNT)
	{
	    AMOUNT = aMOUNT;
	}

	public String getCtsForeignChargesTierGridJson()
	{
	    return ctsForeignChargesTierGridJson;
	}

	public void setCtsForeignChargesTierGridJson(String ctsForeignChargesTierGridJson)
	{
	    this.ctsForeignChargesTierGridJson = ctsForeignChargesTierGridJson;
	}

	public String getENTITY_TYPE()
	{
	    return ENTITY_TYPE;
	}

	public void setENTITY_TYPE(String eNTITY_TYPE)
	{
	    ENTITY_TYPE = eNTITY_TYPE;
	}

	public String getPRODUCT_TYPE()
	{
	    return PRODUCT_TYPE;
	}

	public void setPRODUCT_TYPE(String pRODUCT_TYPE)
	{
	    PRODUCT_TYPE = pRODUCT_TYPE;
	}

	public String getSCHEMA_TYPE()
	{
	    return SCHEMA_TYPE;
	}

	public void setSCHEMA_TYPE(String sCHEMA_TYPE)
	{
	    SCHEMA_TYPE = sCHEMA_TYPE;
	}

	public BigDecimal getENTITY_CODE()
	{
	    return ENTITY_CODE;
	}

	public void setENTITY_CODE(BigDecimal eNTITY_CODE)
	{
	    ENTITY_CODE = eNTITY_CODE;
	}


	public BigDecimal getSCHEMA_CODE()
	{
	    return SCHEMA_CODE;
	}

	public void setSCHEMA_CODE(BigDecimal sCHEMA_CODE)
	{
	    SCHEMA_CODE = sCHEMA_CODE;
	}

	public String getUSER_ID()
	{
	    return USER_ID;
	}

	public void setUSER_ID(String uSER_ID)
	{
	    USER_ID = uSER_ID;
	}

	public boolean isFromSegmentation()
	{
	    return fromSegmentation;
	}

	public void setFromSegmentation(boolean fromSegmentation)
	{
	    this.fromSegmentation = fromSegmentation;
	}

	public String getPRODUCT_CODE()
	{
	    return PRODUCT_CODE;
	}

	public void setPRODUCT_CODE(String pRODUCT_CODE)
	{
	    PRODUCT_CODE = pRODUCT_CODE;
	}

	public BigDecimal getCHARGE_CODE()
	{
	    return CHARGE_CODE;
	}

	public void setCHARGE_CODE(BigDecimal cHARGE_CODE)
	{
	    CHARGE_CODE = cHARGE_CODE;
	}



	
	
	
	
}
