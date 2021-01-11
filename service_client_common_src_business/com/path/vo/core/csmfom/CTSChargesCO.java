package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSCHARGES_CURRENCY_TEMPVO;
import com.path.dbmaps.vo.CTSCHARGES_ROSTER_TEMPVO;
import com.path.dbmaps.vo.CTSCHARGES_TEMPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 */
public class CTSChargesCO extends BaseVO
{
    private CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
    private String ACC_NAME;
    private String VAT_DESC;
    private String DR_ACC_NAME;
    private String CY_NAME;

    // For check Box on screen
    private Boolean allowModifyClear;
    private Boolean allowModify;
    private Boolean deductFromTrx;
    private Boolean fixChkBookCharge;
    private Boolean considerOnceMultiTran;
    private Boolean chargeExceedAmt;
    private Boolean basedOnMosarafa;
    private Boolean passSeperately;
    private Boolean applyVat;

    private Boolean showTiersGrid;
    private Boolean showFyChargesGrid; 

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private BigDecimal COMP_CODE;
    private BigDecimal schemaCode;
    private CTSCHARGES_TEMPVO ctsChargesTempVO =new CTSCHARGES_TEMPVO();
    private String tierGridString;
    private String currencyGridString;
    private List<CTSCHARGES_ROSTER_TEMPVO> ctscharges_ROSTER_TEMPVOs=new ArrayList<CTSCHARGES_ROSTER_TEMPVO>();
    private List<CTSChargesCurrencyCO> ctsChargesCurrencyCOs=new ArrayList<>();
    
    
    private String ENTITY_TYPE;
    private String PRODUCT_TYPE;
    private String SCHEMA_TYPE;
    private BigDecimal chargeCode;


    private BigDecimal ENTITY_CODE;
    private String PRODUCT_CODE;
    private BigDecimal SCHEMA_CODE;
    
    private String ISSUE_TYPE;
    private String CHARGES_CY_POLICY;
    private String CASH_ACCOUNT;
    private String ACTION_TYPE;
    
    
    private BigDecimal SEG_ACC_BR;
    private BigDecimal SEG_ACC_CY;
    private BigDecimal SEG_ACC_GL;    
    private BigDecimal SEG_ACC_CIF;
    private BigDecimal SEG_ACC_SL;
    private BigDecimal CHEQUE_TYPE;
    private BigDecimal LEAVES;
    private String USER_ID;

    
    public CTSCHARGESVO getCtsChargesVO()
    {
	return ctsChargesVO;
    }

    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
	this.ctsChargesVO = ctsChargesVO;
    }

    public String getACC_NAME()
    {
	return ACC_NAME;
    }

    public void setACC_NAME(String aCCNAME)
    {
	ACC_NAME = aCCNAME;
    }

    public String getVAT_DESC()
    {
	return VAT_DESC;
    }

    public void setVAT_DESC(String vATDESC)
    {
	VAT_DESC = vATDESC;
    }

    public String getDR_ACC_NAME()
    {
	return DR_ACC_NAME;
    }

    public void setDR_ACC_NAME(String dRACCNAME)
    {
	DR_ACC_NAME = dRACCNAME;
    }

    public String getCY_NAME()
    {
	return CY_NAME;
    }

    public void setCY_NAME(String cYNAME)
    {
	CY_NAME = cYNAME;
    }

    public Boolean getAllowModifyClear()
    {
	return allowModifyClear;
    }

    public void setAllowModifyClear(Boolean allowModifyClear)
    {
	this.allowModifyClear = allowModifyClear;
    }

    public Boolean getAllowModify()
    {
	return allowModify;
    }

    public void setAllowModify(Boolean allowModify)
    {
	this.allowModify = allowModify;
    }

    public Boolean getDeductFromTrx()
    {
	return deductFromTrx;
    }

    public void setDeductFromTrx(Boolean deductFromTrx)
    {
	this.deductFromTrx = deductFromTrx;
    }

    public Boolean getFixChkBookCharge()
    {
	return fixChkBookCharge;
    }

    public void setFixChkBookCharge(Boolean fixChkBookCharge)
    {
	this.fixChkBookCharge = fixChkBookCharge;
    }

    public Boolean getConsiderOnceMultiTran()
    {
	return considerOnceMultiTran;
    }

    public void setConsiderOnceMultiTran(Boolean considerOnceMultiTran)
    {
	this.considerOnceMultiTran = considerOnceMultiTran;
    }

    public Boolean getChargeExceedAmt()
    {
	return chargeExceedAmt;
    }

    public void setChargeExceedAmt(Boolean chargeExceedAmt)
    {
	this.chargeExceedAmt = chargeExceedAmt;
    }

    public Boolean getBasedOnMosarafa()
    {
	return basedOnMosarafa;
    }

    public void setBasedOnMosarafa(Boolean basedOnMosarafa)
    {
	this.basedOnMosarafa = basedOnMosarafa;
    }

    public Boolean getPassSeperately()
    {
	return passSeperately;
    }

    public void setPassSeperately(Boolean passSeperately)
    {
	this.passSeperately = passSeperately;
    }

    public Boolean getApplyVat()
    {
	return applyVat;
    }

    public void setApplyVat(Boolean applyVat)
    {
	this.applyVat = applyVat;
    }

    public Boolean getShowTiersGrid()
    {
	return showTiersGrid;
    }

    public void setShowTiersGrid(Boolean showTiersGrid)
    {
	this.showTiersGrid = showTiersGrid;
    }

    public Boolean getShowFyChargesGrid()
    {
	return showFyChargesGrid;
    }

    public void setShowFyChargesGrid(Boolean showFyChargesGrid)
    {
	this.showFyChargesGrid = showFyChargesGrid;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }

    public String getTierGridString()
    {
        return tierGridString;
    }

    public void setTierGridString(String tierGridString)
    {
        this.tierGridString = tierGridString;
    }

   
    public String getCurrencyGridString()
    {
        return currencyGridString;
    }

    public void setCurrencyGridString(String currencyGridString)
    {
        this.currencyGridString = currencyGridString;
    }

    public List<CTSCHARGES_ROSTER_TEMPVO> getCtscharges_ROSTER_TEMPVOs()
    {
        return ctscharges_ROSTER_TEMPVOs;
    }

    public void setCtscharges_ROSTER_TEMPVOs(List<CTSCHARGES_ROSTER_TEMPVO> ctscharges_ROSTER_TEMPVOs)
    {
        this.ctscharges_ROSTER_TEMPVOs = ctscharges_ROSTER_TEMPVOs;
    }

   

    public CTSCHARGES_TEMPVO getCtsChargesTempVO()
    {
        return ctsChargesTempVO;
    }

    public void setCtsChargesTempVO(CTSCHARGES_TEMPVO ctsChargesTempVO)
    {
        this.ctsChargesTempVO = ctsChargesTempVO;
    }

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getSchemaCode()
    {
        return schemaCode;
    }

    public void setSchemaCode(BigDecimal schemaCode)
    {
        this.schemaCode = schemaCode;
    }

    public List<CTSChargesCurrencyCO> getCtsChargesCurrencyCOs()
    {
        return ctsChargesCurrencyCOs;
    }

    public void setCtsChargesCurrencyCOs(List<CTSChargesCurrencyCO> ctsChargesCurrencyCOs)
    {
        this.ctsChargesCurrencyCOs = ctsChargesCurrencyCOs;
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

    public String getISSUE_TYPE()
    {
        return ISSUE_TYPE;
    }

    public void setISSUE_TYPE(String iSSUE_TYPE)
    {
        ISSUE_TYPE = iSSUE_TYPE;
    }

    public String getCHARGES_CY_POLICY()
    {
        return CHARGES_CY_POLICY;
    }

    public void setCHARGES_CY_POLICY(String cHARGES_CY_POLICY)
    {
        CHARGES_CY_POLICY = cHARGES_CY_POLICY;
    }

    public String getCASH_ACCOUNT()
    {
        return CASH_ACCOUNT;
    }

    public void setCASH_ACCOUNT(String cASH_ACCOUNT)
    {
        CASH_ACCOUNT = cASH_ACCOUNT;
    }

    public String getACTION_TYPE()
    {
        return ACTION_TYPE;
    }

    public void setACTION_TYPE(String aCTION_TYPE)
    {
        ACTION_TYPE = aCTION_TYPE;
    }

    public BigDecimal getSEG_ACC_BR()
    {
        return SEG_ACC_BR;
    }

    public void setSEG_ACC_BR(BigDecimal sEG_ACC_BR)
    {
        SEG_ACC_BR = sEG_ACC_BR;
    }

    public BigDecimal getSEG_ACC_CY()
    {
        return SEG_ACC_CY;
    }

    public void setSEG_ACC_CY(BigDecimal sEG_ACC_CY)
    {
        SEG_ACC_CY = sEG_ACC_CY;
    }

    public BigDecimal getSEG_ACC_GL()
    {
        return SEG_ACC_GL;
    }

    public void setSEG_ACC_GL(BigDecimal sEG_ACC_GL)
    {
        SEG_ACC_GL = sEG_ACC_GL;
    }

    public BigDecimal getSEG_ACC_CIF()
    {
        return SEG_ACC_CIF;
    }

    public void setSEG_ACC_CIF(BigDecimal sEG_ACC_CIF)
    {
        SEG_ACC_CIF = sEG_ACC_CIF;
    }

    public BigDecimal getSEG_ACC_SL()
    {
        return SEG_ACC_SL;
    }

    public void setSEG_ACC_SL(BigDecimal sEG_ACC_SL)
    {
        SEG_ACC_SL = sEG_ACC_SL;
    }

    public BigDecimal getCHEQUE_TYPE()
    {
        return CHEQUE_TYPE;
    }

    public void setCHEQUE_TYPE(BigDecimal cHEQUE_TYPE)
    {
        CHEQUE_TYPE = cHEQUE_TYPE;
    }

    public BigDecimal getLEAVES()
    {
        return LEAVES;
    }

    public void setLEAVES(BigDecimal lEAVES)
    {
        LEAVES = lEAVES;
    }

    public String getUSER_ID()
    {
        return USER_ID;
    }

    public void setUSER_ID(String uSER_ID)
    {
        USER_ID = uSER_ID;
    }

    public BigDecimal getChargeCode()
    {
        return chargeCode;
    }

    public void setChargeCode(BigDecimal chargeCode)
    {
        this.chargeCode = chargeCode;
    }

    public String getPRODUCT_CODE()
    {
        return PRODUCT_CODE;
    }

    public void setPRODUCT_CODE(String pRODUCT_CODE)
    {
        PRODUCT_CODE = pRODUCT_CODE;
    }

   

  
    
    
}
