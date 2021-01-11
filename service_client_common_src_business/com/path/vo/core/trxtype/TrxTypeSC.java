package com.path.vo.core.trxtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.struts2.lib.common.GridParamsSC;

public class TrxTypeSC extends GridParamsSC
{

    private String type;
    private String trsType;
    private String status;
    private String chequeFlag;
    private String nostro;
    private BigDecimal code;
    private BigDecimal trxTypeGrpCode;
    private BigDecimal trsfr;
    private BigDecimal cif_no;
    private String iv_crud;
    private String multiTrx;
    private String standingOrder;
    private String chqRelated;
    private String crDrForex;
    private String cyExch;
    private String reference;
    private String isDyOpt;
    private String linkToOtherTrx;
    private String trsfrMethod;
    private BigDecimal bulkRemittanceType;
    private String fromTrxTypeDep = "false";
    private String showMessage;
    
    //use this flag to retrieve only the transactions that have OutstandingProfit = 1 by setting it to "true"
    private String outstandingProfit = "false";
    private String folderType;
    
    //habib accocunt restriction 372747
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int nbRecords;
    private List<CTSTRXTYPEVO> listRecords = new ArrayList<>();
    
    private boolean globalDep;
    
    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    /**
     * @return the chequeFlag
     */
    public String getChequeFlag()
    {
	return chequeFlag;
    }

    /**
     * @param chequeFlag the chequeFlag to set
     */
    public void setChequeFlag(String chequeFlag)
    {
	this.chequeFlag = chequeFlag;
    }

    /**
     * @return the nostro
     */
    public String getNostro()
    {
	return nostro;
    }

    /**
     * @param nostro the nostro to set
     */
    public void setNostro(String nostro)
    {
	this.nostro = nostro;
    }

    /**
     * @return the trsfr
     */
    public BigDecimal getTrsfr()
    {
	return trsfr;
    }

    /**
     * @param trsfr the trsfr to set
     */
    public void setTrsfr(BigDecimal trsfr)
    {
	this.trsfr = trsfr;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public String getMultiTrx()
    {
	return multiTrx;
    }

    public void setMultiTrx(String multiTrx)
    {
	this.multiTrx = multiTrx;
    }

    public String getStandingOrder()
    {
	return standingOrder;
    }

    public void setStandingOrder(String standingOrder)
    {
	this.standingOrder = standingOrder;
    }

    public String getChqRelated()
    {
	return chqRelated;
    }

    public void setChqRelated(String chqRelated)
    {
	this.chqRelated = chqRelated;
    }

    public String getCrDrForex()
    {
	return crDrForex;
    }

    public void setCrDrForex(String crDrForex)
    {
	this.crDrForex = crDrForex;
    }

    public String getCyExch()
    {
	return cyExch;
    }

    public void setCyExch(String cyExch)
    {
	this.cyExch = cyExch;
    }

    /**
     * @return the reference
     */
    public String getReference()
    {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference)
    {
        this.reference = reference;
    }

    /**
     * @return the isDyOpt
     */
    public String getIsDyOpt()
    {
        return isDyOpt;
    }

    /**
     * @param isDyOpt the isDyOpt to set
     */
    public void setIsDyOpt(String isDyOpt)
    {
        this.isDyOpt = isDyOpt;
    }

    /**
     * @return the fromTrxTypeDep
     */
    public String getFromTrxTypeDep()
    {
        return fromTrxTypeDep;
    }

    /**
     * @param fromTrxTypeDep the fromTrxTypeDep to set
     */
    public void setFromTrxTypeDep(String fromTrxTypeDep)
    {
        this.fromTrxTypeDep = fromTrxTypeDep;
    }
    
    public String getOutstandingProfit()
    {
        return outstandingProfit;
    }

    public void setOutstandingProfit(String outstandingProfit)
    {
        this.outstandingProfit = outstandingProfit;
    }

    public String getFolderType()
    {
        return folderType;
    }

    public void setFolderType(String folderType)
    {
        this.folderType = folderType;
    }

    public BigDecimal getTrxTypeGrpCode()
    {
        return trxTypeGrpCode;
    }

    public void setTrxTypeGrpCode(BigDecimal trxTypeGrpCode)
    {
        this.trxTypeGrpCode = trxTypeGrpCode;
    }

    /**
     * @return the cif_no
     */
    public BigDecimal getCif_no()
    {
        return cif_no;
    }

    /**
     * @param cifNo the cif_no to set
     */
    public void setCif_no(BigDecimal cifNo)
    {
        cif_no = cifNo;
    }

    /**
     * @return the trsType
     */
    public String getTrsType()
    {
        return trsType;
    }

    /**
     * @param trsType the trsType to set
     */
    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
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
     * @return the linkToOtherTrx
     */
    public String getLinkToOtherTrx()
    {
        return linkToOtherTrx;
    }

    /**
     * @param linkToOtherTrx the linkToOtherTrx to set
     */
    public void setLinkToOtherTrx(String linkToOtherTrx)
    {
        this.linkToOtherTrx = linkToOtherTrx;
    }

    /**
     * @return the trsfrMethod
     */
    public String getTrsfrMethod()
    {
        return trsfrMethod;
    }

    /**
     * @param trsfrMethod the trsfrMethod to set
     */
    public void setTrsfrMethod(String trsfrMethod)
    {
        this.trsfrMethod = trsfrMethod;
    }

    public String getShowMessage()
    {
        return showMessage;
    }

    public void setShowMessage(String showMessage)
    {
        this.showMessage = showMessage;
    }

	
	public String getPageRef()
	{
		return pageRef;
	}

	
	public void setPageRef(String pageRef)
	{
		this.pageRef = pageRef;
	}

	
	public String getErrType()
	{
		return errType;
	}

	
	public void setErrType(String errType)
	{
		this.errType = errType;
	}

	
	public String getErrMsg()
	{
		return errMsg;
	}

	
	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	
	public BigDecimal getRtrnVal()
	{
		return rtrnVal;
	}

	
	public void setRtrnVal(BigDecimal rtrnVal)
	{
		this.rtrnVal = rtrnVal;
	}

	
	public BigDecimal getErrCode()
	{
		return errCode;
	}

	
	public void setErrCode(BigDecimal errCode)
	{
		this.errCode = errCode;
	}

	
	public boolean isCheckNbRec()
	{
		return checkNbRec;
	}

	
	public void setCheckNbRec(boolean checkNbRec)
	{
		this.checkNbRec = checkNbRec;
	}

	
	public int getNbRecords()
	{
		return nbRecords;
	}

	
	public void setNbRecords(int nbRecords)
	{
		this.nbRecords = nbRecords;
	}

	
	public List<CTSTRXTYPEVO> getListRecords()
	{
		return listRecords;
	}

	
	public void setListRecords(List<CTSTRXTYPEVO> listRecords)
	{
		this.listRecords = listRecords;
	}

	public boolean isGlobalDep() {
		return globalDep;
	}

	public void setGlobalDep(boolean globalDep) {
		this.globalDep = globalDep;
	}
}
