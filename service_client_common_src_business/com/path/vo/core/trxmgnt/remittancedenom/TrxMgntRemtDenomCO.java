package com.path.vo.core.trxmgnt.remittancedenom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTRS_REMITT_DENOMVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          TrxMgntRemtDenomCO.java used to
 */
public class TrxMgntRemtDenomCO extends RetailBaseVO
{
    private CTSTRS_REMITT_DENOMVO ctstrsRemittDenomVO = new CTSTRS_REMITT_DENOMVO();
    private CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private REMITTANCEVO remittanceVO = new REMITTANCEVO();
    private BigDecimal amount;
    private BigDecimal tellerNo;
    private BigDecimal headTellerNo;
    private BigDecimal bulkRemittanceType;
    private BigDecimal TRS_CY;
    private String remittCY;
    private String collectionRemittType;
    private BigDecimal minSeqNo;
    private String remitByHeadteller;
    private String warningMessages;
    private String confirmMsg;
    private List<String> listWarningMsg = new ArrayList<String>();
    private String checkCount;// if checkQuantity=0 check the count
    private String trxRemtDenomGridUpdate;
    private List<TrxMgntRemtDenomCO> ctstrsRemittDenomVOs = new ArrayList<TrxMgntRemtDenomCO>();
    private BigDecimal currentGridRow;
    private BigDecimal trxRemittCode; //Rania 504699 - SBI170064 - Prize Bond Management
    
    private BigDecimal linkToOtherTrxBr;
    
    public BigDecimal getLinkToOtherTrxBr()
    {
        return linkToOtherTrxBr;
    }

    public void setLinkToOtherTrxBr(BigDecimal linkToOtherTrxBr)
    {
        this.linkToOtherTrxBr = linkToOtherTrxBr;
    }
    
    /**
     * @return the ctstrsRemittDenomVO
     */
    public CTSTRS_REMITT_DENOMVO getCtstrsRemittDenomVO()
    {
	return ctstrsRemittDenomVO;
    }

    /**
     * @param ctstrsRemittDenomVO the ctstrsRemittDenomVO to set
     */
    public void setCtstrsRemittDenomVO(CTSTRS_REMITT_DENOMVO ctstrsRemittDenomVO)
    {
	this.ctstrsRemittDenomVO = ctstrsRemittDenomVO;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount()
    {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public CTSTRXTYPEVO getCtstrxtypeVO()
    {
        return ctstrxtypeVO;
    }

    public void setCtstrxtypeVO(CTSTRXTYPEVO ctstrxtypeVO)
    {
        this.ctstrxtypeVO = ctstrxtypeVO;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public BigDecimal getTellerNo()
    {
	return tellerNo;
    }

    public void setTellerNo(BigDecimal tellerNo)
    {
	this.tellerNo = tellerNo;
    }

    public BigDecimal getTRS_CY()
    {
	return TRS_CY;
    }

    public void setTRS_CY(BigDecimal tRSCY)
    {
	TRS_CY = tRSCY;
    }

    public BigDecimal getMinSeqNo()
    {
	return minSeqNo;
    }

    public void setMinSeqNo(BigDecimal minSeqNo)
    {
	this.minSeqNo = minSeqNo;
    }

    public String getRemitByHeadteller()
    {
	return remitByHeadteller;
    }

    public void setRemitByHeadteller(String remitByHeadteller)
    {
	this.remitByHeadteller = remitByHeadteller;
    }

    public BigDecimal getHeadTellerNo()
    {
	return headTellerNo;
    }

    public void setHeadTellerNo(BigDecimal headTellerNo)
    {
	this.headTellerNo = headTellerNo;
    }

    public String getCheckCount()
    {
	return checkCount;
    }

    public void setCheckCount(String checkCount)
    {
	this.checkCount = checkCount;
    }

    public REMITTANCEVO getRemittanceVO()
    {
	return remittanceVO;
    }

    public void setRemittanceVO(REMITTANCEVO remittanceVO)
    {
	this.remittanceVO = remittanceVO;
    }

    public String getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public List<String> getListWarningMsg()
    {
        return listWarningMsg;
    }

    public void setListWarningMsg(List<String> listWarningMsg)
    {
        this.listWarningMsg = listWarningMsg;
    }

    public String getConfirmMsg()
    {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
        this.confirmMsg = confirmMsg;
    }

    public String getTrxRemtDenomGridUpdate()
    {
        return trxRemtDenomGridUpdate;
    }

    public void setTrxRemtDenomGridUpdate(String trxRemtDenomGridUpdate)
    {
        this.trxRemtDenomGridUpdate = trxRemtDenomGridUpdate;
    }

    public List<TrxMgntRemtDenomCO> getCtstrsRemittDenomVOs()
    {
        return ctstrsRemittDenomVOs;
    }

    public void setCtstrsRemittDenomVOs(List<TrxMgntRemtDenomCO> ctstrsRemittDenomVOs)
    {
        this.ctstrsRemittDenomVOs = ctstrsRemittDenomVOs;
    }

    public BigDecimal getCurrentGridRow()
    {
        return currentGridRow;
    }

    public void setCurrentGridRow(BigDecimal currentGridRow)
    {
        this.currentGridRow = currentGridRow;
    }

    public String getRemittCY()
    {
        return remittCY;
    }

    public void setRemittCY(String remittCY)
    {
        this.remittCY = remittCY;
    }

    /**
     * @return the bulkRemittanceType
     */
    public BigDecimal getBulkRemittanceType()
    {
        return bulkRemittanceType;
    }

    /**
     * @param bulkRemittanceType the bulkRemittanceType to set
     */
    public void setBulkRemittanceType(BigDecimal bulkRemittanceType)
    {
        this.bulkRemittanceType = bulkRemittanceType;
    }

    /**
     * @return the collectionRemittType
     */
    public String getCollectionRemittType()
    {
        return collectionRemittType;
    }

    /**
     * @param collectionRemittType the collectionRemittType to set
     */
    public void setCollectionRemittType(String collectionRemittType)
    {
        this.collectionRemittType = collectionRemittType;
    }

    public BigDecimal getTrxRemittCode()
    {
        return trxRemittCode;
    }

    public void setTrxRemittCode(BigDecimal trxRemittCode)
    {
        this.trxRemittCode = trxRemittCode;
    }
}
