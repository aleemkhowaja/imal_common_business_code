/**
 * 
 */
package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.DOF_HSTVO;
import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 *
 *          AccPositionSettCO.java used to
 */
public class AccPositionSettCO extends BaseVO
{
    private CURRENCIESVO currenciesVO;
    private DOF_HSTVO dofHstVO;
    private JV_TYPEVO jvTypeVO;
    private TR_TYPESVO trTypeVO;
    private BigDecimal FC_TOTAL;
    private BigDecimal CV_TOTAL;
    private BigDecimal FC_DECIMAL_POINTS;
    private String CYNAME_ENG;
    private String CYNAME_ARAB;
    private BigDecimal baseCurrDecPoint;
    private String transType;
    private BigDecimal netBalance;
    private BigDecimal amount;

    /**
     * @return the currenciesVO
     */
    public CURRENCIESVO getCurrenciesVO()
    {
	return currenciesVO;
    }

    /**
     * @param currenciesVO the currenciesVO to set
     */
    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
	this.currenciesVO = currenciesVO;
    }

    /**
     * @return the dofHstVO
     */
    public DOF_HSTVO getDofHstVO()
    {
	return dofHstVO;
    }

    /**
     * @param dofHstVO the dofHstVO to set
     */
    public void setDofHstVO(DOF_HSTVO dofHstVO)
    {
	this.dofHstVO = dofHstVO;
    }

    /**
     * @return the c_FC_TOTAL
     */
    public BigDecimal getFC_TOTAL()
    {
	return FC_TOTAL;
    }

    /**
     * @param cFCTOTAL the c_FC_TOTAL to set
     */
    public void setFC_TOTAL(BigDecimal FCTOTAL)
    {
	FC_TOTAL = FCTOTAL;
    }

    /**
     * @return the c_CV_TOTAL
     */
    public BigDecimal getCV_TOTAL()
    {
	return CV_TOTAL;
    }

    /**
     * @param cCVTOTAL the c_CV_TOTAL to set
     */
    public void setCV_TOTAL(BigDecimal CVTOTAL)
    {
	CV_TOTAL = CVTOTAL;
    }

    /**
     * @return the fC_DECIMAL_POINTS
     */
    public BigDecimal getFC_DECIMAL_POINTS()
    {
	return FC_DECIMAL_POINTS;
    }

    /**
     * @param fCDECIMALPOINTS the fC_DECIMAL_POINTS to set
     */
    public void setFC_DECIMAL_POINTS(BigDecimal fCDECIMALPOINTS)
    {
	FC_DECIMAL_POINTS = fCDECIMALPOINTS;
    }

    /**
     * @return the c_CYNAME_ENG
     */
    public String getCYNAME_ENG()
    {
	return CYNAME_ENG;
    }

    /**
     * @param cCYNAMEENG the c_CYNAME_ENG to set
     */
    public void setCYNAME_ENG(String CYNAMEENG)
    {
	CYNAME_ENG = CYNAMEENG;
    }

    /**
     * @return the c_CYNAME_ARAB
     */
    public String getCYNAME_ARAB()
    {
	return CYNAME_ARAB;
    }

    /**
     * @param cCYNAMEARAB the c_CYNAME_ARAB to set
     */
    public void setCYNAME_ARAB(String CYNAMEARAB)
    {
	CYNAME_ARAB = CYNAMEARAB;
    }

    /**
     * @return the baseCurrDecPoint
     */
    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    /**
     * @param baseCurrDecPoint the baseCurrDecPoint to set
     */
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public JV_TYPEVO getJvTypeVO()
    {
        return jvTypeVO;
    }

    public void setJvTypeVO(JV_TYPEVO jvTypeVO)
    {
        this.jvTypeVO = jvTypeVO;
    }

    public TR_TYPESVO getTrTypeVO()
    {
        return trTypeVO;
    }

    public void setTrTypeVO(TR_TYPESVO trTypeVO)
    {
        this.trTypeVO = trTypeVO;
    }

    public String getTransType()
    {
        return transType;
    }

    public void setTransType(String transType)
    {
        this.transType = transType;
    }

    public BigDecimal getNetBalance()
    {
        return netBalance;
    }

    public void setNetBalance(BigDecimal netBalance)
    {
        this.netBalance = netBalance;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    
}
